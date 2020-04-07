package com.tharsis.info.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Getter
@Setter
public class RucVo {
    
    @JsonIgnore
    private int status;
    private String msg;
    private String ruc;
    private String razonSocial;
    private String direccion;
    private String ubigeo;
}
