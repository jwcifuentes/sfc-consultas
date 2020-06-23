package com.ibm.ams.db;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "configuracionDB")
@XmlType(propOrder = {"datasources"})
public class ConfiguracionDB {
	private List<ConfiguracionDriverDB> datasources;

	@XmlElementWrapper(name = "datasources")	
	@XmlElement(name = "datasource")	
	public List<ConfiguracionDriverDB> getDatasources() {
		return datasources;
	}

	public void setDatasources(List<ConfiguracionDriverDB> datasources) {
		this.datasources = datasources;
	}
}
