package com.medapp.dao.impl;

import com.medapp.dao.api.TreatmentDAO;
import com.medapp.model.Treatment;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Component
@Stateful
public class TreatmentDAOImpl implements TreatmentDAO {

    private static final Logger logger = LogManager.getLogger(PatientDAOImpl.class.getName());


    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    /**
     * Add treatment to database.
     *
     */
    public void addTreatment(Treatment treatment) {
        entityManager.persist(treatment);
    }
}
