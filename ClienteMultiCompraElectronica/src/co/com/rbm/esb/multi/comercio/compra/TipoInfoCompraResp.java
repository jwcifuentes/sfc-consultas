//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.multi.comercio.compra;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;

import co.com.rbm.esb.multi.TipoInfoAdicional;


/**
 * <p>Java class for TipoInfoCompraResp complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TipoInfoCompraResp">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaTransaccion" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="fechaPosteo" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="numAprobacion" type="{http://www.rbm.com.co/esb/}TipoNumAprobacion"/>
 *         &lt;element name="costoTransaccion" type="{http://www.rbm.com.co/esb/}TipoMonto" minOccurs="0"/>
 *         &lt;element name="infoAdicional" type="{http://www.rbm.com.co/esb/}TipoInfoAdicional" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TipoInfoCompraResp", propOrder = {
    "fechaTransaccion",
    "fechaPosteo",
    "numAprobacion",
    "costoTransaccion",
    "infoAdicional"
})
public class TipoInfoCompraResp {

    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaTransaccion;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar fechaPosteo;
    @XmlElement(required = true)
    protected String numAprobacion;
    protected BigDecimal costoTransaccion;
    protected List<TipoInfoAdicional> infoAdicional;

    /**
     * Gets the value of the fechaTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaTransaccion() {
        return fechaTransaccion;
    }

    /**
     * Sets the value of the fechaTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaTransaccion(XMLGregorianCalendar value) {
        this.fechaTransaccion = value;
    }

    /**
     * Gets the value of the fechaPosteo property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaPosteo() {
        return fechaPosteo;
    }

    /**
     * Sets the value of the fechaPosteo property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaPosteo(XMLGregorianCalendar value) {
        this.fechaPosteo = value;
    }

    /**
     * Gets the value of the numAprobacion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumAprobacion() {
        return numAprobacion;
    }

    /**
     * Sets the value of the numAprobacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumAprobacion(String value) {
        this.numAprobacion = value;
    }

    /**
     * Gets the value of the costoTransaccion property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCostoTransaccion() {
        return costoTransaccion;
    }

    /**
     * Sets the value of the costoTransaccion property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCostoTransaccion(BigDecimal value) {
        this.costoTransaccion = value;
    }

    /**
     * Gets the value of the infoAdicional property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoAdicional property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoAdicional().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TipoInfoAdicional }
     * 
     * 
     */
    public List<TipoInfoAdicional> getInfoAdicional() {
        if (infoAdicional == null) {
            infoAdicional = new ArrayList<TipoInfoAdicional>();
        }
        return this.infoAdicional;
    }

}
