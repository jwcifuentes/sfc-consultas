package com.ibm.ams.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.ibm.ams.calendario.pojos.Festivo;

public class XmlHolidayOperations {
	
	private Document initXML(String file){
		
		Document xml = null;
		
		try{
			DocumentBuilderFactory documentBFact = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentB = documentBFact.newDocumentBuilder();
			xml = documentB.parse(file);
			
		}catch(ParserConfigurationException pce){
			pce.printStackTrace();
		}catch(IOException ioe){
			ioe.printStackTrace();
		}catch(SAXException sae){
			sae.printStackTrace();
		}
		
		return xml;
	}
	
	public void addXML(String file, Festivo newHoliday){
		
		Document xml = initXML(file);
		String labelNew = null;
		String attributeNew = null;
		
		if (newHoliday.getEtiqueta().equals(ConstantsXml.SHOW_FIXED_HOLIDAYS)){
			labelNew = ConstantsXml.LABEL_FIXED_HOLIDAYS;
			attributeNew = ConstantsXml.ATT_DATE;
			
		} else if (newHoliday.getEtiqueta().equals(ConstantsXml.SHOW_EASTER)){
			labelNew = ConstantsXml.LABEL_EASTER_RELATIVES;
			attributeNew = ConstantsXml.ATT_DELTA;
			
		} else if (newHoliday.getEtiqueta().equals(ConstantsXml.SHOW_HOLIDAY)){
			labelNew = ConstantsXml.LABEL_MONDAY_HOLIDAYS;
			attributeNew = ConstantsXml.ATT_DATE;
		}
		
		if (labelNew != null && attributeNew != null){
			
			Node node = xml.getElementsByTagName(labelNew).item(0);
			Element element = xml.createElement(attributeNew);
			element.appendChild(xml.createTextNode(newHoliday.getValor()));
			node.appendChild(element);
			
			try {
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = tFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(xml);
				StreamResult stResult = new StreamResult(new File(file));
				transformer.transform(source, stResult);
				
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public void editXML(String file, String label, String valor ,String valorEdit){
		
		Document xml = initXML(file);
		String attributeEdit = null;
		
		if (label.equals(ConstantsXml.LABEL_MONDAY_HOLIDAYS)){
			attributeEdit = ConstantsXml.ATT_DATE;
		}
		
		if (label != null && attributeEdit != null){
			
			Node node = xml.getElementsByTagName(label).item(0);
			Element element = (Element) node;
			NodeList nodeList = element.getElementsByTagName(attributeEdit);
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				if (element.getElementsByTagName(attributeEdit).item(i).getTextContent().equals(valor)){
					element.getElementsByTagName(attributeEdit).item(i).setTextContent(valorEdit);
				}
			}
			
			try {
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = tFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(xml);
				StreamResult stResult = new StreamResult(new File(file));
				transformer.transform(source, stResult);
				
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	public void deleteXML(String file, String label, String valueDelete){
		
		Document xml = initXML(file);
		String labelDelete = null;
		String attributeDelete = null;
		
		
		if (label.equals(ConstantsXml.LABEL_FIXED_HOLIDAYS)){
			labelDelete = ConstantsXml.LABEL_FIXED_HOLIDAYS;
			attributeDelete = ConstantsXml.ATT_DATE;
			
		} else if (label.equals(ConstantsXml.LABEL_MONDAY_HOLIDAYS)){
			labelDelete = ConstantsXml.LABEL_MONDAY_HOLIDAYS;
			attributeDelete = ConstantsXml.ATT_DATE;
			
		} else if (label.equals(ConstantsXml.LABEL_EASTER_RELATIVES)){
			labelDelete = ConstantsXml.LABEL_EASTER_RELATIVES;
			attributeDelete = ConstantsXml.ATT_DELTA;
		}
		
		if (labelDelete != null && attributeDelete != null){
			
			Node node = xml.getElementsByTagName(labelDelete).item(0);
			Element element = (Element) node;
			NodeList nodeList = element.getElementsByTagName(attributeDelete);
			
			for (int i = 0; i < nodeList.getLength(); i++) {
				if (element.getElementsByTagName(attributeDelete).item(i).getTextContent().equals(valueDelete)){
					node.removeChild(element.getElementsByTagName(attributeDelete).item(i));
				}
			}
			
			try {
				TransformerFactory tFactory = TransformerFactory.newInstance();
				Transformer transformer = tFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.STANDALONE, "yes");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				DOMSource source = new DOMSource(xml);
				StreamResult stResult = new StreamResult(new File(file));
				transformer.transform(source, stResult);
				
			} catch (TransformerConfigurationException e) {
				e.printStackTrace();
			} catch (TransformerException e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	public ArrayList<Festivo> readXML(String file){
		
		Document xml = initXML(file);
		ArrayList<Festivo> listXml = new ArrayList<Festivo>();
		
		Node saturday = xml.getElementsByTagName(ConstantsXml.LABEL_SATURDAY).item(0).getFirstChild();
		Festivo saturdayHoliday = new Festivo();
		saturdayHoliday.setTag(saturday.getParentNode().getNodeName());
		saturdayHoliday.setValor(saturday.getTextContent());
		listXml.add(saturdayHoliday);
		
		Node sunday =  xml.getElementsByTagName(ConstantsXml.LABEL_SUNDAY).item(0).getFirstChild();
		Festivo sundayHoliday = new Festivo();
		sundayHoliday.setTag(sunday.getParentNode().getNodeName());
		sundayHoliday.setValor(sunday.getTextContent());
		listXml.add(sundayHoliday);
		
		Node fixedHoliday = xml.getElementsByTagName(ConstantsXml.LABEL_FIXED_HOLIDAYS).item(0);
		Element elementFH = (Element) fixedHoliday;
		NodeList listDatesFH = elementFH.getElementsByTagName(ConstantsXml.ATT_DATE);
		
		for (int i = 0; i < listDatesFH.getLength(); i++) {
			Festivo dateHolidayF = new Festivo();
			dateHolidayF.setTag(fixedHoliday.getNodeName());
			dateHolidayF.setValor(elementFH.getElementsByTagName(ConstantsXml.ATT_DATE).item(i).getTextContent());
			listXml.add(dateHolidayF);
		}
		
		Node easterRelatives = xml.getElementsByTagName(ConstantsXml.LABEL_EASTER_RELATIVES).item(0);
		Element elementER = (Element) easterRelatives;
		NodeList listValueER = elementER.getElementsByTagName(ConstantsXml.ATT_DELTA);
		
		for (int i = 0; i < listValueER.getLength(); i++) {
			Festivo dateEasterR = new Festivo();
			dateEasterR.setTag(easterRelatives.getNodeName());
			dateEasterR.setValor(elementER.getElementsByTagName(ConstantsXml.ATT_DELTA).item(i).getTextContent());
			listXml.add(dateEasterR);
		}
		
		Node mondayHolidays = xml.getElementsByTagName(ConstantsXml.LABEL_MONDAY_HOLIDAYS).item(0);
		Element elementHM = (Element) mondayHolidays;
		NodeList listDatesHM = elementHM.getElementsByTagName(ConstantsXml.ATT_DATE);
		
		for (int i = 0; i < listDatesHM.getLength(); i++) {
			Festivo dateMondayH = new Festivo();
			dateMondayH.setTag(mondayHolidays.getNodeName());
			dateMondayH.setValor(elementHM.getElementsByTagName(ConstantsXml.ATT_DATE).item(i).getTextContent());
			listXml.add(dateMondayH);
		}
		
		return listXml;
	}

}
