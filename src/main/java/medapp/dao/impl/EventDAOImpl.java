package medapp.dao.impl;

import medapp.dao.api.EventDAO;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Component
public class EventDAOImpl implements EventDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addEvent(Event event) {
        entityManager.persist(event);
    }

    @Override
    public List<Event> getAll() {
        List<Event> eventList = entityManager.createQuery("FROM Event").getResultList();
        return eventList;
    }

    @Override
    public Event getById(Long id) {
        Event event = (Event) entityManager.find(Event.class,id);
        return event;
    }
}
