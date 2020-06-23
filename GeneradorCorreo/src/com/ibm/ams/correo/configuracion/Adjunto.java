package com.ibm.ams.correo.configuracion;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase DTO en la que se se almacena la informacion referente a archivos adjuntos.
*   <p> 
*   
* 	<p><b>Notas: </b>
*   <p> 
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 12/dic/2014
*   
*   @version 1.0, 12/dic/2014
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/
public class Adjunto {
	/**
	 * Nombre del archivo adjunto
	 */
	private String nombre;
	/**
	 * Tipo de contenido del archivo adjunto
	 */
	private String mimeType;
	/**
	 * Identificador de contenido del archivo adjutno
	 */
	private String contentId;
	/**
	 * Arreglo de bytes con la informacion del adjunto
	 */
	private byte[] data;
	/**
	 * Variable que indica si el archivo adjunto va inline en el correo o no
	 */
	private boolean inline;
	
	/**
	 * @return el nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre el nombre a establecer
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return el mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}
	/**
	 * @param mimeType el mimeType a establecer
	 */
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	/**
	 * @return el contentId
	 */
	public String getContentId() {
		return contentId;
	}
	/**
	 * @param contentId el contentId a establecer
	 */
	public void setContentId(String contentId) {
		this.contentId = contentId;
	}
	/**
	 * @return el data
	 */
	public byte[] getData() {
		return data;
	}
	/**
	 * @param data el data a establecer
	 */
	public void setData(byte[] data) {
		this.data = data;
	}
	/**
	 * @return el inline
	 */
	public boolean isInline() {
		return inline;
	}
	/**
	 * @param inline el inline a establecer
	 */
	public void setInline(boolean inline) {
		this.inline = inline;
	}
}
