package com.tharsis.info.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Getter
@Setter
public class Data {

    @JsonIgnore
    private String id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    @JsonIgnore
    private String tipoDocumentoId;
    private String sexo;
    @JsonIgnore
    private String fechaNacimiento;
    @JsonIgnore
    private String edad;
    @JsonIgnore
    private String correo;
    @JsonIgnore
    private String correo2;
    @JsonIgnore
    private String celular;
    @JsonIgnore
    private String celular2;
    private String nroDocumento;
    @JsonIgnore
    private String nuevo;
    @JsonIgnore
    private String estadoCivil;
}
