package com.ibm.ams.log;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MensajeLog implements Serializable {
	private static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	private static final long serialVersionUID = 1L;

	// Variables que determinan el nivel del log
	public static enum Nivel {
		trace, debug, info, warn, error
	};

	// Metodo que contiene todos los campos que van en el mensaje que sera
	// guardado en el log

	private Date fecha;
	private String nivel;
	private String aplicacion;
	private String componente;
	private String metodo;
	private String idHilo;
	private String mensaje;
	private Object referencia;

	// Getters y Setters

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getAplicacion() {
		return aplicacion;
	}

	public void setAplicacion(String aplicacion) {
		this.aplicacion = aplicacion;
	}

	public String getComponente() {
		return componente;
	}

	public void setComponente(String componente) {
		this.componente = componente;
	}

	public String getMetodo() {
		return metodo;
	}

	public void setMetodo(String metodo) {
		this.metodo = metodo;
	}

	public String getIdHilo() {
		return idHilo;
	}

	public void setIdHilo(String idHilo) {
		this.idHilo = idHilo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getReferencia() {
		return referencia;
	}

	public void setReferencia(Object referencia) {
		this.referencia = referencia;
	}

	public String getIdLog() {
		return getAplicacion() + "." + getComponente();
	}

	/**
	 * Metodo que proporciona una formato de Fecha
	 * 
	 * @param fecha
	 * @return String
	 */
	public static String formatFecha(Date fecha) {
		
		return df.format(fecha);
	}

	@Override
	public String toString() {
		fecha = new Date(System.currentTimeMillis());
		StringBuilder sb = new StringBuilder();
		
		sb.append(df.format(fecha)).append(" ")
		.append((nivel.toUpperCase() + "   ").substring(0, 5)).append(" ")
		.append("[").append(idHilo).append("]").append(" ")
		.append(aplicacion).append(".").append(componente).append(".").append(metodo).append(" ")
		.append(mensaje);
		
		if(referencia != null)
			sb.append("\n").append(referencia);
		
		return sb.toString();
	}
}
