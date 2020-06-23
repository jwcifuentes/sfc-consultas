package com.ibm.ams.ldap.config;

import java.util.List;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Clase en la que se mapean los parametros para la administracion de entradas en el directorio
*   
*   
* 	<p><b>Notas: </b>
*   <p>la clase esta anotada para el funcionamiento de JAXB
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
@XmlRootElement(name="LdapMapping")
public class ConfiguracionMapeoLdap {

	/**
	 * Base en la que se ubican los usuarios
	 */
	private String baseUbicacionUsuarios;
	/**
	 * Base en la que se ubican los grupos
	 */
	private String baseUbicacionGrupos;
	/**
	 * Base en el directorio desde la cual se ejecuantan las consultas
	 */
	private String baseBusqueda;
	/**
	 * Identificador de las clase objeto para las entradas
	 */
	private String claseObjeto;
	/**
	 * Identificador del objeto tipo grupo
	 */
	private String objetoGrupo;
	/**
	 * Identificador de atributo con el que se denota pertenencia a un grupo
	 */
	private String objetoPerteneceGrupo;
	/**
	 * Identificador del atributo que representa el id de un usuario
	 */
	private String idUsuario;
	/**
	 * Identificador del atributo que denota el id de un grupo
	 */
	private String idGrupo;
	/**
	 * Identificador del atributo que denota el atributo del objeto Entidades
	 */
	private String objetoEstablecimientos;
	/**
	 * Listado de objetos que componen a una persona
	 */
	private List<String> objetosPersona;
	/**
	 * Listado de atributos tipo objeto que contienen un grupo.
	 */
	private List<String> objetosGrupo;
	
	/**
	 * Identificador del atributo que denota el objeto establecimientos
	 */
	private List<String> objetosEstablecimientos;
	
	/**
	 * Listado de atributos que debe tener un usuario
	 */
	private List<String> atributosPersona;
	/**
	 * Listado de atributos que contiene un grupo
	 */
	private List<String> atributosGrupo;
	/**
	 * Listado de atributos que contiene una entidad
	 */
	private List<String> atributosEstablecimientos;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public ConfiguracionMapeoLdap() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="baseUbicacionUsuarios")
	public String getBaseUbicacionUsuarios() {
		return baseUbicacionUsuarios;
	}

	
	public void setBaseUbicacionUsuarios(String baseUbicacionUsuarios) {
		this.baseUbicacionUsuarios = baseUbicacionUsuarios;
	}

	@XmlElement(name="baseUbicacionGrupos")
	public String getBaseUbicacionGrupos() {
		return baseUbicacionGrupos;
	}

	public void setBaseUbicacionGrupos(String baseUbicacionGrupos) {
		this.baseUbicacionGrupos = baseUbicacionGrupos;
	}
	@XmlElement(name="baseBusqueda")
	public String getBaseBusqueda() {
		return baseBusqueda;
	}

	public void setBaseBusqueda(String baseBusqueda) {
		this.baseBusqueda = baseBusqueda;
	}

	@XmlElement(name="claseObjeto")
	public String getClaseObjeto() {
		return claseObjeto;
	}

	public void setClaseObjeto(String claseObjeto) {
		this.claseObjeto = claseObjeto;
	}

	@XmlElement(name="objetoGrupo")
	public String getObjetoGrupo() {
		return objetoGrupo;
	}

	public void setObjetoGrupo(String objetoGrupo) {
		this.objetoGrupo = objetoGrupo;
	}

	@XmlElement(name="objetoPerteneceGrupo")
	public String getObjetoPerteneceGrupo() {
		return objetoPerteneceGrupo;
	}

	public void setObjetoPerteneceGrupo(String objetoPerteneceGrupo) {
		this.objetoPerteneceGrupo = objetoPerteneceGrupo;
	}

	@XmlElementWrapper(name = "objetosPersona")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "objetoPersona")
	public List<String> getObjetosPersona() {
		return objetosPersona;
	}

	@XmlElement(name = "idUsuario")
	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}

	@XmlElement(name = "idGrupo")
	public String getIdGrupo() {
		return idGrupo;
	}

	public void setIdGrupo(String idGrupo) {
		this.idGrupo = idGrupo;
	}

	public void setObjetosPersona(List<String> objetosPersona) {
		this.objetosPersona = objetosPersona;
	}

	@XmlElementWrapper(name = "objetosGrupo")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "objetoGrupo")
	public List<String> getObjetosGrupo() {
		return objetosGrupo;
	}

	public void setObjetosGrupo(List<String> objetosGrupo) {
		this.objetosGrupo = objetosGrupo;
	}

	@XmlElementWrapper(name = "atributosPersona")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "atributo")
	public List<String> getAtributosPersona() {
		return atributosPersona;
	}

	public void setAtributosPersona(List<String> atributosPersona) {
		this.atributosPersona = atributosPersona;
	}

	@XmlElementWrapper(name = "atributosGrupo")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "atributo")
	public List<String> getAtributosGrupo() {
		return atributosGrupo;
	}

	public void setAtributosGrupo(List<String> atributosGrupo) {
		this.atributosGrupo = atributosGrupo;
	}
	
	
	@XmlElementWrapper(name = "objetosEstablecimientos")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "objetoEstablecimientos")
	public List<String> getObjetosEstablecimientos() {
		return objetosEstablecimientos;
	}

	public void setObjetosEstablecimientos(List<String> objetosEstablecimientos) {
		this.objetosEstablecimientos = objetosEstablecimientos;
	}
	
		
	@XmlElementWrapper(name = "atributosEstablecimientos")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "atributo")
	public List<String> getAtributosEstablecimientos() {
		return atributosEstablecimientos;
	}

	public void setAtributosEstablecimientos(List<String> atributosEstablecimientos) {
		this.atributosEstablecimientos = atributosEstablecimientos;
	}

	@XmlElement(name="objetoEstablecimientos")
	public String getObjetoEstablecimientos() {
		return objetoEstablecimientos;
	}

	public void setObjetoEstablecimientos(String objetoEstablecimientos) {
		this.objetoEstablecimientos = objetoEstablecimientos;
	}
	
	
}
