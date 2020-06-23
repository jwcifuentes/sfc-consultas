package com.ibm.ams.ldap.config;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p>Clase en la que se mapean los parametros de conexion al servidor Ldap
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
@XmlRootElement(name="LdapConfig")
public class ConfiguracionParametrosLdap {

	/**
	 * Host en el que se encuentra el servidor ldap
	 */
	private String ldaphost;
	/**
	 * Puerto en el que escucha el servidor ldap
	 */
	private String ldapport;
	/**
	 * Usuario de conexion al servidor ldap
	 */
	private String ldapuser;
	/**
	 * Password de conexion al servidor ldap
	 */
	private String ldappassword;
	/**
	 * Puerto en el que escucha el servidor ldap con ssl
	 */
	private String ldapportSsl;
	/**
	 * identifica si usa ssl la conexion al servidor ldap
	 */
	private boolean ldapSsl;
	/**
	 * identifica el protocolo ssl que usa la conexion al servidor ldap
	 */
	private String ldapSslProtocol;
	
	
	/**
	 * Constructor por defecto de la clase
	 */
	public ConfiguracionParametrosLdap() {
		// TODO Auto-generated constructor stub
	}

	@XmlElement(name="ldaphost")
	public String getLdaphost() {
		return ldaphost;
	}

	public void setLdaphost(String ldaphost) {
		this.ldaphost = ldaphost;
	}

	@XmlElement(name="ldapport")
	public String getLdapport() {
		return ldapport;
	}

	public void setLdapport(String ldapport) {
		this.ldapport = ldapport;
	}

	@XmlElement(name="ldapuser")
	public String getLdapuser() {
		return ldapuser;
	}

	public void setLdapuser(String ldapuser) {
		this.ldapuser = ldapuser;
	}

	@XmlElement(name="ldappassword")
	public String getLdappassword() {
		return ldappassword;
	}

	public void setLdappassword(String ldappassword) {
		this.ldappassword = ldappassword;
	}

	public boolean isLdapSsl() {
		return ldapSsl;
	}

	public void setLdapSsl(boolean ldapSsl) {
		this.ldapSsl = ldapSsl;
	}

	public String getLdapSslProtocol() {
		return ldapSslProtocol;
	}

	public void setLdapSslProtocol(String ldapSslProtocol) {
		this.ldapSslProtocol = ldapSslProtocol;
	}

	public String getLdapportSsl() {
		return ldapportSsl;
	}

	public void setLdapportSsl(String ldapportSsl) {
		this.ldapportSsl = ldapportSsl;
	}

}
