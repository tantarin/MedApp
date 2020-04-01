package medapp.dao.api;


import medapp.model.Assignment;
import medapp.model.Patient;
import java.util.List;


public interface PatientDAO {
    void addPatient(Patient patient);
    List<Patient> getAll();
    void deleteById(Long id);
    Patient getById(Long id);
    void update(Patient patient);
    List<Assignment> getAssignments(Long id);
}
