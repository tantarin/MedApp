package medapp.service.impl;

import medapp.activemq.JmsClient;
import medapp.dao.api.EventDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.EventDto;
import medapp.dto.FilterDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.api.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    @Transactional
    public List<Event> getAll() {
        return eventDAO.getAll();
    }

    @Override
    public Event getById(Long id) {
        return eventDAO.getById(id);
    }

    @Override
    public List<EventDto> filter(FilterDto filterDto) {
        List<Event> events = eventDAO.getAll();
            if (!filterDto.getByPatient().equals("")) events = eventDAO.filterByPatient(filterDto.getByPatient());
            if (!filterDto.getByDay().equals("no filter")) events = eventDAO.filterByDate();
            if (!filterDto.getByHour().equals("no filter")) events = eventDAO.filterByHour();
        List<EventDto> eventDtos = new ArrayList<>();
        for(Event e:events){
            EventDto eventDto = new EventDto();
            eventDto.setId(e.getId());
            eventDto.setAssignmentName(e.getAssignment().getName());
            eventDto.setDate(e.getDate());
            eventDto.setTime(e.getTime());
            eventDto.setPatientName(e.getPatientName());
            eventDto.setStatus(e.getStatus());
            eventDto.setComments(e.getComments());
            eventDtos.add(eventDto);
        }
        return eventDtos;
    }

    @Override
    @Transactional
    public void update(EventDto eventDto) {
        Event e = eventDAO.getById(eventDto.getId());
        e.setComments(eventDto.getComments());
        e.setStatus(eventDto.getStatus());
        eventDAO.update(e);
    }
}

