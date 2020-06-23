package com.ibm.ams.utils;

import java.security.MessageDigest;

public class Encriptador {
	
	   public static void main(String[] args)throws Exception
	    {
		   
		   //Ejemplo del funcionamiento del algoritmo de hash
	    	String password = "Redeban2017*";
	    	
	    	password = password.trim();

	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(password.getBytes());

	        byte byteData[] = md.digest();
	        
	        System.out.println(byteData);

	        //convert the byte to hex format method 1
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }

	        System.out.println(encriptar("123456"));

	        //convert the byte to hex format method 2
	        StringBuffer hexString = new StringBuffer();
	    	for (int i=0;i<byteData.length;i++) {
	    		String hex=Integer.toHexString(0xff & byteData[i]);
	   	     	if(hex.length()==1) hexString.append('0');
	   	     	hexString.append(hex);
	    	}
	    	System.out.println("Hex format : " + hexString.toString());
	    }
	   
	   public static String encriptar(String key)throws Exception
	    {
	        MessageDigest md = MessageDigest.getInstance("SHA-256");
	        md.update(key.getBytes());
	        byte byteData[] = md.digest();
	        //convert the byte to hex format 
	        StringBuffer sb = new StringBuffer();
	        for (int i = 0; i < byteData.length; i++) {
	         sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
	        }
	      return sb.toString();
	    }

}
