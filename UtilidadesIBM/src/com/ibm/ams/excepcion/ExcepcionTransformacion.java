package com.ibm.ams.excepcion;

public class ExcepcionTransformacion extends Exception {

	private static final long serialVersionUID = 9023919676547145393L;

	public ExcepcionTransformacion() {
		super();
	}

	public ExcepcionTransformacion(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionTransformacion(String message) {
		super(message);
	}

	public ExcepcionTransformacion(Throwable cause) {
		super(cause);
	}

}
