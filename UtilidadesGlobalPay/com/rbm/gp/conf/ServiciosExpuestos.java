package com.rbm.gp.conf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"servicioExpuesto"})
public class ServiciosExpuestos {
	List<ServicioExpuesto> servicioExpuesto;


	public List<ServicioExpuesto> getServicioExpuesto(){
		if(servicioExpuesto == null){
			servicioExpuesto = new ArrayList<ServicioExpuesto>();
		}
		return servicioExpuesto;
	}
	public void setServicioExpuesto(List<ServicioExpuesto> servicioExpuesto) {
		this.servicioExpuesto = servicioExpuesto;
	}
}
