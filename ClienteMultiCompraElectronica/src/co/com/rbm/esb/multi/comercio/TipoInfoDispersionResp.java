//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.multi.comercio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import co.com.rbm.esb.multi.comercio.compra.TipoInfoCompraResp;


/**
 * <p>Java class for TipoInfoDispersionResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoDispersionResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoIdTerminal"/>
 *         &lt;element name="idAdquiriente" type="{http://www.rbm.com.co/esb/comercio/}TipoIdAdquiriente"/>
 *         &lt;element name="infoCompraResp" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoCompraResp"/>
 *         &lt;element name="idTransaccionAutorizador" type="{http://www.rbm.com.co/esb/}TipoIdTransaccionAutorizador"/>
 *         &lt;element name="infoTerminal" type="{http://www.rbm.com.co/esb/comercio/}TipoInfoTerminal" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoDispersionResp", propOrder = {
    "idTerminal",
    "idAdquiriente",
    "infoCompraResp",
    "idTransaccionAutorizador",
    "infoTerminal"
})
public class TipoInfoDispersionResp {

    @XmlElement(required = true)
    protected String idTerminal;
    @XmlElement(required = true)
    protected String idAdquiriente;
    @XmlElement(required = true)
    protected TipoInfoCompraResp infoCompraResp;
    protected long idTransaccionAutorizador;
    protected TipoInfoTerminal infoTerminal;

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
     * Gets the value of the infoCompraResp property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoCompraResp }
     *     
     */
    public TipoInfoCompraResp getInfoCompraResp() {
        return infoCompraResp;
    }

    /**
     * Sets the value of the infoCompraResp property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoCompraResp }
     *     
     */
    public void setInfoCompraResp(TipoInfoCompraResp value) {
        this.infoCompraResp = value;
    }

    /**
     * Gets the value of the idTransaccionAutorizador property.
     * 
     */
    public long getIdTransaccionAutorizador() {
        return idTransaccionAutorizador;
    }

    /**
     * Sets the value of the idTransaccionAutorizador property.
     * 
     */
    public void setIdTransaccionAutorizador(long value) {
        this.idTransaccionAutorizador = value;
    }

    /**
     * Gets the value of the infoTerminal property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoTerminal }
     *     
     */
    public TipoInfoTerminal getInfoTerminal() {
        return infoTerminal;
    }

    /**
     * Sets the value of the infoTerminal property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoTerminal }
     *     
     */
    public void setInfoTerminal(TipoInfoTerminal value) {
        this.infoTerminal = value;
    }

}
