package com.ibm.ams.ldap.gestores;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.directory.api.ldap.model.entry.Attribute;
import org.apache.directory.api.ldap.model.entry.Entry;
import org.apache.directory.api.ldap.model.entry.Value;
import org.apache.directory.api.ldap.model.exception.LdapException;

import com.ibm.ams.ldap.GestorLdapApache;
import com.ibm.ams.ldap.config.ConfiguracionMapeoLdap;
import com.ibm.ams.ldap.config.ConfiguracionParametrosLdap;
import com.ibm.ams.ldap.dto.Grupo;
import com.ibm.ams.ldap.parser.LdapParser;
import com.ibm.ams.utils.ConstantesUsuariosLDAP;
import com.ibm.ams.log.LoggerInst;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*
*   <p><b>Descripcion: </b>
*   <p>Clase que implementa la funcionalidad de administracion de grupos en ldap
*
*
* 	<p><b>Notas: </b>
*   <p> requiere recibir la configuracion de conexion para lograr conexion al servidor
*
* 	<p><b>Proyecto base: </b> CompensacionPortlet
*
*   @author <A HREF="mailto:oballest@co.ibm.com">Oscar Arturo Ballesteros</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 05/sep/2013
*
*   @version 1.0, 06/sep/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0
*	<p>- Creacion de la clase.
*	<p>- Creacion de documentacion.
**/
public class GestorGrupos implements IGestorGrupos {

	/** Instancia del Logger. */
	private static LoggerInst logger = new LoggerInst(GestorGrupos.class, ConstantesUsuariosLDAP.NOMBRE_APLICACION, ConstantesUsuariosLDAP.NOMBRE_APLICACION);
	
	/**
	 * Singleton con la instancia de esta clase
	 */
	private static GestorGrupos instance;
	/**
	 * Objeto con la funcionalidad a bajo nivel con los metodos de acceso a Ldap
	 */
	private GestorLdapApache gestorLdap;
	/**
	 * Objeto con la configuracion de objetos tipo grupo y usuario
	 */
	private ConfiguracionMapeoLdap mapeoLdap;

	/**
	 * Constructor de la clase gestor grupos, encargada de ejecutar logica en ldap correspondiente a grupos
	 * @param parametros objeto con la configuracion de conexion a ldap.
	 * @param mapeo parametros con la configuracion de atributos del directorio
	 */
	private GestorGrupos(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo) {
		gestorLdap = GestorLdapApache.getInstance(parametros, mapeo);
		this.mapeoLdap = mapeo;
	}

	/**
	 * Metodo encargado de obtener una instancia del gestor de grupos utilizando el patron singleton
	 * @param parametros parametros objeto con la configuracion de conexion a ldap.
	 * @param mapeo parametros con la configuracion de atributos del directorio
	 * @return
	 */
	public static GestorGrupos getInstance(ConfiguracionParametrosLdap parametros,ConfiguracionMapeoLdap mapeo){
		if(instance == null){
			instance = new GestorGrupos(parametros,mapeo);
		}
		return instance;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.ibm.ams.ldap.gestores.IGestorGrupos#consultarGrupo(java.lang.String)
	 */
	public Grupo consultarGrupo(String cnGrupo) {
		if(cnGrupo == null){
			return null;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdGrupo(), cnGrupo);
			logger.debug("consultarGrupo", "Grupo "+resultados.get(0));

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry grupo = resultados.get(0);
			Grupo g = new Grupo();

			String[] valores = grupo.toString().split(ConstantesUsuariosLDAP.SPLIT_NUEVA_LINEA);
			List<String> valoresL = new ArrayList<String>();
			for(String valor : valores){
				String[] tokens = valor.split(ConstantesUsuariosLDAP.SPLIT_DOS_PUNTOS);
				if(tokens.length == ConstantesUsuariosLDAP.LONGITUD_TOKEN){
					valoresL.add(valor);
				}
			}
			g = (Grupo) LdapParser.toLdapObject(g.getClass(), valoresL);

			return g;

		} catch (LdapException e) {
			logger.error("consultarGrupo", "Error Ldap", e);
		} catch (IllegalAccessException e) {
			logger.error("consultarGrupo", "Error Instancia", e);
		} catch (InstantiationException e) {
			logger.error("consultarGrupo", "Error Instanciacion", e);
		}

		return null;
	}

	@Override
	/*
	 * (non-Javadoc)
	 * @see com.ibm.ams.ldap.gestores.IGestorGrupos#getUsuarios(java.lang.String)
	 */
	public List<String> getUsuarios(String cnGrupo) {
		if(cnGrupo == null){
			return null;
		}
		try {
			List<Entry> resultados = gestorLdap.ejecutarConsulta(mapeoLdap.getIdGrupo(), cnGrupo);
			
			logger.debug("consultarGrupo", "Grupo "+resultados.get(0), "");

			if(resultados == null || resultados.isEmpty()){
				return null;
			}

			Entry grupo = resultados.get(0);
			Attribute att = grupo.get(mapeoLdap.getObjetoPerteneceGrupo());
			List<String> usuarios = new ArrayList<String>();
			Iterator<Value<?>> iterador = att.iterator();
			while(iterador.hasNext()){
				usuarios.add(iterador.next().toString());
			}

			return usuarios;

		} catch (LdapException e) {
			logger.error("getUsuarios", "Error Ldap", e);
		}

		return null;
	}

}
