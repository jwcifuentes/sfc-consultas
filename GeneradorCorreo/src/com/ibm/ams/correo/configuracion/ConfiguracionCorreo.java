package com.ibm.ams.correo.configuracion;

import javax.xml.bind.annotation.XmlRootElement;
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

@XmlRootElement(name = "CorreoConfig")
@XmlType(propOrder = {"plantillas"})
public class ConfiguracionCorreo {
	
	/** Grupo de plantillas que contiene el archivo de configuracion */
	private Plantillas plantillas;

	/**
	 * @return el plantillas
	 */
	public Plantillas getPlantillas() {
		return plantillas;
	}

	/**
	 * @param plantillas el plantillas a establecer
	 */
	public void setPlantillas(Plantillas plantillas) {
		this.plantillas = plantillas;
	}	
}
