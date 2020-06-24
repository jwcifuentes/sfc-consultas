package com.ibm.ams.reportes.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="com.ibm.ams.reportes.config.ConfigReportes")
public class Reporte {

	private String idReporte;
	private String rutaReporte;
	
	public Reporte() {
		super();
	}
	
	@XmlAttribute(name="id")
	public String getIdReporte() {
		return idReporte;
	}

	public void setIdReporte(String idReporte) {
		this.idReporte = idReporte;
	}

	@XmlAttribute(name="ruta")
	public String getRutaReporte() {
		return rutaReporte;
	}

	public void setRutaReporte(String rutaReporte) {
		this.rutaReporte = rutaReporte;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Reporte){
			return this.idReporte.equals(((Reporte)o).getIdReporte());
		}
		return false;
	}

}
