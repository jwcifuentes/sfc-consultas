package com.ibm.ams.audit.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="AuditConfig")
public class AuditConfig {
	
	private List<ParameterGroup> parameterGroup;
	
	@XmlElement(name = "ParameterGroup")
	public List<ParameterGroup> getParameterGroup() {
		return parameterGroup;
	}

	public void setParameterGroup(List<ParameterGroup> parameterGroup) {
		this.parameterGroup = parameterGroup;
	}

}
