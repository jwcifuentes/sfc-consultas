//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoSolicitudPSE complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoSolicitudPSE">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nitAdquiriente" type="{http://www.rbm.com.co/esb/globalpay/}tipoNitAdquiriente" minOccurs="0"/>
 *         &lt;element name="codigoServicio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="conceptoPago" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoSolicitudPSE", propOrder = {
    "nitAdquiriente",
    "codigoServicio",
    "conceptoPago"
})
public class TipoInfoSolicitudPSE {

    protected String nitAdquiriente;
    protected String codigoServicio;
    protected String conceptoPago;

    /**
     * Gets the value of the nitAdquiriente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNitAdquiriente() {
        return nitAdquiriente;
    }

    /**
     * Sets the value of the nitAdquiriente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNitAdquiriente(String value) {
        this.nitAdquiriente = value;
    }

    /**
     * Gets the value of the codigoServicio property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoServicio() {
        return codigoServicio;
    }

    /**
     * Sets the value of the codigoServicio property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoServicio(String value) {
        this.codigoServicio = value;
    }

    /**
     * Gets the value of the conceptoPago property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getConceptoPago() {
        return conceptoPago;
    }

    /**
     * Sets the value of the conceptoPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setConceptoPago(String value) {
        this.conceptoPago = value;
    }

}