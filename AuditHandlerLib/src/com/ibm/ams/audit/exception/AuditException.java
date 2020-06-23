package com.ibm.ams.audit.exception;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * Clase para el manejo de excepciones del modulo de auditoria
 * 
 * 
 * <p>
 * <b>Notas: </b>
 * 
 * <p>
 * 
 * <p>
 * <b>Proyecto base: </b> AuditWeb
 * 
 * @author dmejiaro@co.ibm.com IBM - Daniel Mejia Rojas
 *         <p>
 *         <b>Fecha de creacion(14/Oct/2015): </b>
 * 
 * @version [1.0, 14/Oct/2015]
 * <p>
 * <b>ChangeLog: </b>
 * 
 * <p>
 * Version: 1.0
 * <p>
 * - Implementacion inicial de la logica requerida por el caso de uso
 * 
 **/
public class AuditException extends Exception {

	private static final long serialVersionUID = -5887461159102309718L;

	/**
	 * @see Exception#Exception()
	 */
	public AuditException() {
		super();
	}

	/**
	 * @see Exception#Exception(String)
	 */
	public AuditException(String message) {
		super(message);
	}

	/**
	 * @see Exception#Exception(Throwable)
	 */
	public AuditException(Throwable cause) {
		super(cause);
	}

	/**
	 * @see Exception#Exception(String, Throwable)
	 */
	public AuditException(String message, Throwable cause) {
		super(message, cause);
	}

}
