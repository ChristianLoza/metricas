package com.tharsis.person.logic;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import com.ms.persist.RepositoryJPA;
import com.ms.util.UtilConstant;
import com.tharsis.person.domain.Person;

/**
 *
 * @author christian
 */
@RequestScoped
public class PersonLogic extends RepositoryJPA<Person, Serializable> {

    public Person savePerson(Person person) {        
        person.setStatus(UtilConstant.ACTIVO);
        return add(person);
    }

    public Person editPerson(Person person) {
        return update(person);
    }

    public Person deletePerson(Person person) {
        person.setStatus(UtilConstant.INACTIVO);
        return update(person);
    }

    public Person findPerson(Integer id) {
        return findById(Person.class, id);
    }

}
