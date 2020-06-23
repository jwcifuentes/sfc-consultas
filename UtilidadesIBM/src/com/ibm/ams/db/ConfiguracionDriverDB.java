package com.ibm.ams.db;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "configuracionDriverDB")
@XmlType(propOrder = {"nombre", 
		"driverClass",
		"url",
		"usuario",
		"clave"})
public class ConfiguracionDriverDB {
	private String nombre;
	private String driverClass;
	private String url;
	private String usuario;
	private String clave;
	
	public String getNombre() {
		return nombre;
	}
	@XmlAttribute
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDriverClass() {
		return driverClass;
	}
	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
}
