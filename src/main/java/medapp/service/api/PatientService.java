package medapp.service.api;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;

import java.util.List;

public interface PatientService {

    void add(Patient patient);

    List<PatientDto> getAll();

    PatientDto getById(Long theId);

    void disharge(Long theId);

    void clear(Long patientId);

    void update(PatientDto patientDto);

    List<Assignment> getAssignments(Long id);

     List<PatientDto> getAllPatients();
}
