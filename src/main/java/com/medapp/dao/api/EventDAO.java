package com.medapp.dao.api;

import com.medapp.model.Event;

import javax.jms.JMSException;
import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    void deleteByAssignmentId(Long assignmentId) throws JMSException;
    List<Event> getAll() throws JMSException;
    Event getById(Long id) throws JMSException;
    List<Event> filterByDate() throws JMSException;
    List<Event> filterByHour() throws JMSException;
    List<Event> filterByPatient(String lastName) throws JMSException;
    void update(Event event);
    List<Event>  getByAssignmentId(Long assId);
}
