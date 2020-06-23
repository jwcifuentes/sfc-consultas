package com.ibm.ams.audit.dto;

import java.io.Serializable;

/**
 * <b>IBM. Global Bussiness Services AMS Colombia .</b>
 * 
 * <p>
 * <b>Descripcion: </b>
 * 
 * <p>
 * DTO que encapsula la informacion de una aplicacion
 * 
 * 
 * <p>
 * <b>Notas: </b>
 * 
 * <p>
 * 
 * <p>
 * <b>Proyecto base: </b> AuditWeb
 * 
 * @author dmejiaro@co.ibm.com IBM - Daniel Mejia Rojas
 *         <p>
 *         <b>Fecha de creacion(14/Oct/2015): </b>
 * 
 * @version [1.0, 14/Oct/2015]
 * <p>
 * <b>ChangeLog: </b>
 * 
 * <p>
 * Version: 1.0
 * <p>
 * - Implementacion inicial de la logica requerida por el caso de uso
 * 
 **/
public class Application implements Serializable {

	private static final long serialVersionUID = 9003039912982086345L;

	private Integer id;
	private String name;
	private String description;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
