//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoTransaccionResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoTransaccionResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTransaccionActual" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoTransaccionResp", propOrder = {
    "idTransaccionActual"
})
public class TipoInfoTransaccionResp {

    @XmlElement(required = true)
    protected String idTransaccionActual;

    /**
     * Gets the value of the idTransaccionActual property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdTransaccionActual() {
        return idTransaccionActual;
    }

    /**
     * Sets the value of the idTransaccionActual property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdTransaccionActual(String value) {
        this.idTransaccionActual = value;
    }

}
