package com.rbm.gp.conf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"restriccion"})
public class Restricciones {
	private List<Restriccion> restriccion;

	public List<Restriccion> getRestriccion() {
		if(restriccion == null){
			restriccion = new ArrayList<Restriccion>();
		}
		return restriccion;
	}

	public void setRestriccion(List<Restriccion> restriccion) {
		this.restriccion = restriccion;
	}
	

}
