package com.rbm.gp.constantes;

import java.io.File;

/**
 * Constantes de GlobalPay.
 */


public class Constantes {
	/** Constante servIniciarCompra. */
	public static final String SERVICIO_REALIZAR_PAGO = "GlobalPayServicioDePago";
	
	/** Constante servIniciarCompra. */
	public static final String SERVICIO_MULTICOMPRA = "BotonPagosServicioMultiCompra";
	
	/** Constante servConsulEstadoTrns. */
	public static final String SERVICIO_CONSULTA_ESTADO = "GlobalPayServicioConsultaEstadoTrns";
	
	/** Constante servConsulEstadoTrns. */
	public static final String SERVICIO_CONSULTA_ESTADO_MULTI = "GlobalPayServicioConsultaEstadoTrnsMulti";
	
	/** Constante gpConfiguracion. */
	public static final String CONFIGURACION_ARCHIVO = "GlobalPay_Conf.xml";
	
	/** Constante gpRaiz. */
	public static final String CONFIGURACION_DIR = "SWF_PORTAL_CONFIGPATH";
	
	/** Directorio de configuracion del LDAP */
	public static final String CONFIGURACION_LDAP = "ldap";
	
	/** Ruta del archivo de configuracion del LDAP */
	public static final String PATH_CONF_LDAP = System.getProperty(CONFIGURACION_DIR) + CONFIGURACION_LDAP +  File.separatorChar + "ldapConfig.xml";


	/** Ruta dle archivo de acceso a usuarios del LDAP */
	public static final String PATH_MAPPING_LDAP = System.getProperty(CONFIGURACION_DIR) + CONFIGURACION_LDAP +  File.separatorChar + "ldapMapping.xml";
	
	/** Constante initTrnsQ. */
	public static final String QUERY_COMPROBAR_TRANSACCION = "ComprobacionInicioTransaccion";
	
	/** Constante obtenerTransaccion. */
	public static final String QUERY_OBTENER_TRANSACCION = "BuscarTransaccion";
	
	/** Constante actualizarTRNS. */
	public static final String QUERY_ACTUALIZAR_TRANSACCION = "ActualizarTRNS";
	
	/** Constante cambiarEstadoTRNS. */
	public static final String QUERY_CAMBIAR_ESTADO_TRANSACCION = "CambiarEstadoTrns";
	
	/** Constante cambiar estado TRANSACCION y estado de la respuesta */
	public static final String QUERY_CAMBIAR_ESTADO_TRANSACCION_RESPUESTA = "CambiarEstadoRespTrns";
	
	/** Constante obtenerFranquicias. */
	public static final String QUERY_OBTENER_FRANQUICIAS = "ObtenerFranquicias";
	
	/** Constante buscarBolsillos. */
	public static final String QUERY_BUSCAR_TIPOS_CUENTA = "BuscarTiposCuentaFranquicia";
	
	/** Constante buscarBines. */
	public static final String QUERY_BUSCAR_BINES = "BuscarBinesFranquicia";
	
	/** Constante buscarDescripcionComercio. */
	public static final String QUERY_BUSCAR_DESC_COMERCIO = "ConsultaDescComercio";
	
	/** Constante obtenerTipoIdentificacion. */
	public static final String QUERY_OBTENER_TIPOS_IDENTIFICACION = "ObtenerTipoTarjetaID";
	public static final String QUERY_OBTENER_ID_TRNS_TERMINAL_DIA = "BuscarTransaccionDiaIdTransaccionTerminal";
	public static final String QUERY_OBTENER_BINES_NO_HABILITADOS = "ObtenerBinesNoValidos";
	public static final String QUERY_OBTENER_COMERCIO_SEI = "ConsultaSEI";
	
	/** Constante obtenerTrnsPendientes */
	public static final String QUERY_OBTENER_TRNS_PENDIENTES = "ConsultaTrnsPendientes";
	
	/** Constante initTrnsQ. */
	public static final String QUERY_ACTUALIZAR_COD_TRAZABILIDAD = "actualizarTrazabilidad";
	
	public static final String QUERY_ACTUALIZAR_NOTIF_CLIENTE = "actualizarNotifCliente";
	
	/** Constante CREDITO. */
	public static final String MEDIO_PAGO_CREDITO = "CD";
	/** Constante DEBITO. */
	public static final String MEDIO_PAGO_DEBITO = "DB";
	/** Constante PRIVADO. */
	public static final String MEDIO_PAGO_PRIVADO= "PR";
	
	/** Constante CREDITOPRIV. */
	public static final String MEDIO_PAGO_CREDITO_PRIV = "CP";
	
	/** Constante DEBITOPRIV. */
	public static final String MEDIO_PAGO_DEBITO_PRIV = "DP";
	
	public static final String CONF_PORCENTAJE_MAX_IVA = "PorcentajeMaxIva";
	public static final String CONF_PORCENTAJE_MAX_CONSUMO = "PorcentajeMaxConsumo";
	public static final String CONF_PORCENTAJE_MAX_MONTO_ADICIONAL = "PorcentajeMaxMontoAdicional";
	
	public static final String CACHE_ADQUIRIENTES = "Adquirientes";
	
	/** Nombre del cache con que se guarda la inforacion de catalogos CACHE_TIPOS_IDENTIFICACION. */
	public static final String CACHE_TIPOS_IDENTIFICACION = "TiposIdentificacion";
	
	/** Nombre del cache con que se guarda la inforacion de catalogos CACHE_FRANQUICIAS. */
	public static final String CACHE_FRANQUICIAS ="Franquicias";
	
