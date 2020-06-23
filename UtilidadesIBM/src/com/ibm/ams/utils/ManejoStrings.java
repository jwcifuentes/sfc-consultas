package com.ibm.ams.utils;

import com.ibm.ams.constantes.Constantes;
import com.ibm.ams.excepcion.ExcepcionCaracteres;

public class ManejoStrings {

	/**
	 * Metodo que enmascara strings segun los parametros que se le envien, se
	 * enmascaran el numero de caracteres deseados y se enmascara hacia la
	 * izquierda o hacia la derecha.
	 * 
	 * @param cadena
	 * @param posicion
	 * @param numeroCaracteresVisibles
	 * @return String
	 * @throws ExcepcionCaracteres
	 */
	public static String enmascarar(String cadena, String posicion,
			int numeroCaracteresVisibles){
		String respuesta = "";
		if (cadena.length() > numeroCaracteresVisibles) {			
			if (posicion.equals(Constantes.IZQUIERDA)) {
				String enmascarado = cadena.substring(0,
						cadena.length() - numeroCaracteresVisibles).replaceAll(
						"[a-zA-Z0-9]", "*");
				respuesta = enmascarado
						+ cadena.substring(cadena.length()
								- numeroCaracteresVisibles, cadena.length());
			} else if (posicion.equals(Constantes.DERECHA)) {
				String enmascarado = cadena.substring
						(numeroCaracteresVisibles,
						cadena.length()).replaceAll("[a-zA-Z0-9]", "*");
				respuesta = cadena.substring(0,
						numeroCaracteresVisibles)
						+ enmascarado;
			}
		} else {
			respuesta = cadena.replaceAll("[a-zA-Z0-9]", "*");
		}
		return respuesta;
	}	
}
