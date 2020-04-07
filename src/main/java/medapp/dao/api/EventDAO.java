package medapp.dao.api;

import medapp.model.Event;
import medapp.model.Patient;

import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    void deleteByAssignmentId(Long assignmentId);
    List<Event> getAll();
    Event getById(Long id);
    List<Event> filterByDate();
    List<Event> filterByHour();
    List<Event> filterByPatient(String lastName);
}
