package medapp.dao.api;

import medapp.model.Assignment;
import medapp.model.Patient;
import java.util.List;


public interface PatientDAO {
    void addPatient(Patient patient);
    List<Patient> listPatients();
    void delete(Integer id);
    Patient getById(Integer id);
}
