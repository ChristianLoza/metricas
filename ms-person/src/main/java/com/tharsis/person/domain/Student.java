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
    @NamedQuery(name = "Student.findAllActive", query = "SELECT p.idperson, p.name, p.lastname, p.phone, p.email  FROM Student s JOIN s.person p  WHERE p.status = 1"),
    @NamedQuery(name = "Student.findByIdstudent", query = "SELECT p.idperson, p.name, p.lastname, p.phone, p.email  FROM Student s JOIN s.person p WHERE p.idperson = :idperson AND p.status = 1"),
    @NamedQuery(name = "Student.findByDnistudent", query = "SELECT p.idperson, p.name, p.lastname, p.phone, p.email  FROM Student s JOIN s.person p WHERE p.dni = :dni AND p.status = 1"),
    @NamedQuery(name = "Student.finIdByNfc", query = "SELECT s.person.idperson FROM Student s WHERE s.idnfc = :idnfc AND s.person.status = 1")
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
    private Integer idStudent;
    @NotNull
    @Column(name = "idnfc")
    private String idNfc;
    @JoinColumn(name = "idstudent", referencedColumnName = "idperson")
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId
    private Person person;

    public Student() {
    }
}
