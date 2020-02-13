package com.tharsis.person.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "organizer")
@NamedQueries({
    @NamedQuery(name = "Organizer.findAllActive", query = "SELECT o.person FROM Organizer o WHERE o.person.status = 1"),
    @NamedQuery(name = "Organizer.findByIdorganizer", query = "SELECT o.person FROM Organizer o WHERE o.person.idperson = :idperson AND o.person.status = 1")

})

@Getter
@Setter
public class Organizer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull

    private Integer idorganizer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "password")
    private String password;

//    @JoinColumn(name = "idorganizer", referencedColumnName = "idperson", insertable = false, updatable = false)
    // OneToOne(optional = false)
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "idorganizer", referencedColumnName = "idperson")
    @MapsId
    private Person person;

    public Organizer() {
    }

}
