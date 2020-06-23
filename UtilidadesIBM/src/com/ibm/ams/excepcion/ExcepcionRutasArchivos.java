package com.ibm.ams.excepcion;

public class ExcepcionRutasArchivos extends Exception {

	private static final long serialVersionUID = -8959250190493288135L;

	public ExcepcionRutasArchivos() {
		super();
	}

	public ExcepcionRutasArchivos(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionRutasArchivos(String message) {
		super(message);
	}

	public ExcepcionRutasArchivos(Throwable cause) {
		super(cause);
	}

}
