package com.rbm.gp.bo;

import java.io.Serializable;

public class TipoCuenta implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2044916515846576528L;
	private String codTipoCuenta;
	private String cuenta;
	private String descripcion;
	private String tipo;
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getCodTipoCuenta() {
		return codTipoCuenta;
	}
	public void setCodTipoCuenta(String codTipoCuenta) {
		this.codTipoCuenta = codTipoCuenta;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
