package com.ibm.ams.log;

import java.io.File;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ibm.ams.constantes.Constantes;
import com.ibm.ams.excepcion.ExcepcionLog;
import com.ibm.ams.log.bo.ConfiguracionNiveles;
import com.ibm.ams.log.bo.Nivel;
import com.ibm.ams.log.bo.NivelesLog;
import com.ibm.ams.utils.MonitorConfiguracion;
import com.ibm.ams.utils.ServicioConfigurable;

public class Logger implements ServicioConfigurable{
	
	private String aplicacion = "";
	private static Logger instance;
	private int nivelDefault;
	private Map<String, Integer> nivelPorLogger;

	
	private int getLogLevel(String loggerClass){
		do{
			Integer nivel = nivelPorLogger.get(loggerClass);
			if(nivel != null){
				return nivel;
			}
			int lastIndex = loggerClass.lastIndexOf('.');
			if(lastIndex > 0){
				loggerClass = loggerClass.substring(0, lastIndex);
			}else{
				return nivelDefault;
			}
		}while(true);
	}
	
	public static Logger getInstance(String aplicacion_, String configDir) {
		if (instance == null){
			instance = new Logger();
			instance.aplicacion = aplicacion_;
			String rutaArchivoConf = System.getProperty(Constantes.CONFIGURACION_DIR) + configDir + File.separatorChar + aplicacion_ + "_logconfig.xml";
			MonitorConfiguracion.iniciarMonitoreo(instance, new File(rutaArchivoConf));
		}		
		return instance;
	}

	/**
	 * Metodo que es invocado por las aplicaciones para generar el log
	 * 
	 * @param clase
	 * @param nombreMetodo
	 * @param mensaje
	 * @param excepcion
	 * @param nivel
	 * @param aplicacion
	 * @param idHilo
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	private void escribirLog(NivelesLog nivel, String clase, String metodo,
			String mensaje, String errorStack, Object... args) throws ExcepcionLog {
		if(nivel.getValor() <= getLogLevel(aplicacion + "." + clase)){
			
			MensajeLog msgLog = new MensajeLog();
			msgLog.setAplicacion(aplicacion);
			msgLog.setComponente(clase);
			msgLog.setFecha(new Date());
			msgLog.setIdHilo(Thread.currentThread().getName());
			msgLog.setMensaje(String.format(mensaje, args));
			msgLog.setMetodo(metodo);
			msgLog.setNivel(nivel.getTexto());
			msgLog.setReferencia(errorStack);

			try {
				enviar(msgLog);
			} catch (Throwable t) {
				t.printStackTrace();
			}		
		}
	}
	
	/**
	 * Metodo que recibe la información de un objeto para armar un mensaje de
	 * tipo trace
	 * 
	 * @param fecha
	 * @param nivel
	 * @param aplicacion
	 * @param componente
	 * @param metodo
	 * @param idHilo
	 * @param mensaje
	 * @param referencia
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	public void trace(String clase, String metodo, String mensaje,
			Object... args) {
		try {
			escribirLog(NivelesLog.TRACE, clase, metodo, mensaje, null, args);
		} catch (ExcepcionLog e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que recibe la información de un objeto para armar un mensaje de
	 * tipo debug
	 * 
	 * @param fecha
	 * @param nivel
	 * @param aplicacion
	 * @param componente
	 * @param metodo
	 * @param idHilo
	 * @param mensaje
	 * @param referencia
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	public void debug(String clase, String metodo, String mensaje,
			Object... args) {
		try {
			escribirLog(NivelesLog.DEBUG, clase, metodo, mensaje, null, args);
		} catch (ExcepcionLog e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que recibe la información de un objeto para armar un mensaje de
	 * tipo info
	 * 
	 * @param fecha
	 * @param nivel
	 * @param aplicacion
	 * @param componente
	 * @param metodo
	 * @param idHilo
	 * @param mensaje
	 * @param referencia
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	public void info(String clase, String metodo, String mensaje,
			Object... args) {
		try {
			escribirLog(NivelesLog.INFO, clase, metodo, mensaje, null, args);
		} catch (ExcepcionLog e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que recibe la información de un objeto para armar un mensaje de
	 * tipo warn
	 * 
	 * @param fecha
	 * @param nivel
	 * @param aplicacion
	 * @param componente
	 * @param metodo
	 * @param idHilo
	 * @param mensaje
	 * @param referencia
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	public void warn(String clase, String metodo, String mensaje,
			Object... args) {
		try {
			escribirLog(NivelesLog.WARN, clase, metodo, mensaje, null, args);
		} catch (ExcepcionLog e) {
			e.printStackTrace();
		}
	}

	/**
	 * Metodo que recibe la información de un objeto para armar un mensaje de
	 * tipo error
	 * 
	 * @param fecha
	 * @param nivel
	 * @param aplicacion
	 * @param componente
	 * @param metodo
	 * @param idHilo
	 * @param mensaje
	 * @param referencia
	 * @throws ExcepcionLog
	 * @throws Exception
	 */
	public void error(String clase, String metodo, String mensaje, Throwable error, 
			Object... args) {
		try {
			String errorStack = null;
			if(error != null){	
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				error.printStackTrace(pw);
				errorStack = sw.toString();
			}
			escribirLog(NivelesLog.ERROR, clase, metodo, mensaje, errorStack, args);
		} catch (ExcepcionLog e) {
			e.printStackTrace();
		}
	}


