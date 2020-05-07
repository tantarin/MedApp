package com.medapp.service.impl;

import com.medapp.constants.ApplicationConstant;
import com.medapp.dao.api.AssignmentDAO;
import com.medapp.dao.api.EventDAO;
import com.medapp.dao.api.PatientDAO;
import com.medapp.dto.AssignmentDto;
import com.medapp.dto.PatientDto;
import com.medapp.model.Assignment;
import com.medapp.model.Event;
import com.medapp.model.Patient;
import com.medapp.service.api.PatientService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    private static Logger logger = LogManager.getLogger(PatientServiceImpl.class.getName());

    @Autowired
    private EventDAO eventDAO;

    private PatientDAO patientDAO;
    @Autowired
    private AssignmentDAO assignmentDAO;

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    public void add(Patient patient) {
        patient.setStatus(ApplicationConstant.STATUS_ON_MEDICATION);
        patientDAO.addPatient(patient);
    }

    /**
     * Gett all patients and convert
     * to patientDto.
     *
     * @return List<PatientDto>
     */
    @Override
    @Transactional
    public List<PatientDto> getAll() {
        List<PatientDto> list = new ArrayList<>();
        for (Patient p : patientDAO.getAll()) {
            PatientDto patient = convertPatientToDto(p);
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
        Patient patient = patientDAO.getById(theId);
        PatientDto patientDto = convertPatientToDto(patient);
        return patientDto;
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
        patient.setStatus(ApplicationConstant.STATUS_DISHARGED);
        patientDAO.update(patient);
        List<Assignment> list = patientDAO.getAssignments(patientId);
        for (Assignment a : list) {
            Long assId = a.getId();
            List<Event> events = eventDAO.getByAssignmentId(assId);
            for(Event e:events){
                if(e.getStatus().equals(ApplicationConstant.EVENT_STATUS_SHEDULED)){
                    e.setStatus(ApplicationConstant.EVENT_STATUS_CANCELLED);
                    e.setComments(ApplicationConstant.DISCHARGED_COMMENTS);
                    eventDAO.update(e);
                }
            }
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
        p.setStatus(patientDto.getStatus());
        p.setDiagnosis(patientDto.getDiagnosis());
        patientDAO.update(p);
    }

    /**
     * Get all assignment using patient id.
     *
     * @param id
     * @return List<AssignmentDto>
     */
    @Override
    public List<AssignmentDto> getAssignments(Long id) {
        List<AssignmentDto> listDtos = new ArrayList<>();
        List<Assignment> listAss = patientDAO.getAssignments(id);
        for(Assignment assignment:listAss){
            AssignmentDto assignmentDto = AssignmentServiceImpl.convertAssignmentToDto(assignment);
            listDtos.add(assignmentDto);
        }
        return listDtos;
    }

    /**
     * Get all patients.
     *
     * @return
     */
    @Override
    public List<PatientDto> getAllPatients() {
        List<PatientDto> dtoList = new ArrayList<>();
        List<Patient> patientList = patientDAO.getAll();
        for(Patient p:patientList){
            PatientDto patientDto = convertPatientToDto(p);
            dtoList.add(patientDto);
        }
        return dtoList;
    }

    /**
     * Convert Patient entity to dto
     *
     * @param patient
     * @return PatientDto
     */
    public PatientDto convertPatientToDto(Patient patient){
        PatientDto patientDto = new PatientDto();
        patientDto.setId(patient.getId());
        patientDto.setFirstName(patient.getFirstName());
        patientDto.setLastName(patient.getLastName());
        patientDto.setDoctor(patient.getDoctor());
        patientDto.setEnsNumber(patient.getEnsNumber());
        patientDto.setAssignments(patient.getAssignments());
        patientDto.setStatus(patient.getStatus());
        patientDto.setDiagnosis(patient.getDiagnosis());
        return patientDto;
    }
}
