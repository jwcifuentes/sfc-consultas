package com.ibm.ams.correo.generadorcorreo;

import java.io.File;
import java.io.StringWriter;
import java.util.Iterator;

import javax.activation.CommandMap;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.MailcapCommandMap;
import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Part;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.naming.InitialContext;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.FileResourceLoader;

import com.ibm.ams.correo.configuracion.Adjunto;
import com.ibm.ams.correo.configuracion.ConfiguracionCorreo;
import com.ibm.ams.correo.configuracion.ConstantesCorreo;
import com.ibm.ams.correo.configuracion.GestorConfiguracionCorreo;
import com.ibm.ams.correo.configuracion.InformacionCorreoDTO;
import com.ibm.ams.correo.configuracion.Plantilla;
import com.ibm.ams.correo.configuracion.Plantillas;
import com.ibm.ams.correo.excepcion.ExcepcionCorreo;
import com.ibm.ams.log.Logger;

/**
*   <b>IBM. Global Bussiness Services AMS Colombia .</b>
*   
*   <p><b>Descripcion: </b>
*   <p> Clase encargada de la contruccion del contenido del correo a enviar y
*   <p> interaccion con el servidor de correo.
*   
* 	<p><b>Notas: </b>
*   <p> Requiere del framework velocity para la construccion del contenido del correo
*   
* 	<p><b>Proyecto base: </b> DatafonoWeb
*   
*   @author <dprojas@co.ibm.com> Edwin Silva</A>
*   <p><b>Fecha de creacion(dd/mmm/aaaa):</b> 11/dic/2014
*   
*   @version 1.0, 11/dic/2014
*   <p><b>ChangeLog:</b>
*	<p>Version: 1.0 
*	<p>- Creacion de la clase.
*	
*	
**/
public class EmailSender {
	/**
	 * Variable de configuracion de velocity con la cual se carga y llena plantillas.
	 */
	private VelocityEngine engine;
	/**
	 * Variable de velocity en la cual se pasa la informacion para llenar una plantilla.
	 */
	private VelocityContext contextv;
	/**
	 * DTO con la informacion de configuracion para el modulo
	 */
	private ConfiguracionCorreo config;
	/**
	 * Gestor de log de DatafonoWeb
	 */
	private Logger logger;
	
	/**
	 * Constructor de la clase
	 * @throws ExcepcionCorreo
	 */
	public EmailSender() throws ExcepcionCorreo {
		if (logger == null)
			logger = Logger.getInstance("gp", "globalpay");
		
		logger.info(this.getClass().getName(), "EmailSender", "Iniciando servicio de correo electrónico.", "");
		// Agregar los MIME types manejados en el correo
		MailcapCommandMap mc = (MailcapCommandMap) CommandMap.getDefaultCommandMap();
		mc.addMailcap("text/html;; x-java-content-handler=com.sun.mail.handlers.text_html");
		mc.addMailcap("multipart/*;; x-java-content-handler=com.sun.mail.handlers.multipart_mixed");
		CommandMap.setDefaultCommandMap(mc);
		
		config = GestorConfiguracionCorreo.getConfigCorreo();
		
		String rutaArchivo = System.getProperty(ConstantesCorreo.CONFIGURACION_DIR)
				+ ConstantesCorreo.MAIL_DIR + File.separatorChar;
		
		engine = new VelocityEngine();
		engine.setProperty(RuntimeConstants.RESOURCE_LOADER, "file");
		engine.setProperty("file.resource.loader.class", FileResourceLoader.class.getName());
		engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_PATH, rutaArchivo);
		engine.setProperty(RuntimeConstants.FILE_RESOURCE_LOADER_CACHE, true);
		engine.init();
	}
	
	/**
	 * Mótodo encargado de enviar un correo electronico, dependiendo de la informacion proporcionada para ello
	 * @param correo Informacion de correo electronico a enviar
	 * @param nombrePlantilla Nombre de la plantilla a usar
	 * @throws ExcepcionCorreo
	 */
	public void enviarCorreo(InformacionCorreoDTO correo, String nombrePlantilla) throws ExcepcionCorreo {
		logger.info(this.getClass().getName(), "enviarCorreo", "Enviando correo electronico.", "");
		if (!correo.getInformacionComercio().isEmpty()) {
			contextv = new VelocityContext();
			Iterator<String> it = correo.getInformacionComercio().keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				logger.info(this.getClass().getName(), "enviarCorreo", "Mapeo de propiedades de correo: Clave " + key + ", Valor: " + correo.getInformacionComercio().get(key), "");
				contextv.put(key, correo.getInformacionComercio().get(key) );
			}			
		} else {
			throw new ExcepcionCorreo("La información de correo estó vacía. No se pueden mapear las propiedades de plantilla");
		}
		
		logger.info(this.getClass().getName(), "enviarCorreo", "Obteniendo plantilla de correo con nombre " + nombrePlantilla, "");	
		Plantillas p = config.getPlantillas();
		Plantilla plantillaCorreo = null;
		if (null != p) {
			for (Plantilla plantilla : p.getPlantilla()) {
				if (nombrePlantilla.equals(plantilla.getNombrePlantilla())) {
					plantillaCorreo = plantilla;
					break;
				} 			
			}
			if(null == plantillaCorreo){
				logger.error(this.getClass().getName(), "enviarCorreo", "Se presento un error al enviar el correo. No se encontraron plantillas para esta configuracion.", null);
				throw new ExcepcionCorreo("Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.");
			}
		} else {
			logger.error(this.getClass().getName(), "enviarCorreo", "Se presento un error al enviar el correo. No se encontraron plantillas para esta configuracion.", null);
			throw new ExcepcionCorreo("Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.");
		}
		
		Template template = engine.getTemplate(nombrePlantilla);
		StringWriter writer = new StringWriter();
		template.merge(contextv, writer);
		
		String contenido = writer.toString();
		
		try {
			InitialContext context = new InitialContext();
			Session mailSession = (Session) context.lookup(plantillaCorreo.getSesionCorreo());
			Message message = new javax.mail.internet.MimeMessage(mailSession);
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electronicos.", "");
			Address[] addresses = null;
			if ((null != correo.getTo()) && (!correo.getTo().isEmpty())) {
				addresses = new Address[correo.getTo().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getTo().get(i));					
				}
				message.setRecipients(RecipientType.TO, addresses);				
			} 
