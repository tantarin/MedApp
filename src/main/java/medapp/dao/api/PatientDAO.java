package medapp.dao.api;


import medapp.model.Assignment;
import medapp.model.Patient;
import java.util.List;


public interface PatientDAO {
    void addPatient(Patient patient);
    List<Patient> getAll();
    Patient getById(Long id);
    void update(Patient patient);
    List<Assignment> getAssignments(Long id);
    void clear(Long patientId);
}
