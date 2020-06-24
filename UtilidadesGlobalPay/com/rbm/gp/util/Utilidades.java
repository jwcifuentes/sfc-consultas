package com.rbm.gp.util;

import java.io.File;

import com.ibm.ams.excepcion.XmlToDtoException;
import com.ibm.ams.utils.XmlToDto;
import com.rbm.gp.conf.Configuracion;
import com.rbm.gp.constantes.Constantes;

/**
 * Clase Utilidades.
 */
public class Utilidades {
	
	/**
	 * Obtener configuracion, metodo que se encarga de obtener todos los datos de configuracion
	 *  de GlobalPay a partir de un Archivo xml
	 *
	 * @return configuracion
	 * @throws XmlToDtoException
	 */
	public Configuracion obtenerConfiguracion() throws XmlToDtoException{
		
		Configuracion general = new Configuracion();
		XmlToDto<Configuracion> dto = new XmlToDto<Configuracion>();
		
		String configPath = System.getProperty(Constantes.CONFIGURACION_DIR) + "globalpay"+ File.separatorChar + Constantes.CONFIGURACION_ARCHIVO;
		File f = new File(configPath);
		
		if(f.exists()){
			general = dto.getDto(general, f);
			return general;
		}else{
			throw new XmlToDtoException("No se Encontro el archivo: " + configPath);
		}
	}

}
