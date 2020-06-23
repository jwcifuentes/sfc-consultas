package com.ibm.ams.utils;
import java.io.File;

import org.apache.commons.jci.monitor.FilesystemAlterationListener;
import org.apache.commons.jci.monitor.FilesystemAlterationMonitor;
import org.apache.commons.jci.monitor.FilesystemAlterationObserver;

public class MonitorConfiguracion implements FilesystemAlterationListener {
	  	private static FilesystemAlterationMonitor fileAlterMonitorObj = new FilesystemAlterationMonitor();
	    private ServicioConfigurable servicio;

	    private MonitorConfiguracion() {
	    }
	    public static void iniciarMonitoreo(ServicioConfigurable servicio, File file) {
	    	MonitorConfiguracion mon = new MonitorConfiguracion();
	    	mon.servicio = servicio;
	    	mon.cargarConfiguracion(file);
	    	fileAlterMonitorObj.addListener(file, mon);
	    	// Intervalo puesto en ms
	    	fileAlterMonitorObj.setInterval(5*60000);
	        fileAlterMonitorObj.start();    
	    }

	    @Override
	    public void onStart(FilesystemAlterationObserver fao) {

	    }

	    @Override
	    public void onFileCreate(File file) {
	    }

	    /**
	     * Metodo utilizado para saber cuando el modificado el archivo de configuraciones.
	     * @param file
	     */
	    @Override
	    public void onFileChange(File file) {
	        cargarConfiguracion(file);
	    }

	    @Override
	    public void onFileDelete(File file) {
	    }

	    @Override
	    public void onDirectoryCreate(File file) {
	    }

	    @Override
	    public void onDirectoryChange(File file) {
	    }

	    @Override
	    public void onDirectoryDelete(File file) {
	    }

	    @Override
	    public void onStop(FilesystemAlterationObserver fao) {
	    }
	    
	    @SuppressWarnings("unchecked")
		private void cargarConfiguracion(File file){
	        try {
	    		Object config = servicio.getConfigObjectInstance();
	            @SuppressWarnings("rawtypes")
				XmlToDto cargadorConf = new XmlToDto();
	    		config = cargadorConf.getDto(config, file);
	            servicio.cargarConfiguracion(config);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}
