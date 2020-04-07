package com.tharsis.info.service;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Clase Java para anonymous complex type.
 *
 * <p>
 * El siguiente fragmento de esquema especifica el contenido que se espera que
 * haya en esta clase.
 *
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dni"
})
@XmlRootElement(name = "getInformacion")
public class GetInformacion {

    @XmlElement(required = true)
    protected String dni;

    /**
     * Obtiene el valor de la propiedad dni.
     *
     * @return possible object is {@link String }
     *
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setDni(String value) {
        this.dni = value;
    }

}
