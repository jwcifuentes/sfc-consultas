//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.07.11 at 02:55:13 PM COT 
//


package co.com.rbm.esb.seguridad;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTerminal" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *		   &lt;element name="infoRespuesta" type="{http://www.rbm.com.co/esb/seguridad}InfoRespuesta"/>
 *         &lt;element name="PINBlock" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "idTerminal",
    "infoRespuesta",
    "pinBlock"
})
@XmlRootElement(name = "obtenerPINBlockRespuesta", namespace="http://www.rbm.com.co/esb/seguridad/")
public class ObtenerPINBlockRespuesta {

    @XmlElement(required = true)
    protected String idTerminal;
    @XmlElement(required = true)
    protected InfoRespuesta infoRespuesta;
    @XmlElement(name = "PINBlock", required = true)
    protected String pinBlock;

    /**
     * Gets the value of the idTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTerminal() {
        return idTerminal;
    }

    /**
     * Sets the value of the idTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTerminal(String value) {
        this.idTerminal = value;
    }

    /**
     * Gets the value of the infoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link ObtenerPINBlockRespuesta.InfoRespuesta }
     *     
     */
    public InfoRespuesta getInfoRespuesta() {
        return infoRespuesta;
    }

    /**
     * Sets the value of the infoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link ObtenerPINBlockRespuesta.InfoRespuesta }
     *     
     */
    public void setInfoRespuesta(InfoRespuesta value) {
        this.infoRespuesta = value;
    }

    /**
     * Gets the value of the pinBlock property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPINBlock() {
        return pinBlock;
    }

    /**
     * Sets the value of the pinBlock property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPINBlock(String value) {
        this.pinBlock = value;
    }
}
