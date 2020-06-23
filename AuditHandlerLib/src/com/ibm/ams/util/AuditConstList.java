package com.ibm.ams.util;

import java.io.File;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * Interface de constantes para el modulo de Auditoria
 * 
 * 
 * <p>
 * <b>Notas: </b>
 * 
 * <p>
 * 
 * <p>
 * <b>Proyecto base: </b> AuditWeb
 * 
 * @author jcmarin@co.ibm.com IBM - Juan Carlos Marin Rincon
 *         <p>
 *         <b>Fecha de creacion(14/Oct/2015): </b>
 * 
 * @version [1.0, 14/Oct/2015]
 * <p>
 * <b>ChangeLog: </b>
 * 
 * <p>
 * Version: 1.0
 * <p>
 * - Implementacion inicial de la logica requerida por el caso de uso
 * 
 **/
public interface AuditConstList {
	
	public static final String CONFIG_URL_BASE = "SWF_PORTAL_CONFIGPATH";
	public static final String CONFIG_FOLDER = "audit";
	public static final String APPLICATION_NAME = "audit";
	public static final String CONFIG_SYSLOG_APPENDER_FILE_NAME = "syslogAppender.xml";
	public static final String CONFIG_FILE_NAME = "audit_conf.xml";
	public static final String CONFIG_EHCACHE_FILE_NAME= "ehcache.xml";
	
	public static final String AUDIT_CACHE_NAME ="auditCache";
	public static final String AUDIT_ID_CACHE = "auh";
	public static final String EVENT_TYPE_CACHE_NAME = "eventTypeCache";
	public static final String APPLICATION_CACHE_NAME = "applicationCache";
	
	public static final String DB_PARAMETER_GROUP = "BD";
	public static final String SAVE_AUDIT_EVENT = "SalvarEventoAuditoria";
	public static final String FIND_AUDIT_EVENTS = "BuscarEventosAuditoria";
	public static final String DATA_SOURCE_PARAMETER = "dataSource";
	public static final String EVENT_TYPES_QUERY_PARAM = "ConsultarTiposEventos";
	public static final String APPLICATIONS_QUERY_PARAM = "ConsultarAplicaciones";
	
	public static final int FIND_QUERY_TIMEOUT = 30;
	public static final int DEFAULT_QUERY_TIMEOUT = 10;
	
	public static final String EX_MESSAGE_FILE_READ_ERROR = "Error obteniendo la informacion de configuración";
	public static final String EX_MESSAGE_FILE_NOT_FOUND = "No se Encontro el archivo de configuración";
	public static final String EX_MESSAGE_CACHE_UPLOAD_ERROR = "Error subiendo el archivo de configuración a cache";
	
	public static final String JMSCF_JNDI_NAME = "jms/JMSAuditConnFactory";
	public static final String JMSQ_JNDI_NAME = "jms/JMSAuditQueue";
	public static final String JMS_SEND_TYPE = "package_received";
	
	public static final String DATE_RANGE_PARAM = "consulta.auditoria.rango.fechas";
	public static final String ROW_NUM_PARAM = "consulta.auditoria.opciones.num.filas";
	public static final String REPORT_DATE_FORMAT = "yyyy-MM-dd";
	public static final String RESOURCE_ID_AUDIT_EXCEL = "ReporteExcelAuditoria";
	public static final String FIND_AUDIT_BEAN = "pc_ConsultaAuditoriaBean";
	public static final String CONTENT_TYPE_EXCEL = "application/vnd.ms-excel";
	public static final String CONTENT_TYPE_KEY = "content-disposition";
	public static final String ATTACHMENT_KEY = "attachment; filename=";
	public static final String EXCEL_FILE_EXTENSION = ".xls";
	public static final String AUDIT_REPORT_NAME = "ReporteAuditoria";
	public static final String REPORT_TEMPLATE_NAME = "plantillaConsultaAuditoria";
	public static final String REPORT_CONFIG_PATH = System.getProperty(CONFIG_URL_BASE) + CONFIG_FOLDER + File.separatorChar + "plantillas" + File.separatorChar + "ReportesConfig.xml";
	
	public static final String PARAM_EVENT_TYPE = "TipoEvento";
	public static final String ACTIVO = "A";
	
	public static final Integer APLICACION_BP = 1;
	public static final Integer APLICACION_DW = 2;
	public static final Integer APLICACION_SAC = 3;
	public static final Integer APLICACION_SIC = 4;
	public static final Integer APLICACION_COMPENSACION = 5;
	public static final Integer APLICACION_SIFRA = 6;
	public static final Integer APLICACION_USUARIOS = 7;
	public static final Integer APLICACION_LOGIN = 8;
	public static final Integer CONSULTA_AUDITORIA = 9;
	public static final Integer CAMBIO_CLAVE = 10;
	public static final Integer CONSULTA_TRANSACCIONES = 11;
	public static final Integer APLICACION_HCWEB = 12;
	public static final Integer APLICACION_AUTOWEB = 13;
	public static final Integer APLICACION_WEBPREPAGO = 14;
	
	

}