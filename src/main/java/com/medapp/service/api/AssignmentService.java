package com.medapp.service.api;

import com.medapp.dto.AssignmentDto;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> getAll(Long id);

    AssignmentDto getById(Long id);

    boolean add(AssignmentDto assignmentDto);

    void update(AssignmentDto assignment);

    void deleteById(Long assignmentId);

    Long getPatientId(Long assId);

    void deleteEventsByAssId(Long assId);

    void generateEventsByAssId(Long assId);
}