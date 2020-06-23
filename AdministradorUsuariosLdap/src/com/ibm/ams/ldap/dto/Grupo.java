package com.ibm.ams.ldap.dto;

import com.ibm.ams.ldap.parser.LdapAttribute;
import com.ibm.ams.ldap.parser.LdapEntity;


/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Clase en la que se mapean los atributos que contiene un grupo en ldap
*   
*   
* 	<p><b>Notas: </b>
*   <p>la clase esta anotada personalizadamente para el mapeo de los atributos de grupo
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
public class Grupo {
	/**
	 * Nombre del grupo en ldap
	 */
	@LdapAttribute(name="cn")
	private String nombreGrupo;
	/**
	 * Descripcion del grupo en ldap
	 */
	private String descripcion;
	/**
	 * Listado de usuarios que pertenecen al grupo
	 */
	@LdapAttribute (name="uniquemember")
	private String[] usuarios;
	
	public Grupo() {
		// TODO Auto-generated constructor stub
	}
	
	public Grupo(String nombreGrupo, String descripcion, String[] usuarios) {
		super();
		this.nombreGrupo = nombreGrupo;
		this.descripcion = descripcion;
		this.usuarios = usuarios;
	}

	public String getNombreGrupo() {
		return nombreGrupo;
	}

	public void setNombreGrupo(String nombreGrupo) {
		this.nombreGrupo = nombreGrupo;
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

	

}
