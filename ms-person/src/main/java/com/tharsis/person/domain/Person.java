package com.tharsis.person.domain;

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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name="Person.login", query="SELECT p.role FROM Person p WHERE p.dni = :dni AND p.password = :password AND p.status = 1")
})
@Getter
@Setter
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idperson")
    @JsonIgnore
    private Integer idPerson;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "lastname")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "dni")
    private String dni;
    @NotNull
    @Size(min = 1, max = 100)
    private String password;
    @Size(max = 15)
    @Column(name = "phone")
    private String phone;
    @Size(max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    @JsonIgnore
    private int status;

//    @JsonIgnore
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
//    private Student student;

    //@JsonIgnore
    //@OneToOne(cascade = CascadeType.ALL, mappedBy = "person", fetch = FetchType.LAZY)
    //private Organizer organizer;
    public Person() {
    }
}
