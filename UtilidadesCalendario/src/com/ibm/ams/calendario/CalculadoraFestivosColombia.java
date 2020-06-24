package com.ibm.ams.calendario;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.DateUtils;

import com.ibm.ams.calendario.pojos.FestivosColombia;
import com.ibm.ams.excepcion.XmlToDtoException;
import com.ibm.ams.log.Logger;
import com.ibm.ams.utils.XmlToDto;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase encargada mediante la configuracion cargada por XML, calcular todos los dias festivos
*   <p>correspondientes a un ano
*   
* 	<p><b>Notas: </b>
*   <p> Requiere la libreria ApacheCommonsUtils
*   
* 	<p><b>Proyecto base: </b> Compensacion
*   
*   @author <oballest@co.ibm.com> Oscar Ballesteros</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 01/sep/2013
*   
*   @version 1.0, 01/oct/2013
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/

public class CalculadoraFestivosColombia {

	/** Instancia del Logger. */
	private static Logger logger = null;
	
	/** Constante de variable de entorno */
	private static final String RUTA_BASE = "SWF_PORTAL_CONFIGPATH";
	
	
	private static final String DIRECTORIO_CONFIG = "compensaciones";
	
	/** Ruta de archivo de configuracion */
	private static final String RUTA_ARCHIVO = System.getProperty(RUTA_BASE) + DIRECTORIO_CONFIG + File.separatorChar + "festivos.xml";
	
	/**
	 * Clase en la que se guarda la configuracion de festivos para cualquier ano
	 */
	private static FestivosColombia festivosColombia = new FestivosColombia();
	/**
	 * Mapa con el cache de dias festivos para un ano
	 */
	private static Map<Integer,List<Date>> cacheFestivos = new HashMap<Integer,List<Date>>();
	
	/**
	 * Inicializador estatico de la clase, carga el archivo de configuracion de festivos 
	 * y carga la configuracion de los festivos en la clase FestivosColombia
	 */
	static{
		logger = Logger.getInstance("compensacion", "compensaciones");
		XmlToDto<FestivosColombia> parser = new XmlToDto<FestivosColombia>();
		
		File archivo = new File(RUTA_ARCHIVO);
		
		try {
			festivosColombia =  parser.getDto(festivosColombia, archivo);
		} catch (XmlToDtoException e) {
			logger.error(CalculadoraFestivosColombia.class.getName(), "static", "Error Cargando Configurion XML", e);
		}
	}
	
	/**
	 * Constructor por defecto de la clse
	 */
	public CalculadoraFestivosColombia() {
		
	}
	
	/**
	 * Metodo encargado de consultar todos los dias festivos para un ano en particular, como 
	 * primer paso consulta en el mapa de cache si ya se hizo el calculo de festivos para el ano solicitado y si no
	 * se encuentra la informacion en cache procede a calcular las fechas para festivos.
	 * @param anio Ano sobre el cual se consultan todos los festivos
	 * @return Listado de fechas festivas para el ano de interes
	 * @throws XmlToDtoException excepcion al cargar el archivo de configuracion.
	 */
	public static List<Date> getDiasFestivos(int anio)throws XmlToDtoException{
		
		List<Date> festivos = cacheFestivos.get(anio);
		if(festivos != null ){
			return festivos;
		}
		
		Date pascua = calcularPascua(anio);
		List<Date> festivosFijos = calcularFestivosFijos(anio,festivosColombia.getFestivosFijos());
		List<Date> festivosLunes = calcularFestivosLunes(anio,festivosColombia.getFestivosLunes());
		List<Date> festivosPascua = calcularFestivosRelativos(pascua, festivosColombia.getFestivosRelativos());
		
		List<Date> todosFestivos = new ArrayList<Date>(festivosFijos);
		todosFestivos.addAll(festivosLunes);
		todosFestivos.addAll(festivosPascua);
		
		cacheFestivos.put(anio, todosFestivos);
		
		return todosFestivos;
	}
	
