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
    @NamedQuery(name = "Eventregister.findAll", query = "SELECT e FROM Eventregister e"),
    @NamedQuery(name = "Eventregister.findByIdeventregister", query = "SELECT e FROM Eventregister e WHERE e.ideventregister = :ideventregister"),
    @NamedQuery(name = "Eventregister.findByIdstudent", query = "SELECT e FROM Eventregister e WHERE e.idstudent = :idstudent"),
    @NamedQuery(name = "Eventregister.findByTimeentry", query = "SELECT e FROM Eventregister e WHERE e.timeentry = :timeentry"),
    @NamedQuery(name = "Eventregister.findByStatus", query = "SELECT e FROM Eventregister e WHERE e.status = :status")})
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
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Event idevent;

    public Eventregister() {
    }

}
