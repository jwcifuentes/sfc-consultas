package com.ibm.ams.audit.manager;

import static com.ibm.ams.util.AuditConstList.APPLICATIONS_QUERY_PARAM;
import static com.ibm.ams.util.AuditConstList.APPLICATION_CACHE_NAME;
import static com.ibm.ams.util.AuditConstList.CONFIG_FILE_NAME;
import static com.ibm.ams.util.AuditConstList.CONFIG_FOLDER;
import static com.ibm.ams.util.AuditConstList.CONFIG_URL_BASE;
import static com.ibm.ams.util.AuditConstList.DATA_SOURCE_PARAMETER;
import static com.ibm.ams.util.AuditConstList.DB_PARAMETER_GROUP;
import static com.ibm.ams.util.AuditConstList.EVENT_TYPES_QUERY_PARAM;
import static com.ibm.ams.util.AuditConstList.EVENT_TYPE_CACHE_NAME;
import static com.ibm.ams.util.AuditConstList.EX_MESSAGE_FILE_NOT_FOUND;
import static com.ibm.ams.util.AuditConstList.EX_MESSAGE_FILE_READ_ERROR;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.jci.monitor.FilesystemAlterationListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;
import org.apache.commons.jci.monitor.FilesystemAlterationObserver;

import com.ibm.ams.audit.dto.Application;
import com.ibm.ams.audit.dto.EventDto;
import com.ibm.ams.audit.exception.AuditException;
import com.ibm.ams.audit.xml.AuditConfig;
import com.ibm.ams.audit.xml.Parameter;
import com.ibm.ams.audit.xml.ParameterGroup;
import com.ibm.ams.util.AuditConstList;
import com.ibm.ams.utils.XmlToDto;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * Manager para el manejo de la informacion configurable en archivo y en base de datos para el
 * modulo de auditoria
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
public class AuditConfigurationManager implements FilesystemAlterationListener{
	
	private CacheManager cacheManager = null;
	private FilesystemAlterationMonitor fileAlterMonitorObj = new FilesystemAlterationMonitor();
	private String fileURL = System.getProperty(CONFIG_URL_BASE) + CONFIG_FOLDER + File.separatorChar + CONFIG_FILE_NAME;
	private File auditConfFile = new File(fileURL);
	
	/**
	 * Constructor por defecto
	 * 
	 * @throws AuditException
	 *             por si ocurre algun problema al constuir el objeto
	 */
	public AuditConfigurationManager() throws AuditException {
		cacheManager = CacheManager.getInstance();
	}
	
	/**
	 * Metodo que inicia el monitoreo de cambios sobre el archivo de
	 * configuracion
	 */
    public void startMonitor() {
    	try{
    		AuditConfigurationManager mon = new AuditConfigurationManager();
        	fileAlterMonitorObj.addListener(auditConfFile, mon);
        	
        	getAuditConfiguration();
        	
        	fileAlterMonitorObj.setInterval(5*60000);
            fileAlterMonitorObj.start();
    	} catch(AuditException e) {
    		// TODO manejar excepcion
    		e.printStackTrace();
    	}
    }

	/**
	 * Metodo que obtiene el DTO correspondiente al archivo de configuracion de
	 * la aplicacion
	 * 
	 * @return DTO con la informacion de configuracion
	 * @throws AuditException
	 *             si ocurre algun problema al obtener la informacion de
	 *             configuracion
	 */
	public AuditConfig getAuditConfiguration() throws AuditException {
		try {
			if (auditConfFile != null && auditConfFile.exists()) {
				XmlToDto<AuditConfig> parser = new XmlToDto<AuditConfig>();
				AuditConfig config = new AuditConfig();
				config = parser.getDto(config, auditConfFile);
				return config;
			} else {
				throw new AuditException(EX_MESSAGE_FILE_NOT_FOUND);
			}
		} catch (Throwable e) {
			throw new AuditException(EX_MESSAGE_FILE_READ_ERROR, e);
		}
	}
	
	/**
	 * Metodo que obtiene un grupo de parametros configurados
	 * 
	 * @param id
	 *            Identificador del grupo de parametros
	 * @return grupo de parametros correspondiente al identificador ingresado
	 * @throws AuditException
	 *             si ocurre algun problema al realizar la consulta
	 */
	public ParameterGroup getParameterGroupById(String id) throws AuditException {
		for(ParameterGroup tmp : getAuditConfiguration().getParameterGroup()) {
			if(id.equals(tmp.getId())) {
				return tmp;
			}
		}
		return null;
	}
	
