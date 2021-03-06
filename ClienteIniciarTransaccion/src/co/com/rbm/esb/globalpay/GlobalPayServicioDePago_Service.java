//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "GlobalPayServicioDePago", targetNamespace = "http://www.rbm.com.co/esb/globalpay/", wsdlLocation = "META-INF/wsdl/GlobalPayServicioDePago.wsdl")
public class GlobalPayServicioDePago_Service
    extends Service
{

    private final static URL GLOBALPAYSERVICIODEPAGO_WSDL_LOCATION;
    private final static WebServiceException GLOBALPAYSERVICIODEPAGO_EXCEPTION;
    private final static QName GLOBALPAYSERVICIODEPAGO_QNAME = new QName("http://www.rbm.com.co/esb/globalpay/", "GlobalPayServicioDePago");

    static {
            GLOBALPAYSERVICIODEPAGO_WSDL_LOCATION = co.com.rbm.esb.globalpay.GlobalPayServicioDePago_Service.class.getResource("/META-INF/wsdl/GlobalPayServicioDePago.wsdl");
        WebServiceException e = null;
        if (GLOBALPAYSERVICIODEPAGO_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'META-INF/wsdl/GlobalPayServicioDePago.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        GLOBALPAYSERVICIODEPAGO_EXCEPTION = e;
    }

    public GlobalPayServicioDePago_Service() {
        super(__getWsdlLocation(), GLOBALPAYSERVICIODEPAGO_QNAME);
    }

    public GlobalPayServicioDePago_Service(WebServiceFeature... features) {
        super(__getWsdlLocation(), GLOBALPAYSERVICIODEPAGO_QNAME, features);
    }

    public GlobalPayServicioDePago_Service(URL wsdlLocation) {
        super(wsdlLocation, GLOBALPAYSERVICIODEPAGO_QNAME);
    }

    public GlobalPayServicioDePago_Service(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, GLOBALPAYSERVICIODEPAGO_QNAME, features);
    }

    public GlobalPayServicioDePago_Service(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public GlobalPayServicioDePago_Service(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns GlobalPayServicioDePago
     */
    @WebEndpoint(name = "GlobalPayServicioDePagoSOAP")
    public GlobalPayServicioDePago getGlobalPayServicioDePagoSOAP() {
        return super.getPort(new QName("http://www.rbm.com.co/esb/globalpay/", "GlobalPayServicioDePagoSOAP"), GlobalPayServicioDePago.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns GlobalPayServicioDePago
     */
    @WebEndpoint(name = "GlobalPayServicioDePagoSOAP")
    public GlobalPayServicioDePago getGlobalPayServicioDePagoSOAP(WebServiceFeature... features) {
        return super.getPort(new QName("http://www.rbm.com.co/esb/globalpay/", "GlobalPayServicioDePagoSOAP"), GlobalPayServicioDePago.class, features);
    }

    private static URL __getWsdlLocation() {
        if (GLOBALPAYSERVICIODEPAGO_EXCEPTION!= null) {
            throw GLOBALPAYSERVICIODEPAGO_EXCEPTION;
        }
        return GLOBALPAYSERVICIODEPAGO_WSDL_LOCATION;
    }

}
