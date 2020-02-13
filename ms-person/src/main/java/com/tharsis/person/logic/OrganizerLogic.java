package com.tharsis.person.logic;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.ms.persist.RepositoryJPA;
import com.ms.util.UtilConstant;
import com.ms.util.UtilEncrypt;
import com.tharsis.person.domain.Organizer;

/**
 *
 * @author christian
 */
@RequestScoped
public class OrganizerLogic extends RepositoryJPA<Organizer, Serializable> {

    @Inject
    private PersonLogic personLogic;

    public void saveOrganizer(Organizer organizer) {
        organizer.setPassword(UtilEncrypt.encryptToSha1(organizer.getPassword()));
        organizer.getPerson().setStatus(UtilConstant.ACTIVO);
        add(organizer);

//        organizer.setIdorganizer(personLogic.savePerson(organizer.getPerson())
//                .getIdperson());
//        organizer.setPassword(UtilEncrypt.encryptToSha1(organizer.getPassword()));
//        add(organizer);
    }

    public void updateOrganizer(Organizer organizer) {
        //Organizer findOrganizer = findById(Organizer.class, organizer.getIdorganizer());
        //personLogic.editPerson(organizer.getPerson());
        organizer.setPassword(UtilEncrypt.encryptToSha1(organizer.getPassword()));
        update(organizer);
    }

    public void deleteOrganizer(Organizer organizer) {
        personLogic.deletePerson(organizer.getPerson());        
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
