package com.ibm.ams.excepcion;

public class ExcepcionCaracteres extends Exception {

	private static final long serialVersionUID = -5214246651329086805L;

	public ExcepcionCaracteres() {
		super();
	}

	public ExcepcionCaracteres(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionCaracteres(String message) {
		super(message);
	}

	public ExcepcionCaracteres(Throwable cause) {
		super(cause);
	}

}
