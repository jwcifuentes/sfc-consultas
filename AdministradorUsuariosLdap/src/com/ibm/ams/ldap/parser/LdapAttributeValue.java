package com.ibm.ams.ldap.parser;

import com.ibm.ams.utils.ConstantesUsuariosLDAP;

public class LdapAttributeValue {
	
	private String name;
	private String value;
	
	public LdapAttributeValue(String nameAndValue){
		String[] attrParts = nameAndValue.split(ConstantesUsuariosLDAP.SPLIT_DOS_PUNTOS);
		if(attrParts.length != ConstantesUsuariosLDAP.LONGITUD_TOKEN)
			throw new IllegalArgumentException("El atributo [" + nameAndValue + "] no tiene un formato valido");
		
		name = attrParts[0].trim();
		value = attrParts[1].trim();
	}

	public String getName() {
		return name;
	}

	public String getValue() {
		return value;
	}
}
