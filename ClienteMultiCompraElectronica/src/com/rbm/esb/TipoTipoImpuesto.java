//
// Generated By:JAX-WS RI IBM 2.2.1-11/28/2011 08:28 AM(foreman)- (JAXB RI IBM 2.2.3-11/28/2011 06:21 AM(foreman)-)
//


package com.rbm.esb;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TipoTipoImpuesto.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTipoImpuesto">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="IVA"/>
 *     &lt;enumeration value="Consumo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TipoTipoImpuesto")
@XmlEnum
public enum TipoTipoImpuesto {

    IVA("IVA"),
    @XmlEnumValue("Consumo")
    CONSUMO("Consumo");
    private final String value;

    TipoTipoImpuesto(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TipoTipoImpuesto fromValue(String v) {
        for (TipoTipoImpuesto c: TipoTipoImpuesto.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}