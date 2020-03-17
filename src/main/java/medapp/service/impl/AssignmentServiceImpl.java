package medapp.service.impl;

import medapp.dao.api.AssignmentDAO;
import medapp.dto.AssignmentDto;
import medapp.dto.PatientDto;
import medapp.model.Assignment;
import medapp.service.api.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AssignmentServiceImpl implements AssignmentService {

    private AssignmentDAO assignmentDAO;

    @Autowired
    public void setAssignmentDAO(AssignmentDAO assignmentDAO) {
        this.assignmentDAO = assignmentDAO;
    }

    @Override
    @Transactional
    public void addAssignment(Assignment assignment) {
        assignmentDAO.addAssignment(assignment);
    }

    @Override
    @Transactional
    public List<Assignment> getAll(Integer id) {
        return assignmentDAO.getAll(id);
    }

    @Override
    @Transactional
    public AssignmentDto getAssignment(int id) {
        AssignmentDto ad = new AssignmentDto();
        Assignment a = assignmentDAO.getAssignment(id);
        ad.setId(a.getId());
        ad.setName(a.getName());
        ad.setType(a.getType());
        ad.setPatientId(a.getPatient().getId());
        return ad;
    }


}
