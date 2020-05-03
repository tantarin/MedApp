package medapp.service.impl;

import medapp.dao.api.AssignmentDAO;
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
    private AssignmentDAO assignmentDAO;

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void add(Patient patient) {
        patientDAO.addPatient(patient);
    }

    /**
     * Gett all patients and convert
     * to patientDto.
     *
     * @return
     */
    @Override
    @Transactional
    public List<PatientDto> getAll() {
        List<PatientDto> list = new ArrayList<>();
        for(Patient p: patientDAO.getAll()){
            PatientDto patient = new PatientDto();
            patient.setId(p.getId());
            patient.setFirstName(p.getFirstName());
            patient.setLastName(p.getLastName());
            patient.setEnsNumber(p.getEnsNumber());
            patient.setDoctor(p.getDoctor());
            patient.setAssignments(p.getAssignments());
            patient.setStatus(p.getStatus());
            list.add(patient);
        }
        return list;
    }

    /**
     * Get patient by patient's id
     * and convert to patientDto.
     *
     * @param theId
     * @return
     */
    @Override
    @Transactional
    public PatientDto getById(Long theId) {
        PatientDto patientDto = new PatientDto();
        Patient p = patientDAO.getById(theId);
        patientDto.setId(p.getId());
        patientDto.setFirstName(p.getFirstName());
        patientDto.setLastName(p.getLastName());
        patientDto.setDoctor(p.getDoctor());
        patientDto.setEnsNumber(p.getEnsNumber());
        patientDto.setAssignments(p.getAssignments());
        return new PatientDto();
    }

    /**
     * Change patient's status and delete all assignments
     * and events of this patient.
     *
     * @param patientId
     */
    @Override
    @Transactional
    public void disharge(Long patientId) {
        Patient patient = patientDAO.getById(patientId);
        patient.setStatus("discharged");
        patientDAO.update(patient);
        List<Assignment> list = patientDAO.getAssignments(patientId);
        for(Assignment a: list){
            assignmentDAO.delete(a.getId());
        }
    }

    /**
     * Delete patient.
     *
     * @param patientId
     */
    @Override
    @Transactional
    public void clear(Long patientId) {
        patientDAO.clear(patientId);
    }

    /**
     * Update patient.
     *
     * @param patientDto
     */
    @Override
    @Transactional
    public void update(PatientDto patientDto) {
        Patient p = patientDAO.getById(patientDto.getId());
        p.setFirstName(patientDto.getFirstName());
        p.setLastName(patientDto.getLastName());
        p.setAssignments(patientDto.getAssignments());
        p.setDoctor(patientDto.getDoctor());
        p.setEnsNumber(patientDto.getEnsNumber());
        patientDAO.update(p);
    }

    /**
     * Get all assignment of this patient.
     *
     * @param id
     * @return
     */
    @Override
    public List<Assignment> getAssignments(Long id) {
        return patientDAO.getAssignments(id);
    }

    /**
     * Get all patients.
     *
     * @return
     */
    @Override
    public List<Patient> getAllPatients(){
        return patientDAO.getAll();
    }
}
