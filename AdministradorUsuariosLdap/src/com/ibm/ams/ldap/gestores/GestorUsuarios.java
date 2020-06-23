package com.ibm.ams.ldap.gestores;

import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

import org.apache.directory.api.ldap.model.entry.DefaultEntry;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.exception.LdapException;

import com.ibm.ams.ldap.GestorLdapApache;
import com.ibm.ams.ldap.config.ConfiguracionMapeoLdap;
import com.ibm.ams.ldap.config.ConfiguracionParametrosLdap;
import com.ibm.ams.ldap.dto.Usuario;
import com.ibm.ams.ldap.dto.UsuarioModificado;
import com.ibm.ams.ldap.dto.UsuarioPassword;
import com.ibm.ams.ldap.parser.LdapParser;
import com.ibm.ams.utils.ConstantesUsuariosLDAP;
import com.ibm.ams.log.LoggerInst;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*
*   <p><b>Descripción: </b>
*   <p>Clase que implementa la funcionalidad de administracion de usuarios en ldap
*
*
* 	<p><b>Notas: </b>
*   <p> requiere recibir la configuracion de conexion para lograr conexion al servidor
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
public class GestorUsuarios implements IGestorUsuarios{

	/** Instancia del Logger. */
	private static LoggerInst logger = new LoggerInst(GestorUsuarios.class,
			ConstantesUsuariosLDAP.NOMBRE_APLICACION,
			ConstantesUsuariosLDAP.NOMBRE_APLICACION);
	
	/**
	 * Instancia del Gestor Usuarios para utilizar con el patron singleton
	 */
	private static GestorUsuarios instance;

	/**
	 * Objeto con los metodos a bajo nivel para la conexion con ldap
	 */
	private GestorLdapApache gestorLdap;
	/**
	 * Objeto con la configuración de objetos tipo grupo y usuario
	 */
	private ConfiguracionMapeoLdap mapeoLdap;

	/**
	 * Constructor del la clase encargada de ofrecer las funcionalidades
	 * requeridas para la administracion de usuarios en el directorio
	 * corporativo.
	 * 
	 * @param parametros
	 *            parametros de conexion al servidor
	 * @param mapeo
	 *            parametros de configuracion de nombres del directorio.
	 */
	private GestorUsuarios(ConfiguracionParametrosLdap parametros,
			ConfiguracionMapeoLdap mapeo) {
		gestorLdap = GestorLdapApache.getInstance(parametros, mapeo);
		mapeoLdap = mapeo;
	}

	/**
	 * metodo encargado de obtener una instancia del gestor de usuarios, se usa
	 * el patron singleton
	 * 
	 * @param parametros
	 *            parametros de conexion al servidor
	 * @param mapeo
	 *            parametros de configuracion de nombres del directorio.
	 * @return instancia del gestor de usuarios
	 */
	public static GestorUsuarios getInstance(
			ConfiguracionParametrosLdap parametros, ConfiguracionMapeoLdap mapeo) {
		if(instance == null){
			instance = new GestorUsuarios(parametros,mapeo);
		}
		return instance;
	}

	/**
	 * metodo encargado para consultar la información de un usuario en el directorio corporativo
	 * @param identificador de el usuario a consultar
	 * @return Objeto usuario con la informacion consultada del directorio
	 */
	public Usuario consultarUsuario(String uid) {
		if(uid == null){
			return null;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uid);

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry usuario = resultados.get(0);

			List<Entry> resultadosGrupo = gestorLdap.consultarGruposUsuario(usuario.getDn().getName());

			Usuario usuarioDto = new Usuario();
			usuarioDto = (Usuario)LdapParser.toLdapObject(usuarioDto.getClass(), usuario.toString());

			if(usuarioDto == null){
				return null;
			}
			if(usuario.get("homephone")!=null){
				if(!usuario.get("homephone").getString().isEmpty()){
					usuarioDto.setTelefono(usuario.get("homephone").getString());
				}else{
					usuarioDto.setTelefono(null);
				}
			}
			if(usuario.get("givenname")!=null){
				if(!usuario.get("givenname").getString().isEmpty()){
				usuarioDto.setNombreComercio(usuario.get("givenname").getString());
				}else{
					usuarioDto.setNombreComercio(null);
				}
			}
			List<String> grupos = new ArrayList<String>();
			for(Entry e : resultadosGrupo){
				grupos.add(e.get(mapeoLdap.getIdGrupo()).getString());
			}
			usuarioDto.setGrupos(grupos);
			return usuarioDto;
		} catch (LdapException e) {
			logger.error("consultarUsuario"," Error Ldap",e);
		} catch (IllegalAccessException e) {
			logger.error("consultarUsuario"," Error Clase",e);
		} catch (InstantiationException e) {
			logger.error("consultarUsuario"," Error Instancia",e);
		}catch (Exception e){
			logger.error("consultarUsuario"," Error en LDAP "+e.getMessage() ,e);
		}

