package com.ibm.ams.excepcion;

public class ExcepcionLog extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -688094690275988207L;

	public ExcepcionLog() {
		super();
	}

	public ExcepcionLog(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionLog(String message) {
		super(message);
	}

	public ExcepcionLog(Throwable cause) {
		super(cause);
	}

}
