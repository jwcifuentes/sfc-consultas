package com.ibm.ams.ldap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.directory.api.ldap.model.cursor.CursorException;
import org.apache.directory.api.ldap.model.cursor.EntryCursor;
import org.apache.directory.api.ldap.model.entry.DefaultEntry;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.ModificationOperation;
import org.apache.directory.api.ldap.model.exception.LdapException;
import org.apache.directory.api.ldap.model.message.SearchScope;
import org.apache.directory.ldap.client.api.LdapConnection;
import org.apache.directory.ldap.client.api.LdapConnectionConfig;
import org.apache.directory.ldap.client.api.LdapConnectionPool;
import org.apache.directory.ldap.client.api.LdapNetworkConnection;
import org.apache.directory.ldap.client.api.NoVerificationTrustManager;
import org.apache.directory.ldap.client.api.PoolableLdapConnectionFactory;

import com.ibm.ams.ldap.config.ConfiguracionMapeoLdap;
import com.ibm.ams.ldap.config.ConfiguracionParametrosLdap;
import com.ibm.ams.log.LoggerInst;
import com.ibm.ams.utils.ConstantesUsuariosLDAP;


/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*
*   <p><b>Descripción: </b>
*   <p>Clase encargada de conectarse al servidro de Ldap y gestionar la infomacion de usuarios
*
*
* 	<p><b>Notas: </b>
*   <p>Se utiliza la libreria provista por apache para realizar las tareas administrativas sobre el directorio de personas
*
* 	<p><b>Proyecto base: </b> CompensacionPortlet
*
*   @author <A HREF="mailto:oballest@co.ibm.com">Oscar Arturo Ballesteros</A>
*   <p><b>Fecha de creación(dd/mmm/aaaa):</b> 05/sep/2013
*
*   @version 1.0, 06/sep/2013
*   <p><b>ChangeLog:</b>
*	<p>Versión: 1.0
*	<p>- Creación de la clase.
*	<p>- Creación de documentación.
**/
public class GestorLdapApache {
	
	/** Instancia del Logger. */
	private static LoggerInst logger = new LoggerInst(GestorLdapApache.class, ConstantesUsuariosLDAP.NOMBRE_APLICACION, ConstantesUsuariosLDAP.NOMBRE_APLICACION);

	private static GestorLdapApache instance;
	/** Objeto que maneja un pool de conexiones hacia el servidor Ldap */
	private LdapConnectionPool pool;
	
	/** Objeto conexion  ldap usado para validar las credenciales de un usuario */
	private LdapConnection connection;
	
	/** Cadena con la ubicacion base de busqueda en el directorio */
	private String baseBusqueda = "";
	
	/** Identificador del del class objeto para las entradas */
	private String claseObjeto = "";
	
	/** Identificador del atributo que denota un grupo */
	private String objetoGrupo = "";
	
	/** Identificador del atributo de pertenencia a un grupo */
	private String objetoPerteneceGrupo = "";
	
	private ConfiguracionParametrosLdap parametrosLdap;
	private ConfiguracionMapeoLdap mapeoLdap;

	public static GestorLdapApache getInstance(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo) {
		if(instance == null){
			instance = new GestorLdapApache(parametros, mapeo);
		}
		return instance;
	}
	/**
	 * Constructor clase encargada de interactuar con el api cliente para Ldap
	 * @param parametros Objeto con la configuracion de conexion al servidor Ldap
	 * @param mapeo Objeto con la configuracion de mapeo hacia atributos Ldap
	 */
	public GestorLdapApache(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo) {
		if(parametros != null && mapeo != null){
			parametrosLdap = parametros;
			mapeoLdap = mapeo;

			baseBusqueda = mapeoLdap.getBaseBusqueda();
	
			claseObjeto = mapeoLdap.getClaseObjeto();
			objetoGrupo = mapeoLdap.getObjetoGrupo();
			objetoPerteneceGrupo = mapeoLdap.getObjetoPerteneceGrupo();
	
			LdapConnectionConfig config = new LdapConnectionConfig();
			config.setLdapHost( parametrosLdap.getLdaphost() );
			config.setLdapPort( Integer.valueOf(parametrosLdap.getLdapport()) );
			config.setName( parametrosLdap.getLdapuser() );
			config.setCredentials( parametrosLdap.getLdappassword());
			if(parametrosLdap.isLdapSsl()){
				logger.debug(this.getClass().getName(), "GestorLdapApache", "");
				config.setLdapPort( Integer.valueOf(parametrosLdap.getLdapportSsl()) );
				config.setUseSsl(parametrosLdap.isLdapSsl());
				config.setSslProtocol(parametrosLdap.getLdapSslProtocol());
				config.setTrustManagers(new NoVerificationTrustManager());
			}
			PoolableLdapConnectionFactory factory = new PoolableLdapConnectionFactory( config );
			pool = new LdapConnectionPool( factory );
			pool.setTestOnBorrow( true );
		}
	}

