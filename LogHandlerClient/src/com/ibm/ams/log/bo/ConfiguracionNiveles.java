package com.ibm.ams.log.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "configuracionLog")
@XmlType(propOrder = {"root",
		"logger"})
public class ConfiguracionNiveles {
	private RootNivel root;
	private List<Nivel> logger;
	public RootNivel getRoot() {
		return root;
	}
	public void setRoot(RootNivel root) {
		this.root = root;
	}
	public List<Nivel> getLogger() {
		return logger;
	}
	public void setLogger(List<Nivel> logger) {
		this.logger = logger;
	}
	
}
	


