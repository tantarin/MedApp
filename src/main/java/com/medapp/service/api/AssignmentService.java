package com.medapp.service.api;

import com.medapp.dto.AssignmentDto;

import javax.jms.JMSException;
import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> getAll(Long id);

    AssignmentDto getById(Long id);

    boolean add(AssignmentDto assignmentDto);

    void update(AssignmentDto assignment) throws JMSException;

    void deleteById(Long assignmentId) throws JMSException;

    Long getPatientId(Long assId);

    void deleteEventsByAssId(Long assId) throws JMSException;

    void generateEventsByAssId(Long assId);
}