	/**
	 * Metodo encargado de obtener una conexion a partir del pool de conexiones hacia el ldap
	 * @return Objeto Conexion hacia el servidor Ldap
	 */
	public LdapConnection getConection(){
		try {
			if(pool != null){
				return pool.getConnection();
			}
		} catch (Exception e) {
			logger.error("getConection", "Error Obteniendo Conexion", e);
		}
		return null;
	}

	/**
	 * Metodo encargado de devolver una conexion de ldap hacia el pool de conexiones
	 * @param conection Conexion a devolver al pool
	 */
	public void releaseConection(LdapConnection conection){
		if(pool == null || conection == null){
			return;
		}
		try {
			pool.releaseConnection(conection);
		} catch (Exception e) {
			logger.error("releaseConection", "Error Liberando Conexion", e);
		}
	}

	/**
	 * Metodo encargado de crear una nueva entrada tipo usuario en el directorio ldap
	 * @param entradaUid identificador unico del usuario a crear
	 * @param entrada informacion de la entrada a crear sobre el directorio.
	 * @throws LdapException Excepcion al crear la entrada.
	 */
	public void crearEntrada(String entradaUid,Entry entrada, String ruta)throws LdapException{
		LdapConnection connection = getConection();
		try {
			if(entrada != null){
				entrada.setDn(mapeoLdap.getIdUsuario()+"="+entradaUid+","+ruta);
				connection.add(entrada);
			}
		} catch (LdapException e) {
			logger.error("crearEntrada", "Error Creando Entrada", e);
			throw e;
		}finally{
			releaseConection(connection);
		}
	}
	
	
	/**
	 * Metodo encargado de crear una nueva entidad en el directorio ldap
	 * @param entrada informacion de la entrada a crear sobre el directorio.
	 * @throws LdapException Excepcion al crear la entrada.
	 */
	public void crearEntidad(String cn, String organization, Entry entrada, String ruta)throws LdapException{
		LdapConnection connection = getConection();
		try {
			if(entrada != null){
				entrada.setDn(mapeoLdap.getObjetoEstablecimientos() + "=" + cn + "," + ruta);
				connection.add(entrada);
			}
		} catch (LdapException e) {
			logger.error("crearEntrada", "Error Creando Entrada", e);
			throw e;
		}finally{
			releaseConection(connection);
		}
		
	}
	

	/**
	 * Metodo encargado de agrear un usuario a un grupo especifico
	 * @param usuarioDn dn del usuario a agregar al grupo.
	 * @param grupoDn dn del grupo al que se agregara el usuario.
	 * @throws LdapException Exepcion a agregar el usuario al grupo
	 */
	public void agregarUsuarioGrupo(String usuarioDn,String grupoDn)throws LdapException {
		LdapConnection connection = null;
		try {
			connection = getConection();
			DefaultEntry de  = new DefaultEntry(grupoDn,mapeoLdap.getObjetoPerteneceGrupo(),usuarioDn);
			connection.modify(de, ModificationOperation.ADD_ATTRIBUTE);
			releaseConection(connection);
		} finally{
			releaseConection(connection);
		}
	}

