package medapp.dao.api;

import medapp.model.Event;
import medapp.model.Patient;

import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    List<Event> getAll();
    Event getById(Long id);
    List<Event> filterByDate();
    List<Event> filterByHour();
    List<Event> filterByPatient(Integer id);
    void deleteFromToday(Long patientId);
}
