package com.ibm.ams.ldap.dto;

import java.util.List;

import com.ibm.ams.ldap.parser.LdapAttribute;
import com.ibm.ams.ldap.parser.LdapEntity;
/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Clase en la que se mapean los atributos que contiene un usuario en ldap
*   
*   
* 	<p><b>Notas: </b>
*   <p>la clase esta anotada personalizadamente para el mapeo de los atributos de usuario
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
@LdapEntity(objectType={"top","person", "inetOrgPerson","organizationalPerson"})
public class Usuario {
	
	/**
	 * Nombres del Usuario
	 */
	@LdapAttribute(name="givenName")
	private String nombres;
	/**
	 * Apellidos del usuario
	 */
	@LdapAttribute (name="sn")
	private String apellidos;
	/**
	 * Correo electronico del usuario
	 */
	@LdapAttribute (name="mail")
	private String correo;
	/**
	 * Identificador unico del usuario
	 */
	@LdapAttribute (name="uid")
	private String login;
	/**
	 * Password del usuario
	 */
	@LdapAttribute (name="userpassword")
	private String password;
	/**
	 * Lenguaje configurado para el usuario
	 */
	@LdapAttribute (name="businessCategory")
	private String categoriaDeNegocio; 	
	
	@LdapAttribute (name="organization")
	private String comercio;
	
	@LdapAttribute (name="cn")
	private String nombreComercio ;
	
	@LdapAttribute (name="employeeType")
	private String tipoCliente ;
	
	@LdapAttribute (name="description")
	private String fechaUltima;
	
	@LdapAttribute (name="title")
	private String fechaPenultima;
	
	@LdapAttribute (name="mobile")
	private String celular;
	
	@LdapAttribute(name="homePhone")
	private String telefono;
	
	@LdapAttribute(name="st")
	private String ultimoCambioFecha;
	
	private String correoAdicional;
	
	private int tipoNegocio;
	
	private String passwordConfirm;
	
	private String tipoId;
	
	/**
	 * Listado de grupos a los que pertenece el usuario
	 */
	private List<String> grupos;
	
	public Usuario(){
		
	}
	
	
	public Usuario(String nombres, String apellidos, String correo,
			String login, String password) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.login = login;
		this.password = password;
	}
	
	public Usuario(String nombres, String apellidos, String correo,
			String login, String password, String fechaUltima,
			String fechaPenultima) {
		super();
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.correo = correo;
		this.login = login;
		this.password = password;
		this.fechaUltima = fechaUltima;
		this.fechaPenultima = fechaPenultima;
	}


	public String getNombres() {
		return nombres;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	public String getCategoriaDeNegocio() {
		if (categoriaDeNegocio == null || categoriaDeNegocio.equals("null")) {
			return null;
		}
		return categoriaDeNegocio;
	}


	public void setCategoriaDeNegocio(String categoriaDeNegocio) {
		this.categoriaDeNegocio = categoriaDeNegocio;
	}


	public String getComercio() {
		return comercio;
	}


	public void setComercio(String comercio) {
		this.comercio = comercio;
	}
	
//	public int getTipoNegocio() {
//		return tipoNegocio;
//	}
//
//
//	public void setTipoNegocio(int tipoNegocio) {
//		this.tipoNegocio = tipoNegocio;
//	}


	public List<String> getGrupos() {
		return grupos;
	}


	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the correoAdicional
	 */
	public String getCorreoAdicional() {
		return correoAdicional;
	}


	/**
	 * @param correoAdicional the correoAdicional to set
	 */
	public void setCorreoAdicional(String correoAdicional) {
		this.correoAdicional = correoAdicional;
	}


	/**
	 * @return the tipoNegocio
	 */
	public int getTipoNegocio() {
		return tipoNegocio;
	}


	/**
	 * @param tipoNegocio the tipoNegocio to set
	 */
	public void setTipoNegocio(int tipoNegocio) {
		this.tipoNegocio = tipoNegocio;
	}


	/**
	 * @return the passwordConfirm
	 */
	public String getPasswordConfirm() {
		return passwordConfirm;
	}


	/**
	 * @param passwordConfirm the passwordConfirm to set
	 */
	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}


	/**
	 * @return the nombreComercio
	 */
	public String getNombreComercio() {
		return nombreComercio;
	}


	/**
	 * @param nombreComercio the nombreComercio to set
	 */
	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}
	
	public String getFechaUltima() {
		return fechaUltima;
	}


	public void setFechaUltima(String fechaUltima) {
		this.fechaUltima = fechaUltima;
	}


	public String getFechaPenultima() {
		return fechaPenultima;
	}


	public void setFechaPenultima(String fechaPenultima) {
		this.fechaPenultima = fechaPenultima;
	}
	
	public String getCelular() {
		return celular;
	}


	public void setCelular(String celular) {
		this.celular = celular;
	}

	/**
	 * @return the tipoCliente
	 */
	public String getTipoCliente() {
		return tipoCliente;
	}


	/**
	 * @param tipoCliente the tipoCliente to set
	 */
	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}

	public String getTipoId() {
		return tipoId;
	}


	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}


	@Override
	public String toString() {
		return "Usuario [nombres=" + nombres + ", apellidos=" + apellidos
				+ ", correo=" + correo + ", login=" + login + ", password="
				+ password + ", categoriaDeNegocio="
				+ categoriaDeNegocio + ", comercio=" + comercio
				+ ", fechaUltima=" + fechaUltima + ", fechaPenultima="
				+ fechaPenultima + ", telefono=" + telefono
				+ ", correoAdicional=" + correoAdicional + ", tipoNegocio="
				+ tipoNegocio + ", passwordConfirm=" + passwordConfirm
				+ ", grupos=" + grupos + ", celular=" + celular + "]";
	}


	public String getUltimoCambioFecha() {
		return ultimoCambioFecha;
	}


	public void setUltimoCambioFecha(String ultimoCambioFecha) {
		this.ultimoCambioFecha = ultimoCambioFecha;
	}



}
