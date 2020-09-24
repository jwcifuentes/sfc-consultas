//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package co.com.rbm.esb.comercio.compra;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.rbm.esb.comercio.compra.TipoRespuesta;
import com.rbm.esb.comercio.compra.TipoSolicitudCompra;

@WebService(name = "MultiCompraElectronica_MsgSetPortType", targetNamespace = "http://www.rbm.com.co/esb/comercio/compra/")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
    com.rbm.esb.ObjectFactory.class,
    com.rbm.esb.comercio.ObjectFactory.class,
    com.rbm.esb.comercio.compra.ObjectFactory.class
})
public interface MultiCompraElectronicaMsgSetPortType {


    /**
     * 
     * @param multiCompraProcesarSolicitud
     * @return
     *     returns co.com.rbm.esb.comercio.compra.TipoRespuesta
     */
    @WebMethod
    @WebResult(name = "multiCompraProcesarRespuesta", targetNamespace = "http://www.rbm.com.co/esb/comercio/compra/", partName = "multiCompraProcesarRespuesta")
    public TipoRespuesta multiCompraProcesar(
        @WebParam(name = "multiCompraProcesarSolicitud", targetNamespace = "http://www.rbm.com.co/esb/comercio/compra/", partName = "multiCompraProcesarSolicitud")
        TipoSolicitudCompra multiCompraProcesarSolicitud);

    /**
     * 
     * @param multiCompraReversarSolicitud
     * @return
     *     returns co.com.rbm.esb.comercio.compra.TipoRespuesta
     */
    @WebMethod
    @WebResult(name = "multiCompraReversarRespuesta", targetNamespace = "http://www.rbm.com.co/esb/comercio/compra/", partName = "multiCompraReversarRespuesta")
    public TipoRespuesta multiCompraReversar(
        @WebParam(name = "multiCompraReversarSolicitud", targetNamespace = "http://www.rbm.com.co/esb/comercio/compra/", partName = "multiCompraReversarSolicitud")
        TipoSolicitudCompra multiCompraReversarSolicitud);

}
