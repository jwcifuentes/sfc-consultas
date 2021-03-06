//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.multi.comercio.compra;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import co.com.rbm.esb.multi.TipoIdPersona;
import co.com.rbm.esb.multi.TipoInfoRefCancelacion;


/**
 * <p>Java class for TipoSolicitudCancelacion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoSolicitudCancelacion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraSolicitud" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoCabeceraSolicitud"/>
 *         &lt;element name="idPersona" type="{http://www.rbm.com.co/esb/}TipoIdPersona" minOccurs="0"/>
 *         &lt;element name="infoMedioPago" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoMedioPago"/>
 *         &lt;element name="infoCompra" type="{http://www.rbm.com.co/esb/comercio/compra/}TipoInfoCompra"/>
 *         &lt;element name="infoRefCancelacion" type="{http://www.rbm.com.co/esb/}TipoInfoRefCancelacion"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoSolicitudCancelacion", propOrder = {
    "cabeceraSolicitud",
    "idPersona",
    "infoMedioPago",
    "infoCompra",
    "infoRefCancelacion"
})
public class TipoSolicitudCancelacion {

    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraSolicitud;
    protected TipoIdPersona idPersona;
    @XmlElement(required = true)
    protected TipoInfoMedioPago infoMedioPago;
    @XmlElement(required = true)
    protected TipoInfoCompra infoCompra;
    @XmlElement(required = true)
    protected TipoInfoRefCancelacion infoRefCancelacion;

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

    /**
     * Gets the value of the infoRefCancelacion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoRefCancelacion }
     *     
     */
    public TipoInfoRefCancelacion getInfoRefCancelacion() {
        return infoRefCancelacion;
    }

    /**
     * Sets the value of the infoRefCancelacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoRefCancelacion }
     *     
     */
    public void setInfoRefCancelacion(TipoInfoRefCancelacion value) {
        this.infoRefCancelacion = value;
    }

}
