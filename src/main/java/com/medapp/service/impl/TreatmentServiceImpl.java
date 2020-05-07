package com.medapp.service.impl;

import com.medapp.dao.api.TreatmentDAO;
import com.medapp.model.Treatment;
import com.medapp.service.api.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    private TreatmentDAO treatmentDAO;

    @Override
    public void addTreatment(Treatment treatment) {
        treatmentDAO.addTreatment(treatment);
    }
}
