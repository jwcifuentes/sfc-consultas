//
// Generated By:JAX-WS RI IBM 2.2.1-11/25/2013 11:48 AM(foreman)- (JAXB RI IBM 2.2.3-11/25/2013 12:35 PM(foreman)-)
//


package co.com.rbm.esbPignoracion;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CabeceraTipoTransaccionType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CabeceraTipoTransaccionType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="pignorarCuenta"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CabeceraTipoTransaccionType")
@XmlEnum
public enum CabeceraTipoTransaccionType {

    @XmlEnumValue("pignorarCuenta")
    PIGNORAR_CUENTA("pignorarCuenta");
    private final String value;

    CabeceraTipoTransaccionType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CabeceraTipoTransaccionType fromValue(String v) {
        for (CabeceraTipoTransaccionType c: CabeceraTipoTransaccionType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}