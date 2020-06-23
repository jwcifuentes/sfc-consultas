package com.ibm.ams.correo.configuracion;

import java.io.File;

import com.ibm.ams.utils.XmlToDto;

import com.ibm.ams.correo.excepcion.ExcepcionCorreo;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase encargada de cargar la configuracion de modulo a partir del archivo de configuracion   
*   <p> en formato xml
*   
* 	<p><b>Notas: </b>
*   <p> Requiere de utilidades IBM para la carga del archivo de configuracion
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 11/dic/2013
*   
*   @version 1.0, 11/dic/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/
public class GestorConfiguracionCorreo {

	
	/**
	 * metodo encargado de cargar la configuracion para el modulo RBMovil, desde un archivo xml
	 * @return DTO con la configuracion del modulo RBMovil
	 * @throws ExcepcionConfiguracion excepcion lanzada cuando no se puede cargar la configuracion del modulo
	 */
	public static ConfiguracionCorreo getConfigCorreo() throws ExcepcionCorreo {
		try {
			String rutaArchivo = System.getProperty(ConstantesCorreo.CONFIGURACION_DIR) + ConstantesCorreo.MAIL_DIR + File.separatorChar + ConstantesCorreo.NOMBRE_ARCHIVO_CONFIG;
			File archivo = new File(rutaArchivo);
			
			XmlToDto<ConfiguracionCorreo> parser = new XmlToDto<ConfiguracionCorreo>();
			ConfiguracionCorreo config = new ConfiguracionCorreo();
			config = parser.getDto(config, archivo);
			return config;
		} catch (Throwable e) {
			throw new ExcepcionCorreo("Error obteniendo configuración para el envio de correo", e);
		}
	}
}
