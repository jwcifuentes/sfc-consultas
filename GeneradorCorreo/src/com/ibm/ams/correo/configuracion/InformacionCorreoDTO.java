package com.ibm.ams.correo.configuracion;

import java.util.List;
import java.util.Map;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase DTO en la que se viaja la informacion para construir y enviar un mensaje de correo.
*   <p> 
*   
* 	<p><b>Notas: </b>
*   <p> 
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 12/dic/2014
*   
*   @version 1.0, 12/dic/2014
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/
public class InformacionCorreoDTO {
	/**
	 * Informacion de correo para envio a plantilla
	 */
	private Map<String, Object> informacionComercio;
	/**
	 * Listado de remmitentes
	 */
	private List<String> to;
	/**
	 * Listado de remitentes a copia
	 */
	private List<String> cc;
	
	private String asunto;
	/**
	 * Listado de remitentes a copia oculta
	 */
	private List<String> bcc;
	/**
	 * @return el informacionComercio
	 */
	public Map<String, Object> getInformacionComercio() {
		return informacionComercio;
	}
	/**
	 * @param informacionComercio el informacionComercio a establecer
	 */
	public void setInformacionComercio(Map<String, Object> informacionComercio) {
		this.informacionComercio = informacionComercio;
	}
	/**
	 * @return el to
	 */
	public List<String> getTo() {
		return to;
	}
	/**
	 * @param to el to a establecer
	 */
	public void setTo(List<String> to) {
		this.to = to;
	}
	/**
	 * @return el cc
	 */
	public List<String> getCc() {
		return cc;
	}
	/**
	 * @param cc el cc a establecer
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	/**
	 * @return el bcc
	 */
	public List<String> getBcc() {
		return bcc;
	}
	/**
	 * @param bcc el bcc a establecer
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	/**
	 * @return el adjuntos
	 */
	public List<Adjunto> getAdjuntos() {
		return adjuntos;
	}
	/**
	 * @param adjuntos el adjuntos a establecer
	 */
	public void setAdjuntos(List<Adjunto> adjuntos) {
		this.adjuntos = adjuntos;
	}
	/**
	 * Archivos adjuntos que seran enviados con el correo
	 */
	private List<Adjunto> adjuntos;
	
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
}
