//
// Generated By:JAX-WS RI IBM 2.2.1-11/30/2010 12:42 PM(foreman)- (JAXB RI IBM 2.2.3-03/09/2011 06:46 PM(foreman)-)
//


package co.com.rbm.esb.globalpay;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;

@WebService(name = "GlobalPayServicioDePago", targetNamespace = "http://www.rbm.com.co/esb/globalpay/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    co.com.rbm.esb.ObjectFactory.class,
    co.com.rbm.esb.globalpay.ObjectFactory.class
})
public interface GlobalPayServicioDePago {


    /**
     * 
     * @param parameters
     * @return
     *     returns co.com.rbm.esb.globalpay.IniciarTransaccionDeCompraRespuesta
     * @throws IniciarTransaccionDeCompraFaultException
     */
    @WebMethod(operationName = "IniciarTransaccionDeCompra", action = "http://www.rbm.com.co/esb/globalpay/IniciarTransaccionDeCompra")
    @WebResult(name = "IniciarTransaccionDeCompraRespuesta", targetNamespace = "http://www.rbm.com.co/esb/globalpay/", partName = "parameters")
    @Action(input = "http://www.rbm.com.co/esb/globalpay/IniciarTransaccionDeCompra", output = "http://www.rbm.com.co/esb/globalpay/GlobalPayServicioDePago/IniciarTransaccionDeCompraResponse", fault = {
        @FaultAction(className = IniciarTransaccionDeCompraFaultException.class, value = "http://www.rbm.com.co/esb/globalpay/GlobalPayServicioDePago/IniciarTransaccionDeCompra/Fault/IniciarTransaccionDeCompraFault_Exception")
    })
    public IniciarTransaccionDeCompraRespuesta iniciarTransaccionDeCompra(
        @WebParam(name = "IniciarTransaccionDeCompraSolicitud", targetNamespace = "http://www.rbm.com.co/esb/globalpay/", partName = "parameters")
        IniciarTransaccionDeCompraSolicitud parameters)
        throws IniciarTransaccionDeCompraFaultException
    ;

    /**
     * 
     * @param parameters
     * @return
     *     returns co.com.rbm.esb.globalpay.ConsultarEstadoDePagoRespuesta
     * @throws ConsultarEstadoDePagoFaultException
     */
    @WebMethod(operationName = "ConsultarEstadoDePago", action = "http://www.rbm.com.co/esb/globalpay/ConsultarEstadoDePago")
    @WebResult(name = "ConsultarEstadoDePagoRespuesta", targetNamespace = "http://www.rbm.com.co/esb/globalpay/", partName = "parameters")
    @Action(input = "http://www.rbm.com.co/esb/globalpay/ConsultarEstadoDePago", output = "http://www.rbm.com.co/esb/globalpay/GlobalPayServicioDePago/ConsultarEstadoDePagoResponse", fault = {
        @FaultAction(className = ConsultarEstadoDePagoFaultException.class, value = "http://www.rbm.com.co/esb/globalpay/GlobalPayServicioDePago/ConsultarEstadoDePago/Fault/ConsultarEstadoDePagoFault_Exception")
    })
    public ConsultarEstadoDePagoRespuesta consultarEstadoDePago(
        @WebParam(name = "ConsultarEstadoDePagoSolicitud", targetNamespace = "http://www.rbm.com.co/esb/globalpay/", partName = "parameters")
        ConsultarEstadoDePagoSolicitud parameters)
        throws ConsultarEstadoDePagoFaultException
    ;

}
