package com.ibm.ams.calendario.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Pojo el cual mapea la configuracion de dias festivos desde un archivo xml
*   
* 	<p><b>Notas: </b>
*   <p> El cargue de informacion a esta pagina se realiza utilizando el api de jaxb
*   
* 	<p><b>Proyecto base: </b> Compensacion
*   
*   @author <dprojas@co.ibm.com> Oscar Ballesteros</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 01/sep/2013
*   
*   @version 1.0, 01/oct/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*
**/


@XmlRootElement(name="FestivosColombia")
public class FestivosColombia {

	/**
	 * Flag indicando si el dia sabado es tratado como festivo
	 */
	private boolean sabadoFestivo;
	/**
	 * Flag indicando si el dia Domingo es tratado como festivo
	 */
	private boolean domingoFestivo;
	
	/**
	 * Listado en el que se indica que dias feriados son ubicados en la misma fecha
	 */
	private List<String> festivosFijos;
	/**
	 * Listado indicando que dias feriados se corren al siguiente lunes
	 */
	private List<String> festivosLunes;
	/*
	 * Listado indicando que dias feriados son relativos a una fecha
	 */
	private List<Integer> festivosRelativos;
	
	/**
	 * Constructor por defecto de la clase
	 */
	public FestivosColombia() {
		
	}

	/**
	 * 
	 * @return
	 */
	@XmlElement(name="sabadoEsFestivo")
	public boolean isSabadoFestivo() {
		return sabadoFestivo;
	}


	/**
	 * 
	 * @param sabadoFestivo
	 */
	public void setSabadoFestivo(boolean sabadoFestivo) {
		this.sabadoFestivo = sabadoFestivo;
	}

	/**
	 * 
	 * @return
	 */
	@XmlElement(name="domingoEsFestivo")
	public boolean isDomingoFestivo() {
		return domingoFestivo;
	}

	/**
	 * 
	 * @param domingoFestivo
	 */
	public void setDomingoFestivo(boolean domingoFestivo) {
		this.domingoFestivo = domingoFestivo;
	}

	/**
	 * 
	 * @return
	 */
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "DiasFijos")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "fecha")
	public List<String> getFestivosFijos() {
		return festivosFijos;
	}

	
	/**
	 * 
	 * @param festivosFijos
	 */
	public void setFestivosFijos(List<String> festivosFijos) {
		this.festivosFijos = festivosFijos;
	}

	/**
	 * 
	 * @return
	 */
	// XmLElementWrapper generates a wrapper element around XML representation
	@XmlElementWrapper(name = "SiguienteLunes")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "fecha")
	public List<String> getFestivosLunes() {
		return festivosLunes;
	}

	
	/**
	 * 
	 * @param festivosLunes
	 */
	public void setFestivosLunes(List<String> festivosLunes) {
		this.festivosLunes = festivosLunes;
	}

	/**
	 * 
	 * @return
	 */
	@XmlElementWrapper(name = "RelativosPascua")
	// XmlElement sets the name of the entities in collection
	@XmlElement(name = "delta")
	public List<Integer> getFestivosRelativos() {
		return festivosRelativos;
	}

	
	/**
	 * 
	 * @param festivosRelativos
	 */
	public void setFestivosRelativos(List<Integer> festivosRelativos) {
		this.festivosRelativos = festivosRelativos;
	}
	
	/**
	 * 
	 */
	@Override
	public String toString() {
		StringBuilder cadena = new StringBuilder();
		cadena.append("Configuracion Dias Festivo: \n");
		cadena.append(" Es sabado Festivo: "+this.sabadoFestivo+" es Domingo festivo "+this.domingoFestivo+" \n");
		cadena.append(" Festivos Fijos \n");
		if(this.festivosFijos != null && !this.festivosFijos.isEmpty()){
			cadena.append(festivosFijos);
		}
		cadena.append(" \nFestivos Fijos Lunes \n");
		if(this.festivosLunes != null && !this.festivosLunes.isEmpty()){
			cadena.append(festivosLunes);

		}
		cadena.append("\n Festivos Relativos Pascua \n");
		if(this.festivosRelativos != null && !this.festivosRelativos.isEmpty()){	
			cadena.append(festivosRelativos);
		}
		return cadena.toString();
	}

}
