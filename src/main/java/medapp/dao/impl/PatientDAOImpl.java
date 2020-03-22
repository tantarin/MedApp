package medapp.dao.impl;

import medapp.dao.api.AbstractDao;
import medapp.dao.api.PatientDAO;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PatientDAOImpl extends AbstractDao implements PatientDAO {

    @Override
    public void addPatient(Patient patient) {
        getEntityManager().persist(patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getAll() {
        List<Patient> patientList = getEntityManager().createQuery("from Patient").getResultList();
        return patientList;
    }

    @Override
    public void deleteById(Long id) {
        getEntityManager().remove(getById(id));
    }

    @Override
    public Patient getById(Long id) {
        Patient patient = (Patient) getEntityManager().find(Patient.class,id);
        return patient;
    }

    @Override
    public void update(Patient patient) {
        getEntityManager().persist(patient);
    }
}
