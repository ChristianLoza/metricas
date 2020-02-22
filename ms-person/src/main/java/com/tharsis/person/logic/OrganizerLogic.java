package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;

import com.tharsis.persist.RepositoryJPA;
import com.tharsis.person.domain.Organizer;
import com.tharsis.util.UtilConstant;
import com.tharsis.util.UtilEncrypt;

/**
 *
 * @author christian
 */
@RequestScoped
public class OrganizerLogic extends RepositoryJPA<Organizer, Serializable> {

    public void saveOrganizer(Organizer organizer) {
        organizer.getPerson().setPassword(UtilEncrypt.encryptToSha1(organizer.getPerson().getPassword()));
        organizer.getPerson().setStatus(UtilConstant.ENABLE);
        add(organizer);
    }

    public void updateOrganizer(int id, Organizer organizer) {
        Organizer findOrganizer = findById(Organizer.class, id);
        organizer.setIdOrganizer(findOrganizer.getIdOrganizer());
        organizer.getPerson().setIdPerson(findOrganizer.getPerson().getIdPerson());
        if((organizer.getPerson().getPassword().equals("")))
            organizer.getPerson().setPassword(findOrganizer.getPerson().getPassword());
        else
            organizer.getPerson().setPassword(UtilEncrypt.encryptToSha1(organizer.getPerson().getPassword()));                
        update(organizer);
    }

    public void deleteOrganizer(int id) {
        Organizer organizer = findById(Organizer.class, id);
        organizer.getPerson().setStatus(UtilConstant.DISABLE);
        update(organizer);
    }

    public List<Organizer> findOrganizer(Integer id) {  
        Map<String, Object> param = new HashMap<>();
        param.put("idperson", id);

        List<Organizer> list = createNamedQuery("Organizer.findByIdorganizer", param)
                .setMaxResults(1)
                .getResultList();

        return list;
    }

    public List<Organizer> allOrganizer() {
        return findAll("Organizer.findAllActive");
    }

    public List<Organizer> allOrganizer(int limit) {
        return findAll("Organizer.findAllActive", limit);
    }
}
