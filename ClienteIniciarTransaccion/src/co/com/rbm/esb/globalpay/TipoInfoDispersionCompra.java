//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoDispersionCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoDispersionCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTerminal">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="8"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="idAdquiriente">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="19"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="infoCompra" type="{http://www.rbm.com.co/esb/globalpay/}TipoInfoCompra"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoDispersionCompra", propOrder = {
    "idTerminal",
    "idAdquiriente",
    "infoCompra"
})
public class TipoInfoDispersionCompra {

    @XmlElement(required = true)
    protected String idTerminal;
    @XmlElement(required = true)
    protected String idAdquiriente;
    @XmlElement(required = true)
    protected TipoInfoCompra infoCompra;

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
     * Gets the value of the idAdquiriente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdAdquiriente() {
        return idAdquiriente;
    }

    /**
     * Sets the value of the idAdquiriente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdAdquiriente(String value) {
        this.idAdquiriente = value;
    }

    /**
     * Gets the value of the infoCompra property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoCompra }
     *     
     */
    public TipoInfoCompra getInfoCompra() {
        return infoCompra;
    }

    /**
     * Sets the value of the infoCompra property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoCompra }
     *     
     */
    public void setInfoCompra(TipoInfoCompra value) {
        this.infoCompra = value;
    }

}