	public void enviar(Serializable bo) throws ExcepcionLog {
		String JMSCF_JNDI_NAME = "jms/JMSLogConnFactory";
		String JMSQ_JNDI_NAME = "jms/JMSLogQueue";

		InitialContext initCtx = null;
		Connection connection = null;
		Session session = null;
		MessageProducer queueSender = null;
		try {
			initCtx = new InitialContext();
			// Finding the WAS QueueConnectionFactory
			javax.jms.ConnectionFactory qcf = (javax.jms.ConnectionFactory) initCtx
					.lookup(JMSCF_JNDI_NAME);

			// Finding the Queue Destination
			Destination q = (Destination) initCtx.lookup(JMSQ_JNDI_NAME);

			// Create JMS Connection
			connection = qcf.createConnection();

			// Create JMS Session
			session = connection.createSession(false,
					Session.AUTO_ACKNOWLEDGE);

			// Create MessageProducer and TextMessage
			queueSender = session.createProducer(q);
			// TextMessage outMessage = session.createTextMessage();
			// outMessage.setText(messageText);
			ObjectMessage outMessage = session.createObjectMessage(bo);

			// Set type and destination and send
			outMessage.setJMSType("package_received");
			outMessage.setJMSDestination(q);
			queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			queueSender.send(outMessage);
			connection.close();
		} catch (JMSException e) {
			throw new ExcepcionLog(
					"Error al intentar acceder al enviar el mensaje a la cola",
					e);
		} catch (NamingException e) {
			throw new ExcepcionLog(
					"Error no se pudo encontrar el nombre de la cola", e);
		}finally {
			if (queueSender != null) {
				try {
					queueSender.close();
				} catch (JMSException e) {
					throw new ExcepcionLog("Error cerrando recursos de colas queueSender", e);
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					throw new ExcepcionLog("Error cerrando recursos de colas session", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					throw new ExcepcionLog("Error cerrando recursos de colas connection", e);
				}
			}
			if (initCtx != null) {
				try {
					initCtx.close();
				} catch (NamingException e) {
					throw new ExcepcionLog("Error cerrando recursos de colas initCtx", e);
				}
			}			
		}
	}

	@Override
	public void cargarConfiguracion(Object obj) {	
		ConfiguracionNiveles config = (ConfiguracionNiveles) obj;
		nivelDefault = NivelesLog.valueOf(config.getRoot().getLevel()).getValor();
		nivelPorLogger = new HashMap<String, Integer>();
		for(Nivel nivel : config.getLogger()){
			nivelPorLogger.put(nivel.getName(), NivelesLog.valueOf(nivel.getLevel()).getValor());
		}
	}

	@Override
	public Object getConfigObjectInstance() {
		return new ConfiguracionNiveles();
	}
}
