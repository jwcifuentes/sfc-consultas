package com.ibm.ams.log.bo;

import javax.xml.bind.annotation.XmlAttribute;

public class RootNivel {
	private String level;

	public String getLevel() {
		return level;
	}
	@XmlAttribute
	public void setLevel(String level) {
		this.level = level;
	}
	

}
