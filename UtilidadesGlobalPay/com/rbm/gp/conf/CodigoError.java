package com.rbm.gp.conf;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"codigo"})

public class CodigoError {
	
	String nombre;
	String codigo;
	
	public String getNombre() {
		return nombre;
	}
	
	@XmlAttribute
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

}
