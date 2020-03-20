package medapp.dao.impl;

import medapp.dao.api.PatientDAO;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Component
public class PatientDAOImpl implements PatientDAO {

    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    private EntityManager entityManager;

    @Override
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
    public void delete(Long id) {
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
