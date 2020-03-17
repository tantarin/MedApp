package medapp.service;

import medapp.dao.AssignmentDAO;
import medapp.dao.PatientDAO;
import medapp.model.Assignment;
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
    public List<Assignment> getAll(int id) {
        assignmentDAO.getAll(id);
    }
}
