package com.ibm.ams.log.bo;

public enum NivelesLog {
	TRACE(4,"trace"),
	DEBUG(3,"debug"),
	INFO(2,"info"),
	WARN(1,"warn"),
	ERROR(0,"error");
	
	private int valor;
	private String texto;
	NivelesLog(int valor, String texto){
		this.valor = valor;
		this.texto = texto;
	}
	public int getValor() {
		return valor;
	}
	public String getTexto(){
		return texto;
	}

	
	
}
