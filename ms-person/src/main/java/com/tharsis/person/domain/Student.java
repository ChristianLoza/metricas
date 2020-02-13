package com.tharsis.person.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAllActive", query = "SELECT s.person FROM Student s WHERE s.person.status = 1"),
    @NamedQuery(name = "Student.findByIdstudent", query = "SELECT s.person FROM Student s WHERE s.person.idperson = :idperson AND s.person.status = 1"),
    @NamedQuery(name = "Student.findByDnistudent", query = "SELECT s.person FROM Student s WHERE s.person.dni = :dni AND s.person.status = 1")
})

@Getter
@Setter
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idstudent")
    private Integer idstudent;
    @JoinColumn(name = "idstudent", referencedColumnName = "idperson", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Person person;

    public Student() {
    }
}
