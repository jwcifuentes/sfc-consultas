package com.ibm.ams.log.bo;

import javax.xml.bind.annotation.XmlAttribute;

public class Nivel {
	private String name;
	private String level;
	
	public String getName() {
		return name;
	}
	@XmlAttribute
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	@XmlAttribute
	public void setLevel(String level) {
		this.level = level;
	}

}
