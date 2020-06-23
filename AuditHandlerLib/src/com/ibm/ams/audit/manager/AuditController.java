package com.ibm.ams.audit.manager;

import static com.ibm.ams.util.AuditConstList.ACTIVO;
import static com.ibm.ams.util.AuditConstList.DATA_SOURCE_PARAMETER;
import static com.ibm.ams.util.AuditConstList.DB_PARAMETER_GROUP;
import static com.ibm.ams.util.AuditConstList.JMSCF_JNDI_NAME;
import static com.ibm.ams.util.AuditConstList.JMSQ_JNDI_NAME;
import static com.ibm.ams.util.AuditConstList.JMS_SEND_TYPE;
import static com.ibm.ams.util.AuditConstList.PARAM_EVENT_TYPE;

import java.util.List;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.ibm.ams.audit.dto.AuditDto;
import com.ibm.ams.audit.dto.AuditFilter;
import com.ibm.ams.audit.exception.AuditException;
import com.ibm.ams.audit.xml.Parameter;
import com.ibm.ams.util.AuditConstList;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * Controlador del modulo de auditoria
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
public class AuditController {

	private AuditDBManager dbManager;
	private AuditConfigurationManager configManager;
	
	/**
	 * Constructor por defecto
	 */
	public AuditController() {
		try {
			configManager = new AuditConfigurationManager();
			if (configManager != null) {
				Parameter parameter = configManager.getParameter(DB_PARAMETER_GROUP, DATA_SOURCE_PARAMETER);
				if (parameter != null && parameter.getValue() != null && !parameter.getValue().isEmpty()) {
					dbManager = new AuditDBManager(parameter.getValue());
				}
			}
		} catch (AuditException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que ingresa un evento de auditoria en la cola de mensajes para ser
	 * procesado
	 * 
	 * @param bo
	 *            Objeto de evento de auditoria
	 * @throws AuditException
	 *             En caso de ocurrir un error al encolar el mensaje
	 */
	public void audit(AuditDto bo) throws AuditException {
		if (!isEventAuditable(bo)) {
			return;
		}	
		
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
			outMessage.setJMSType(JMS_SEND_TYPE);
			outMessage.setJMSDestination(q);
			queueSender.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			queueSender.send(outMessage);
			
			connection.close();
			
		} catch (JMSException e) {
			e.printStackTrace();
			throw new AuditException("Error al intentar acceder al enviar el mensaje a la cola", e);
		} catch (NamingException e) {
			e.printStackTrace();
			throw new AuditException ("Error no se pudo encontrar el nombre de la cola", e);
		}finally {
			if (queueSender != null) {
				try {
					queueSender.close();
				} catch (JMSException e) {
					throw new AuditException("Error cerrando recursos de colas queueSender", e);
				}
			}
			if (session != null) {
				try {
					session.close();
				} catch (JMSException e) {
					throw new AuditException("Error cerrando recursos de colas session", e);
				}
			}
			if (connection != null) {
				try {
					connection.close();
				} catch (JMSException e) {
					throw new AuditException("Error cerrando recursos de colas connection", e);
				}
			}
			if (initCtx != null) {
				try {
					initCtx.close();
				} catch (NamingException e) {
					throw new AuditException("Error cerrando recursos de colas initCtx", e);
				}
			}			
		}
	}
	
	/**
	 * Metodo encargado de almacenar el registro de auditoria
	 * 
	 * @param auditEvent
	 *            Evento de auditoria a almacenar
	 * @throws AuditException
	 *             En caso de ocurrir algun problema al almacenar el registro de
	 *             auditoria
	 */
	public void saveAuditEvent(AuditDto auditEvent) throws AuditException {
		dbManager.saveAuditEvent(auditEvent, 
				configManager.getParameter(
						AuditConstList.DB_PARAMETER_GROUP, 
						AuditConstList.SAVE_AUDIT_EVENT).getValue());
	}
	
	/**
	 * Metodo encargado de consultar los registros de auditoria por el filtro
	 * ingresado
	 * 
	 * @param filter
	 *            Filtro con la informacion de consulta
	 * @return Listado de eventos de auditoria
	 * @throws AuditException
	 *             en caso de ocurrir algun problema al realizar la consulta
	 */
	public List<AuditDto> findAuditEvents(AuditFilter filter) throws AuditException {
		return dbManager.findAuditEvents(filter, 
				configManager.getParameter(AuditConstList.DB_PARAMETER_GROUP, 
						AuditConstList.FIND_AUDIT_EVENTS).getValue());
	}

	private boolean isEventAuditable(AuditDto auditDto){
		try {
			Parameter param = configManager.getParameter(PARAM_EVENT_TYPE, auditDto.getEventType().getId().toString());
			if (param != null && ACTIVO.equalsIgnoreCase(param.getValue())) {
				return true;
			}
		} catch (AuditException e) {
			// TODO Auto-generated catch block
		}
		
		return false;
	}
	
}