	/**
	 * Metodo encargado de realizar una busqueda sobre el directorio mediante un parametro y un valor
	 * @param parametro tipo de objeto sobre el que se busca en el directorio.
	 * @param valor valor a encontrar para el tipo de objeto.
	 * @return Listado de entradas en el directorio encontrados con los parametros de busqueda.
	 * @throws LdapException Excepcion generada al ejecutar la consulta
	 */
	public List<Entry> ejecutarConsulta(String parametro,String valor)throws LdapException{
		logger.debug(this.getClass().getName(), "ejecutarConsulta"+ "entra metodo ejecutarConsulta");
		logger.debug(this.getClass().getName(), "ejecutarConsulta"+"valor :"+valor);
		LdapConnection connection = null;
		EntryCursor cursor = null;
		List<Entry> resultados = new ArrayList<Entry>();
		try {
			connection = getConection();
			String usuarioF = valor;
			String [] primero = usuarioF.split(",");
			String [] segundo = primero[0].toString().split("=");
			String usuarioFinal;
			if(segundo.length>1){
				usuarioFinal = segundo[1];
			}else{
				usuarioFinal = segundo[0];
			}
			cursor = connection.search(baseBusqueda, "("+parametro+"="+usuarioFinal+")", SearchScope.SUBTREE);
			while (cursor.next()){
			    resultados.add(cursor.get());
			}
			return resultados;
		}catch( CursorException e){
			throw new LdapException(e);
		}finally{
			if(cursor !=null){
				cursor.close();
			}
			releaseConection(connection);
		}
	}
	
	/**
	 * Metodo encargado de realizar una busqueda de usuario sobre el directorio mediante un uid, una ruta origen y un ou origen.
	 * @param rutaOrigen Ruta en el ldap sobre la cual se va a buscar al usuario.
	 * @param uid Identificafor del usuario a buscar.
	 * @param ouOrigen 
	 * @return Entrada (usuario) encontrada en el directorio con los parametros de busqueda
	 * @throws LdapException Excepcion generada al ejecutar la consulta
	 */
	public Entry consultarUsuarioPorUID(String rutaOrigen, String uidValor, String ouOrigen)throws LdapException{

		LdapConnection connection = null;
		EntryCursor cursor = null;
		Entry resultado = null;
		
		try {
			
			connection = getConection();
			
			cursor = connection.search(rutaOrigen, "(uid="+uidValor+")", SearchScope.SUBTREE);
			
			if(cursor.next()){
				
			    resultado = cursor.get();
			}
			
			return resultado;
			
		}catch( CursorException e){
			
			throw new LdapException(e);
			
		}finally{
			
			if(cursor !=null){
				
				cursor.close();
			}
			releaseConection(connection);
		}
	}
	
	public List<Entry> ejecutarConsultaUsuariosFiltro(String parametroUid, String valorUid, String parametroGiven, String valorGiven) throws LdapException {
		LdapConnection connection = null;
		EntryCursor cursor = null;
		List<Entry> resultados = new ArrayList<Entry>();
		try {
			connection = getConection();
			StringBuilder consulta = new StringBuilder();
			if(valorGiven != null && !valorGiven.equals("")) {
				consulta.append("(&("+parametroUid+"="+valorUid+"*)");
				consulta.append("("+parametroGiven+"="+valorGiven+"*))");
			} else {
				consulta.append("("+parametroUid+"="+valorUid+")");
			}
			
			//System.out.println("CONSULTA POR FILTRO: " + consulta.toString());
			
			cursor = connection.search(baseBusqueda, consulta.toString(), SearchScope.SUBTREE);
			while (cursor.next()){
			    resultados.add(cursor.get());
			}
			return resultados;
			
		}catch(CursorException e){
			throw new LdapException(e);
		}finally{
			if(cursor !=null){
				cursor.close();
			}
			releaseConection(connection);

		}
	}

	/**
	 * Metodo encargado de modificar un parametro de una entrada en el directorio
	 * @param entradaDn identificador de la entrada a modificar.
	 * @param atributo identificador del atributo a modificar para la entrada.
	 * @param valor nuevo valor a asignar al atributo de la entrada
	 * @param nuevo indicador si se esta agregando un nuevo atributo a la entrada a modificar
	 * @throws LdapException exepcion generada cuando se realiza la modificacion.
	 */
	public void modificarEntrada(String entradaDn,String atributo,Object valor,boolean nuevo)throws LdapException{
		LdapConnection connection = getConection();
		try {
			DefaultEntry de  = new DefaultEntry(entradaDn,atributo,valor);
			if(nuevo){
				connection.modify(de, ModificationOperation.ADD_ATTRIBUTE);
			}else{
				connection.modify(de, ModificationOperation.REPLACE_ATTRIBUTE);
			}
		}catch (LdapException e) {
			logger.error("modificarEntrada", "Error Modificando Entrada", e);
			throw e;
		}finally{
			releaseConection(connection);
		}
	}

