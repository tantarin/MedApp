package medapp.service.impl;

import medapp.dao.api.EventDAO;
import medapp.model.Event;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    EventDAO eventDAO;

    @Autowired
    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Override
    public void addEvent(Event event) {
        eventDAO.addEvent(event);
    }

    @Override
    public List<Event> getAll() {
        return eventDAO.getAll();
    }

    @Override
    public Event getById(Long id) {
        return eventDAO.getById(id);
    }

    @Override
    public List<Event> filterByDate() {
        return eventDAO.filterByDate();
    }

    @Override
    public List<Event> filterByHour() {
        return eventDAO.filterByHour();
    }

    @Override
    @Transactional
    public List<Event> filterByPatient(Integer id) {
        return eventDAO.filterByPatient(id);
    }
}