		return null;
	}
	
	/**
	 * metodo encargado para consultar la información de un usuarioModificado en el directorio corporativo
	 * @param identificador de el usuario a consultar
	 * @return Objeto usuario con la informacion consultada del directorio
	 */
	public UsuarioModificado consultarUsuarioModificar(String uid) {
		if(uid == null){
			return null;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uid);

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry usuario = resultados.get(0);

			List<Entry> resultadosGrupo = gestorLdap.consultarGruposUsuario(resultados.get(0).getDn().getName());

			UsuarioModificado usuarioDto = new UsuarioModificado();
			usuarioDto = (UsuarioModificado)LdapParser.toLdapObject(usuarioDto.getClass(), usuario.toString());

			if(usuarioDto == null){
				return null;
			}

			List<String> grupos = new ArrayList<String>();
			for(Entry e : resultadosGrupo){
				grupos.add(e.get(mapeoLdap.getIdGrupo()).getString());
			}
			usuarioDto.setGrupos(grupos);
			return usuarioDto;
		} catch (LdapException e) {
			logger.error("consultarUsuario"," Error Ldap",e);
		} catch (IllegalAccessException e) {
			logger.error("consultarUsuario"," Error Clase",e);
		} catch (InstantiationException e) {
			logger.error("consultarUsuario"," Error Instancia",e);
		}

		return null;
	}
	
	
	public List<Usuario> consultarUsuarioFiltros(String uid, String givenName, List<String> roles, String abreviaturaApp) {
		if(uid == null) {
			return null;
		}
		
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			List<Entry> resultados = gestorLdap.ejecutarConsultaUsuariosFiltro(mapeoLdap.getIdUsuario(), uid, mapeoLdap.getAtributosPersona().get(0), givenName);

			if(resultados == null || resultados.isEmpty()) {
				return null;
			}
			
			for (Entry entry : resultados) {
				List<Entry> resultadosGrupo = gestorLdap.consultarGruposUsuario(entry.getDn().getName());

				Usuario usuarioDto = new Usuario();
				usuarioDto = (Usuario)LdapParser.toLdapObject(usuarioDto.getClass(), entry.toString());

				if(usuarioDto == null) {
					return null;
				}

				List<String> grupos = new ArrayList<String>();
				for(Entry e : resultadosGrupo) {
					grupos.add(e.get(mapeoLdap.getIdGrupo()).getString());
				}
				
				if (roles != null && !roles.isEmpty()) {
					if (ConstantesUsuariosLDAP.APP_BOTON.equals(roles.get(0)) && abreviaturaApp != null) {
						if (usuarioDto.getApellidos() != null && usuarioDto.getApellidos().contains(abreviaturaApp)) {
							usuarios.add(usuarioDto);
						}
					} else if(ConstantesUsuariosLDAP.APP_CONEX_DIREC.equals(roles.get(0)) && abreviaturaApp != null) {
						if (usuarioDto.getApellidos() != null && usuarioDto.getApellidos().contains(abreviaturaApp)) {
							usuarios.add(usuarioDto);
						}
					} else {
						boolean encuentraRol = false;
						for (String rol : roles) {
							if (grupos.contains(rol)) {
								usuarioDto.setGrupos(grupos);
								encuentraRol = true;
							}
						}
						
						if (encuentraRol) {
							usuarios.add(usuarioDto);
						}
					}
				} else {
					// Si no se envia el rol como filtro se toman todos los resultados
					usuarioDto.setGrupos(grupos);
					usuarios.add(usuarioDto);
				}
				
			}		
			return usuarios;
		} catch (LdapException e) {
			logger.error("consultarUsuario"," Error Ldap",e);
		} catch (IllegalAccessException e) {
			logger.error("consultarUsuario"," Error Clase",e);
		} catch (InstantiationException e) {
			logger.error("consultarUsuario"," Error Instancia",e);
		}

		return null;
	}

	@Override
	/**
	 * metodo encargado de crear un usuario en el directorio
	 * @param usuario objeto con la informacion de usuario a crear.
	 *
	 */
	public void crearUsuario(Usuario usuario, String ruta) {
		if(usuario == null){
			return;
		}
		try {
			List<String> atributos = LdapParser.toLdapAttrList(usuario);
			DefaultEntry entrada = new DefaultEntry(mapeoLdap.getIdUsuario()+"="+usuario.getLogin(), atributos.toArray());
			entrada.add(ConstantesUsuariosLDAP.ENTRADA, usuario.getNombres()+" "+usuario.getApellidos());
			gestorLdap.crearEntrada(usuario.getLogin(), entrada, ruta);
		} catch (LdapException e) {
			logger.error("crearUsuario"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("crearUsuario"," Error Instancia",e);
		} catch (IllegalAccessException e) {
			logger.error("crearUsuario"," Error Instanciacion",e);
		}


	}
	
	@Override
	public void crearUsuarioNuevo(Usuario usuario, String ruta) throws Exception {
		if(usuario == null){
			return;
		}
		try {
			List<String> atributos = LdapParser.toLdapAttrList(usuario);
			DefaultEntry entrada = new DefaultEntry(mapeoLdap.getIdUsuario()+"="+usuario.getLogin(), atributos.toArray());
			
			String businessCategory = entrada.get(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase()).toString();
			String employeeType = entrada.get(ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE.toLowerCase()).toString();
			String givenName = entrada.get(ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME.toLowerCase()).toString();
			
			entrada.removeAttributes(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY.toLowerCase(), 
					ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE.toLowerCase(), 
					ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME.toLowerCase());
			
			entrada.put(ConstantesUsuariosLDAP.CAMPO_BUSINESS_CATEGORY, businessCategory.split(":")[1].trim());
			entrada.put(ConstantesUsuariosLDAP.CAMPO_EMPLOYEE_TYPE, employeeType.split(":")[1].trim());
			entrada.put(ConstantesUsuariosLDAP.CAMPO_GIVEN_NAME, givenName.split(":")[1].trim());
			
			gestorLdap.crearEntrada(usuario.getLogin(), entrada, ruta);
		} catch (LdapException e) {
			logger.error("crearUsuario"," Error Ldap",e);
			throw new Exception("Error Ldap");
		} catch (IllegalArgumentException e) {
			logger.error("crearUsuario"," Error Instancia",e);
			throw new Exception("Error Ldap");
		} catch (IllegalAccessException e) {
			logger.error("crearUsuario"," Error Instanciacion",e);
			throw new Exception("Error Ldap");
		}


	}


	@Override
	/**
	 * metodo encargado de eliminar un usuario del directorio corporativo
	 * @param uid identificador del usuario a eliminar.
	 * @return indicador si el usuario fue eliminado exitosamente del directorio
	 */
	public boolean eliminarUsuario(String uid) {
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uid);

			if(resultados.isEmpty()){
				return true;
			}else{
				logger.debug("eliminarUsuario", "Numero Resultados: %s", resultados.size());
				Entry usuario = resultados.get(0);
				String dnUsuario = usuario.getDn().getName();
				logger.debug("eliminarUsuario", "Dn Usuario eliminar: %s", dnUsuario);

				boolean  eliminado = gestorLdap.eliminarEntrada(dnUsuario);
				return eliminado;
			}
		} catch (LdapException e) {
			logger.error("eliminarUsuario"," Error Ldap",e);
		}
		return false;
	}
	
	/**
	 * Metodo encargado de eliminar un usuario del directorio corporativo por OU.
	 * @param rutaOrigen de la cual se va a eliminar el usuario.
	 * @param uid identificador del usuario a eliminar.
	 * @return indicador si el usuario fue eliminado exitosamente del directorio.
	 */
	public boolean eliminarUsuarioPorOU(String rutaOrigen, String uid) {
		
		try {
			
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uid);
			Iterator<Entry> iterator = resultados.iterator();
			
			while(iterator.hasNext()){
				
				Entry usuario = iterator.next();
				
				if(usuario != null){
					
					String rutaUsuario = usuario.getDn().getName();
					String rutacn = rutaUsuario.substring(rutaUsuario.indexOf(",")+1);
					
					if(rutacn.equalsIgnoreCase(rutaOrigen)){
						
						logger.debug("eliminarUsuario", "Numero Resultados: %s", resultados.size());
						usuario = resultados.get(0);
						String dnUsuario = usuario.getDn().getName();
						logger.debug("eliminarUsuario", "Dn Usuario eliminar: %s", dnUsuario);

						boolean  eliminado = gestorLdap.eliminarEntrada(dnUsuario);
						return eliminado;
					}
				}
			}
		} catch (LdapException e) {
			
			logger.error("eliminarUsuario"," Error Ldap",e);
		}
		return false;
	}

	@Override
	/**
	 * Metodo encargado de modificar la informacion de un usuario en el directorio.
	 * @param usuario objeto con la informacion del usuario a modificar.
	 */
	public void modificar(Usuario usuario) {

		if(usuario == null){
			return;
		}

		try {
			List<String> atributos = LdapParser.toLdapAttrList(usuario);
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), usuario.getLogin());
			logger.debug("modificar", "Numero Resultados: %s", resultados.size());
			Entry eUsuario = resultados.get(0);
			String dnUsuario = eUsuario.getDn().getName();
			logger.debug("modificar","Dn Usuario actualizar: %s", dnUsuario);

			gestorLdap.modificarEntrada(dnUsuario, atributos, false);
		} catch (LdapException e) {
			logger.error("modificar"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("modificar"," Error Instancia",e);
		} catch (IllegalAccessException e) {
			logger.error("modificar"," Error Instanciacion",e);
		}
	}
	
	@Override
	/**
	 * Metodo con el cual se modifica las dos últimas fechas de ingreo de un usuario en el directorio corporativo
	 * @param usuario objeto con la informacion del usuario a modificar.
	 */
	public void modificarUsuario(UsuarioModificado usuarioModificado) {

		if(usuarioModificado == null){
			return;
		}

		try {
			List<String> atributos = LdapParser.toLdapAttrList(usuarioModificado);
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), usuarioModificado.getLogin());
			logger.debug("modificar", "Numero Resultados: %s", resultados.size());
			Entry eUsuario = resultados.get(0);
			String dnUsuario = eUsuario.getDn().getName();
			logger.debug("modificar","Dn Usuario actualizar: %s", dnUsuario);

			gestorLdap.modificarEntrada(dnUsuario, atributos, false);
		} catch (LdapException e) {
			logger.error("modificar"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("modificar"," Error Instancia",e);
		} catch (IllegalAccessException e) {
			logger.error("modificar"," Error Instanciacion",e);
		}
	}

	@Override
	/**
	 * Metodo con el cual se modifica las dos últimas fechas de ingreo de un usuario en el directorio corporativo
	 * @param usuario objeto con la informacion del usuario a modificar.
	 */
	public void modificarUsuarioSinPassword(UsuarioPassword usuarioPass) {

		if(usuarioPass == null){
			return;
		}

		try {
			List<String> atributos = LdapParser.toLdapAttrList(usuarioPass);
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), usuarioPass.getLogin());
			logger.debug("modificar", "Numero Resultados: %s", resultados.size());
			Entry eUsuario = resultados.get(0);
			String dnUsuario = eUsuario.getDn().getName();
			logger.debug("modificar","Dn Usuario actualizar: %s", dnUsuario);

			gestorLdap.modificarEntrada(dnUsuario, atributos, false);
		} catch (LdapException e) {
			logger.error("modificar"," Error Ldap",e);
		} catch (IllegalArgumentException e) {
			logger.error("modificar"," Error Instancia",e);
		} catch (IllegalAccessException e) {
			logger.error("modificar"," Error Instanciacion",e);
		}
	}

	
	/**
	 * Metodo encargado de cambiar la constraseña de un usuario
	 * @param uidUsuario identificador de usuario a modificar
	 * @param password constraseña a asignar al usuario
	 */
	@Override
	public boolean cambiarPassword(String uidUsuario, String password) {
		if(null == uidUsuario || uidUsuario.isEmpty() || null == password || password.isEmpty()){
			return false;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uidUsuario);
			logger.debug("cambiarPassword","Numero Resultados: %s", resultados.size());
			Entry usuario = resultados.get(0);
			String dnUsuario = usuario.getDn().getName();
			logger.debug("cambiarPassword","Dn Usuario cambiar: %s",dnUsuario);

			gestorLdap.modificarEntrada(dnUsuario, "userPassword", password, false);
			return true;

		} catch (LdapException e) {
			logger.error("cambiarPassword"," Error Ldap",e);
			return false;
		}


	}
	/**
	 * Metodo encargado de cambiar la constraseña de un usuario La próxima vez
	 * que el usuario inicia sesion se le pide cambir la contraseña
	 * 
	 * @param uidUsuario
	 *            identificador de usuario a modificar
	 * @param password
	 *            constraseña a asignar al usuario
	 */

	public boolean cambiarPassword2(String uidUsuario, String password) {
		if (null == uidUsuario || uidUsuario.isEmpty() || null == password
				|| password.isEmpty()) {
			return false;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdUsuario(), uidUsuario);
			// logger.debug("cambiarPassword","Numero Resultados: %s",
			// resultados.size());
			Entry usuario = resultados.get(0);
			String dnUsuario = usuario.getDn().getName();
			// logger.debug("cambiarPassword","Dn Usuario cambiar: %s",dnUsuario);

			gestorLdap.modificarEntrada(dnUsuario, "userPassword", password,
					false);
			gestorLdap
					.modificarEntrada(dnUsuario, "description", "null", false);
			return true;

		} catch (LdapException e) {
			logger.error("cambiarPassword", " Error Ldap", e);
			return false;
		}

	}
	
	/**
	 * Metodo encargado de asociar un grupo a un usuario
	 * @param uidUsuario identificador del usuario al que se cambia la constraseña
	 * @param cnGrupo identificardor del grupo a asociar con el usuario.
	 */
	@Override
	public void asociarGrupo(String uidUsuario, String cnGrupo, String tipoEntidad) {
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uidUsuario);
			logger.debug( "asociarGrupo","Numero Resultados: %s", resultados.size());
			if(resultados == null || resultados.isEmpty()){
				return;
			}
			Entry usuario = resultados.get(0);
			String dnUsuario = usuario.getDn().getName();
			logger.debug( "asociarGrupo","Dn Usuario asociar: %s", dnUsuario);

			List<Entry> resultadosGrupo = gestorLdap.ejecutarConsulta(mapeoLdap.getIdGrupo(), cnGrupo);
			Entry grupo = null;
			if(cnGrupo.equalsIgnoreCase("tieneToken") && tipoEntidad.equalsIgnoreCase("Entidad")){
				grupo = resultadosGrupo.get(1);
			}else if(cnGrupo.equalsIgnoreCase("tieneToken") && tipoEntidad.equalsIgnoreCase("Redeban")){
					for (Entry g : resultadosGrupo) {
						if(g.getDn().getName().contains("ou=redeban")){
							grupo = g;
							break;
						}
					}
			} else {
				grupo = resultadosGrupo.get(0);
			}
			String dnGrupo = grupo.getDn().getName();
			logger.debug( "asociarGrupo","Dn Grupo actualizar: %s", dnGrupo);
			
			gestorLdap.agregarUsuarioGrupo(dnUsuario, dnGrupo);

		} catch (LdapException e) {
			logger.error("asociarGrupo"," Error Ldap",e);
		}
	}

	public void asociarGrupo(String uidUsuario, String cnGrupo,
			String tipoEntidad, String rutaGrupos) {
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdUsuario(), uidUsuario);
			logger.debug("asociarGrupo", "Numero Resultados: %s",
					resultados.size());
			if (resultados == null || resultados.isEmpty()) {
				return;
			}
			Entry usuario = resultados.get(0);
			String dnUsuario = usuario.getDn().getName();
			logger.debug("asociarGrupo", "Dn Usuario asociar: %s", dnUsuario);

			List<Entry> resultadosGrupo = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdGrupo(), cnGrupo);
			String dnGrupo = null;
			// dependiendo del tipo entidad del grupo, decide cual cn
			// "tieneTokenUsar"

			if (cnGrupo.equalsIgnoreCase("tieneToken") && tipoEntidad != null) {

				dnGrupo = rutaGrupos;

			}

			if (dnGrupo == null)
				dnGrupo = resultadosGrupo.get(0).getDn().getName();

			logger.debug("asociarGrupo", "Dn Grupo actualizar: %s", dnGrupo);

			gestorLdap.agregarUsuarioGrupo(dnUsuario, dnGrupo);

		} catch (LdapException e) {
			logger.error("asociarGrupo", " Error Ldap", e);
		}
	}
	
	/**
	 * Metodo encargado de asociar un grupo a un usuario de web prepago
	 * @param uidUsuario identificador del usuario al que se cambia la constraseña
	 * @param cnGrupo identificardor del grupo a asociar con el usuario.
	 * @throws Exception 
	 */

	public void asociarGrupoWP(String uidUsuario, String cnGrupo, String tipoEntidad, String RutaGrupos) throws Exception {
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uidUsuario);
			logger.debug( "asociarGrupo","Numero Resultados: %s", resultados.size());
			if(resultados == null || resultados.isEmpty()){
				return;
			}
			Entry usuario = resultados.get(0);
			String dnUsuario = usuario.getDn().getName();
			logger.debug( "asociarGrupo","Dn Usuario asociar: %s", dnUsuario);

			/*List<Entry> resultadosGrupo = gestorLdap.ejecutarConsulta(mapeoLdap.getIdGrupo(), cnGrupo);
			Entry grupo = null;
			if(cnGrupo.equalsIgnoreCase("tieneToken") && tipoEntidad.equalsIgnoreCase("Entidad")){
				grupo = resultadosGrupo.get(1);
			} else {
				grupo = resultadosGrupo.get(0);
			}
			String dnGrupo = grupo.getDn().getName();
			logger.debug( "asociarGrupo","Dn Grupo actualizar: %s", dnGrupo);
			*/
			//cn=Tarjeta Habiente,cn=grupos,ou=personas,DC=REDEBAN,DC=COM
			String dnGrupoWP = RutaGrupos;
			if(gestorLdap.existeGrupo(dnGrupoWP)){
				gestorLdap.agregarUsuarioGrupo(dnUsuario, dnGrupoWP);
			}else{
				throw new Exception("El grupo"+dnGrupoWP+" no existe");
			}
			//gestorLdap.agregarUsuarioGrupo(dnUsuario, dnGrupo);

		} catch (LdapException e) {
			logger.error("asociarGrupo"," Error Ldap",e);
		}
	}

	/**
	 * Metodo encargado de consultar los nombres de grupo tipo entidad a los cuales pertenece
	 * @param idUsuario identificador del usuario para el cual se consulta el listado de entidades a las que pertenece
	 * @return Listado de entidades a las que perenece el usuario en el directorio
	 */
	public List<String> consultarListaEntidades(String idUsuario) {
		try {
			if(idUsuario == null){
				return null;
			}

			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), idUsuario);
			logger.debug( "consultarListaEntidades","Numero de resultados de usuario: %s", resultados.size());

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry usuario = resultados.get(0);

			System.out.println("ENTRY CONSULTADO: " + usuario.getDn().getName());
			
			List<Entry> resultadosGrupo = gestorLdap.consultarGruposUsuario(usuario.getDn().getName());
			if(resultadosGrupo == null || resultadosGrupo.isEmpty()){
				logger.debug( "consultarListaEntidades","El usuario no tiene grupos: %s", idUsuario);
				return null;
			}
			
			System.out.println("CANTIDAD DE GRUPOS CONSULTADOS: " + resultadosGrupo.size());
			
			List<String> gruposEntidad = new ArrayList<String>();

			for(Entry entrada : resultadosGrupo){
				
				String dn = entrada.getDn().toString();
				System.out.println("ENTIDAD: " + dn);
				logger.debug( "consultarListaEntidades","Dn del Grupo: %s", dn);
				int lugar_ou = dn.lastIndexOf(ConstantesUsuariosLDAP.INDEX);
				String estructuraUnidad = dn.substring(0,lugar_ou-1);
				logger.debug("consultarListaEntidades", "Estructura Unidad: %s", estructuraUnidad);
				System.out.println("Estructura Unidad: " + estructuraUnidad);

				int lugarUltimoGrupo = estructuraUnidad.lastIndexOf(mapeoLdap.getIdGrupo());
				String nomGrupo = estructuraUnidad.substring(lugarUltimoGrupo+3);

				if(!nomGrupo.equals(ConstantesUsuariosLDAP.GRUPOS) && entrada.get(ConstantesUsuariosLDAP.ORGANIZATION) != null){
					System.out.println("entidad: " + entrada.getDn().getName());
					logger.debug("consultarListaEntidades","Entidad: %s", entrada, null);
					String idEntidad = entrada.get(ConstantesUsuariosLDAP.ORGANIZATION).getString();
					gruposEntidad.add(idEntidad);
				}

			}
			return gruposEntidad;

		} catch (LdapException e) {
			logger.error("consultarListaEntidades"," Error Ldap",e);
		}
		return null;
	}

	/**
	 * Metodo encargado de determinar si un usuario pertenece al grupo de redeban
	 * @param idUsuario Identificador unico del usuario a consultar
	 * @return idicador si el usuario pertenece a redeban o no
	 */
	public boolean esUsuarioRedeban(String idUsuario){
		try {
			if(idUsuario == null){
				return false;
			}

			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), idUsuario);
			logger.debug( "esUsuarioRedeban","Numero de resultados de usuario: %s", resultados.size(), null);

			if(resultados == null || resultados.isEmpty()){
				return false;
			}

			Entry usuario = resultados.get(0);

			String dn = usuario.getDn().getName();

			String[] tokenDn = dn.split(ConstantesUsuariosLDAP.SPLIT_COMA);

			if(tokenDn != null && tokenDn.length < 5){
				return true;
			}

		} catch (LdapException e) {
			logger.error("esUsuarioRedeban"," Error Ldap",e);
		}
		return false;
	}
	
	/**
	 * Metodo encargado de consultar los nombres de grupo a los que pertenece un usuario
	 * @param idUsuario identificador del usuario para el cual se consulta el listado de entidades a las que pertenece
	 * @return Listado de grupos a las que perenece el usuario en el directorio
	 */
	public List<String> consultarGruposPorTipo(String tipo, String rutaBusquedaGrupos) {
		try {
			if(tipo == null){
				return null;
			}

			List<Entry> resultadosGrupo = gestorLdap.consultarGruposPorTipo(tipo, rutaBusquedaGrupos);
			if(resultadosGrupo == null || resultadosGrupo.isEmpty()){
				return null;
			}

			List<String> grupos = new ArrayList<String>();

			for(Entry entrada : resultadosGrupo){

				String cn = entrada.get(ConstantesUsuariosLDAP.ENTRADA).toString();
				if(!grupos.contains(cn)){
					cn = cn.subSequence(4, cn.length()).toString();
					grupos.add(cn);
				}
			}
			return grupos;

		} catch (LdapException e) {
			logger.error("consultarListaEntidades"," Error Ldap",e);
		}
		return null;
	}
	
	/**
	 * Metodo encargado de consultar los nombres de grupo a los que pertenece un usuario
	 * @param idUsuario identificador del usuario para el cual se consulta el listado de entidades a las que pertenece
	 * @return Listado de grupos a las que perenece el usuario en el directorio
	 */
	public List<String> consultarGruposUsuario(String idUsuario) {
		try {
			if(idUsuario == null){
				return null;
			}

			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), idUsuario);
			logger.debug("consultarGruposUsuario", "Numero de resultados de usuario: %s", resultados.size());

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry usuario = resultados.get(0);

			List<Entry> resultadosGrupo = gestorLdap.consultarGruposUsuario(usuario.getDn().getName());
			if(resultadosGrupo == null || resultadosGrupo.isEmpty()){
				logger.debug("consultarGruposUsuario", "El usuario no tiene grupos: %s", idUsuario);
				return null;
			}

			List<String> grupos = new ArrayList<String>();

			for(Entry entrada : resultadosGrupo){

				String dn = entrada.getDn().toString();
				logger.debug("consultarGruposUsuario", "Dn del Grupo: %s", dn);
				grupos.add(dn);

			}
			return grupos;

		} catch (LdapException e) {
			logger.error("consultarGruposUsuario", "Error Ldap: ",e);
		}
		return null;
	}
	
	/**
	 * metodo encargado de autenticar un usuario ante el directorio
	 * @param identificador de el usuario a autenticar
	 * @return boolean indicando si el usuario se autentico exitosamente
	 */
	public boolean autenticarUsuario(String uid,char[] password) {
		if(uid == null || password == null || password.length == 0){
			return false;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdUsuario(), uid);
			logger.debug( "consultarUsuario", "Numero de resultados de usuario: %s", resultados.size());

			if(resultados == null || resultados.isEmpty()){
				return false;
			}

			Entry usuario = resultados.get(0);
			
			boolean autenticado = gestorLdap.autenticarUsuario(usuario.getDn().toString(), password);
			return autenticado;						
		} catch (LdapException e) {
			logger.error("consultarUsuario"," Error Ldap",e);
			return false;
		} 
	}
	public boolean usuarioVencido(String uid, char[] password,
			long diasVencimiento) {
		if (uid == null || password == null || password.length == 0) {
			return false;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdUsuario(), uid);
			logger.debug("consultarUsuario",
					"Numero de resultados de usuario: %s", resultados.size());

			if (resultados == null || resultados.isEmpty()) {
				return false;
			}

			Usuario consultado = this.consultarUsuario(uid);
			Date fecha = new Date();
			if (consultado.getUltimoCambioFecha() != null && !consultado.getUltimoCambioFecha().equals("null")) {
				fecha = new SimpleDateFormat(
						ConstantesUsuariosLDAP.FORMATO_FECHA,
						ConstantesUsuariosLDAP.FORMATO_COLOMBIA)
						.parse(consultado.getUltimoCambioFecha());
			} else {
				// no tiene el parametor en el LDAP
				return false;
			}

			long total = System.currentTimeMillis() - fecha.getTime();

			if (total > diasVencimiento) {
				return true;
			}

			return false;
		} catch (LdapException e) {
			logger.error("consultarUsuario", " Error Ldap", e);
			return false;
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("consultarUsuario", " Error Ldap", e);
			return false;
		}

	}
	public int diasRestantesVencimiento(String uid, char[] password,
			long milisVencimiento) {
		if (uid == null || password == null || password.length == 0) {
			return -1;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdUsuario(), uid);
			logger.debug("consultarUsuario",
					"Numero de resultados de usuario: %s", resultados.size());

			if (resultados == null || resultados.isEmpty()) {
				return -1;
			}

			Usuario consultado = this.consultarUsuario(uid);
			Date fechaUltimoCambio = new Date();
			if (consultado.getUltimoCambioFecha() != null && !consultado.getUltimoCambioFecha().equals("null")) {
				fechaUltimoCambio = new SimpleDateFormat(
						ConstantesUsuariosLDAP.FORMATO_FECHA,
						ConstantesUsuariosLDAP.FORMATO_COLOMBIA)
						.parse(consultado.getUltimoCambioFecha());
			} else {
				// no tiene el parametor en el LDAP
				return -1;
			}
			// fecha vencimiento- fecha actual
			long milisRestantes = (fechaUltimoCambio.getTime() + milisVencimiento)
					- System.currentTimeMillis();
			int diasRestantes = (int) (milisRestantes / (1000 * 3600 * 24));
			return diasRestantes;
		} catch (LdapException e) {
			logger.error("consultarUsuario", " Error Ldap", e);
			return -1;
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("consultarUsuario", " Error Ldap", e);
			return -1;
		}

	}

	public boolean verificarAdvertencia(String uid, char[] password,
			long diasAdvertencia) {
		if (uid == null || password == null || password.length == 0) {
			return false;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(
					mapeoLdap.getIdUsuario(), uid);
			logger.debug("consultarUsuario",
					"Numero de resultados de usuario: %s", resultados.size());

			if (resultados == null || resultados.isEmpty()) {
				return false;
			}

			Usuario consultado = this.consultarUsuario(uid);
			Date fecha = new Date();
			if (consultado.getUltimoCambioFecha() != null && !consultado.getUltimoCambioFecha().equals("null")) {
				fecha = new SimpleDateFormat(
						ConstantesUsuariosLDAP.FORMATO_FECHA,
						ConstantesUsuariosLDAP.FORMATO_COLOMBIA)
						.parse(consultado.getUltimoCambioFecha());
			}

			long total = System.currentTimeMillis() - fecha.getTime();

			if (total > diasAdvertencia) {
				return true;
			}

			return false;
		} catch (LdapException e) {
			logger.error("consultarUsuario", " Error Ldap", e);
			return false;
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("consultarUsuario", " Error Ldap", e);
			return false;
		}

	}

}
