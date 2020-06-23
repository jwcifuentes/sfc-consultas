package com.ibm.ams.utils;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.ibm.ams.excepcion.XmlToDtoException;

public class XmlToDto<T> {

	/**
	 * Metodo encargado de generar un Unmarshall.
	 * 
	 * @param <T>
	 * @param t
	 * @param archivo
	 * @return
	 */
	@SuppressWarnings({ "hiding", "unchecked" })
	public <T extends Object> T getDto(T t, File archivo)
			throws XmlToDtoException {
		Object dto = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(t.getClass());
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			dto = jaxbUnmarshaller.unmarshal(archivo);
		} catch (JAXBException ex) {
			throw new XmlToDtoException("ERROR TRANSFORMANDO XML A DTO "
					+ archivo.getAbsolutePath() + "--" + ex.getMessage() + "--"
					+ ex.getCause());
		}
		return (T) dto;
	}
	
	
	@SuppressWarnings({ "unchecked", "hiding" })
	public <T extends Object> T getDtoFromXMLString(T t, String str) throws XmlToDtoException{
		InputStream strBytes = new ByteArrayInputStream(str.getBytes());
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(t.getClass());
			Unmarshaller unmarshall = contexto.createUnmarshaller();
			return (T)unmarshall.unmarshal(strBytes);
		} catch (JAXBException e) {
			throw new XmlToDtoException("Error transformando XMLString a DTO"
					+ str + " " + e.getMessage() + " "
					+ e.getCause());
		}
	}
	
	@SuppressWarnings({ "hiding" })	
	public <T extends Object> String getXMLStringFromDto(T t) throws XmlToDtoException{
		StringWriter xmlStringWriter = new StringWriter();
		try {
		JAXBContext contexto = JAXBContext.newInstance(t.getClass());		
		Marshaller marshaller = contexto.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.marshal(t.getClass(), xmlStringWriter);
		return xmlStringWriter.toString();
		} catch (JAXBException e){
			throw new XmlToDtoException("Error transformando DTO a XMLString" +
					 e.getMessage() + " "
					+ e.getCause());
		}
	}
}
