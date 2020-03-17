package medapp.dao;

import medapp.model.Assignment;

import java.util.List;


public interface AssignmentDAO {

    public void addAssignment(Assignment assignment);

    List<Assignment> getAll(int id);
}
