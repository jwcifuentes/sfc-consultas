package com.rbm.gp.conf;

import java.util.ArrayList;
import java.util.List;

public class Queries {
	
	private List<Sentencia> sentencia;

	public List<Sentencia> getSentencia() {
		if(sentencia == null){
			sentencia = new ArrayList<Sentencia>();
		}
		return sentencia;
	}

	public void setSentencia(List<Sentencia> sentencia) {
		this.sentencia = sentencia;
	}

	
}
