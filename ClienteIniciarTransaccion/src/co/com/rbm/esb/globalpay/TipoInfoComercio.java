//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoComercio complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoComercio">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="informacionComercio" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="informacionAdicional" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="200"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoComercio", propOrder = {
    "informacionComercio",
    "informacionAdicional"
})
public class TipoInfoComercio {

    protected String informacionComercio;
    protected String informacionAdicional;

    /**
     * Gets the value of the informacionComercio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformacionComercio() {
        return informacionComercio;
    }

    /**
     * Sets the value of the informacionComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformacionComercio(String value) {
        this.informacionComercio = value;
    }

    /**
     * Gets the value of the informacionAdicional property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformacionAdicional() {
        return informacionAdicional;
    }

    /**
     * Sets the value of the informacionAdicional property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformacionAdicional(String value) {
        this.informacionAdicional = value;
    }

}
