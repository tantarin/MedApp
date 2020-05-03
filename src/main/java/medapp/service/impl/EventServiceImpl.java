package medapp.service.impl;

import medapp.activemq.JmsClient;
import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.EventDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.EventDto;
import medapp.dto.FilterDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.EventService;
import org.apache.log4j.spi.TriggeringEventEvaluator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {

    EventDAO eventDAO;
    PatientDAO patientDAO;

    @Autowired
    JmsClient jsmClient;

    @Autowired
    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void addEvent(Event event) {
        eventDAO.addEvent(event);
    }

    /**
     * Get all events through dao and send
     * events to queue.
     *
     * @return
     * @throws JMSException
     */
    @Override
    @Transactional
    public List<EventDto> getAll() throws JMSException {
        sendUpdatedEvents();
        List<Event> events = eventDAO.getAll();
        List<EventDto> eventDtoList = new ArrayList<>();
        for (Event e : events) {
            EventDto eventDto = convertEventToEventDto(e);
            eventDtoList.add(eventDto);
        }
        return eventDtoList;
    }

    /**
     * Get event by event's id through dao.
     *
     * @param id
     * @return
     */
    @Override
    public EventDto getById(Long id) {
        Event event = eventDAO.getById(id);
        return convertEventToEventDto(event);
    }

    /**
     * Filter table of events by Patient's last name
     * or by by day or by time.
     *
     * @param filterDto
     * @return List<EventDto>
     */
    @Override
    public List<EventDto> filter(FilterDto filterDto) {
        List<Event> events = eventDAO.getAll();
        if (!filterDto.getByPatient().equals("")) events = eventDAO.filterByPatient(filterDto.getByPatient());
        if (!filterDto.getByDay().equals("no filter")) events = eventDAO.filterByDate();
        if (!filterDto.getByHour().equals("no filter")) events = eventDAO.filterByHour();
        List<EventDto> eventDtos = new ArrayList<>();
        for (Event e : events) {
            EventDto eventDto = convertEventToEventDto(e);
            eventDtos.add(eventDto);
        }
        return eventDtos;
    }

    /**
     * Update Event when add new comment to event.
     *
     * @param eventDto
     */
    @Override
    @Transactional
    public void update(EventDto eventDto) {
        Event e = eventDAO.getById(eventDto.getId());
        e.setComments(eventDto.getComments());
        e.setStatus(eventDto.getStatus());
        eventDAO.update(e);
    }

    /**
     * Convert all events to eventDtos
     * and send to queue.
     *
     * @throws JMSException
     */
    @Override
    @Transactional
    public void sendUpdatedEvents() throws JMSException {
        List<EventDto> eventDtoList = new ArrayList<>();
        List<Event> events = eventDAO.filterByDate();
        for (Event e : events) {
            EventDto eventDto = convertEventToEventDto(e);
            eventDtoList.add(eventDto);
        }
        jsmClient.sendListEvents(eventDtoList);
    }

    /**
     * When edit patient last name,
     * then also update patient's last name in
     * table of events.
     *
     * @param patientId
     */
    @Override
    @Transactional
    public void updateLastNameEvent(Long patientId) {
        String lastName = patientDAO.getById(patientId).getLastName();
        List<Assignment> assignmentList = patientDAO.getAssignments(patientId);
        for (Assignment a : assignmentList) {
            Long assId = a.getId();
            List<Event> eventList = eventDAO.getByAssignmentId(assId);
            for (Event e : eventList) {
                e.setPatientName(lastName);
                eventDAO.update(e);
            }
        }
    }

    public EventDto convertEventToEventDto(Event event){
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setAssignmentName(event.getAssignment().getName());
        eventDto.setDate(event.getDate());
        eventDto.setTime(event.getTime());
        eventDto.setPatientName(event.getPatientName());
        eventDto.setStatus(event.getStatus());
        eventDto.setComments(event.getComments());
        return eventDto;
    }


}

