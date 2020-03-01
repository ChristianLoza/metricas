package com.tharsis.event.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "eventregister")
@NamedQueries({
    @NamedQuery(name="Eventregister.findAllbyIdStudent",query="SELECT DISTINCT e.eventname, e.credit, e.dateevent FROM Eventregister er JOIN er.idevent e WHERE er.idstudent = :idstudent AND e.status = 1"),
    @NamedQuery(name="Eventregister.findAllStudentbyEvent", query ="SELECT DISTINCT(er.idstudent) FROM Eventregister er JOIN er.idevent e JOIN er.idevent e WHERE e.idevent =:idevent")
})
@Getter
@Setter
public class Eventregister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideventregister")
    private Integer ideventregister;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstudent")
    private int idstudent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timeentry")
    @Temporal(TemporalType.TIME)
    private Date timeentry;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinColumn(name = "idevent", referencedColumnName = "idevent")
    //@ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Event idevent;

    public Eventregister() {
    }

}
