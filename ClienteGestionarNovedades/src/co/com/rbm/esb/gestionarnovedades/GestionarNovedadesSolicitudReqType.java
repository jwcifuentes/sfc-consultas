//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package co.com.rbm.esb.gestionarnovedades;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import co.com.rbm.esb.CabeceraType;


/**
 * <p>Java class for gestionarNovedadesSolicitudReqType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="gestionarNovedadesSolicitudReqType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraSolicitud" type="{http://www.rbm.com.co/esb/}CabeceraType"/>
 *         &lt;element name="infoTransaccion" type="{http://www.rbm.com.co/esb/gestionarNovedades}InfoTransaccionReqType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "gestionarNovedadesSolicitudReqType", propOrder = {
    "cabeceraSolicitud",
    "infoTransaccion"
})
public class GestionarNovedadesSolicitudReqType {

    @XmlElement(required = true)
    protected CabeceraType cabeceraSolicitud;
    @XmlElement(required = true)
    protected InfoTransaccionReqType infoTransaccion;

    /**
     * Gets the value of the cabeceraSolicitud property.
     * 
     * @return
     *     possible object is
     *     {@link CabeceraType }
     *     
     */
    public CabeceraType getCabeceraSolicitud() {
        return cabeceraSolicitud;
    }

    /**
     * Sets the value of the cabeceraSolicitud property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabeceraType }
     *     
     */
    public void setCabeceraSolicitud(CabeceraType value) {
        this.cabeceraSolicitud = value;
    }

    /**
     * Gets the value of the infoTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link InfoTransaccionReqType }
     *     
     */
    public InfoTransaccionReqType getInfoTransaccion() {
        return infoTransaccion;
    }

    /**
     * Sets the value of the infoTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoTransaccionReqType }
     *     
     */
    public void setInfoTransaccion(InfoTransaccionReqType value) {
        this.infoTransaccion = value;
    }

}
