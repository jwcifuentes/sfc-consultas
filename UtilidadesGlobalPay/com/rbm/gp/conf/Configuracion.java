package com.rbm.gp.conf;

 import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name="globalpay")
@XmlType(propOrder = {"dataSource",
		"dataSourceSei",
		"dataSourceLink",
		"timeoutInicioTrns",
		"timeoutPinBlock",
		"mensajeVoucherRBM",
		"registrarAuditoria",
		"estadoTxURL",
		"queries",
		"serviciosExpuestos",
		"informacionVoucherRBM",
		"restricciones",
		"codigosErrorReintentos",
		"keyEncript",
		"initVector",
		"terminalRBM",
		"estadoInactivoLink",
		"codFranqPSE",
		"urlRetornoIndex",
		"tiemposEjeucuionTarea",
		"tiempoEjecucionConsultaPendiente",
		"idTerminal",
		"idadquiriente",
		"nit",
		"urlPruebasMB",
		"urlSegundaClave",
		"urlRealizarPago",
		"usrPinBLock",
		"passPinkBLock"})

public class Configuracion {
	private String dataSource;
	private String dataSourceSei;
	private int timeoutInicioTrns;
	private long timeoutPinBlock;
	private String mensajeVoucherRBM;
	private int registrarAuditoria;
	private String estadoTxURL;
	private Queries queries;
	private ServiciosExpuestos serviciosExpuestos;
	private String informacionVoucherRBM;
	private Restricciones restricciones;
	private CodigosErrorReintentos codigosErrorReintentos;
	private String keyEncript;
	private String initVector;
	private String dataSourceLink;
	private String terminalRBM;
	private int estadoInactivoLink;
	private String codFranqPSE;
	private String urlRetornoIndex;
	private String tiemposEjeucuionTarea;
	private String tiempoEjecucionConsultaPendiente;
	private String idTerminal;
	private String idadquiriente;
	private String nit;
	private String urlPruebasMB;
	private String urlSegundaClave;	
	private String urlRealizarPago;
	private String usrPinBLock;
	private String passPinkBLock;
	
	public String getUrlSegundaClave() {
		return urlSegundaClave;
	}
	public void setUrlSegundaClave(String urlSegundaClave) {
		this.urlSegundaClave = urlSegundaClave;
	}
	public String getMensajeVoucherRBM() {
		return mensajeVoucherRBM;
	}
	public void setMensajeVoucherRBM(String mensajeVoucherRBM) {
		this.mensajeVoucherRBM = mensajeVoucherRBM;
	}
	
	public int getRegistrarAuditoria() {
		return registrarAuditoria;
	}
	public void setRegistrarAuditoria(int registrarAuditoria) {
		this.registrarAuditoria = registrarAuditoria;
	}
	public Restricciones getRestricciones() {
		return restricciones;
	}
	public void setRestricciones(Restricciones restricciones) {
		this.restricciones = restricciones;
	}
	public CodigosErrorReintentos getCodigosErrorReintentos() {
		return codigosErrorReintentos;
	}
	public void setCodigosErrorReintentos(CodigosErrorReintentos codigosErrorReintentos) {
		this.codigosErrorReintentos = codigosErrorReintentos;
	}
	public String getInformacionVoucherRBM() {
		return informacionVoucherRBM;
	}
	public void setInformacionVoucherRBM(String informacionVoucherRBM) {
		this.informacionVoucherRBM = informacionVoucherRBM;
	}
	public Queries getQueries() {
		return queries;
	}
	public void setQueries(Queries queries) {
		this.queries = queries;
	}
	public String getDataSource() {
		return dataSource;
	}
	public void setDataSource(String dataSource) {
		this.dataSource = dataSource;
	}
	public String getDataSourceSei() {
		return dataSourceSei;
	}
	public void setDataSourceSei(String dataSourceSei) {
		this.dataSourceSei = dataSourceSei;
	}
	public int getTimeoutInicioTrns() {
		return timeoutInicioTrns;
	}
	public void setTimeoutInicioTrns(int timeoutInicioTrns) {
		this.timeoutInicioTrns = timeoutInicioTrns;
	}

