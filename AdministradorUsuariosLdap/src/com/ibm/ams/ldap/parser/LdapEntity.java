package com.ibm.ams.ldap.parser;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value = RetentionPolicy.RUNTIME)
public @interface LdapEntity {
	String[] objectType();
}
