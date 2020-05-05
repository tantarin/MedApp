package com.medapp.dao.impl;

import com.medapp.dao.api.PatientDAO;
import com.medapp.model.Assignment;
import com.medapp.model.Patient;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
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

    private static final Logger logger = LogManager.getLogger(PatientDAOImpl.class.getName());


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
