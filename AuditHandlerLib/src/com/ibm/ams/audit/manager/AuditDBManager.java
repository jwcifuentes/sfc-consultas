package com.ibm.ams.audit.manager;

import static com.ibm.ams.util.AuditConstList.DEFAULT_QUERY_TIMEOUT;
import static com.ibm.ams.util.AuditConstList.FIND_QUERY_TIMEOUT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import javax.naming.NamingException;

import com.ibm.ams.audit.dto.Application;
import com.ibm.ams.audit.dto.AuditDto;
import com.ibm.ams.audit.dto.AuditFilter;
import com.ibm.ams.audit.dto.EventDto;
import com.ibm.ams.audit.dto.SeverityEnum;
import com.ibm.ams.audit.exception.AuditException;
import com.ibm.ams.db.ManejadorDeDatosDB;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * Manejador para el acceso a al base de datos del modulo de auditoria
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
public class AuditDBManager {

	private String dataSource;
	
	public AuditDBManager(String dataSource) {
		this.dataSource = dataSource;
	}
	
	public List<AuditDto> findAuditEvents(AuditFilter filter, String query) throws AuditException {
		String finalQuery = buildQuery(filter, query);
		List<Object> objectList = getQueryParam(filter);
		Connection connection = null;
		List<AuditDto> dtoList = new ArrayList<AuditDto>();
		ResultSet rset = null;
		try {
			connection = ManejadorDeDatosDB.obtenerConexionPorDatasource(dataSource);
			rset = ManejadorDeDatosDB.consultarBD(connection, finalQuery, objectList, FIND_QUERY_TIMEOUT);
			while (rset.next()) {
				AuditDto auditDto = new AuditDto();
				auditDto.setId(rset.getLong("ID_EVENTO_AUDITORIA"));
				auditDto.setEventDate(new Date(rset.getTimestamp("FECHA_EVENTO").getTime()));
				auditDto.setEventMessage(rset.getString("MENSAJE"));
				auditDto.setEventOriginApp(this.fillAplication(rset.getInt("APLICACION"), filter.getApplications()));
				auditDto.setEventOriginClass(rset.getString("FUNCIONALIDAD"));
				auditDto.setEventOriginIp(rset.getString("IP_SERVIDOR"));
				auditDto.setEventSeverity(SeverityEnum.fromValue(rset.getInt("SEVERIDAD")));
				auditDto.setEventSuccess(rset.getString("INDICADOR_EXITO"));
				auditDto.setEventType(this.fillEventType(rset.getInt("TIPO_EVENTO"), filter.getEventTypes()));
				auditDto.setEventUserIp(rset.getString("IP_CLIENTE"));
				auditDto.setUser(rset.getString("USUARIO"));
				dtoList.add(auditDto);
			}

		} catch (Exception e) {
			throw new AuditException("Error al consultar la base de datos: ", e);
		} finally {
			this.cerrarRecursos(rset, null, connection);
		}
		return dtoList;
		
	}
	
	public void saveAuditEvent(AuditDto auditEvent, String query) throws AuditException {
		Connection connection = null;
		try {
			connection = ManejadorDeDatosDB.obtenerConexionPorDatasource(dataSource);
			ManejadorDeDatosDB.actualizarDB(connection, query, auditEvent.getObjectList(), DEFAULT_QUERY_TIMEOUT);
		} catch (Exception e) {
			throw new AuditException("Error al insertar en la base de datos: " + auditEvent.toString(), e);
		} finally {
			this.cerrarRecursos(null, null, connection);
		}
		
	}
	
	public List<EventDto> getEventTypes(String query) throws AuditException {
		ResultSet result = null;
		Connection connection = null;
		List<EventDto> eventTypes = new ArrayList<EventDto>();
		
		try {
			connection = ManejadorDeDatosDB.obtenerConexionPorDatasource(dataSource);
			result = ManejadorDeDatosDB.consultarBD(connection, query, DEFAULT_QUERY_TIMEOUT);
			
			while (result.next()) {
				EventDto eventDto = new EventDto();
				eventDto.setId(result.getInt("id_tipo_evento"));
				eventDto.setName(result.getString("nombre"));
				eventDto.setDescription(result.getString("descripcion"));
				
				eventTypes.add(eventDto);
			}
			
		} catch (SQLException e) {
			throw new AuditException("Error al consultar la base de datos: ", e);
		} catch (NamingException e) {
			throw new AuditException("Error al consultar la base de datos: ", e);
		} finally {
			this.cerrarRecursos(result, null, connection);
		}
		
		return eventTypes;
	}
	
	public List<Application> getAplications(String query) throws AuditException {
		ResultSet result = null;
		Connection connection = null;
		List<Application> applications = new ArrayList<Application>();
		
		try {
			connection = ManejadorDeDatosDB.obtenerConexionPorDatasource(dataSource);
			result = ManejadorDeDatosDB.consultarBD(connection, query, DEFAULT_QUERY_TIMEOUT);
			
			while (result.next()) {
				Application application = new Application();
				application.setId(result.getInt("id_aplicacion"));
				application.setName(result.getString("nombre"));
				application.setDescription(result.getString("descripcion"));
				
				applications.add(application);
			}
		} catch(SQLException e) {
			throw new AuditException("Error al consultar la base de datos: ", e);
		} catch (NamingException e) {
			throw new AuditException("Error al consultar la base de datos: ", e);
		} finally {
			this.cerrarRecursos(result, null, connection);
		}
		
		return applications;
	}

	private String buildQuery(AuditFilter filter, String query){
		Set<String> set;
		HashMap<String, Object> map = filter.getParamsQuery();
		set = map.keySet();

		for(String tmpParameter: set){
			query += (" AND " + tmpParameter + "= ?"); 
		}
		
		query += (" ORDER BY fecha_evento");
		return query;
	}
	
	private List<Object> getQueryParam(AuditFilter filter){
		List<Object>  objectList = new ArrayList<Object>();
		Set<String> set;
		HashMap<String, Object> map = filter.getParamsQuery();
		set = map.keySet();
		objectList.add(new Timestamp(filter.getInitDate().getTime()));
		objectList.add(new Timestamp(filter.getEndDate().getTime()));
		
		for(String tmpParameter: set){
			objectList.add(map.get(tmpParameter));
		}
		return objectList;
	}
	
	private EventDto fillEventType(Integer id, List<EventDto> eventTypes) {
		for (EventDto eventDto : eventTypes) {
			if (id == eventDto.getId()) {
				return eventDto;
			}
		}
		
		return null;
	}
	
	private Application fillAplication(Integer id, List<Application> applications) {
		for (Application application : applications) {
			if (id == application.getId()) {
				return application;
			}
		}
		
		return null;
	}
	
	private void cerrarRecursos(ResultSet result, PreparedStatement statement, Connection connection) throws AuditException {
		try {
			if (result != null) {
				result.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch(SQLException e) {
			throw new AuditException("Error cerrando recursos de la BD: ", e);
		}
	}
}
