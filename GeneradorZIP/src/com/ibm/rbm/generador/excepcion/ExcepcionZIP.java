package com.ibm.rbm.generador.excepcion;

public class ExcepcionZIP extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8406223597867486372L;
	
	public ExcepcionZIP() {
		super();
	}

	public ExcepcionZIP(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionZIP(String message) {
		super(message);
	}

	public ExcepcionZIP(Throwable cause) {
		super(cause);
	}
	
}
