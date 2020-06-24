package com.ibm.ams.utils;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
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

}
