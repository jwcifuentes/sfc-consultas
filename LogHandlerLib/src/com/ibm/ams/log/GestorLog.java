package com.ibm.ams.log;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibm.ams.excepcion.ExcepcionLog;
import com.ibm.ams.log.MensajeLog;
import com.ibm.ams.log.MensajeLog.Nivel;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class GestorLog {

	private static GestorLog instance;
	private static Map<String, Logger> loggers = new HashMap<String, Logger>();
	
	/**
	 * Metodo que crea una instancia de esta clase
	 * 
	 * @return GestorLog
	 */
	public static GestorLog getInstance() {
		if (instance == null)
			instance = new GestorLog();
		return instance;
	}

	/**
	 * Metodo que inicializa la configuración del log
	 * 
	 * @param configFileName
	 * @throws JoranException
	 */
	public static void initialize(String configFileName) throws ExcepcionLog {
		LoggerContext context = (LoggerContext) LoggerFactory
				.getILoggerFactory();
		try {
			JoranConfigurator configurator = new JoranConfigurator();
			configurator.setContext(context);
			// Sobreescribe cualquier configuracion anterior
			context.reset();
			configurator.doConfigure(configFileName);
			loggers = new HashMap<String, Logger>();
		} catch (JoranException je) {
			throw new ExcepcionLog("Error al iniciar configuración de log", je);
		}
	}

	/**
	 * Metodo que retorna un nuevo log
	 * 
	 * @param name
	 * @return Logger
	 */
	public Logger getLogger(String name) {
		Logger logger = loggers.get(name);
		if (logger == null) {
			logger = LoggerFactory.getLogger(name);
			loggers.put(name, logger);
			
		}
		return logger;
	}

	/**
	 * Metodo que trae el log segun el nombre de la clase
	 * 
	 * @param clas
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Logger getLogger(Class clas) {
		return getLogger(clas.getName());
	}

	/**
	 * Metodo que escribe en el log con el mensaje que recibe
	 * 
	 * @param messageLog
	 * @throws Exception
	 */
	public static void escribirLog(MensajeLog messageLog) throws ExcepcionLog {
		Logger log = GestorLog.getInstance().getLogger(messageLog.getIdLog());

		Nivel nivel = Nivel.valueOf(messageLog.getNivel());
		StringBuilder textLog = new StringBuilder();
		textLog.append(messageLog.toString());
		switch (nivel) {
		case trace:
			log.trace(textLog.toString());
			break;
		case info:
			log.info(textLog.toString());
			break;
		case debug:
			log.debug(textLog.toString());
			break;
		case warn:
			log.warn(textLog.toString(), messageLog.getReferencia());
			break;
		case error:
			log.error(textLog.toString(), messageLog.getReferencia());
			break;
		}
	}
}
