package com.ibm.ams.audit.dto;

public enum SeverityEnum {
	EMERGENCY(0),
	ALERT(1),
	CRITICAL(2),
	ERROR(3),
	WARNING(5),
	INFORMATIONAL(6),
	DEBUG(7);
	
	private final int intValue;
	
	SeverityEnum(int value){
		this.intValue = value;
	}
	
	public int intValue() {
        return intValue;
    }
	
	public static SeverityEnum fromValue(int v) {
		for (SeverityEnum s : SeverityEnum.values()) {
			if (s.intValue == v) {
				return s;
			}
		}
		throw new IllegalArgumentException(String.valueOf(v));
	}

}
