package com.ibm.ams.cache.excepciones;

public final class ExcepcionCache extends Exception {

	private static final long serialVersionUID = -565723215211388900L;

	public ExcepcionCache() {
		super();
	}

	public ExcepcionCache(String message, Throwable cause) {
		super(message, cause);
	}

	public ExcepcionCache(String message) {
		super(message);
	}

	public ExcepcionCache(Throwable cause) {
		super(cause);
	}

}
