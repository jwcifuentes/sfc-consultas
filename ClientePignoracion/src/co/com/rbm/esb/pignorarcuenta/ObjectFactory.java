//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.pignorarcuenta;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the co.com.rbm.esb.pignorarcuenta package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PignorarCuentaSolicitud_QNAME = new QName("http://www.rbm.com.co/esb/pignorarCuenta", "pignorarCuentaSolicitud");
    private final static QName _PignorarCuentaRespuesta_QNAME = new QName("http://www.rbm.com.co/esb/pignorarCuenta", "pignorarCuentaRespuesta");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: co.com.rbm.esb.pignorarcuenta
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PignorarCuentaRespuestaResType }
     * 
     */
    public PignorarCuentaRespuestaResType createPignorarCuentaRespuestaResType() {
        return new PignorarCuentaRespuestaResType();
    }

    /**
     * Create an instance of {@link PignorarCuentaSolicitudReqType }
     * 
     */
    public PignorarCuentaSolicitudReqType createPignorarCuentaSolicitudReqType() {
        return new PignorarCuentaSolicitudReqType();
    }

    /**
     * Create an instance of {@link InfoTransaccionReqType }
     * 
     */
    public InfoTransaccionReqType createInfoTransaccionReqType() {
        return new InfoTransaccionReqType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PignorarCuentaSolicitudReqType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/pignorarCuenta", name = "pignorarCuentaSolicitud")
    public JAXBElement<PignorarCuentaSolicitudReqType> createPignorarCuentaSolicitud(PignorarCuentaSolicitudReqType value) {
        return new JAXBElement<PignorarCuentaSolicitudReqType>(_PignorarCuentaSolicitud_QNAME, PignorarCuentaSolicitudReqType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PignorarCuentaRespuestaResType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.rbm.com.co/esb/pignorarCuenta", name = "pignorarCuentaRespuesta")
    public JAXBElement<PignorarCuentaRespuestaResType> createPignorarCuentaRespuesta(PignorarCuentaRespuestaResType value) {
        return new JAXBElement<PignorarCuentaRespuestaResType>(_PignorarCuentaRespuesta_QNAME, PignorarCuentaRespuestaResType.class, null, value);
    }

}