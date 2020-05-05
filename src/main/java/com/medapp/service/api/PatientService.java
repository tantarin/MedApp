package com.medapp.service.api;

import com.medapp.dto.AssignmentDto;
import com.medapp.dto.PatientDto;
import com.medapp.model.Patient;

import java.util.List;

public interface PatientService {

    void add(Patient patient);

    List<PatientDto> getAll();

    PatientDto getById(Long theId);

    void disharge(Long theId);

    void clear(Long patientId);

    void update(PatientDto patientDto);

    List<AssignmentDto> getAssignments(Long id);

     List<PatientDto> getAllPatients();
}
