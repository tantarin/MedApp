package medapp.dao.impl;

import medapp.dao.api.PatientDAO;
import medapp.model.Assignment;
import medapp.model.Patient;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Component
@Stateful
public class PatientDAOImpl implements PatientDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    /**
     *
     */
    public void addPatient(Patient patient) {
        entityManager.persist(patient);
    }

    @SuppressWarnings("unchecked")
    @Override
    /**
     *
     */
    public List<Patient> getAll() {
        return entityManager.createQuery("from Patient").getResultList();
    }

    @Override
    /**
     *
     */
    public Patient getById(Long id) {
        return (Patient) entityManager.find(Patient.class,id);
    }

    @Override
    public void update(Patient patient) {
      //  entityManager.merge(patient);
        entityManager.persist(patient);
    }

    @Override
    public List<Assignment> getAssignments(Long patientId) {
        Query query = entityManager.createQuery("select a from Assignment a where a.patient.id = ?1");
        query.setParameter(1,patientId);
        return query.getResultList();
    }

    @Override
    public void clear(Long patientId) {
        entityManager.remove(getById(patientId));
    }
}
