package com.tharsis.event.logic;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;

import com.tharsis.event.domain.Eventtype;
import com.tharsis.persist.RepositoryJPA;
import com.tharsis.util.UtilConstant;

/**
 *
 * @author christian
 */
@RequestScoped
public class EventTypeLogic extends RepositoryJPA<Eventtype, Serializable> {

    public void saveTypeEvent(Eventtype eventType) {
        eventType.setStatus(UtilConstant.ENABLE);
        add(eventType);
    }

    public void updateTypeEvent(Integer id, Eventtype eventType) {
        Eventtype findEventType = findById(Eventtype.class, id);
        eventType.setIdeventtype(findEventType.getIdeventtype());
        update(eventType);
    }

    public void deleteTypeEvent(Integer id) {
        Eventtype findEventType = findById(Eventtype.class, id);
        findEventType.setStatus(UtilConstant.DISABLE);
        update(findEventType);
    }

    public Eventtype findEvenTypeById(Integer id) {
        Eventtype findEventType = findById(Eventtype.class, id);
        return findEventType;
    }

    public List<Eventtype> AllTypeEvent() {
        return findAll("Eventtype.findAll");
    }

}