	/** Nombre del cache con que se guarda la inforacion de los filtros de CACHE_FRANQUICIAS. */
	public static final String CACHE_FILTROS_FRANQUICIAS = "FiltrosFranquicias";
	
	/** Nombre del cache con que se guarda la inforacion de los bancos de CACHE_BANCOS */
	public static final String CACHE_BANCOS = "Bancos";
	
	public static final String FORMATO_DECIMAL = "#,##0.00";
	
	public static final String FORMATO_FECHA = "dd/MM/yyyy HH:mm";
	
	public static final String FECHA = "yyMMdd";
	
	public static final String APROBADO = "Aprobado";
	
	public static final String RECHAZADO = "Rechazado";
	
	public static final String APROBADOM = "aprobado";
	
	public static final String RECHAZADOM = "rechazado";
	
	public static final String PENDIENTE = "Pendiente";
	
	public static final String INICIADO = "iniciado";
	
	public static final String PROCESANDO = "procesando";
	
	public static final String RECIBIDA = "Recibida";
	
	public static final String ERROR = "error";
	
	public static final String PNG = ".png";
	
	public static final String PDF = ".pdf";
	
	public static final String TRUE = "TRUE";
	
	public static final String APLICACION = "globalpay";
	
	public static final String TARJ = "TARJ";
	
	public static final String PSE = "PSE";
	
	public static final String HABILITADO = "HABILITADO";
	
	public static final String SI = "S";
	
	public static final String NO = "N";
	
	public static final String FIJ = "FIJ";
	
	public static final String URL = "url/CompraElectronica";
	
	public static final String FORMATO_CLAVE = "3DES";
	
	public static final String JMSCF_JNDI_NAME = "jms/JMSMQConnFactory";
	
	public static final String JMSQ_JNDI_NAME_OUT = "jms/PinBlockQueueOut";
	
	public static final String JMSQ_JNDI_NAME_IN = "jms/PinBlockQueueIn";
	
	public static final String CREDITO = "C";
	
	public static final String DEBITO = "D";
	
	public static final String COD_RESPUESTA_9002 = "9002";
	
	public static final String COD_RESPUESTA_9003 = "9003";
	
	public static final String COD_RESPUESTA_9004 = "9004";
	
	public static final String COD_RESPUESTA_9006 = "9006";
	
	public static final String COD_RESPUESTA_9008 = "9008";
	
	public static final String INICIAR_TRANSACCION = "IniciarTransaccionMultiCompra\"";
	
	public static final String ID_TERMINAL = "idTerminal=";
	
	public static final String ID_TRANSACCION = "&idTransaccion=";
	
	/**	Mensajes de error */
	
	public static final String ME001 = "Error en la validación de las tarjetas";
	
	public static final String ME002 = "El número de tarjeta esta incompleto";
	
	public static final String ME003 = "El número de tarjeta especificado no es valido";
	
	public static final String ME004 = "Tarjeta no soportada por el sistema";
	
	public static final String ME005 = "La transacción no pudo ser procesada en este momento";
	
	public static final String ME006 = "Comercio no identificado";
	
	public static final String ME007 = "El comercio no tiene entidades bancarias asociadas para los pagos por PSE";
	
	public static final String ME008 = "Estamos teniendo problemas técnicos. Por favor consulte al Comercio";
	
	public static final String ME009 = "Ha Ocurrido un Error no Esperado en el Servicio Web";
	
	public static final String ME010 = "Aplicacion No Disponible";
	
	public static final String ME011 = "Error en validacion de estructura";
	
	/** Mensajes informativos */
	
	public static final String MI001 = "Transaccion iniciada";
	
	public static final String MI002 = "Transaccion aprobada";
	
	public static final String MI003 = "Transaccion rechazada";
	
	public static final String MI004 = "Transaccion está en proceso";
	
	public static final String MI005 = "Error al procesar la transaccion";
	
	public static final String MI006 = "Operacion Exitosa";
	
	/** Constante con la ruta de configuracion de las imagenes */
	public static final String IMAGENES_DIR = System.getProperty(Constantes.CONFIGURACION_DIR) + "globalpay"+File.separatorChar + "logos-franquicias"+File.separatorChar;
	
	/** Constante con la ruta de configuracion de las imagenes */
	public static final String IMAGENES_DIR_RAIZ = "/GlobalPayWeb/images/";

	public static final String QUERY_OBTENER_INFO_LINK = "ObtenerInfoLink";
	
	public static final String QUERY_OBTENER_CORREO_COMERCIO = "consultarCorreoComercio";

	public static final String URLIniCompra = "url/IniciarCompra";

	public static final String QUERY_OBTENER_ESTADO_USUARIO_LP = "EstadoUsuarioLinkPago";

	public static final String QUERY_OBTENER_ESTADO_LINK = "EstadoLink";

	public static final String QUERY_OBTENER_ACTUALIZAR_ID_LINK = "ActualizarIdLink";
	
	public static final String QUERY_CONSULTAR_NIT_PSE = "ConsultarNitPSE";
	
	public static final String JOB_LIMPIAR_CACHE_LISTA_BANCO ="jobListaBancos";

	public static final String GROUP_NAME_PROCESO_LISTA_BANCO = "grupoCacheListaBanco";

	public static final String TRIGGER_NAME_PROCESO_LISTA_BANCO = "triggerCacheListaBanco";

	public static final String COD_COLSUBSIDIO = "Colsubsidio";

	public static final String JOB_CONSULTAR_ESTADO ="jobConsultarEstado";
	
	public static final String GROUP_NAME_PROCESO_CONSULTAR_ESTADO = "grupoConsultarEstado";
	
	public static final String TRIGGER_NAME_PROCESO_CONSULTAR_ESTADO = "triggerConsultarEstado";
	
}
