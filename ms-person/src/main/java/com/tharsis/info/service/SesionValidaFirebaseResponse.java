
package com.tharsis.info.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para anonymous complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="sesionValidaFirebaseReturn" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "sesionValidaFirebaseReturn"
})
@XmlRootElement(name = "sesionValidaFirebaseResponse")
public class SesionValidaFirebaseResponse {

    @XmlElement(required = true)
    protected String sesionValidaFirebaseReturn;

    /**
     * Obtiene el valor de la propiedad sesionValidaFirebaseReturn.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSesionValidaFirebaseReturn() {
        return sesionValidaFirebaseReturn;
    }

    /**
     * Define el valor de la propiedad sesionValidaFirebaseReturn.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSesionValidaFirebaseReturn(String value) {
        this.sesionValidaFirebaseReturn = value;
    }

}
