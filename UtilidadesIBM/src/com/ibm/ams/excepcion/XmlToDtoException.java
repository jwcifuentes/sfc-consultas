package com.ibm.ams.excepcion;

public class XmlToDtoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8098437350709207067L;

	public XmlToDtoException(Throwable cause) {
		super(cause);
	}

	public XmlToDtoException(String message, Throwable cause) {
		super(message, cause);
	}

	public XmlToDtoException(String message) {
		super(message);
	}

	public XmlToDtoException() {
	}
}
