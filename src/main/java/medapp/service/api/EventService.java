package medapp.service.api;

import medapp.model.Event;

import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAll();
    Event getById(Long id);
}
