package medapp.service;

import medapp.model.Assignment;

import java.util.List;

public interface AssignmentService {

    void addAssignment(Assignment assignment);

    List<Assignment> getAll(int id);
}
