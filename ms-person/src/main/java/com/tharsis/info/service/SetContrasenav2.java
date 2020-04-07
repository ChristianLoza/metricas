
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
 *         &lt;element name="dni" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="contrasena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nuevaContrasena" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="navegador" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ip" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="ubicacion" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="firebaseid" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "dni",
    "contrasena",
    "nuevaContrasena",
    "navegador",
    "ip",
    "ubicacion",
    "firebaseid"
})
@XmlRootElement(name = "setContrasenav2")
public class SetContrasenav2 {

    @XmlElement(required = true)
    protected String dni;
    @XmlElement(required = true)
    protected String contrasena;
    @XmlElement(required = true)
    protected String nuevaContrasena;
    @XmlElement(required = true)
    protected String navegador;
    @XmlElement(required = true)
    protected String ip;
    @XmlElement(required = true)
    protected String ubicacion;
    @XmlElement(required = true)
    protected String firebaseid;

    /**
     * Obtiene el valor de la propiedad dni.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDni() {
        return dni;
    }

    /**
     * Define el valor de la propiedad dni.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDni(String value) {
        this.dni = value;
    }

    /**
     * Obtiene el valor de la propiedad contrasena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Define el valor de la propiedad contrasena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContrasena(String value) {
        this.contrasena = value;
    }

    /**
     * Obtiene el valor de la propiedad nuevaContrasena.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNuevaContrasena() {
        return nuevaContrasena;
    }

    /**
     * Define el valor de la propiedad nuevaContrasena.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNuevaContrasena(String value) {
        this.nuevaContrasena = value;
    }

    /**
     * Obtiene el valor de la propiedad navegador.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNavegador() {
        return navegador;
    }

    /**
     * Define el valor de la propiedad navegador.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNavegador(String value) {
        this.navegador = value;
    }

    /**
     * Obtiene el valor de la propiedad ip.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIp() {
        return ip;
    }

    /**
     * Define el valor de la propiedad ip.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIp(String value) {
        this.ip = value;
    }

    /**
     * Obtiene el valor de la propiedad ubicacion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUbicacion() {
        return ubicacion;
    }

    /**
     * Define el valor de la propiedad ubicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUbicacion(String value) {
        this.ubicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad firebaseid.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirebaseid() {
        return firebaseid;
    }

    /**
     * Define el valor de la propiedad firebaseid.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirebaseid(String value) {
        this.firebaseid = value;
    }

}
