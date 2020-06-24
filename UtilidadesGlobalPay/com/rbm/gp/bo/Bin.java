package com.rbm.gp.bo;

import java.io.Serializable;

public class Bin implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4228623671596766846L;
	private String codBin;
	private String codPais;
	private String habilitado;
	public String getCodBin() {
		return codBin;
	}
	public void setCodBin(String codBin) {
		this.codBin = codBin;
	}
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getHabilitado() {
		return habilitado;
	}
	public void setHabilitado(String habilitado) {
		this.habilitado = habilitado;
	}
}
