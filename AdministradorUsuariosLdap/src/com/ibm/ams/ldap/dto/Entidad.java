package com.ibm.ams.ldap.dto;

import com.ibm.ams.ldap.parser.LdapAttribute;
import com.ibm.ams.ldap.parser.LdapEntity;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Clase en la que se mapean los atributos que contiene una entidad en ldap
*   
*   
* 	<p><b>Notas: </b>
*   <p>la clase esta anotada personalizadamente para el mapeo de los atributos de la entidad
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
@LdapEntity(objectType={"top","groupOfUniqueNames"})
public class Entidad {
	
	/**
	 * Nombre de la entidad en ldap
	 */
	@LdapAttribute(name="cn")
	private String nombreEntidad;
	
	@LdapAttribute(name="organization")
	private String organization;
	/**
	 * Descripcion de la entidad en ldap
	 */
	private String descripcion;
	/**
	 * Listado de usuarios que pertenecen a la entidad
	 */
	@LdapAttribute (name="uniquemember")
	private String[] usuarios;
	
	@LdapAttribute (name="businessCategory")
	private String   categoria;
	
	public Entidad() {
		// TODO Auto-generated constructor stub
	}
	
	public Entidad(String nombreEntidad, String descripcion, String[] usuarios,String organization) {
		super();
		this.nombreEntidad = nombreEntidad;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
		this.organization = organization;
	}
	
	public String getNombreEntidad() {
		return nombreEntidad;
	}

	public void setNombreEntidad(String nombreEntidad) {
		this.nombreEntidad = nombreEntidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String[] getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(String[] usuarios) {
		this.usuarios = usuarios;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @param organization the organization to set
	 */
	public void setOrganization(String organization) {
		this.organization = organization;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
