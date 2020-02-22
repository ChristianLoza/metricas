package com.tharsis.person.logic;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;

import com.tharsis.persist.RepositoryJPA;
import com.tharsis.person.domain.Person;
import com.tharsis.util.UtilConstant;

/**
 *
 * @author christian
 */
@RequestScoped
public class PersonLogic extends RepositoryJPA<Person, Serializable> {
    
    public Person savePerson(Person person) {
        person.setStatus(UtilConstant.ENABLE);
        return add(person);
    }

    public Person editPerson(Person person) {
        return update(person);
    }

    public Person deletePerson(Person person) {
        person.setStatus(UtilConstant.DISABLE);
        return update(person);
    }

    public Person findPerson(Integer id) {
        return findById(Person.class, id);
    }

}
