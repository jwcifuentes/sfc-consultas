//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.multi.comercio.compra;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import co.com.rbm.esb.multi.TipoIdPersona;
import co.com.rbm.esb.multi.comercio.TipoInfoDispersion;


/**
 * <p>Java class for TipoSolicitudCompra complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoSolicitudCompra">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraSolicitud" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoCabeceraSolicitud"/>
 *         &lt;element name="idPersona" type="{http://www.rbm.com.co/esb/}TipoIdPersona" minOccurs="0"/>
 *         &lt;element name="infoMedioPago" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoMedioPago"/>
 *         &lt;element name="infoDispersion" type="{http://www.rbm.com.co/esb/comercio/}TipoInfoDispersion" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoSolicitudCompra", propOrder = {
    "cabeceraSolicitud",
    "idPersona",
    "infoMedioPago",
    "infoDispersion"
})
public class TipoSolicitudCompra {

    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraSolicitud;
    protected TipoIdPersona idPersona;
    @XmlElement(required = true)
    protected TipoInfoMedioPago infoMedioPago;
    @XmlElement(required = true)
    protected List<TipoInfoDispersion> infoDispersion;

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
     * Gets the value of the idPersona property.
     * 
     * @return
     *     possible object is
     *     {@link TipoIdPersona }
     *     
     */
    public TipoIdPersona getIdPersona() {
        return idPersona;
    }

    /**
     * Sets the value of the idPersona property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoIdPersona }
     *     
     */
    public void setIdPersona(TipoIdPersona value) {
        this.idPersona = value;
    }

    /**
     * Gets the value of the infoMedioPago property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoMedioPago }
     *     
     */
    public TipoInfoMedioPago getInfoMedioPago() {
        return infoMedioPago;
    }

    /**
     * Sets the value of the infoMedioPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoMedioPago }
     *     
     */
    public void setInfoMedioPago(TipoInfoMedioPago value) {
        this.infoMedioPago = value;
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
     * {@link TipoInfoDispersion }
     * 
     * 
     */
    public List<TipoInfoDispersion> getInfoDispersion() {
        if (infoDispersion == null) {
            infoDispersion = new ArrayList<TipoInfoDispersion>();
        }
        return this.infoDispersion;
    }

}