	/**
	 * Metodo encargado de determinar si un dia en particular es festivo, se basa en el calculo previo
	 * de los festivos para el ano que se consulta, si no se encuentra esta configuracion solicita al metodo
	 * de calculo de festivos de un ano
	 * @param dia Fecha para la que se consulta si un dia es festivo.
	 * @return true : si el dia es festivo, false: si el dia no es festivo
	 * @throws XmlToDtoException excepcion al cargar el archivo de configuracion.
	 */
	public static boolean isDiaFestivo(Date dia)throws XmlToDtoException{
		if(dia == null){
			return false;
		}
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dia);
		
		if(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
		   && festivosColombia.isSabadoFestivo()){
			return true;
		}
		if(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY
		   && festivosColombia.isDomingoFestivo()){
			return true;
		}
			
		int anio = calendario.get(Calendar.YEAR);
		
		List<Date> festivosDate = getDiasFestivos(anio);
		
		dia = DateUtils.truncate(dia, Calendar.DAY_OF_MONTH);
		
		boolean festivo = festivosDate.contains(dia);
		
		logger.debug(CalculadoraFestivosColombia.class.getName(), "isDiaFestivo", dia+" es dia festivo "+festivo);
	
		return festivo;
	}
	
	
	/**
	 * Metodo encargado de encontrar el siguiente dia habil para un fecha dada
	 * @param dia Dia para el cual se pregunta cuando es el siguiente dia habil.
	 * @return Feecha del siguiente dia habil al consultado.
	 * @throws XmlToDtoException excepcion al cargar el archivo de configuracion.
	 */
	public static Date getSiguienteDiaHabil(Date dia)throws XmlToDtoException{	
		return getDiaHabilCorrimiento(dia, true);
	}
	
	/**
	 * Metodo encargado de encontrar el anterior dia habil para un fecha dada
	 * @param dia Dia para el cual se pregunta cuando es el siguiente dia habil.
	 * @return Feecha del siguiente dia habil al consultado.
	 * @throws XmlToDtoException excepcion al cargar el archivo de configuracion.
	 */
	public static Date getAnteriorDiaHabil(Date dia)throws XmlToDtoException{
		if(!isDiaFestivo(dia)){
			return dia;
		}
		return getDiaHabilCorrimiento(dia, false);
	}
	
	
	/** 
	 * Metodo privado encargado de encontrar el siguiente o anterior dia habil a una fecha dada, utiliza recursion
	 * para moverse de uno en uno despues de la fecha dada para encontrar el dia habil siguiente.
	 * @param dia Dia para el que se quiere encontrar el siguiente o anterior dia habil.
	 * @param adelante si es true busca hacia adelante en las fechas y false busca hacia atras.
	 * @return Fecha del siguiente o anterior dia habil.
	 * @throws XmlToDtoException
	 */
	private static Date getDiaHabilCorrimiento(Date dia,boolean adelante)throws XmlToDtoException{
		if(dia == null){
			return null;
		}
		int suma = 0;
		if(adelante){
			suma = 1;
		}else{
			suma = -1;
		}
		Date diaSiguiente = DateUtils.addDays(dia, suma);
		boolean esFestivo = isDiaFestivo(diaSiguiente);
		if(!esFestivo){
			return diaSiguiente;
		}
		return getDiaHabilCorrimiento(diaSiguiente,adelante);
	}
	
	/**
	 * Metodo privado encargado de calcular las fechas festivas fijas para un ano en particular.
	 * @param anio Ano para el cual se calculan los festivos fijos.
	 * @param festivos Listado con la configuracion de fechas en formato "mm-dia".
	 * @return Listado de fechas de los festivos de un ano en particular.
	 */
	private static List<Date> calcularFestivosFijos(int anio,List<String> festivos){
		List<Date> festivosDate = new ArrayList<Date>();
		Calendar calendario = new GregorianCalendar();
		if(festivos != null && !festivos.isEmpty()){
			for(String dia : festivos){
				String[] mesDia =  dia.split("-");
				calendario.set(Calendar.YEAR, anio);
				calendario.set(Calendar.MONTH,Integer.parseInt(mesDia[0])-1);
				calendario.set(Calendar.DAY_OF_MONTH,Integer.parseInt(mesDia[1]));
				
				calendario = DateUtils.truncate(calendario, Calendar.DAY_OF_MONTH);
				
				festivosDate.add(calendario.getTime());
			}
		}
		return festivosDate;
	}
	
	/**
	 * Metodo privado encargado de calcular todos los festivos que se mueven al siguiente lunes par aun ano
	 * en particular.
	 * @param anio Ano para el cual se quiere calcular los festivos a correr a lunes.
	 * @param festivos Listado de fechas en formato "MM-DD" que se deben correr al siguiente lunes.
	 * @return Listado de festivos en dia lunes para un ano en particular. 
	 */
	private static List<Date> calcularFestivosLunes(int anio,List<String> festivos){
		List<Date> festivosDate = new ArrayList<Date>();
		Calendar calendario = new GregorianCalendar();
		if(festivos == null || festivos.isEmpty()){
			return festivosDate;
		}
		
		for(String dia : festivos){
			String[] mesDia =  dia.split("-");
			calendario.set(Calendar.YEAR, anio);
			calendario.set(Calendar.MONTH,Integer.parseInt(mesDia[0])-1);
			calendario.set(Calendar.DAY_OF_MONTH,Integer.parseInt(mesDia[1]));
	
			calendario = DateUtils.truncate(calendario, Calendar.DAY_OF_MONTH);
			
			if(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
				festivosDate.add(calendario.getTime());
			}else if(calendario.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				calendario.add(Calendar.DAY_OF_MONTH, 1);
				festivosDate.add(calendario.getTime());
			}else{	
				int diaSemana = calendario.get(Calendar.DAY_OF_WEEK);
				
				int diasSumar = 7 -(diaSemana  - 2);
				
				
				calendario.add(Calendar.DAY_OF_MONTH, diasSumar);
				festivosDate.add(calendario.getTime());
			}
			
		}
		
		return festivosDate;
	}
	
	/**
	 * Metodo privado encargado de calcular todos los festivos relativos a pascua para un ano en particular.
	 * @param pascua Fecha de pascua para el ano de calculo.
	 * @param festivos Listado de Numero de dias en que se debe correr desde pascua que son festivos.
	 * @return Listado de las fechas que son festivos relativos a pascua.
	 */
	public static List<Date> calcularFestivosRelativos(Date pascua,List<Integer> festivos){
		List<Date> festivosDate = new ArrayList<Date>();
		Calendar calendario = new GregorianCalendar();
		calendario = DateUtils.truncate(calendario, Calendar.DAY_OF_MONTH);
		if(festivos != null && !festivos.isEmpty()){
			for(Integer dias : festivos){
				calendario.setTime(pascua);
				calendario.add(Calendar.DAY_OF_MONTH, dias);
				festivosDate.add(calendario.getTime());
			}
		}
		return festivosDate;
	}
	
	/**
	 * Metodo privado encargado de calcular el dia de pascual para un ano en particular.
	 * @param anio Ano para el cual se quiere calcular la pascua.
	 * @return Fecha del dia de pascua para el ano solicitado.
	 */
	public static Date calcularPascua(int anio){
		
		int a = anio % 19;
		double b = Math.floor(anio/100);
		int c = anio % 100;
		double d = Math.floor(b / 4);
		double e = b % 4;
		double f = Math.floor((b + 8) / 25);
		double g = Math.floor((b - f + 1) / 3);
		double h = ((19*a) + b - d - g + 15) % 30;
		double i = Math.floor (c / 4);
		double k = c % 4;
		double l = (32 + (2*e) + (2*i) - h - k) % 7;
		double m = Math.floor((a + (11*h) + (22*l)) / 451);
		double month = Math.floor ((h + l - (7*m) + 114) / 31);
		double day = ((h + l - (7*m) + 114) % 31) + 1;
		
		logger.debug(CalculadoraFestivosColombia.class.getName(),"calcularPascua", "Mes Pascua "+month+" dia "+day);
				
		GregorianCalendar calendario = new GregorianCalendar(anio, (int)month-1, (int)day);
		
		return calendario.getTime();
	}
}
