package com.tharsis.event.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "event")
@NamedQueries({
    @NamedQuery(name = "Event.findAllActive", query = "SELECT e FROM Event e WHERE e.status = 1"),
    @NamedQuery(name = "Event.findAllEventByDate", query = "SELECT e.idevent, e.eventname, e.dateevent, e.credit, e.site, te.name FROM Event e JOIN e.idtypeevent te WHERE e.dateevent >=:datenow AND e.status = 1"),
    @NamedQuery(name = "Event.findExpired", query = "SELECT e FROM Event e WHERE e.status = 3"),
    @NamedQuery(name = "Event.findByIdorganizer", query = "SELECT e FROM Event e WHERE e.idorganizer = :idorganizer AND e.status = 1"),
    @NamedQuery(name = "Event.findAllByType", query = "SELECT e, et FROM Event e JOIN e.idtypeevent et WHERE et.ideventtype =:ideventtype AND e.status = 1"),
    @NamedQuery(name ="Event.findLastEvent", query = "SELECT e FROM Event e WHERE e.status = 1 ORDER BY e.idevent DESC")
})
@Getter
@Setter
public class Event implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idevent")
    private Integer idevent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idorganizer")
    private int idorganizer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "eventname")
    private String eventname;
    @Lob
    @Size(max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateevent")
    @Temporal(TemporalType.DATE)
    private Date dateevent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expireddate")
    @Temporal(TemporalType.DATE)
    private Date expireddate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "credit")
    private BigDecimal credit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "site")
    private String site;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

//    @JsonIgnore
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idevent", fetch = FetchType.LAZY)
//    private List<Eventregister> eventregisterList;
    @JsonIgnore
    @JoinColumn(name = "idtypeevent", referencedColumnName = "ideventtype")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Eventtype idtypeevent;

    public Event() {
    }

}
