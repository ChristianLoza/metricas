package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.tharsis.persist.RepositoryJPA;
import com.tharsis.person.auth.Token;
import com.tharsis.person.domain.Person;
import com.tharsis.person.domain.Role;
import com.tharsis.util.UtilCollection;
import com.tharsis.util.UtilEncrypt;

/**
 *
 * @author christian
 */
@RequestScoped
public class PersonLogic extends RepositoryJPA<Person, Serializable> {

    public boolean login(String dni, String password) {

        if (!"".equals(dni) && !"".equals(password)) {
            Map<String, Object> param = new HashMap<>();
            param.put("dni", dni);
            param.put("password", UtilEncrypt.encryptToSha1(password));
            List<Role> role = createNamedQuery("Person.login", param, Role.class).getResultList();
            if (!role.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public String generateToken(String dni, String uriInfo) {
        Map<String, Object> param = new HashMap<>();
        param.put("dni", dni);
        List<Person> person = createNamedQuery("Person.data", param).getResultList();
        Person getPerson = UtilCollection.firstElement(person);
        String tokenGenerated = Token.createToken(getPerson, uriInfo);
        return tokenGenerated;
    }

}
