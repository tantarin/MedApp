package com.medapp.dao.api;

import com.medapp.model.Event;

import java.util.List;

public interface EventDAO {
    void addEvent(Event event);
    void deleteByAssignmentId(Long assignmentId);
    List<Event> getAll();
    Event getById(Long id);
    List<Event> filterByDate();
    List<Event> filterByHour();
    List<Event> filterByPatient(String lastName);
    void update(Event event);
    List<Event>  getByAssignmentId(Long assId);
}