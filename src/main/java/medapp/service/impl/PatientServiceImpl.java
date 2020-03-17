package medapp.service.impl;

import medapp.dao.api.PatientDAO;
import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.api.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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
    public List<PatientDto> getPatients() {
        List<PatientDto> list = new ArrayList<>();
        for(Patient p: patientDAO.listPatients()){
            PatientDto patient = new PatientDto();
            patient.setId(p.getId());
            patient.setFirst_name(p.getFirstName());
            patient.setLast_name(p.getLastName());
            patient.setAssignments(p.getAssignments());
        }
        return list;
    }

    @Override
    @Transactional
    public PatientDto getPatient(int theId) {
        PatientDto patientDto = new PatientDto();
        Patient p = patientDAO.getPatient(theId);
        patientDto.setId(p.getId());
        patientDto.setFirst_name(p.getFirstName());
        patientDto.setLast_name(p.getLastName());
        patientDto.setAssignments(p.getAssignments());
        return new PatientDto();
    }

    @Override
    @Transactional
    public void deletePatient(int theId) {

    }

}
