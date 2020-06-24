package com.ibm.ams.calendario;

import java.util.Calendar;
import java.util.Date;

import com.ibm.ams.excepcion.XmlToDtoException;

public class CalculadoraCalendarioTest {

	public static void main(String... args){
		try {
			testFestivosAnio2013();	
			testEsDiaFestivo();
			testSiguienteDiaHabil();
			testAnteriorDiaHabil();
		} catch (XmlToDtoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static void testFestivosAnio2013()throws XmlToDtoException{
		CalculadoraFestivosColombia.getDiasFestivos(2013);
	}
	
	public static void testEsDiaFestivo()throws XmlToDtoException{
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.DAY_OF_MONTH, 21);
		calendario.set(Calendar.MONTH, 6);
		System.out.println("Es Festivo "+CalculadoraFestivosColombia.isDiaFestivo(calendario.getTime()));
	}
	
	public static void testSiguienteDiaHabil()throws XmlToDtoException{
		Date sig = CalculadoraFestivosColombia.getSiguienteDiaHabil(new Date());
		System.out.println("Siguiente Habil "+sig);
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, 7);
		calendario.set(Calendar.DAY_OF_MONTH,6);
		sig = CalculadoraFestivosColombia.getSiguienteDiaHabil(calendario.getTime());
		System.out.println("Siguiente Habil "+sig);
	}
	
	public static void testAnteriorDiaHabil()throws XmlToDtoException{
		Date sig = CalculadoraFestivosColombia.getAnteriorDiaHabil(new Date());
		System.out.println("Anterior Habil "+sig);
		
		Calendar calendario = Calendar.getInstance();
		calendario.set(Calendar.MONTH, 7);
		calendario.set(Calendar.DAY_OF_MONTH,8);
		sig = CalculadoraFestivosColombia.getAnteriorDiaHabil(calendario.getTime());
		System.out.println("Anterior Habil "+sig);
	}
	
}
