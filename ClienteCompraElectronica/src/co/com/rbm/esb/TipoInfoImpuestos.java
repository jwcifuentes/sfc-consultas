//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoInfoImpuestos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoImpuestos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="tipoImpuesto" type="{http://www.rbm.com.co/esb/}TipoTipoImpuesto"/>
 *         &lt;element name="monto" type="{http://www.rbm.com.co/esb/}TipoMonto"/>
 *         &lt;element name="baseImpuesto" type="{http://www.rbm.com.co/esb/}TipoMonto" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoImpuestos", propOrder = {
    "tipoImpuesto",
    "monto",
    "baseImpuesto"
})
public class TipoInfoImpuestos {

    @XmlElement(required = true)
    protected TipoTipoImpuesto tipoImpuesto;
    @XmlElement(required = true)
    protected BigDecimal monto;
    protected BigDecimal baseImpuesto;

    /**
     * Gets the value of the tipoImpuesto property.
     * 
     * @return
     *     possible object is
     *     {@link TipoTipoImpuesto }
     *     
     */
    public TipoTipoImpuesto getTipoImpuesto() {
        return tipoImpuesto;
    }

    /**
     * Sets the value of the tipoImpuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTipoImpuesto }
     *     
     */
    public void setTipoImpuesto(TipoTipoImpuesto value) {
        this.tipoImpuesto = value;
    }

    /**
     * Gets the value of the monto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * Sets the value of the monto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMonto(BigDecimal value) {
        this.monto = value;
    }

    /**
     * Gets the value of the baseImpuesto property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getBaseImpuesto() {
        return baseImpuesto;
    }

    /**
     * Sets the value of the baseImpuesto property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setBaseImpuesto(BigDecimal value) {
        this.baseImpuesto = value;
    }

}