	/**
	 * Metodo que obtiene el parametro correspondiente al identeficador y grupo
	 * de parametros indicado
	 * 
	 * @param groupId
	 *            Identificador del grupo de parametros
	 * @param parameterId
	 *            Identificador del parametro
	 * @return Valores del parametro correspondiente a los identificadores
	 *         ingresados
	 * @throws AuditException
	 *             si ocurre algun problema al realizar la consulta
	 */
	public Parameter getParameter(String groupId, String parameterId) throws AuditException {
		ParameterGroup group = getParameterGroupById(groupId);
		if(null != group) {
			for(Parameter tmp: group.getParameter()) {
				if(parameterId.equals(tmp.getName())) {
					return tmp;
				}
			}
		}
		return null;
	}

	/**
	 * Metodo que obtiene la lista de tipos de eventos configurados en la base
	 * de datos
	 * 
	 * @return Lista de tipos de eventos configurados
	 * @throws AuditException
	 *             si ocurre algun problema al realizar la consulta
	 */
	@SuppressWarnings("unchecked")
	public List<EventDto> getListEventType() throws AuditException {
		Object cacheObject = cacheManager.getCacheData(EVENT_TYPE_CACHE_NAME);
		List<EventDto> eventTypes = new ArrayList<EventDto>();
		
		if (cacheObject == null) {
			Parameter dataSourceParameter = this.getParameter(DB_PARAMETER_GROUP, DATA_SOURCE_PARAMETER);
			Parameter eventTypeQueryParam = this.getParameter(DB_PARAMETER_GROUP, EVENT_TYPES_QUERY_PARAM);
			AuditDBManager dbManager = new AuditDBManager(dataSourceParameter.getValue());
			
			eventTypes = dbManager.getEventTypes(eventTypeQueryParam.getValue());
			
			if (eventTypes != null && !eventTypes.isEmpty()) {
				cacheManager.putCacheData(EVENT_TYPE_CACHE_NAME, eventTypes);
			}
		} else {
			eventTypes = (List<EventDto>)cacheObject;
		}
		
		return eventTypes;
	}
	
	@SuppressWarnings("unchecked")
	public List<Application> getApplications() throws AuditException {
		Object cacheObject = cacheManager.getCacheData(APPLICATION_CACHE_NAME);
		List<Application> applications = new ArrayList<Application>();
		
		if (cacheObject == null) {
			Parameter dataSourceParameter = this.getParameter(DB_PARAMETER_GROUP, DATA_SOURCE_PARAMETER);
			Parameter applicationsQueryParam = this.getParameter(DB_PARAMETER_GROUP, APPLICATIONS_QUERY_PARAM);
			AuditDBManager dbManager = new AuditDBManager(dataSourceParameter.getValue());
			
			applications = dbManager.getAplications(applicationsQueryParam.getValue());
			
			if (applications != null && !applications.isEmpty()) {
				cacheManager.putCacheData(APPLICATION_CACHE_NAME, applications);
			}
		} else {
			applications = (List<Application>)cacheObject;
		}
		
		return applications;
	}
	
	/**
	 * @see FilesystemAlterationListener#onFileChange(File)
	 */
	@Override
	public void onFileChange(File arg0) {
		try {
			if(auditConfFile != null && auditConfFile.exists()) {
				XmlToDto<AuditConfig> parser = new XmlToDto<AuditConfig>();
				AuditConfig config = new AuditConfig();
				config = parser.getDto(config, auditConfFile);
				cacheManager.putCacheData(AuditConstList.AUDIT_CACHE_NAME, config);
			} else {
				throw new AuditException(AuditConstList.EX_MESSAGE_FILE_NOT_FOUND);
			}
		}catch(Exception e){
			//TODO: Manejar excepcion
			e.printStackTrace();
		}
	}
	
	/**
	 * @see FilesystemAlterationListener#onFileCreate(File)
	 */
	@Override
	public void onFileCreate(File arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onFileDelete(File)
	 */
	@Override
	public void onFileDelete(File arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onDirectoryChange(File)
	 */
	@Override
	public void onDirectoryChange(File arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onDirectoryCreate(File)
	 */
	@Override
	public void onDirectoryCreate(File arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onDirectoryDelete(File)
	 */
	@Override
	public void onDirectoryDelete(File arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onStart(FilesystemAlterationObserver)
	 */
	@Override
	public void onStart(FilesystemAlterationObserver arg0) {
		
	}
	
	/**
	 * @see FilesystemAlterationListener#onStop(FilesystemAlterationObserver)
	 */
	@Override
	public void onStop(FilesystemAlterationObserver arg0) {
		
	}

}
