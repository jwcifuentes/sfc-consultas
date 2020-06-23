package com.ibm.ams.correo.excepcion;

public class ExcepcionCorreo extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4292119308348546456L;

	public ExcepcionCorreo() {
		super();
	}

	public ExcepcionCorreo(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionCorreo(String message) {
		super(message);
	}

	public ExcepcionCorreo(Throwable cause) {
		super(cause);
	}
}
