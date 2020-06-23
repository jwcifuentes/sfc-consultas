package com.ibm.ams.utils;


public interface ServicioConfigurable {
	//public void cargarConfiguracion(File archivoDeConfig);
	public void cargarConfiguracion(Object objeto);
	public Object getConfigObjectInstance();
}