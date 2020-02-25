package com.tharsis.event.vo;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Getter
@Setter
public class EventVO {
    private Integer idTypeEvent;
    
    private Integer idEvent;
    private int idorganizer;
    private String eventname;
    private String description;
    private Date dateevent;
    private Date expireddate;
    private BigDecimal credit;
    private String site;
}
