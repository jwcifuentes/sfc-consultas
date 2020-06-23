package com.ibm.ams.correo.configuracion;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase encargada de la contruccion del contenido del correo a enviar y
*   <p> interaccion con el servidor de correo.
*   
* 	<p><b>Notas: </b>
*   <p> Requiere del framework velocity para la construccion del contenido del correo
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 18/dic/2014
*   
*   @version 1.0, 18/dic/2014
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/
public class ConstantesCorreo {
	/**
	 * Constante para obtener la plantilla de envio de voucher 
	 */
	public static String PLANTILLA_CORREO_VOUCHER = "correo.vm";
	
	/** PATH donde se ubica la carpeta base en donde se encuentra la configuracion del aplicativo. */
	public static final String CONFIGURACION_DIR = "SWF_PORTAL_CONFIGPATH";
	/**
	 * Nombre del directorio en el cual se encuentran los archivos de configuracion del aplicativo
	 */
	public static final String MAIL_DIR = "mail";
	/**
	 * Nombre del archivo de configuracion del modulo
	 */
	public static final String NOMBRE_ARCHIVO_CONFIG = "correoConfig.xml";

}
