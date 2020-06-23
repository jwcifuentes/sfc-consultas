package com.ibm.ams.log;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripción: </b>
*   <p>Clase de utilidad para facilitar la generación de log en una clase
*   
* 	<p><b>Proyecto base: </b> Framework de Log
*   
*   @author <A HREF="mailto:lardilab@co.ibm.com">Alexander Ardila</A>
*   <p><b>Fecha de creación(dd/mmm/aaaa):</b> 17/oct/2013
*   
*   @version 1.0, 17/oct/2013
*   <p><b>ChangeLog:</b>
*	<p>Versión: 1.0 
*	<p>- Creación de la clase.
*	<p>- Creación de documentación.
**/
public class LoggerInst {
	/**
	 * Instancia del log para la aplicación
	 */
	private Logger logger;
	/**
	 * Nombre del la clase para la que se esta generando el log
	 */
	private String className;
	
	/**
	 * Crea una instancia del logger para una clase
	 * 
	 * @param clazz clase para la cual se genera el mensaje 
	 * @param aplicacion aplicación desde la cual se genera el mensaje
	 * @param configDir subcarpeta dentro de la ruta de configuración en la cual se 
	 * 				    encuentra el archivo de configuración de niveles de log.
	 */
	public LoggerInst(@SuppressWarnings("rawtypes") Class clazz, String aplicacion, String configDir){
		className = clazz.getName(); 
		logger = Logger.getInstance(aplicacion, configDir);
	}
	
	/**
	 * Crea una instancia del logger para una categoria especificada
	 * 
	 * @param categoria categoria para la cual se genera el mensaje 
	 * @param aplicacion aplicación desde la cual se genera el mensaje
	 * @param configDir subcarpeta dentro de la ruta de configuración en la cual se 
	 * 				    encuentra el archivo de configuración de niveles de log.
	 */
	public LoggerInst(String categoria, String aplicacion, String configDir){
		className = categoria; 
		logger = Logger.getInstance(aplicacion, configDir);
	}	
	
	/**
	 * Escribe un mensaje de tipo trace
	 * 
	 * @param metodo desde el cual se genera el mensaje
	 * @param mensaje mensaje a escribir en el log. Para pasar parametros utilice %s
	 * @param args parametros que deben ser reemplazados en el mensaje
	 */
	public void trace(String metodo, String mensaje, Object... args) {
		logger.trace(className, metodo, mensaje, args);
	}

	/**
	 * Escribe un mensaje de tipo debug
	 * 
	 * @param metodo desde el cual se genera el mensaje
	 * @param mensaje mensaje a escribir en el log. Para pasar parametros utilice %s
	 * @param args parametros que deben ser reemplazados en el mensaje
	 */	
	public void debug(String metodo, String mensaje, Object... args) {
		logger.debug(className, metodo, mensaje, args);
	}

	/**
	 * Escribe un mensaje de tipo info
	 * 
	 * @param metodo desde el cual se genera el mensaje
	 * @param mensaje mensaje a escribir en el log. Para pasar parametros utilice %s
	 * @param args parametros que deben ser reemplazados en el mensaje
	 */	
	public void info(String metodo, String mensaje, Object... args) {
		logger.info(className, metodo, mensaje, args);
	}

	/**
	 * Escribe un mensaje de tipo warning
	 * 
	 * @param metodo desde el cual se genera el mensaje
	 * @param mensaje mensaje a escribir en el log. Para pasar parametros utilice %s
	 * @param args parametros que deben ser reemplazados en el mensaje
	 */	
	public void warn(String metodo, String mensaje, Object... args) {
		logger.warn(className, metodo, mensaje, args);
	}

	/**
	 * Escribe un mensaje de tipo error
	 * 
	 * @param metodo desde el cual se genera el mensaje
	 * @param mensaje mensaje a escribir en el log. Para pasar parametros utilice %s
	 * @param error que se reporta al log
	 * @param args parametros que deben ser reemplazados en el mensaje
	 */	
	public void error(String metodo, String mensaje, Throwable error, Object... args) {
		logger.error(className, metodo, mensaje, error, args);
	}	
}
