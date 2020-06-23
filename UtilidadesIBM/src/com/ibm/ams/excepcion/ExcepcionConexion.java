package com.ibm.ams.excepcion;

public class ExcepcionConexion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -688094690275988207L;

	public ExcepcionConexion() {
		super();
	}

	public ExcepcionConexion(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionConexion(String message) {
		super(message);
	}

	public ExcepcionConexion(Throwable cause) {
		super(cause);
	}

}
