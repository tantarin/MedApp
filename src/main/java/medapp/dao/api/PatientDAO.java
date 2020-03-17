package medapp.dao.api;

import medapp.model.Patient;
import java.util.List;


public interface PatientDAO {
    public void addPatient(Patient patient);
    public List<Patient> listPatients();
    public void removePatient(Integer id);
    Patient getPatient(Integer id);
}