	public ServiciosExpuestos getServiciosExpuestos() {
		return serviciosExpuestos;
	}
	public void setServiciosExpuestos(ServiciosExpuestos serviciosExpuestos) {
		this.serviciosExpuestos = serviciosExpuestos;
	}
	public long getTimeoutPinBlock() {
		return timeoutPinBlock;
	}
	public void setTimeoutPinBlock(long timeoutPinBlock) {
		this.timeoutPinBlock = timeoutPinBlock;
	}
	
	public void setEstadoTxURL(String estadoTxURL){
		this.estadoTxURL = estadoTxURL;
	}
	public String getEstadoTxURL() {
		return estadoTxURL;
	}
	public String getKeyEncript() {
		return keyEncript;
	}
	public void setKeyEncript(String keyEncript) {
		this.keyEncript = keyEncript;
	}
	public String getInitVector() {
		return initVector;
	}
	public void setInitVector(String initVector) {
		this.initVector = initVector;
	}
	public String getDataSourceLink() {
		return dataSourceLink;
	}
	public void setDataSourceLink(String dataSourceLink) {
		this.dataSourceLink = dataSourceLink;
	}
	public String getTerminalRBM() {
		return terminalRBM;
	}
	public void setTerminalRBM(String terminalRBM) {
		this.terminalRBM = terminalRBM;
	}
	public int getEstadoInactivoLink() {
		return estadoInactivoLink;
	}
	public void setEstadoInactivoLink(int estadoInactivoLink) {
		this.estadoInactivoLink = estadoInactivoLink;
	}
	public String getCodFranqPSE() {
		return codFranqPSE;
	}
	public void setCodFranqPSE(String codFranqPSE) {
		this.codFranqPSE = codFranqPSE;
	}
	public String getTiemposEjeucuionTarea() {
		return tiemposEjeucuionTarea;
	}
	public void setTiemposEjeucuionTarea(String tiemposEjeucuionTarea) {
		this.tiemposEjeucuionTarea = tiemposEjeucuionTarea;
	}
	public String getTiempoEjecucionConsultaPendiente() {
		return tiempoEjecucionConsultaPendiente;
	}
	public void setTiempoEjecucionConsultaPendiente(
			String tiempoEjecucionConsultaPendiente) {
		this.tiempoEjecucionConsultaPendiente = tiempoEjecucionConsultaPendiente;
	}
	public String getIdTerminal() {
		return idTerminal;
	}
	public void setIdTerminal(String idTerminal) {
		this.idTerminal = idTerminal;
	}
	public String getIdadquiriente() {
		return idadquiriente;
	}
	public void setIdadquiriente(String idadquiriente) {
		this.idadquiriente = idadquiriente;
	}
	public String getNit() {
		return nit;
	}
	public void setNit(String nit) {
		this.nit = nit;
	}
	
	public String getUrlPruebasMB() {
		return urlPruebasMB;
	}
	
	public void setUrlPruebasMB(String urlPruebasMB) {
		this.urlPruebasMB = urlPruebasMB;
	}
	
	public String getUrlRetornoIndex() {
		return urlRetornoIndex;
	}
	public void setUrlRetornoIndex(String urlRetornoIndex) {
		this.urlRetornoIndex = urlRetornoIndex;
	}
	public String getUrlRealizarPago() {
		return urlRealizarPago;
	}
	public void setUrlRealizarPago(String urlRealizarPago) {
		this.urlRealizarPago = urlRealizarPago;
	}
	public String getUsrPinBLock() {
		return usrPinBLock;
	}
	public void setUsrPinBLock(String usrPinBLock) {
		this.usrPinBLock = usrPinBLock;
	}
	public String getPassPinkBLock() {
		return passPinkBLock;
	}
	public void setPassPinkBLock(String passPinkBLock) {
		this.passPinkBLock = passPinkBLock;
	}
	
}
