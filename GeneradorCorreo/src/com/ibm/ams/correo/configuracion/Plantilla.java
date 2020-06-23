package com.ibm.ams.correo.configuracion;

import javax.xml.bind.annotation.XmlType;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> DTO configuracdo con anotaciones JAXB para el cargue de la configuracion del modulo   
*   <p> 
*   
* 	<p><b>Notas: </b>
*   <p> 
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 12/dic/2013
*   
*   @version 1.0, 12/dic/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/

@XmlType(propOrder = {"nombrePlantilla","sesionCorreo","asuntoCorreo"})
public class Plantilla {
	/**
	 * Nombre del archivo que contiene la plantilla de envio de correo
	 */
	private String nombrePlantilla;
	/**
	 * Direccion hacia la que se envia el correo de contacto
	 */
	private String sesionCorreo;
	/**
	 * Asunto con el que se envia el correo de contacto
	 */
	private String asuntoCorreo;
	
	/**
	 * get de la propiedad nombrePlantilla
	 * @return valor de la propiedad nombrePlantilla
	 */
	public String getNombrePlantilla() {
		return nombrePlantilla;
	}
	/**
	 * set de la propiedad nombrePlantilla
	 * @param nombrePlantilla nuevo valor de la propiedad nombre plantilla
	 */
	public void setNombrePlantilla(String nombrePlantilla) {
		this.nombrePlantilla = nombrePlantilla;
	}
	/**
	 * get de la propiedad DireccionEnvio
	 * @return valor de la propiedad DireccionEnvio
	 */
	public String getSesionCorreo() {
		return sesionCorreo;
	}
	/**
	 * set de la propiedad direccionEnvio
	 * @param dirreccionEnvio nuevo valor de la propiedad direccionEnvio
	 */
	public void setSesionCorreo(String sesionCorreo) {
		this.sesionCorreo = sesionCorreo;
	}
	/**
	 * get de la propiedad asuntoCorreo
	 * @return valor de la propiedad asuntoCorreo.
	 */
	public String getAsuntoCorreo() {
		return asuntoCorreo;
	}
	/**
	 * set de la popiedad asuntoCorreo
	 * @param asuntoCorreo nuevo valor de la popiedad asunto correo
	 */
	public void setAsuntoCorreo(String asuntoCorreo) {
		this.asuntoCorreo = asuntoCorreo;
	}
}
