package com.ibm.ams.ldap.parser;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ibm.ams.utils.ConstantesUsuariosLDAP;

public class LdapParser {
	private static HashMap<Class<?>, HashMap<String, Field>> classFieldsByLdapAttr = new HashMap<Class<?>, HashMap<String,Field>>();

	/**
	 * Retorna una lista de string con la representacion del objeto en 
	 * el formato esperado por LDAP
	 * @param obj
	 * @return List<String>
	 * @throws IllegalArgumentException
	 * @throws IllegalAccessException
	 */
	public static List<String> toLdapAttrList(Object obj) throws IllegalArgumentException, IllegalAccessException {
		LdapEntity entity = null;
		ArrayList<String> result = new ArrayList<String>();
		
		if(obj != null){
			entity = obj.getClass().getAnnotation(LdapEntity.class);
		}
		if(entity != null){
			String[] objTypes = entity.objectType();
			for (int i = 0; i < objTypes.length; i++){
				result.add("ObjectClass: "+objTypes[i]);
			}
		}

		if(obj != null){
	    	for (Field field : obj.getClass().getDeclaredFields()) {
	    		LdapAttribute attr = field.getAnnotation(LdapAttribute.class);
	            if (attr == null){
	            	continue;
	            }
	            
	            field.setAccessible(true);
	        	if(field.getType().isArray()){
	        		Object arr = field.get(obj);
	        		if(arr != null){
		        		int arrLength = Array.getLength(arr);
						for (int i = 0; i < arrLength; i++){
							result.add(attr.name()+ConstantesUsuariosLDAP.SPLIT_DOS_PUNTOS+Array.get(arr, i));
						}
	        		}
	        	}else{
	        		result.add(attr.name()+ConstantesUsuariosLDAP.SPLIT_DOS_PUNTOS+field.get(obj));
	        	}			            
			}
		}
    	return result;
	}	
	
	/**
	 * Crea una instancia de la clase especificada y le asigna los datos suministrados
	 * en la lista.
	 * @param clazz
	 * @param data
	 * @return Object
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 */
	public static Object toLdapObject(Class<?> clazz, List<String> data) throws IllegalAccessException, InstantiationException {
		Object obj = clazz.newInstance();
		Map<String, Field> fieldByAttr = getFieldsByLdapAttr(clazz);
    	
		List<String> processedAttrs = new ArrayList<String>();
		if(data != null){
	    	for (String attr : data) {
	    		LdapAttributeValue attrObj = new LdapAttributeValue(attr);
	    		
				Field field = fieldByAttr.get(attrObj.getName());
				if(field == null){
					continue;
				}
	    		if(field.getType() == int.class){
	    			field.set(obj, Integer.parseInt(attrObj.getValue()));
	    		}
	    		else if(field.getType() == long.class){
	    			field.set(obj, Long.parseLong(attrObj.getValue()));
	    		}
	    		else if(field.getType().isArray()){
	    			if(!processedAttrs.contains(attrObj.getName())){
	    				processedAttrs.add(attrObj.getName());
	    				field.set(obj, getAttributeValueList(attrObj.getName(), data));
	    			}
	    		}else{
	    			field.set(obj, attrObj.getValue());
	    		}
			}
		}
    	
    	return obj;
	}
	
	public static Object toLdapObject(Class<?> clazz, String data) throws IllegalAccessException, InstantiationException {
		String[] valores = null;
		List<String> valoresL = new ArrayList<String>();
		
		if(data != null){
			valores = data.toString().split(ConstantesUsuariosLDAP.SPLIT_NUEVA_LINEA);
		}
		if(valores != null){
			for(String valor : valores){
				String[] tokens = valor.split(ConstantesUsuariosLDAP.SPLIT_DOS_PUNTOS);
				if(tokens.length == ConstantesUsuariosLDAP.LONGITUD_TOKEN){
					valoresL.add(valor);
				}
			}
		}
		if(valoresL == null || valoresL.isEmpty()){
			return null;
		}
		valoresL.remove(0);
    	return toLdapObject(clazz, valoresL);
	}

	private static String[] getAttributeValueList(String attrName, List<String> data) {
		ArrayList<String> attrDataList = new ArrayList<String>();
		if(data != null){
			for (String attr1 : data) {
				LdapAttributeValue attrObj1 = new LdapAttributeValue(attr1);
				if(attrObj1.getName().equals(attrName)){
					attrDataList.add(attrObj1.getValue());
				}
			}
		}
		return (String[])attrDataList.toArray(new String[attrDataList.size()]);
	}

	/**
	 * Analiza la clase recibida y crea un mapa que tiene como llave el id de un atributo
	 * en LDAP y como valor un objeto que representa el campo del objeto.
	 * 
	 * @param clazz
	 * @return HashMap<String, Field>
	 */
	private static Map<String, Field> getFieldsByLdapAttr(Class<?> clazz) {
		HashMap<String, Field> fieldByAttr = classFieldsByLdapAttr.get(clazz);
		if(fieldByAttr == null){
			fieldByAttr = new HashMap<String, Field>();
			if(clazz != null){
		    	for (Field field : clazz.getDeclaredFields()) {
		    		field.setAccessible(true);
		    		LdapAttribute attr = field.getAnnotation(LdapAttribute.class);
		            if (attr != null){
		            	fieldByAttr.put(attr.name(), field);
		            }
				}
			}
	    	classFieldsByLdapAttr.put(clazz, fieldByAttr);
		}
		return fieldByAttr;
	}		
} 