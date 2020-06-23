package com.ibm.ams.ldap.dto;

import java.util.List;

import com.ibm.ams.ldap.parser.LdapAttribute;
import com.ibm.ams.ldap.parser.LdapEntity;

@LdapEntity(objectType={"top","person", "inetOrgPerson","organizationalPerson"})
public class UsuarioModificado {

	/**
	 * Identificador unico del usuario
	 */
	@LdapAttribute (name="uid")
	private String login;
	
	@LdapAttribute (name="description")
	private String fechaUltima;
	
	@LdapAttribute (name="title")
	private String fechaPenultima;
	
	@LdapAttribute (name="st")
	private String ultimoCambioPassword;

	/**
	 * Listado de grupos a los que pertenece el usuario
	 */
	private List<String> grupos;

	public UsuarioModificado() {
	}

	public UsuarioModificado(String login, String fechaUltima,
			String fechaPenultima) {
		this.login = login;
		this.fechaUltima = fechaUltima;
		this.fechaPenultima = fechaPenultima;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
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

	public List<String> getGrupos() {
		return grupos;
	}

	public void setGrupos(List<String> grupos) {
		this.grupos = grupos;
	}

	public String getUltimoCambioPassword() {
		return ultimoCambioPassword;
	}

	public void setUltimoCambioPassword(String ultimoCambioPassword) {
		this.ultimoCambioPassword = ultimoCambioPassword;
	}
	
}
