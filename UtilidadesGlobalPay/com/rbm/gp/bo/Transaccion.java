package com.rbm.gp.bo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;



public class Transaccion implements Serializable{
	private static final long serialVersionUID = -2075159957125421145L;
	private String id;
	private String idTransaccionMulticompra;
	private Timestamp fecha;
	private Timestamp fechaTrnsCompraElectronica;
	private String adquirienteCodigo;
	private String idAdquirienteMulticompra;
	private String adquirienteNombre;
	private String clienteApellidos;
	private String clienteCelular;
	private String clienteIdentificacion;
	private String clienteMail;
	private String clienteNombre;
	private TipoIdentificacion clienteTipoIdentificacion; 
	private Integer cuotas;
	private BigDecimal impConsumo;
	private BigDecimal impIva;
	private BigDecimal impIvaBase;
	private BigDecimal impIvaBaseDev;
	private BigDecimal montoDetallado;
	private String infoAdicional;
	private String infoContacto;
	private BigDecimal montoTotal;
	private String respAprobacion;
	private String respCodigo;
	private String respDescripcion;
	private String respEstado;
	private String tarjetaBin;
	private String tarjetaNum;
	private Date tarjetaFechaVen;
	private String facturaNumero;
	private String tarjetaTipo;
	private String terminalId;
	private String idTerminalMulticompra;
	private long terminalIdTrn;
	private String trnEstado;
	private boolean trnReversada;
	private Franquicia franquicia;
	private BigDecimal trnCosto;
	private long trnIdAutorizador;
	private String trnTipoCuenta;
	private String tipoCuentaSeleccionada;
	private String nitAdquiriente;
	private String codigoServicio;
	private String conceptoPago;
	private String urlComercio;
	private String codTrazabilidad;
	private int referencia;
	private Timestamp fechaProcBanco;
    private String cicloTransaccion;
    private String descripcionBanco;
    private String codigoBanco;
    private String direccionIP;
	private String appOrigen;
	private String linkPago;
	