//			else {
//				throw new ExcepcionCorreo("Listado de correos electronicos vacios. No se puede enviar correo electronico.");
//			}
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electronicos en copia.", "");
			if ((null != correo.getCc()) && (!correo.getCc().isEmpty())) {
				addresses = new Address[correo.getCc().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getCc().get(i));					
				}
				message.setRecipients(RecipientType.CC, addresses);
			}
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electronicos en copia oculta.", "");
			if ((null != correo.getBcc()) && (!correo.getBcc().isEmpty())) {
				addresses = new Address[correo.getBcc().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getBcc().get(i));					
				}
				message.setRecipients(RecipientType.BCC, addresses);
			}
			
			
			message.setSubject(plantillaCorreo.getAsuntoCorreo());	
			message.setText(contenido);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message.getContent(), "text/html");
			MimeMultipart multipart = new MimeMultipart("related");
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource fds = null;
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando archivos adjuntos al correo electronico.", "");
			if ((null != correo.getAdjuntos()) && (!correo.getAdjuntos().isEmpty())) {
				for (Adjunto adjunto : correo.getAdjuntos()) {
					messageBodyPart = new MimeBodyPart();
					if (!adjunto.isInline()) {
						fds = new ByteArrayDataSource(adjunto.getData(), adjunto.getMimeType());
						messageBodyPart.setDataHandler(new DataHandler(fds));
						messageBodyPart.setFileName(adjunto.getNombre());
						multipart.addBodyPart(messageBodyPart);
					} else {
						fds = new ByteArrayDataSource(adjunto.getData(), adjunto.getMimeType());
						messageBodyPart.setDataHandler(new DataHandler(fds));
						messageBodyPart.setFileName(adjunto.getNombre());
						messageBodyPart.setHeader("Content-ID", "<" + adjunto.getContentId() + ">");
						messageBodyPart.setDisposition(Part.INLINE);
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			message.setContent(multipart);
			
			//Envoo de correo electronico
			javax.mail.Transport.send(message);
		} catch (Exception e) {
			logger.error(this.getClass().getName(), "enviarCorreo", "Se presento un error al enviar el correo", e);
			throw new ExcepcionCorreo(e);
		}
	}
	public void enviarCorreoCompleto(InformacionCorreoDTO correo, String nombrePlantilla) throws ExcepcionCorreo {
		logger.info(this.getClass().getName(), "enviarCorreo", "Enviando correo electrónico.", "");
		if (!correo.getInformacionComercio().isEmpty()) {
			contextv = new VelocityContext();
			Iterator<String> it = correo.getInformacionComercio().keySet().iterator();
			while (it.hasNext()) {
				String key = it.next();
				logger.info(this.getClass().getName(), "enviarCorreo", "Mapeo de propiedades de correo: Clave " + key + ", Valor: " + correo.getInformacionComercio().get(key), "");
				contextv.put(key, correo.getInformacionComercio().get(key) );
			}			
		} else {
			throw new ExcepcionCorreo("La información de correo está vacía. No se pueden mapear las propiedades de plantilla");
		}
		
		logger.info(this.getClass().getName(), "enviarCorreo", "Obteniendo plantilla de correo con nombre " + nombrePlantilla, "");	
		Plantillas p = config.getPlantillas();
		Plantilla plantillaCorreo = null;
		if (null != p) {
			for (Plantilla plantilla : p.getPlantilla()) {
				if (nombrePlantilla.equals(plantilla.getNombrePlantilla())) {
					plantillaCorreo = plantilla;
					break;
				} 			
			}
			if(null == plantillaCorreo){
				logger.error(this.getClass().getName(), "enviarCorreo", "Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.", null);
				throw new ExcepcionCorreo("Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.");
			}
		} else {
			logger.error(this.getClass().getName(), "enviarCorreo", "Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.", null);
			throw new ExcepcionCorreo("Se presentó un error al enviar el correo. No se encontraron plantillas para esta configuración.");
		}
		
		Template template = engine.getTemplate(nombrePlantilla);
		StringWriter writer = new StringWriter();
		template.merge(contextv, writer);
		
		String contenido = writer.toString();
		
		try {
			InitialContext context = new InitialContext();
			Session mailSession = (Session) context.lookup(plantillaCorreo.getSesionCorreo());
			Message message = new javax.mail.internet.MimeMessage(mailSession);
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electrónicos.", "");
			Address[] addresses = null;
			if ((null != correo.getTo()) && (!correo.getTo().isEmpty())) {
				addresses = new Address[correo.getTo().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getTo().get(i));					
				}
				message.setRecipients(RecipientType.TO, addresses);				
			} 
//			else {
//				throw new ExcepcionCorreo("Listado de correos electrónicos vacíos. No se puede enviar correo electrónico.");
//			}
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electrónicos en copia.", "");
			if ((null != correo.getCc()) && (!correo.getCc().isEmpty())) {
				addresses = new Address[correo.getCc().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getCc().get(i));					
				}
				message.setRecipients(RecipientType.CC, addresses);
			}
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando listado de correos electrónicos en copia oculta.", "");
			if ((null != correo.getBcc()) && (!correo.getBcc().isEmpty())) {
				addresses = new Address[correo.getBcc().size()];
				for (int i = 0; i < addresses.length; i++) {
					addresses[i] = new InternetAddress(correo.getBcc().get(i));					
				}
				message.setRecipients(RecipientType.BCC, addresses);
			}
			
			
			message.setSubject(correo.getAsunto());	
			message.setText(contenido);
			BodyPart messageBodyPart = new MimeBodyPart();
			messageBodyPart.setContent(message.getContent(), "text/html");
			MimeMultipart multipart = new MimeMultipart("related");
			multipart.addBodyPart(messageBodyPart);
			
			messageBodyPart = new MimeBodyPart();
			DataSource fds = null;
			
			logger.info(this.getClass().getName(), "enviarCorreo", "Mapeando archivos adjuntos al correo electrónico.", "");
			if ((null != correo.getAdjuntos()) && (!correo.getAdjuntos().isEmpty())) {
				for (Adjunto adjunto : correo.getAdjuntos()) {
					messageBodyPart = new MimeBodyPart();
					if (!adjunto.isInline()) {
						fds = new ByteArrayDataSource(adjunto.getData(), adjunto.getMimeType());
						messageBodyPart.setDataHandler(new DataHandler(fds));
						messageBodyPart.setFileName(adjunto.getNombre());
						multipart.addBodyPart(messageBodyPart);
					} else {
						fds = new ByteArrayDataSource(adjunto.getData(), adjunto.getMimeType());
						messageBodyPart.setDataHandler(new DataHandler(fds));
						messageBodyPart.setFileName(adjunto.getNombre());
						messageBodyPart.setHeader("Content-ID", "<" + adjunto.getContentId() + ">");
						messageBodyPart.setDisposition(Part.INLINE);
						multipart.addBodyPart(messageBodyPart);
					}
				}
			}
			message.setContent(multipart);
			
			//Envío de correo electrónico
			javax.mail.Transport.send(message);
		} catch (Exception e) {
			logger.error(this.getClass().getName(), "enviarCorreo", "Se presentó un error al enviar el correo", e);
			throw new ExcepcionCorreo(e);
		}
	}
}