package medapp.service.api;

import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;

import java.util.List;

public interface PatientService {

    void addPatient(Patient patient);

    public List<PatientDto> getPatients();

    public PatientDto getPatient(int theId);

    public void deletePatient(int theId);

    Assignment getAssignment(int id);
}
