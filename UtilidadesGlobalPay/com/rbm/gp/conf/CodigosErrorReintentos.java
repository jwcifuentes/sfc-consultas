package com.rbm.gp.conf;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"codigoError"})

public class CodigosErrorReintentos {
	
	private List<CodigoError> codigoError;

	public List<CodigoError> getCodigoError() {
		if (codigoError == null) {
			codigoError = new ArrayList<CodigoError>();
		}
		return codigoError;
	}

	public void setCodigoError(List<CodigoError> codigoError) {
		this.codigoError = codigoError;
	}

}
