//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoCHIP complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoCHIP">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="codSeguridadEMV" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="dataEMV" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoCHIP", propOrder = {
    "codSeguridadEMV",
    "dataEMV"
})
public class TipoInfoCHIP {

    @XmlElement(required = true)
    protected String codSeguridadEMV;
    @XmlElement(required = true)
    protected String dataEMV;

    /**
     * Gets the value of the codSeguridadEMV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodSeguridadEMV() {
        return codSeguridadEMV;
    }

    /**
     * Sets the value of the codSeguridadEMV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodSeguridadEMV(String value) {
        this.codSeguridadEMV = value;
    }

    /**
     * Gets the value of the dataEMV property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDataEMV() {
        return dataEMV;
    }

    /**
     * Sets the value of the dataEMV property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDataEMV(String value) {
        this.dataEMV = value;
    }

}