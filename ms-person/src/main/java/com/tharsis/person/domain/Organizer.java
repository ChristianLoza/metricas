package com.tharsis.person.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "organizer")
@NamedQueries({
    @NamedQuery(name = "Organizer.findAllActive", query = "SELECT p.idperson, p.dni, p.name, p.lastname, p.phone, p.email FROM Organizer o JOIN o.person p WHERE p.status = 1"),
    @NamedQuery(name = "Organizer.findByIdorganizer", query = "SELECT NEW com.tharsis.person.domain.Organizer(p.idperson, p.dni, p.name, p.lastname, p.phone, p.email) FROM Organizer o JOIN o.person p WHERE p.idperson = :idperson AND p.status = 1")

})

@Getter
@Setter
public class Organizer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    private Integer idorganizer;

//    @JoinColumn(name = "idorganizer", referencedColumnName = "idperson", insertable = false, updatable = false)
    // OneToOne(optional = false)
    @JoinColumn(name = "idorganizer", referencedColumnName = "idperson")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    private Person person;

    public Organizer() {
    }
    //Organizer.findAllActive
    public Organizer(Integer idperson, String dni, String name, String lastname, String phone, String email) {
        this.setPerson(new Person());
        this.getPerson().setIdperson(idperson);
        this.getPerson().setDni(dni);
        this.getPerson().setName(name);
        this.getPerson().setLastname(lastname);
        this.getPerson().setPhone(phone);
        this.getPerson().setEmail(email);
    }

}