	/**
	 * Metodo encarfado de modificar varios atributos de una entrada en el directorio.
	 * @param entradaDn Identificador de la entrada en el directorio
	 * @param atributos Listado de parejas atributo valor a modificar en el directorio, debe tener formato (atributo:valor)
	 * @param nuevo indicador si se esta agregando un nuevo atributo a la entrada a modificar
	 * @throws LdapException exepcion generada cuando se realiza la modificacion.
	 */
	public void modificarEntrada(String entradaDn,List<String> atributos,boolean nuevo)throws LdapException{
		LdapConnection connection = getConection();
		try {
			DefaultEntry de  = new DefaultEntry(entradaDn,atributos.toArray());
			String businessCategory = null;
			String employeeType = null;
			String givenName = null;
			if(de.get(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY) != null){
			 businessCategory = de.get(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase()).toString();
			}
			
			if(de.get(ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE) != null){
				employeeType = de.get(ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE.toLowerCase()).toString();
			}
			if(de.get(ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME) != null){
			 givenName = de.get(ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME.toLowerCase()).toString();
			}
			
			de.removeAttributes(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase(), 
					ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE.toLowerCase(), 
					ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME.toLowerCase());
			if(businessCategory != null){
				de.put(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY, businessCategory.split(":")[1].trim());
			}
			
			if(employeeType!= null){
				de.put(ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE, employeeType.split(":")[1].trim());
			}
			if(givenName != null){
				de.put(ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME, givenName.split(":")[1].trim());
			}
			if(nuevo){
				connection.modify(de, ModificationOperation.ADD_ATTRIBUTE);
			}else{
				connection.modify(de, ModificationOperation.REPLACE_ATTRIBUTE);
			}
		}catch (LdapException e) {
			logger.error("modificarEntrada", "Error Modificando Entrada", e);
			throw e;
		}finally{
			releaseConection(connection);
		}
	}

	/**
	 * Metodo encargado de eliminar una entrada en el directorio.
	 * @param entradaDn identificador de la entrada a eliminar
	 * @return indicador si la operación de eliminación fue exitoso o no
	 */
	public boolean eliminarEntrada(String entradaDn){
		LdapConnection connection = getConection();
		try {
			if(connection.exists(entradaDn)){
				connection.delete(entradaDn);
				return true;
			}
		} catch (LdapException e) {
			logger.error("eliminarEntrada", "Error Elimianando Entrada", e);
		}finally{
			releaseConection(connection);
		}
		return false;
	}

	/**
	 * Metodo encargado de consultar todos los grupos a los que pertenece un usuario
	 * @param usuarioDn identificador unico del usuario al que se revisan los grupos.
	 * @return Listado de entradas tipo grupo a los que pertenece el usuario
	 * @throws LdapException excepcion generada al realizar la consulta.
	 */
	public List<Entry> consultarGruposUsuario(String usuarioDn)throws LdapException{
		LdapConnection connection = getConection();
		List<Entry> resultados = new ArrayList<Entry>();
		EntryCursor cursor = null;
		try {
			StringBuilder consulta = new StringBuilder("(&("+claseObjeto+"="+objetoGrupo+")");
			consulta.append("("+objetoPerteneceGrupo+"="+usuarioDn+"))");
			//System.out.println("CONSULTA LDAP: " + consulta.toString());
			connection.setTimeOut(999999999);
			cursor = connection.search(baseBusqueda, consulta.toString()
												   , SearchScope.SUBTREE);
			
			while (cursor.next()){
			    Entry entry = cursor.get();
			    resultados.add(entry);
			}
			
			//System.out.println("ENTRADAS ENCONTRADAS: " + resultados.size());
			return resultados;
		} catch (LdapException e) {
			logger.error("consultarGruposUsuario", "Error Consulta Ldap", e);
			throw e;
		} catch( CursorException e){
			logger.error("consultarGruposUsuario", "Error Lectura de Datos Ldap", e);
			throw new LdapException(e);
		} finally {
			if(cursor != null){
				cursor.close();
			}
			releaseConection(connection);
		}
	}
	
