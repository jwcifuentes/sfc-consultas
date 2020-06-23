package com.ibm.ams.correo.configuracion;

import java.util.ArrayList;
import java.util.List;

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
public class Plantillas {
	
	private List<Plantilla> plantilla;

	/**
	 * @return el plantillas
	 */
	public List<Plantilla> getPlantilla() {
		if (null == plantilla) {
			plantilla = new ArrayList<Plantilla>();
		}
		return plantilla;
	}

	/**
	 * @param plantillas el plantillas a establecer
	 */
	public void setPlantilla(List<Plantilla> plantilla) {
		this.plantilla = plantilla;
	}
}
