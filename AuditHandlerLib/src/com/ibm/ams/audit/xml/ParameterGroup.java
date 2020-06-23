package com.ibm.ams.audit.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

public class ParameterGroup {
	private String id;
	private List<Parameter> parameter;

	@XmlAttribute(name="id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name="parameter")
	public List<Parameter> getParameter() {
		return parameter;
	}

	public void setParameter(List<Parameter> parameter) {
		this.parameter = parameter;
	}

	public ParameterGroup() {
		// TODO Auto-generated constructor stub
	}

}
