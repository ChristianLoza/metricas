package com.tharsis.event.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "eventtype")
@NamedQueries({
    @NamedQuery(name = "Eventtype.findAll", query = "SELECT e FROM Eventtype e WHERE e.status = 1"),
    @NamedQuery(name = "Eventtype.findByIdeventtype", query = "SELECT e FROM Eventtype e WHERE e.ideventtype = :ideventtype"),
    @NamedQuery(name = "Eventtype.findByName", query = "SELECT e FROM Eventtype e WHERE e.name = :name"),
    @NamedQuery(name = "Eventtype.findByStatus", query = "SELECT e FROM Eventtype e WHERE e.status = :status")})
@Data
@Getter
@Setter
public class Eventtype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ideventtype")
    private Integer ideventtype;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idtypeevent", fetch = FetchType.EAGER)
//    private List<Event> eventList;

    public Eventtype() {
    }
}
