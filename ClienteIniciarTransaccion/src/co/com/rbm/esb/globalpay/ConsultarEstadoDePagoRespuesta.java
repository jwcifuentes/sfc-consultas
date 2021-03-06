//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import co.com.rbm.esb.TipoInfoRespuesta;


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
 *         &lt;element name="cabeceraRespuesta" type="{http://www.rbm.com.co/esb/globalpay/}TipoCabeceraSolicitud"/>
 *         &lt;element name="infoPago" type="{http://www.rbm.com.co/esb/globalpay/}TipoInfoPago" minOccurs="0"/>
 *         &lt;element name="estadoActualTransaccion" type="{http://www.rbm.com.co/esb/globalpay/}TipoEstadoActualTransaccion" minOccurs="0"/>
 *         &lt;element name="infoRespuesta" type="{http://www.rbm.com.co/esb/}TipoInfoRespuesta"/>
 *         &lt;element name="infoPSE" type="{http://www.rbm.com.co/esb/globalpay/}TipoInfoPSE" minOccurs="0"/>
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
    "cabeceraRespuesta",
    "infoPago",
    "estadoActualTransaccion",
    "infoRespuesta",
    "infoPSE"
})
@XmlRootElement(name = "ConsultarEstadoDePagoRespuesta")
public class ConsultarEstadoDePagoRespuesta {

    @XmlElement(required = true)
    protected TipoCabeceraSolicitud cabeceraRespuesta;
    protected TipoInfoPago infoPago;
    protected TipoEstadoActualTransaccion estadoActualTransaccion;
    @XmlElement(required = true)
    protected TipoInfoRespuesta infoRespuesta;
    protected TipoInfoPSE infoPSE;

    /**
     * Gets the value of the cabeceraRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public TipoCabeceraSolicitud getCabeceraRespuesta() {
        return cabeceraRespuesta;
    }

    /**
     * Sets the value of the cabeceraRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoCabeceraSolicitud }
     *     
     */
    public void setCabeceraRespuesta(TipoCabeceraSolicitud value) {
        this.cabeceraRespuesta = value;
    }

    /**
     * Gets the value of the infoPago property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoPago }
     *     
     */
    public TipoInfoPago getInfoPago() {
        return infoPago;
    }

    /**
     * Sets the value of the infoPago property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoPago }
     *     
     */
    public void setInfoPago(TipoInfoPago value) {
        this.infoPago = value;
    }

    /**
     * Gets the value of the estadoActualTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link TipoEstadoActualTransaccion }
     *     
     */
    public TipoEstadoActualTransaccion getEstadoActualTransaccion() {
        return estadoActualTransaccion;
    }

    /**
     * Sets the value of the estadoActualTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoEstadoActualTransaccion }
     *     
     */
    public void setEstadoActualTransaccion(TipoEstadoActualTransaccion value) {
        this.estadoActualTransaccion = value;
    }

    /**
     * Gets the value of the infoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoRespuesta }
     *     
     */
    public TipoInfoRespuesta getInfoRespuesta() {
        return infoRespuesta;
    }

    /**
     * Sets the value of the infoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoRespuesta }
     *     
     */
    public void setInfoRespuesta(TipoInfoRespuesta value) {
        this.infoRespuesta = value;
    }

    /**
     * Gets the value of the infoPSE property.
     * 
     * @return
     *     possible object is
     *     {@link TipoInfoPSE }
     *     
     */
    public TipoInfoPSE getInfoPSE() {
        return infoPSE;
    }

    /**
     * Sets the value of the infoPSE property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoInfoPSE }
     *     
     */
    public void setInfoPSE(TipoInfoPSE value) {
        this.infoPSE = value;
    }

}
