package com.tharsis.event.logic;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tharsis.event.domain.Event;
import com.tharsis.event.util.Constant;
import com.tharsis.event.vo.EventVO;
import com.tharsis.persist.RepositoryJPA;
import com.tharsis.util.UtilCollection;
import com.tharsis.util.UtilConstant;
import com.tharsis.util.UtilDate;
import com.tharsis.util.UtilObject;

/**
 *
 * @author christian
 */
@RequestScoped
public class EventLogic extends RepositoryJPA<Event, Serializable> {

    @Inject
    private EventTypeLogic eventTypeLogic;

    public void saveEvent(EventVO eventVO) {
        eventVO.setIdEvent(null);
        Event event = UtilObject.objeto(eventVO, Event.class);
        event.setStatus(UtilConstant.ENABLE);
        event.setIdtypeevent(eventTypeLogic
                .findEvenTypeById(eventVO.getIdTypeEvent()));
        add(event);
    }

    public void updateEvent(EventVO eventVO) {
        Event eventFind = UtilObject.objeto(eventVO, Event.class);
        eventFind.setIdevent(eventVO.getIdEvent());
        eventFind.setIdtypeevent(eventTypeLogic
                .findEvenTypeById(eventVO.getIdTypeEvent()));
        eventFind.setStatus(UtilConstant.ENABLE);
        update(eventFind);
    }

    public Event findEventById(Integer id) {
        return findById(Event.class, id);
    }

    public void deleteEvent(Integer idEvent) {
        Event findEvent = findById(Event.class, idEvent);
        findEvent.setStatus(UtilConstant.DISABLE);
        update(findEvent);
    }

    public List<Event> allEventByIdOrganizer(Integer IdOrganizer) {
        Map<String, Object> param = new HashMap<>();
        param.put("idorganizer", IdOrganizer);
        List<Event> list = createNamedQuery("Event.findByIdorganizer", param)
                .getResultList();
        return list;
    }

    public List<Event> allActiveEventByTypeEvent(Integer idTypeEvent) {
        Map<String, Object> param = new HashMap<>();
        param.put("ideventtype", idTypeEvent);
        List<Event> list = createNamedQuery("Event.findAllByType", param)
                .getResultList();
        return list;
    }

    public List<Event> allActiveEvent() {
        return findAll("Event.findAllActive");
    }

    public List<Event> allExpiredEvent() {
        return findAll("Event.findExpired");
    }

    public List<Event> findAllEventByDate() {
        Map<String, Object> param = new HashMap<>();
        param.put("datenow", new Date());
        List<Event> list = createNamedQuery("Event.findAllEventByDate", param)
                .getResultList();
        return list;
    }

    public Event findLastEvent() {
        List<Event> list = createNamedQuery("Event.findLastEvent", null)
                .setMaxResults(1)
                .getResultList();
        Event event = UtilCollection.firstElement(list);
        return event;
    }

    private void checkexpiredEvent() {
        List<Event> activeEvent = allActiveEvent();
        for (Event event : activeEvent) {
            if (event.getExpireddate().equals(UtilDate.getDateNow())) {
                event.setStatus(UtilConstant.DISABLE);
                update(event);
            }
        }
    }

    @PostConstruct
    public void init() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                checkexpiredEvent();
            }
        }, Constant.SIX_HOURS);
    }

}
