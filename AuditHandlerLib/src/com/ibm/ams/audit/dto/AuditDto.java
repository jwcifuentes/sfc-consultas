package com.ibm.ams.audit.dto;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * DTO que encapsula la informacion de un evento de auditoria
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
 * @author dmejiaro@co.ibm.com IBM - Daniel Mejia Rojas
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
public class AuditDto implements Serializable {

	private static final long serialVersionUID = 7132893083472763196L;
	
	private Long id;
	private Date eventDate;
	private String user;
	private EventDto eventType;
	private String eventOriginIp;
	private Application eventOriginApp;
	private String eventOriginClass;
	private String eventUserIp;
	private String eventMessage;
	private SeverityEnum eventSeverity;
	private String eventSuccess;
	
	private String eventSeverityName;

	public AuditDto() {
		eventType = new EventDto();
		eventOriginApp = new Application();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEventDate() {
		return eventDate;
	}

	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public EventDto getEventType() {
		return eventType;
	}

	public void setEventType(EventDto eventType) {
		this.eventType = eventType;
	}

	public String getEventOriginIp() {
		return eventOriginIp;
	}

	public void setEventOriginIp(String eventOriginIp) {
		this.eventOriginIp = eventOriginIp;
	}

	public Application getEventOriginApp() {
		return eventOriginApp;
	}

	public void setEventOriginApp(Application eventOriginApp) {
		this.eventOriginApp = eventOriginApp;
	}

	public String getEventOriginClass() {
		return eventOriginClass;
	}

	public void setEventOriginClass(String eventOriginClass) {
		this.eventOriginClass = eventOriginClass;
	}

	public String getEventUserIp() {
		return eventUserIp;
	}

	public void setEventUserIp(String eventUserIp) {
		this.eventUserIp = eventUserIp;
	}

	public String getEventMessage() {
		return eventMessage;
	}

	public void setEventMessage(String eventMessage) {
		this.eventMessage = eventMessage;
	}

	public SeverityEnum getEventSeverity() {
		return eventSeverity;
	}

	public void setEventSeverity(SeverityEnum eventSeverity) {
		this.eventSeverity = eventSeverity;
	}

	public String getEventSuccess() {
		return eventSuccess;
	}

	public void setEventSuccess(String eventSuccess) {
		this.eventSuccess = eventSuccess;
	}
	
	public String getEventSeverityName() {
		eventSeverityName = "";
		if (eventSeverity != null) {
			eventSeverityName = eventSeverity.name().toString();
		}
		return eventSeverityName;
	}
	
	public void setEventSeverityName(String eventSeverityName) {
		this.eventSeverityName = eventSeverityName;
	}
	
	public List<Object> getObjectList() {
		ArrayList<Object> list = new ArrayList<Object>();
		list.add(new Timestamp(eventDate.getTime()));
		list.add(user);
		list.add(eventType.getId());
		list.add(eventOriginIp);
		list.add(eventOriginApp.getId());
		list.add(eventOriginClass);
		list.add(eventUserIp);
		list.add(eventMessage);
		list.add(eventSeverity.intValue());
		list.add(eventSuccess);
		return list;
	}

	@Override
	public String toString() {
		return "FECHA: " + eventDate + " - USUARIO: " + user + " - ID_TIPO_EVENTO: " + eventType.getId() + " - IP_ORIGEN: " + eventOriginIp + " - APLICACION: " + eventOriginApp.getId() 
				+ " - FUNCIONALIDAD: " + eventOriginClass + " - IP_USUARIO: " + eventUserIp + " - MENSAJE: " + eventMessage + " - SEVERIDAD: " + eventSeverity.intValue() 
				+ " - INDICADOR_EXITO: " + eventSuccess;
	}
}
