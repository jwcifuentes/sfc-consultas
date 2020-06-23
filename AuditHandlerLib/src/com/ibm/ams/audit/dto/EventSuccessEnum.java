package com.ibm.ams.audit.dto;

public enum EventSuccessEnum {

	SUCCESS(0),
	FAILED(1);
	
	private final int value;
	
	EventSuccessEnum(int value){
		this.value = value;
	}
	
	public int value() {
        return value;
    }
	
	public static EventSuccessEnum fromValue(int v) {
		for (EventSuccessEnum s : EventSuccessEnum.values()) {
			if (s.value == v) {
				return s;
			}
		}
		throw new IllegalArgumentException(String.valueOf(v));
	}

	
	
	
}
