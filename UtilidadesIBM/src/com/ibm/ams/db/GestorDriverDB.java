package com.ibm.ams.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import com.ibm.ams.constantes.Constantes;
import com.ibm.ams.utils.XmlToDto;

public class GestorDriverDB {
	private	Map<String, ConfiguracionDriverDB> config = new HashMap<String, ConfiguracionDriverDB>();
	private static GestorDriverDB instance;
	
	private GestorDriverDB(){
		try {
			ConfiguracionDB configDB = new ConfiguracionDB();
			XmlToDto<ConfiguracionDB> cargadorConf = new XmlToDto<ConfiguracionDB>();
			configDB = cargadorConf.getDto(configDB, new File(Constantes.DB_CONFIG));
			
			for (ConfiguracionDriverDB configDriver : configDB.getDatasources()){
				config.put(configDriver.getNombre(), configDriver);
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error obteniendo conexion por driver", e);
		}	
	}
	
	public static GestorDriverDB getInstance(){
		if(instance == null){
			instance = new GestorDriverDB();
		}
		
		return instance;
	}
	
	public Connection getConexion(String datasource){
		ConfiguracionDriverDB configDriver = config.get(datasource);
		if(configDriver == null){
			throw new IllegalArgumentException("No se encontro configuracion para el datasource: " + datasource);
		}
		
		try{
			Class.forName(configDriver.getDriverClass());
			return DriverManager.getConnection(configDriver.getUrl(), configDriver.getUsuario(), configDriver.getClave());
		}catch(Throwable e){
			throw new RuntimeException("Error generando la conexion a la base de datos por driver: " + configDriver, e);
		}

	}	
}
