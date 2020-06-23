package com.ibm.ams.utils;

public class ValidadorFormato {

	
	/**
	 * Metodo que valida si el el valor recibido es numerico o no.
	 * @param parametro
	 * @return
	 */
	public static boolean esNumero(String parametro) {
		if(parametro.matches("[0-9]*"))
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que valida si el el valor recibido es numerico y con espacios.
	 * @param parametro
	 * @return
	 */
	public static boolean esNumeroConEspacios(String parametro) {
		if(parametro.matches("[0-9 ]*"))
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que valida si una palabra solo contiene letras.
	 * @param parametro
	 * @return
	 */
	public static boolean esPalabraSinEspacios(String parametro) {
		if(parametro.matches("[a-zA-Z]*"))
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que valida si una palabra es alfanumerica sin espacios.
	 * @param parametro
	 * @return
	 */
	public static boolean esAlfanumericoSinEspacios(String parametro) {
		if(parametro.matches("[A-Za-z0-9]*"))
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que valida si una palabra es alfanumerica con espacios.
	 * @param parametro
	 * @return
	 */
	public static boolean esAlfanumericoConEspacios(String parametro) {
		if(parametro.matches("[A-Za-z0-9 ]*"))
			return true;
		else
			return false;
	}
	
	/**
	 * Metodo que imprime la cantidad de espacios que lleguen por parametro, con su respetivo valor del campo.
	 * @param cantidad
	 * @param valor
	 * @return
	 */
	public static StringBuilder numeroEspacios (int cantidad, String valor){
		int i = 0;
		StringBuilder espacio = new StringBuilder();
		if(cantidad != 0)
			while(i < cantidad){
				espacio.append(valor);
				i++;
			}
		return espacio;
	}
	
	/**
	 * Metodo que convierte de un numero decimal a un numero sin decimales.
	 * @param numero
	 * @return
	 */
	public static String formatoDecimal (String numero){
		if(numero.contains(".")){
			int pos = numero.indexOf(".");
			if(numero.substring(pos).length() == 2){
				numero = numero.replace(".", "");
				numero = numero.concat("0");
			}else{
				numero = numero.replace(".", "");
			}
		}
		else{
			numero = numero.concat("00");
		}
		return numero;
	}
	
}
