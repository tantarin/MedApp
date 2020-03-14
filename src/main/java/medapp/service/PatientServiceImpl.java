package medapp.service;

import medapp.dao.PatientDAO;
import medapp.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private PatientDAO patientDAO;

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        patientDAO.addPatient(patient);
    }

    @Override
    @Transactional
    public List<Patient> getPatients() {
        return patientDAO.listPatients();
    }

    @Override
    @Transactional
    public Patient getPatient(int theId) {
        return null;
    }

    @Override
    @Transactional
    public void deletePatient(int theId) {

    }
}
