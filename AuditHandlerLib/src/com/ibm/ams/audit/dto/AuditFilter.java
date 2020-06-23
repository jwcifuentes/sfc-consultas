package com.ibm.ams.audit.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * DTO que encapsula la informacion de consulta de eventos de auditoria
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
public class AuditFilter implements Serializable {

	private static final long serialVersionUID = 8080834396893026422L;
	
	private Date initDate = null;
	private Date endDate = null;
	private String user = null;
	private Integer application = null;
	private Integer eventCode = null;
	private Integer eventSeverity = null;
	private String eventSuccess = null;
	
	private List<EventDto> eventTypes = null;
	private List<Application> applications = null;

	public Date getInitDate() {
		return initDate;
	}

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public Integer getApplication() {
		return application;
	}

	public void setApplication(Integer application) {
		this.application = application;
	}

	public Integer getEventCode() {
		return eventCode;
	}

	public void setEventCode(Integer eventCode) {
		this.eventCode = eventCode;
	}

	public Integer getEventSeverity() {
		return eventSeverity;
	}

	public void setEventSeverity(Integer eventSeverity) {
		this.eventSeverity = eventSeverity;
	}

	public String getEventSuccess() {
		return eventSuccess;
	}

	public void setEventSuccess(String eventSuccess) {
		this.eventSuccess = eventSuccess;
	}
	
	public List<EventDto> getEventTypes() {
		return eventTypes;
	}

	public void setEventTypes(List<EventDto> eventTypes) {
		this.eventTypes = eventTypes;
	}

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public HashMap<String, Object> getParamsQuery(){
		HashMap<String,Object> parameterMap = new HashMap<String, Object>();

		if(user != null && !user.isEmpty()) {
			parameterMap.put("usuario", user);
		}
		if(application != null && application != -1) {
			parameterMap.put("aplicacion", application);
		}
		if(eventCode != null && eventCode != -1) {
			parameterMap.put("tipo_evento", eventCode);
		}
		if(eventSeverity != null && eventSeverity != -1) {
			parameterMap.put("severidad", eventSeverity);
		}
		if(eventSuccess != null && !eventSuccess.isEmpty()) {
			parameterMap.put("indicador_exito", eventSuccess);
		}
		return parameterMap;
	}
}
