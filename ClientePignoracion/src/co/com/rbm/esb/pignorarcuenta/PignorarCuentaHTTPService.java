//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esb.pignorarcuenta;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "pignorarCuenta_HTTP_Service", targetNamespace = "http://www.rbm.com.co/esb/pignorarCuenta", wsdlLocation = "META-INF/wsdl/pignorarCuenta.wsdl")
public class PignorarCuentaHTTPService
    extends Service
{

    private final static URL PIGNORARCUENTAHTTPSERVICE_WSDL_LOCATION;
    private final static WebServiceException PIGNORARCUENTAHTTPSERVICE_EXCEPTION;
    private final static QName PIGNORARCUENTAHTTPSERVICE_QNAME = new QName("http://www.rbm.com.co/esb/pignorarCuenta", "pignorarCuenta_HTTP_Service");

    static {
            PIGNORARCUENTAHTTPSERVICE_WSDL_LOCATION = co.com.rbm.esb.pignorarcuenta.PignorarCuentaHTTPService.class.getResource("/META-INF/wsdl/pignorarCuenta.wsdl");
        WebServiceException e = null;
        if (PIGNORARCUENTAHTTPSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/pignorarCuenta.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        PIGNORARCUENTAHTTPSERVICE_EXCEPTION = e;
    }

    public PignorarCuentaHTTPService() {
        super(__getWsdlLocation(), PIGNORARCUENTAHTTPSERVICE_QNAME);
    }

    public PignorarCuentaHTTPService(WebServiceFeature... features) {
        super(__getWsdlLocation(), PIGNORARCUENTAHTTPSERVICE_QNAME, features);
    }

    public PignorarCuentaHTTPService(URL wsdlLocation) {
        super(wsdlLocation, PIGNORARCUENTAHTTPSERVICE_QNAME);
    }

    public PignorarCuentaHTTPService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, PIGNORARCUENTAHTTPSERVICE_QNAME, features);
    }

    public PignorarCuentaHTTPService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public PignorarCuentaHTTPService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns PignorarCuentaPortType
     */
    @WebEndpoint(name = "pignorarCuenta_HTTP_Port")
    public PignorarCuentaPortType getPignorarCuentaHTTPPort() {
        return super.getPort(new QName("http://www.rbm.com.co/esb/pignorarCuenta", "pignorarCuenta_HTTP_Port"), PignorarCuentaPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns PignorarCuentaPortType
     */
    @WebEndpoint(name = "pignorarCuenta_HTTP_Port")
    public PignorarCuentaPortType getPignorarCuentaHTTPPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.rbm.com.co/esb/pignorarCuenta", "pignorarCuenta_HTTP_Port"), PignorarCuentaPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (PIGNORARCUENTAHTTPSERVICE_EXCEPTION!= null) {
            throw PIGNORARCUENTAHTTPSERVICE_EXCEPTION;
        }
        return PIGNORARCUENTAHTTPSERVICE_WSDL_LOCATION;
    }

}
