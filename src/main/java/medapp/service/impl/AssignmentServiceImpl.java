package medapp.service.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentDAO assignmentDAO;
    private PatientDAO patientDAO;

    @Autowired
    public void setAssignmentDAO(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    @Autowired
    public void setPatientDAO(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Override
    @Transactional
    public void add(AssignmentDto assignmentDto) {
        Patient p = patientDAO.getById(assignmentDto.getPatientId());
        Assignment a = new Assignment();
        a.setPatient(p);
        a.setId(assignmentDto.getId());
        a.setName(assignmentDto.getName());
        a.setType(assignmentDto.getType());
        assignmentDAO.add(a);
    }

    @Override
    @Transactional
    public List<Assignment> getAll(Integer id) {
        return assignmentDAO.getAll(id);
    }

    @Override
    @Transactional
    public AssignmentDto getById(int id) {
        AssignmentDto ad = new AssignmentDto();
        return ad;
    }


}
