package com.ibm.ams.calendario.pojos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;

@Entity(name = "Festivo")
public class Festivo implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String tag;
	private String valor;
	private String etiqueta;
	private String fecha;
	private String dia;
	private String bloqueo;
	private Date fechaOrd;
	
	public Festivo() {
	}

	public Festivo(String tag, String valor, String etiqueta, String fecha, String dia, String bloqueo, Date fechaOrd) {
		this.tag = tag;
		this.valor = valor;
		this.etiqueta = etiqueta;
		this.fecha = fecha;
		this.dia = dia;
		this.bloqueo = bloqueo;
		this.fechaOrd = fechaOrd;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getEtiqueta() {
		return etiqueta;
	}

	public void setEtiqueta(String etiqueta) {
		this.etiqueta = etiqueta;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getBloqueo() {
		return bloqueo;
	}

	public void setBloqueo(String bloqueo) {
		this.bloqueo = bloqueo;
	}

	public Date getFechaOrd() {
		return fechaOrd;
	}

	public void setFechaOrd(Date fechaOrd) {
		this.fechaOrd = fechaOrd;
	}
	
}
