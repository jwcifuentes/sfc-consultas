package com.ibm.ams.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

import com.ibm.ams.excepcion.ExcepcionFOP;
import com.ibm.ams.excepcion.ExcepcionRutasArchivos;
import com.ibm.ams.excepcion.ExcepcionTransformacion;

public class GeneradorPDFs {

	/**
	 * Metodo que convierte el archivo en outputStream para posteriormente crear
	 * un archivo PDF
	 * 
	 * @param xmlSource
	 * @param rutaArchivoPlantilla
	 * @return ByteArrayOutputStream
	 * @throws ExcepcionRutasArchivos
	 * @throws Exception
	 */
	public ByteArrayOutputStream crearOutputStreamPDF(Object datos, String rutaArchivoPlantilla)
			throws ExcepcionFOP, ExcepcionTransformacion, ExcepcionRutasArchivos {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			// Nombre del archivo FO
			URL url;
			url = new File(rutaArchivoPlantilla).toURI().toURL();
			// Creacion del recurso transformado
			StreamSource transformSource = new StreamSource(url.openStream());
			// Fuente de datos
			ByteArrayOutputStream streamSource = getXMLSource(datos);
			StreamSource source = new StreamSource(new ByteArrayInputStream(streamSource.toByteArray()));
			FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
			FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

			// Archivo PDF
			out = new ByteArrayOutputStream();
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer(transformSource);
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(source, res);
			out.close();
			return out;
		} catch (FOPException e) {
			throw new ExcepcionFOP("Excepcion al leer el archivo usando FOP", e);
		} catch (IOException e) {
			throw new ExcepcionRutasArchivos("El archivo no pudo ser creado", e);
		} catch (TransformerException e) {
			throw new ExcepcionTransformacion("Error al crear el Transformer encargado de generar el PDF", e);
		}
	}

	/**
	 * Metodo que obtiene el OutputStream del objeto que se le pasa por
	 * parametro
	 * 
	 * @param data
	 * @return
	 * @throws ExcepcionTransformacion
	 */
	public ByteArrayOutputStream getXMLSource(Object data)
			throws ExcepcionTransformacion {
		JAXBContext context;
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		try {
			context = JAXBContext.newInstance(data.getClass());
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			m.marshal(data, outStream);
		} catch (JAXBException e) {
			throw new ExcepcionTransformacion(
					"Error al transformar el leer el objeto enviado para generar el PDF",
					e);
		}
		return outStream;
	}
}