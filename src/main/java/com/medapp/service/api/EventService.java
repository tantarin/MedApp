package com.medapp.service.api;

import com.medapp.dto.EventDto;
import com.medapp.dto.FilterDto;
import com.medapp.model.Event;

import javax.jms.JMSException;
import java.util.List;

public interface EventService {
    void addEvent(Event event);
    List<EventDto> getAll() throws JMSException;
    EventDto getById(Long id) throws JMSException;
    List<EventDto> filter(FilterDto filterDto) throws JMSException;
    void update(EventDto eventDto) throws JMSException;
    void sendUpdatedEvents() throws JMSException;
    void updateLastNameEvent(Long patientId) throws JMSException;
}
