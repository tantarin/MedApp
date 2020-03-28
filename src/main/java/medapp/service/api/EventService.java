package medapp.service.api;

import medapp.model.Event;

import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAll();
    Event getById(Long id);
    List<Event> filterByDate();
    List<Event> filterByHour();
    List<Event> filterByPatient(Integer id);
}