	/**
	 * Metodo encargado de consultar todos los grupos a los que pertenece un usuario
	 * @param usuarioDn identificador unico del usuario al que se revisan los grupos.
	 * @return Listado de entradas tipo grupo a los que pertenece el usuario
	 * @throws LdapException excepcion generada al realizar la consulta.
	 */
	public List<Entry> consultarGruposPorTipo(String tipo, String rutaBusquedaGrupos)throws LdapException{
		LdapConnection connection = getConection();
		List<Entry> resultados = new ArrayList<Entry>();
		EntryCursor cursor = null;
		try {

			StringBuilder consulta = new StringBuilder("("+claseObjeto+"="+objetoGrupo+")");
			cursor = connection.search(rutaBusquedaGrupos, consulta.toString()
												   , SearchScope.SUBTREE);
			while ( cursor.next() )
			{
			    Entry entry = cursor.get();
			    resultados.add(entry);
			}
			return resultados;
		} catch (LdapException e) {
			logger.error("consultarGruposPorTipo", "Error Consulta Ldap", e);
			throw e;
		} catch( CursorException e){
			logger.error("consultarGruposPorTipo", "Error Lectura de Datos Ldap", e);
			throw new LdapException(e);
		}finally{
			if(cursor != null ){
				cursor.close();
			}
			releaseConection(connection);
		}
	}
	
	public boolean autenticarUsuario(String usuarioDn,char[] password)throws LdapException{
		LdapConnection connection = null;
		try {
			if(parametrosLdap.isLdapSsl()){
				LdapConnectionConfig config = new LdapConnectionConfig();
				config.setLdapHost( parametrosLdap.getLdaphost() );
				config.setLdapPort( Integer.valueOf(parametrosLdap.getLdapportSsl()) );
				config.setUseSsl(parametrosLdap.isLdapSsl());
				config.setSslProtocol(parametrosLdap.getLdapSslProtocol());
				config.setTrustManagers(new NoVerificationTrustManager());
				connection = new LdapNetworkConnection(config);
			}else{
				connection = new LdapNetworkConnection(parametrosLdap.getLdaphost(), Integer.valueOf(parametrosLdap.getLdapport()));
			}
			connection.bind( usuarioDn,  new String(password) );
			
			if(!connection.isConnected() && connection.isAuthenticated()){
				return false;
			}
			return true;
		} catch (LdapException e) {
			logger.error("autenticarUsuario", "Error Autenticar Ldap", e);
			throw e;
		} finally{
			try {
				connection.close();
			} catch (IOException e) {
				logger.error("autenticarUsuario", "Error al cerrar la conexion", e);
			}
		}
	}
	
	
	/**
	 * Metodo encargado de realizar una busqueda sobre el directorio de los establecimientos 
	 * @return Listado de entradas en el directorio encontrados con los parametros de busqueda.
	 * @throws LdapException Excepcion generada al ejecutar la consulta
	 */
	public List<Entry> ejecutarConsultaEstablecimientos(String rutaBase)throws LdapException{
		LdapConnection connection = null;
		EntryCursor cursor = null;
		List<Entry> resultados = new ArrayList<Entry>();
		try {
			connection = getConection();
			StringBuilder consulta = new StringBuilder("("+claseObjeto+"="+objetoGrupo+")");
			cursor = connection.search(rutaBase, consulta.toString(), SearchScope.SUBTREE);
			while (cursor.next()){
			    resultados.add(cursor.get());
			}
			return resultados;
		}catch( CursorException e){
			throw new LdapException(e);
		}finally{
			if(cursor !=null){
				cursor.close();
			}
			releaseConection(connection);
		}
	}
	
	public boolean existeGrupo(String valor)throws LdapException{
		LdapConnection connection = null;
		EntryCursor cursor = null;
		try {
			connection = getConection();
			if (connection.exists(valor)){
			    return true;
			}else{
				return false;
			}
		}finally{
			if(cursor !=null){
				cursor.close();
			}
			releaseConection(connection);
		}
	}
}
