
package com.tharsis.info.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element name="sesionValidaReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
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
    "sesionValidaReturn"
})
@XmlRootElement(name = "sesionValidaResponse")
public class SesionValidaResponse {

    protected boolean sesionValidaReturn;

    /**
     * Obtiene el valor de la propiedad sesionValidaReturn.
     * 
     */
    public boolean isSesionValidaReturn() {
        return sesionValidaReturn;
    }

    /**
     * Define el valor de la propiedad sesionValidaReturn.
     * 
     */
    public void setSesionValidaReturn(boolean value) {
        this.sesionValidaReturn = value;
    }

}
