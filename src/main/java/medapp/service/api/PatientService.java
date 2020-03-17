package medapp.service.api;

import medapp.model.Patient;

import java.util.List;

public interface PatientService {

    void addPatient(Patient patient);

    public List<Patient> getPatients();

    public Patient getPatient(int theId);

    public void deletePatient(int theId);
}
