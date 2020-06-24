package com.rbm.gp.bo;

import java.io.Serializable;
import java.util.List;

public class Franquicia implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5860041673757164568L;
	private String codFranquicia;
	private String origenPinblock;
	private String descCuenta;
	private int longCvc;
	private int longTarjeta;
	private String nombre;
	private boolean reqClave;
	private boolean reqCvc;
	private boolean reqFechaVencimiento;
	private boolean reqSegunaClave;
	private boolean reqTipoCuenta;
	private String tipoLongTarjeta;
	private boolean reqValidarBin;
	private String tipoTarjeta;
	private List<BinFranquicia> bines;
	private List<TipoCuenta> cuentas;
	private String habilitada;
	private boolean reqCuotas;
	private String nombreImg;
	
	public String getHabilitada() {
		return habilitada;
	}
	public void setHabilitada(String habilitada) {
		this.habilitada = habilitada;
	}
	public String getTipoTarjeta() {
		return tipoTarjeta;
	}
	public void setTipoTarjeta(String tipoTarjeta) {
		this.tipoTarjeta = tipoTarjeta;
	}
	public String getCodFranquicia() {
		return codFranquicia;
	}
	public void setCodFranquicia(String codFranquicia) {
		this.codFranquicia = codFranquicia;
	}
	public String getOrigenPinblock() {
		return origenPinblock;
	}
	public void setOrigenPinblock(String origenPinblock) {
		this.origenPinblock = origenPinblock;
	}
	public String getDescCuenta() {
		return descCuenta;
	}
	public void setDescCuenta(String descCuenta) {
		this.descCuenta = descCuenta;
	}
	public int getLongCvc() {
		return longCvc;
	}
	public void setLongCvc(int longCvc) {
		this.longCvc = longCvc;
	}
	public int getLongTarjeta() {
		return longTarjeta;
	}
	public void setLongTarjeta(int longTarjeta) {
		this.longTarjeta = longTarjeta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isReqClave() {
		return reqClave;
	}
	public void setReqClave(boolean reqClave) {
		this.reqClave = reqClave;
	}
	public boolean isReqCvc() {
		return reqCvc;
	}
	public void setReqCvc(boolean reqCvc) {
		this.reqCvc = reqCvc;
	}
	public boolean isReqFechaVencimiento() {
		return reqFechaVencimiento;
	}
	public void setReqFechaVencimiento(boolean reqFechaVencimiento) {
		this.reqFechaVencimiento = reqFechaVencimiento;
	}
	public boolean isReqSegunaClave() {
		return reqSegunaClave;
	}
	public void setReqSegunaClave(boolean reqSegunaClave) {
		this.reqSegunaClave = reqSegunaClave;
	}
	public boolean isReqTipoCuenta() {
		return reqTipoCuenta;
	}
	public void setReqTipoCuenta(boolean reqTipoCuenta) {
		this.reqTipoCuenta = reqTipoCuenta;
	}
	public String getTipoLongTarjeta() {
		return tipoLongTarjeta;
	}
	public void setTipoLongTarjeta(String tipoLongTarjeta) {
		this.tipoLongTarjeta = tipoLongTarjeta;
	}
	public boolean isReqValidarBin() {
		return reqValidarBin;
	}
	public void setReqValidarBin(boolean reqValidarBin) {
		this.reqValidarBin = reqValidarBin;
	}
	public List<BinFranquicia> getBines() {
		return bines;
	}
	public void setBines(List<BinFranquicia> bines) {
		this.bines = bines;
	}
	public List<TipoCuenta> getCuentas() {
		return cuentas;
	}
	public void setCuentas(List<TipoCuenta> cuentas) {
		this.cuentas = cuentas;
	}
	public boolean isReqCuotas() {
		return reqCuotas;
	}
	public void setReqCuotas(boolean reqCuotas) {
		this.reqCuotas = reqCuotas;
	}
	public String isNombreImg() {
		return nombreImg;
	}
	public void setNombreImg(String nombreImg) {
		this.nombreImg = nombreImg;
	}
}
