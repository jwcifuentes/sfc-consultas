//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.pignorarcuenta;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

import co.com.rbm.esbPignoracion.CabeceraType;
import co.com.rbm.esbPignoracion.InfoRespuestaResType;


/**
 * <p>Java class for pignorarCuentaRespuestaResType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pignorarCuentaRespuestaResType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cabeceraRespuesta" type="{http://www.rbm.com.co/esb/}CabeceraType"/>
 *         &lt;element name="infoRespuesta" type="{http://www.rbm.com.co/esb/}InfoRespuestaResType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pignorarCuentaRespuestaResType", propOrder = {
    "cabeceraRespuesta",
    "infoRespuesta"
})
public class PignorarCuentaRespuestaResType {

    @XmlElement(required = true)
    protected CabeceraType cabeceraRespuesta;
    @XmlElement(required = true)
    protected InfoRespuestaResType infoRespuesta;

    /**
     * Gets the value of the cabeceraRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link CabeceraType }
     *     
     */
    public CabeceraType getCabeceraRespuesta() {
        return cabeceraRespuesta;
    }

    /**
     * Sets the value of the cabeceraRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link CabeceraType }
     *     
     */
    public void setCabeceraRespuesta(CabeceraType value) {
        this.cabeceraRespuesta = value;
    }

    /**
     * Gets the value of the infoRespuesta property.
     * 
     * @return
     *     possible object is
     *     {@link InfoRespuestaResType }
     *     
     */
    public InfoRespuestaResType getInfoRespuesta() {
        return infoRespuesta;
    }

    /**
     * Sets the value of the infoRespuesta property.
     * 
     * @param value
     *     allowed object is
     *     {@link InfoRespuestaResType }
     *     
     */
    public void setInfoRespuesta(InfoRespuestaResType value) {
        this.infoRespuesta = value;
    }

}
