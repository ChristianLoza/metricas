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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author christian
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAllActive", query = "SELECT p.idperson, p.dni, p.name, p.lastname, p.phone, p.email  FROM Student s JOIN s.person p  WHERE p.status = 1"),
    @NamedQuery(name = "Student.findAllById", query = "SELECT p.idperson, p.dni, p.name, p.lastname, p.phone, p.email  FROM Student s JOIN s.person p  WHERE p.status = 1 AND p.idperson = :idperson"),
    @NamedQuery(name = "Student.findByIdstudent", query = "SELECT NEW com.tharsis.person.domain.Student(p.idperson, p.dni, p.name, p.lastname, p.phone, p.email, p.status) FROM Student s JOIN s.person p WHERE p.idperson =:idperson AND p.status = 1"),
    @NamedQuery(name = "Student.findByDnistudent", query = "SELECT NEW  com.tharsis.person.domain.Student(s.idnfc,p.idperson, p.dni, p.name, p.lastname, p.phone, p.email)  FROM Student s JOIN s.person p WHERE p.dni = :dni AND p.status = 1"),
    @NamedQuery(name = "Student.finIdByNfc", query = "SELECT p.idperson FROM Student s JOIN s.person p WHERE s.idnfc = :idnfc AND s.person.status = 1")
})

@Getter
@Setter
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstudent")
    @JsonIgnore
    private Integer idstudent;
    @NotNull
    @Column(name = "idnfc")
    private String idnfc;
    @JoinColumn(name = "idstudent", referencedColumnName = "idperson")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    private Person person;

    public Student() {
    }

    //Student.findByIdstudent
    public Student(Integer idperson, String dni, String name, String lastname, String phone, String email, Integer status) {
        this.setPerson(new Person());
        this.getPerson().setIdperson(idperson);
        this.getPerson().setDni(dni);
        this.getPerson().setName(name);
        this.getPerson().setLastname(lastname);
        this.getPerson().setPhone(phone);
        this.getPerson().setEmail(email);
        this.getPerson().setStatus(status);
    }

    public Student(Integer idperson, String dni, String name, String lastname, String phone, String email) {
        this.setPerson(new Person());
        this.getPerson().setIdperson(idperson);
        this.getPerson().setDni(dni);
        this.getPerson().setName(name);
        this.getPerson().setLastname(lastname);
        this.getPerson().setPhone(phone);
        this.getPerson().setEmail(email);
    }

    //Student.findByDnistudent
    public Student(String idnfc, Integer idperson, String dni, String name, String lastName, String phone, String email) {
        this.setIdnfc(idnfc);
        this.setPerson(new Person());
        this.getPerson().setIdperson(idperson);
        this.getPerson().setDni(dni);
        this.getPerson().setName(name);
        this.getPerson().setLastname(lastName);
        this.getPerson().setPhone(phone);
        this.getPerson().setEmail(email);
    }
}
