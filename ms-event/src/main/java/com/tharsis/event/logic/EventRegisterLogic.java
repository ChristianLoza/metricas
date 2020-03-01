package com.tharsis.event.logic;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import com.tharsis.event.domain.Event;
import com.tharsis.event.domain.Eventregister;
import com.tharsis.event.vo.EventRegisterVO;
import com.tharsis.persist.RepositoryJPA;
import com.tharsis.util.UtilConstant;

/**
 *
 * @author christian
 */
@RequestScoped
public class EventRegisterLogic extends RepositoryJPA<Eventregister, Serializable> {

    @Inject
    private EventLogic eventLogic;

    public void saveEventRegister(EventRegisterVO eventRegisterVO) {
        Event event = eventLogic.findEventById(eventRegisterVO.getIdEvent());

        if (event.getStatus() == UtilConstant.ENABLE) {
            Eventregister eventregister = new Eventregister();
            eventregister.setIdevent(event);
            eventregister.setIdstudent(eventRegisterVO.getIdstudent());
            eventregister.setTimeentry(new Date());
            eventregister.setStatus(UtilConstant.ENABLE);
            add(eventregister);
        }
    }
    
    public List<Eventregister> listEventRegisterByStudent(Integer idStudent) {
        Map<String, Object> param = new HashMap<>();
        param.put("idstudent", idStudent);
        List<Eventregister> list = createNamedQuery("Eventregister.findAllbyIdStudent", param).getResultList();
        return list;
    }
    
    public BigDecimal totalCreditsByIdStudent(Integer idStudent) {
        Map<String, Object> param = new HashMap<>();
        param.put("idstudent", idStudent);
        List<BigDecimal> list = createQuery("SELECT distinct(e.credit) FROM Eventregister er JOIN  er.idevent e WHERE er.idstudent = :idstudent AND e.status = 1", param, BigDecimal.class).getResultList();
        BigDecimal result = list.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        return result;
    }
    
    public List<Eventregister> listStudentByIdEvent(Integer idEvent) {
        Map<String, Object> map = new HashMap<>();
        map.put("idevent", idEvent);
        List<Eventregister> list = createNamedQuery("Eventregister.findAllStudentbyEvent", map).getResultList();
        return list;
    }
}
