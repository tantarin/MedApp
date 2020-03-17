package medapp.dao.api;

import medapp.model.Assignment;

import java.util.List;


public interface AssignmentDAO {

    void addAssignment(Assignment assignment);
    List<Assignment> getAll(int id);
}
