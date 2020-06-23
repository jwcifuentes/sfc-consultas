package com.ibm.ams.audit.dto;

public enum EventTypeEnum {

	CONSULTA(0),
	PAGO(1),
	REPORTE(2),
	AUTENTICACION(3),
	DETALLE(4),
	AJUSTE(5),
	CREAR(6),
	MODIFICAR(7),
	ERROR(8),
	AUTORIZACION_RECHAZO(9),
	ACEPTACION_TERMINOS(10),
	RECHAZO_TERMINOS(11),
	ANULACION(12);
	
	
	private final int value;
	
	EventTypeEnum(int value){
		this.value = value;
	}
	
	public int value() {
        return value;
    }
	
	public static EventTypeEnum fromValue(int v) {
		for (EventTypeEnum s : EventTypeEnum.values()) {
			if (s.value == v) {
				return s;
			}
		}
		throw new IllegalArgumentException(String.valueOf(v));
	}
}
