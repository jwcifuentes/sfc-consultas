package com.rbm.gp.excepciones;

public class ValidacionCamposException extends Exception {

	private static final long serialVersionUID = -4310645398179621265L;

	public ValidacionCamposException() {
		super();
	}

	public ValidacionCamposException(String message, Throwable cause) {
		super(message, cause);
	}

	public ValidacionCamposException(String message) {
		super(message);
	}

	public ValidacionCamposException(Throwable cause) {
		super(cause);
	}

}
