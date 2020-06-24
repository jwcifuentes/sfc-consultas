package com.rbm.gp.bo;

import java.io.Serializable;

public class BinFranquicia implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7361700575776668073L;
	private String codFranquicia;
	private long binInicial;
	private long binFinal;
	
	public String getCodFranquicia() {
		return codFranquicia;
	}
	public void setCodFranquicia(String codFranquicia) {
		this.codFranquicia = codFranquicia;
	}
	public long getBinInicial() {
		return binInicial;
	}
	public void setBinInicial(long binInicial) {
		this.binInicial = binInicial;
	}
	public long getBinFinal() {
		return binFinal;
	}
	public void setBinFinal(long binFinal) {
		this.binFinal = binFinal;
	}

}
