package com.rbm.gp.conf;	

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"nombre",
		"query",
		"timeout"})

public class Sentencia {
	
	private String nombre;
	private String query;
	private int timeout;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getQuery() {
		return query;
	}
	public void setQuery(String query) {
		this.query = query;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}
	

}
