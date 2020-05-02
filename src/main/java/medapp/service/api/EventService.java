package medapp.service.api;

import medapp.dto.EventDto;
import medapp.dto.FilterDto;
import medapp.dto.PatientDto;
import medapp.model.Event;

import javax.jms.JMSException;
import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<Event> getAll() throws JMSException;
    Event getById(Long id);
    List<EventDto> filter(FilterDto filterDto);
    void update(EventDto eventDto);
    void sendUpdatedEvents() throws JMSException;
    void updateLastNameEvent(Long patientId);
}
