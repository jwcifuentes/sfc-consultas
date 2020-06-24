package com.rbm.gp.bo.pdf;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compra {

	private String nombreComercio;
	private String codigoComercio;
	private String codigoTerminal;
	private String tipoTransaccion;
	private String numeroAprobacion;
	private String clienteYNumeroTarjeta;
	private String tipoCuenta;
	private String numeroFactura;
	private String numeroAutorizador;
	private String conceptoPago;
	private String numeroITerminalTrn;
	private Date fechaYHora;
	private String fechaYHoraConFormato;
	private BigDecimal valorTotalDeCompra;
	private String valorTotalDeCompraConFormato;
	private BigDecimal impIva;
	private String impIvaConFormato;
	private BigDecimal impConsumo;
	private String impConsumoConFormato;
	private String totalConFormato;
	private BigDecimal impBaseDevolucion;
	private String impBaseDevolucionConFormato;
	private String direccionIP;
	private String infoAdicional;
	private String pieDePagina;
	private BigDecimal montoAdicional;
	private String montoAdicionalConFormato;
	private BigDecimal baseDevolucion;
	private String baseDevolucionConFormato;
	private String infoComercio;
	private String cuotas;
	
	

	// Getters y Setters

	public String getNombreComercio() {
		return nombreComercio;
	}

	public String getCuotas() {
		return cuotas;
	}

	public void setCuotas(String cuotas) {
		this.cuotas = cuotas;
	}

	public String getInfoComercio() {
		return infoComercio;
	}

	public void setInfoComercio(String infoComercio) {
		this.infoComercio = infoComercio;
	}

	public String getBaseDevolucionConFormato() {
		return baseDevolucionConFormato;
	}

	public void setBaseDevolucionConFormato(String baseDevolucionConFormato) {
		this.baseDevolucionConFormato = baseDevolucionConFormato;
	}

	public BigDecimal getBaseDevolucion() {
		return baseDevolucion;
	}

	public void setBaseDevolucion(BigDecimal baseDevolucion) {
		this.baseDevolucion = baseDevolucion;
		setBaseDevolucionConFormato(formatoValores(this.baseDevolucion));
	}

	public void setNombreComercio(String nombreComercio) {
		this.nombreComercio = nombreComercio;
	}

	public String getCodigoComercio() {
		return codigoComercio;
	}

	public void setCodigoComercio(String codigoComercio) {
		this.codigoComercio = codigoComercio;
	}

	public String getCodigoTerminal() {
		return codigoTerminal;
	}

	public void setCodigoTerminal(String codigoTerminal) {
		this.codigoTerminal = codigoTerminal;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getNumeroAprobacion() {
		return numeroAprobacion;
	}

	public void setNumeroAprobacion(String numeroAprobacion) {
		this.numeroAprobacion = numeroAprobacion;
	}

	public String getClienteYNumeroTarjeta() {
		return clienteYNumeroTarjeta;
	}

	public void setClienteYNumeroTarjeta(String clienteYNumeroTarjeta) {
		this.clienteYNumeroTarjeta = clienteYNumeroTarjeta;
	}

	public String getTipoCuenta() {
		return tipoCuenta;
	}

	public void setTipoCuenta(String tipoCuenta) {
		this.tipoCuenta = tipoCuenta;
	}
	
	public String getNumeroAutorizador() {
		return numeroAutorizador;
	}

	public void setNumeroAutorizador(String numeroAutorizador) {
		this.numeroAutorizador = numeroAutorizador;
	}

	public String getNumeroITerminalTrn() {
		return numeroITerminalTrn;
	}

	public void setNumeroITerminalTrn(String numeroITerminalTrn) {
		this.numeroITerminalTrn = numeroITerminalTrn;
	}

	public String formatoFechaVencimiento(Date fechaVencimiento) {
		String patron = "MM-yyyy";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		return formato.format(fechaVencimiento);
	}

	public String formatoFechaYHora(Date fechaVencimiento) {
		String patron = "dd/MM/yyyy HH:mm";
		SimpleDateFormat formato = new SimpleDateFormat(patron);
		return formato.format(fechaVencimiento);
	}

	public String formatoValores(BigDecimal valor) {
		DecimalFormat formato = new DecimalFormat("#,##0.00");
		return formato.format(valor);
	}

	public String getNumeroFactura() {
		return numeroFactura;
	}

	public void setNumeroFactura(String numeroFactura) {
		this.numeroFactura = numeroFactura;
	}

	public Date getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(Date fechaYHora) {
		this.fechaYHora = fechaYHora;
		this.setFechaYHoraConFormato(formatoFechaYHora(fechaYHora));
	}

	public BigDecimal getValorTotalDeCompra() {
		return valorTotalDeCompra;
	}

	public void setValorTotalDeCompra(BigDecimal valorTotalDeCompra) {
		this.valorTotalDeCompra = valorTotalDeCompra;
		this.setValorTotalDeCompraConFormato(formatoValores(valorTotalDeCompra));
	}

	public BigDecimal getImpIva() {
		return impIva;
	}

	public void setImpIva(BigDecimal impIva) {
		this.impIva = impIva;
		this.setImpIvaConFormato(formatoValores(impIva));
	}

	public BigDecimal getImpConsumo() {
		return impConsumo;
	}

	public void setImpConsumo(BigDecimal impConsumo) {
		this.impConsumo = impConsumo;
		this.setImpConsumoConFormato(formatoValores(impConsumo));
	}

	public BigDecimal getImpBaseDevolucion() {
		return impBaseDevolucion;
	}

	public void setImpBaseDevolucion(BigDecimal impBaseDevolucion) {
		this.impBaseDevolucion = impBaseDevolucion;
		this.setImpBaseDevolucionConFormato(formatoValores(impBaseDevolucion));
	}

	public String getDireccionIP() {
		return direccionIP;
	}

	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}

	public String getInfoAdicional() {
		return infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getPieDePagina() {
		return pieDePagina;
	}

	public void setPieDePagina(String pieDePagina) {
		this.pieDePagina = pieDePagina;
	}

	public String getFechaYHoraConFormato() {
		return fechaYHoraConFormato;
	}

	public void setFechaYHoraConFormato(String fechaYHoraConFormato) {
		this.fechaYHoraConFormato = fechaYHoraConFormato;
	}

	public String getValorTotalDeCompraConFormato() {
		return valorTotalDeCompraConFormato;
	}

	public void setValorTotalDeCompraConFormato(
			String valorTotalDeCompraConFormato) {
		this.valorTotalDeCompraConFormato = valorTotalDeCompraConFormato;
	}

	public String getImpIvaConFormato() {
		return impIvaConFormato;
	}

	public void setImpIvaConFormato(String impIvaConFormato) {
		this.impIvaConFormato = impIvaConFormato;
	}

	public String getImpConsumoConFormato() {
		return impConsumoConFormato;
	}

	public void setImpConsumoConFormato(String impConsumoConFormato) {
		this.impConsumoConFormato = impConsumoConFormato;
	}

	public String getTotalConFormato() {
		return totalConFormato;
	}

	public void setTotalConFormato(String totalConFormato) {
		this.totalConFormato = totalConFormato;
	}

	public String getImpBaseDevolucionConFormato() {
		return impBaseDevolucionConFormato;
	}

	public void setImpBaseDevolucionConFormato(
			String impBaseDevolucionConFormato) {
		this.impBaseDevolucionConFormato = impBaseDevolucionConFormato;
	}

	public BigDecimal getMontoAdicional() {
		return montoAdicional;
	}

	public void setMontoAdicional(BigDecimal montoAdicional) {
		this.montoAdicional = montoAdicional;
		this.setMontoAdicionalConFormato(formatoValores(montoAdicional));
	}

	public String getMontoAdicionalConFormato() {
		return montoAdicionalConFormato;
	}

	public void setMontoAdicionalConFormato(String montoAdicionalConFormato) {
		this.montoAdicionalConFormato = montoAdicionalConFormato;
	}

	public String getConceptoPago() {
		return conceptoPago;
	}

	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
	}

}