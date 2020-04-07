
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
 *         &lt;element name="setContrasenav2Return" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "setContrasenav2Return"
})
@XmlRootElement(name = "setContrasenav2Response")
public class SetContrasenav2Response {

    @XmlElement(required = true)
    protected String setContrasenav2Return;

    /**
     * Obtiene el valor de la propiedad setContrasenav2Return.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSetContrasenav2Return() {
        return setContrasenav2Return;
    }

    /**
     * Define el valor de la propiedad setContrasenav2Return.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSetContrasenav2Return(String value) {
        this.setContrasenav2Return = value;
    }

}