	public String getTipoCuentaSeleccionada() {
		return tipoCuentaSeleccionada;
	}
	public void setTipoCuentaSeleccionada(String tipoCuentaSeleccionada) {
		this.tipoCuentaSeleccionada = tipoCuentaSeleccionada;
	}
	public String getTrnTipoCuenta() {
		return trnTipoCuenta;
	}
	public void setTrnTipoCuenta(String trnTipoCuenta) {
		this.trnTipoCuenta = trnTipoCuenta;
	}
	public long getTrnIdAutorizador() {
		return trnIdAutorizador;
	}
	public void setTrnIdAutorizador(long trnIdAutorizador) {
		this.trnIdAutorizador = trnIdAutorizador;
	}
	public Date getTarjetaFechaVen() {
		return tarjetaFechaVen;
	}
	public void setTarjetaFechaVen(Date tarjetaFechaVen) {
		this.tarjetaFechaVen = tarjetaFechaVen;
	}
	public String getFacturaNumero() {
		return facturaNumero;
	}
	public void setFacturaNumero(String facturaNumero) {
		this.facturaNumero = facturaNumero;
	}
	public String getTarjetaTipo() {
		return tarjetaTipo;
	}
	public void setTarjetaTipo(String tarjetaTipo) {
		this.tarjetaTipo = tarjetaTipo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getIdTransaccionMulticompra() {
		return idTransaccionMulticompra;
	}
	public void setIdTransaccionMulticompra(String idTransaccionMulticompra) {
		this.idTransaccionMulticompra = idTransaccionMulticompra;
	}
	public Timestamp getFecha() {
		return fecha;
	}
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}
	public String getAdquirienteCodigo() {
		return adquirienteCodigo;
	}
	public void setAdquirienteCodigo(String adquirienteCodigo) {
		this.adquirienteCodigo = adquirienteCodigo;
	}
	public String getIdAdquirienteMulticompra() {
		return idAdquirienteMulticompra;
	}
	public void setIdAdquirienteMulticompra(String idAdquirienteMulticompra) {
		this.idAdquirienteMulticompra = idAdquirienteMulticompra;
	}
	public String getAdquirienteNombre() {
		return adquirienteNombre;
	}
	public void setAdquirienteNombre(String adquirienteNombre) {
		this.adquirienteNombre = adquirienteNombre;
	}
	public String getClienteApellidos() {
		return clienteApellidos;
	}
	public void setClienteApellidos(String clienteApellidos) {
		this.clienteApellidos = clienteApellidos;
	}
	public String getClienteCelular() {
		return clienteCelular;
	}
	public void setClienteCelular(String clienteCelular) {
		this.clienteCelular = clienteCelular;
	}
	public String getClienteIdentificacion() {
		return clienteIdentificacion;
	}
	public void setClienteIdentificacion(String clienteIdentificacion) {
		this.clienteIdentificacion = clienteIdentificacion;
	}
	public String getClienteMail() {
		return clienteMail;
	}
	public void setClienteMail(String clienteMail) {
		this.clienteMail = clienteMail;
	}
	public String getClienteNombre() {
		return clienteNombre;
	}
	public void setClienteNombre(String clienteNombre) {
		this.clienteNombre = clienteNombre;
	}
	public TipoIdentificacion getClienteTipoIdentificacion() {
		return clienteTipoIdentificacion;
	}
	public void setClienteTipoIdentificacion(
			TipoIdentificacion clienteTipoIdentificacion) {
		this.clienteTipoIdentificacion = clienteTipoIdentificacion;
	}
	public Integer getCuotas() {
		return cuotas;
	}
	public void setCuotas(Integer cuotas) {
		this.cuotas = cuotas;
	}
	public BigDecimal getImpConsumo() {
		return impConsumo;
	}
	public void setImpConsumo(BigDecimal impConsumo) {
		this.impConsumo = impConsumo;
	}
	public BigDecimal getImpIva() {
		return impIva;
	}
	public void setImpIva(BigDecimal impIva) {
		this.impIva = impIva;
	}
	public BigDecimal getImpIvaBase() {
		return impIvaBase;
	}
	public void setImpIvaBase(BigDecimal impIvaBase) {
		this.impIvaBase = impIvaBase;
	}
	public BigDecimal getImpIvaBaseDev() {
		return impIvaBaseDev;
	}
	public void setImpIvaBaseDev(BigDecimal impIvaBaseDev) {
		this.impIvaBaseDev = impIvaBaseDev;
	}
	public String getInfoAdicional() {
		return infoAdicional;
	}
	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}
	public String getInfoContacto() {
		return infoContacto;
	}
	public void setInfoContacto(String infoContacto) {
		this.infoContacto = infoContacto;
	}
	public BigDecimal getMontoTotal() {
		return montoTotal;
	}
	public void setMontoTotal(BigDecimal montoTotal) {
		this.montoTotal = montoTotal;
	}
	public String getRespAprobacion() {
		return respAprobacion;
	}
	public void setRespAprobacion(String respAprobacion) {
		this.respAprobacion = respAprobacion;
	}
	public String getRespCodigo() {
		return respCodigo;
	}
	public void setRespCodigo(String respCodigo) {
		this.respCodigo = respCodigo;
	}
	public String getRespDescripcion() {
		return respDescripcion;
	}
	public void setRespDescripcion(String respDescripcion) {
		this.respDescripcion = respDescripcion;
	}
	public String getRespEstado() {
		return respEstado;
	}
	public void setRespEstado(String respEstado) {
		this.respEstado = respEstado;
	}
	public String getTarjetaBin() {
		return tarjetaBin;
	}
	public void setTarjetaBin(String tarjetaBin) {
		this.tarjetaBin = tarjetaBin;
	}
	public String getTarjetaNum() {
		return tarjetaNum;
	}
	public void setTarjetaNum(String tarjetaNum) {
		this.tarjetaNum = tarjetaNum;
	}
	public String getTerminalId() {
		return terminalId;
	}
	public void setTerminalId(String terminalId) {
		this.terminalId = terminalId;
	}
	public String getIdTerminalMulticompra() {
		return idTerminalMulticompra;
	}
	public void setIdTerminalMulticompra(String idTerminalMulticompra) {
		this.idTerminalMulticompra = idTerminalMulticompra;
	}
	public long getTerminalIdTrn() {
		return terminalIdTrn;
	}
	public void setTerminalIdTrn(long terminalIdTrn) {
		this.terminalIdTrn = terminalIdTrn;
	}
	public String getTrnEstado() {
		return trnEstado;
	}
	public void setTrnEstado(String trnEstado) {
		this.trnEstado = trnEstado;
	}
	public boolean isTrnReversada() {
		return trnReversada;
	}
	public void setTrnReversada(boolean trnReversada) {
		this.trnReversada = trnReversada;
	}
	public Franquicia getFranquicia() {
		return franquicia;
	}
	public void setFranquicia(Franquicia franquicia) {
		this.franquicia = franquicia;
	}
	public BigDecimal getTrnCosto() {
		return trnCosto;
	}
	public void setTrnCosto(BigDecimal trnCosto) {
		this.trnCosto = trnCosto;
	}
	public BigDecimal getMontoDetallado() {
		return montoDetallado;
	}
	public void setMontoDetallado(BigDecimal montoDetallado) {
		this.montoDetallado = montoDetallado;
	}
	public Timestamp getFechaTrnsCompraElectronica() {
		return fechaTrnsCompraElectronica;
	}
	public void setFechaTrnsCompraElectronica(Timestamp fechaTrnsCompraElectronica) {
		this.fechaTrnsCompraElectronica = fechaTrnsCompraElectronica;
	}
	public String getNitAdquiriente() {
		return nitAdquiriente;
	}
	public void setNitAdquiriente(String nitAdquiriente) {
		this.nitAdquiriente = nitAdquiriente;
	}
	public String getCodigoServicio() {
		return codigoServicio;
	}
	public void setCodigoServicio(String codigoServicio) {
		this.codigoServicio = codigoServicio;
	}
	public String getConceptoPago() {
		return conceptoPago;
	}
	public void setConceptoPago(String conceptoPago) {
		this.conceptoPago = conceptoPago;
	}
	public String getUrlComercio() {
		return urlComercio;
	}
	public void setUrlComercio(String urlComercio) {
		this.urlComercio = urlComercio;
	}
	
	public String getCodTrazabilidad() {
		return codTrazabilidad;
	}
	public void setCodTrazabilidad(String codTrazabilidad) {
		this.codTrazabilidad = codTrazabilidad;
	}
	public int getReferencia() {
		return referencia;
	}
	public void setReferencia(int referencia) {
		this.referencia = referencia;
	}
	public Timestamp getFechaProcBanco() {
		return fechaProcBanco;
	}
	public void setFechaProcBanco(Timestamp fechaProcBanco) {
		this.fechaProcBanco = fechaProcBanco;
	}
	public String getCicloTransaccion() {
		return cicloTransaccion;
	}
	public void setCicloTransaccion(String cicloTransaccion) {
		this.cicloTransaccion = cicloTransaccion;
	}
	public String getDescripcionBanco() {
		return descripcionBanco;
	}
	public void setDescripcionBanco(String descripcionBanco) {
		this.descripcionBanco = descripcionBanco;
	}
	public String getCodigoBanco() {
		return codigoBanco;
	}
	public void setCodigoBanco(String codigoBanco) {
		this.codigoBanco = codigoBanco;
	}
	public String getDireccionIP() {
		return direccionIP;
	}
	public void setDireccionIP(String direccionIP) {
		this.direccionIP = direccionIP;
	}
	public String getAppOrigen() {
		return appOrigen;
	}
	public void setAppOrigen(String appOrigen) {
		this.appOrigen = appOrigen;
	}
	public String getLinkPago() {
		return linkPago;
	}
	public void setLinkPago(String linkPago) {
		this.linkPago = linkPago;
	}
	
}
