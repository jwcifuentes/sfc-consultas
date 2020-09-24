//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.comercio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoPuntoInteraccion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoPuntoInteraccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoTipoTerminal"/>
 *         &lt;element name="idTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoIdTerminal"/>
 *         &lt;element name="idAdquiriente" type="{http://www.rbm.com.co/esb/comercio/}TipoIdAdquiriente"/>
 *         &lt;element name="idTransaccionTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoIdTransaccionTerminal"/>
 *         &lt;element name="modoCapturaPAN" type="{http://www.rbm.com.co/esb/comercio/}TipoModoCapturaPAN"/>
 *         &lt;element name="capacidadPIN" type="{http://www.rbm.com.co/esb/comercio/}TipoCapacidadPIN"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoPuntoInteraccion", propOrder = {
    "tipoTerminal",
    "idTerminal",
    "idAdquiriente",
    "idTransaccionTerminal",
    "modoCapturaPAN",
    "capacidadPIN"
})
public class TipoInfoPuntoInteraccion {

    @XmlElement(required = true)
    protected TipoTipoTerminal tipoTerminal;
    @XmlElement(required = true)
    protected String idTerminal;
    @XmlElement(required = true)
    protected String idAdquiriente;
    protected long idTransaccionTerminal;
    @XmlElement(required = true)
    protected TipoModoCapturaPAN modoCapturaPAN;
    @XmlElement(required = true)
    protected TipoCapacidadPIN capacidadPIN;

    /**
     * Gets the value of the tipoTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoTerminal }
     *     
     */
    public TipoTipoTerminal getTipoTerminal() {
        return tipoTerminal;
    }

    /**
     * Sets the value of the tipoTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoTerminal }
     *     
     */
    public void setTipoTerminal(TipoTipoTerminal value) {
        this.tipoTerminal = value;
    }

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
     * Gets the value of the idTransaccionTerminal property.
     * 
     */
    public long getIdTransaccionTerminal() {
        return idTransaccionTerminal;
    }

    /**
     * Sets the value of the idTransaccionTerminal property.
     * 
     */
    public void setIdTransaccionTerminal(long value) {
        this.idTransaccionTerminal = value;
    }

    /**
     * Gets the value of the modoCapturaPAN property.
     * 
     * @return
     *     possible object is
     *     {@link TipoModoCapturaPAN }
     *     
     */
    public TipoModoCapturaPAN getModoCapturaPAN() {
        return modoCapturaPAN;
    }

    /**
     * Sets the value of the modoCapturaPAN property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoModoCapturaPAN }
     *     
     */
    public void setModoCapturaPAN(TipoModoCapturaPAN value) {
        this.modoCapturaPAN = value;
    }

    /**
     * Gets the value of the capacidadPIN property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCapacidadPIN }
     *     
     */
    public TipoCapacidadPIN getCapacidadPIN() {
        return capacidadPIN;
    }

    /**
     * Sets the value of the capacidadPIN property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCapacidadPIN }
     *     
     */
    public void setCapacidadPIN(TipoCapacidadPIN value) {
        this.capacidadPIN = value;
    }

}
