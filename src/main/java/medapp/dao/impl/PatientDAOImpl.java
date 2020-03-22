package medapp.dao.impl;

import medapp.dao.api.AbstractDao;
import medapp.dao.api.PatientDAO;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class PatientDAOImpl implements PatientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void addPatient(Patient patient) {
        entityManager.persist(patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Patient> getAll() {
        List<Patient> patientList = entityManager.createQuery("from Patient").getResultList();
        return patientList;
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public Patient getById(Long id) {
        Patient patient = (Patient) entityManager.find(Patient.class,id);
        return patient;
    }

    @Override
    public void update(Patient patient) {
        entityManager.persist(patient);
    }
}
