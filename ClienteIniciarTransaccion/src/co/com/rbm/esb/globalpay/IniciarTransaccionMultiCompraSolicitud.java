//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element name="credenciales" type="{http://www.rbm.com.co/esb/globalpay/}TipoCredenciales" minOccurs="0"/>
 *         &lt;element name="cabeceraSolicitud" type="{http://www.rbm.com.co/esb/globalpay/}TipoCabeceraSolicitud"/>
 *         &lt;element name="infoPersona" type="{http://www.rbm.com.co/esb/globalpay/}TipoInfoPersona" minOccurs="0"/>
 *         &lt;element name="infoComercio" type="{http://www.rbm.com.co/esb/globalpay/}TipoInformacionComercio" minOccurs="0"/>
 *         &lt;element name="infoDispersion" type="{http://www.rbm.com.co/esb/globalpay/}TipoInfoDispersionCompra" maxOccurs="unbounded"/>
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
    "credenciales",
    "cabeceraSolicitud",
    "infoPersona",
    "infoComercio",
    "infoDispersion"
})
@XmlRootElement(name = "IniciarTransaccionMultiCompraSolicitud")
public class IniciarTransaccionMultiCompraSolicitud {

    protected TipoCredenciales credenciales;
    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraSolicitud;
    protected TipoInfoPersona infoPersona;
    protected TipoInformacionComercio infoComercio;
    @XmlElement(required = true)
    protected List<TipoInfoDispersionCompra> infoDispersion;

    /**
     * Gets the value of the credenciales property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCredenciales }
     *     
     */
    public TipoCredenciales getCredenciales() {
        return credenciales;
    }

    /**
     * Sets the value of the credenciales property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCredenciales }
     *     
     */
    public void setCredenciales(TipoCredenciales value) {
        this.credenciales = value;
    }

    /**
     * Gets the value of the cabeceraSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public TipoCabeceraSolicitud getCabeceraSolicitud() {
        return cabeceraSolicitud;
    }

    /**
     * Sets the value of the cabeceraSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public void setCabeceraSolicitud(TipoCabeceraSolicitud value) {
        this.cabeceraSolicitud = value;
    }

    /**
     * Gets the value of the infoPersona property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoPersona }
     *     
     */
    public TipoInfoPersona getInfoPersona() {
        return infoPersona;
    }

    /**
     * Sets the value of the infoPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoPersona }
     *     
     */
    public void setInfoPersona(TipoInfoPersona value) {
        this.infoPersona = value;
    }

    /**
     * Gets the value of the infoComercio property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInformacionComercio }
     *     
     */
    public TipoInformacionComercio getInfoComercio() {
        return infoComercio;
    }

    /**
     * Sets the value of the infoComercio property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInformacionComercio }
     *     
     */
    public void setInfoComercio(TipoInformacionComercio value) {
        this.infoComercio = value;
    }

    /**
     * Gets the value of the infoDispersion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoDispersion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoDispersion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoInfoDispersionCompra }
     * 
     * 
     */
    public List<TipoInfoDispersionCompra> getInfoDispersion() {
        if (infoDispersion == null) {
            infoDispersion = new ArrayList<TipoInfoDispersionCompra>();
        }
        return this.infoDispersion;
    }

}
