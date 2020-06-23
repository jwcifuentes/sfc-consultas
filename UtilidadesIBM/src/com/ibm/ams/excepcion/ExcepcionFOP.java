package com.ibm.ams.excepcion;

public class ExcepcionFOP extends Exception {

	private static final long serialVersionUID = 5978303970673169105L;

	public ExcepcionFOP() {
		super();
	}

	public ExcepcionFOP(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionFOP(String message) {
		super(message);
	}

	public ExcepcionFOP(Throwable cause) {
		super(cause);
	}

}
