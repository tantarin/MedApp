package medapp.service.api;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;

import java.util.List;

public interface PatientService {

    void add(Patient patient);

    List<PatientDto> getAll();

    PatientDto getById(Long theId);

    void delete(Long theId);

    void update(PatientDto patientDto);
}
