package com.ibm.rbm.generador.entidades;

import java.io.Serializable;

/**
 * @author dprojas - IBM Colombia
 * @version Proyecto GeneradorZIP-v1.0_Agosto, 2013
 *
 */
public class ContentZIP implements Serializable{

	private static final long serialVersionUID = 5044627920680892241L;

	
	/**
	 * Atributo que representa el nombre con el que se genera el archivo contenido en el zip.
	 */
	private String nombre;
	
	/**
	 * Atributo que representa el contenido del archivo que va ser comprimido.
	 */
	private byte[] archivo;


	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public byte[] getArchivo() {
		return archivo;
	}
	public void setArchivo(byte[] archivo) {
		this.archivo = archivo;
	}
}
