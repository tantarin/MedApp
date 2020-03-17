package medapp.service.api;

import medapp.model.Assignment;

import java.util.List;

public interface AssignmentService {

    void addAssignment(Assignment assignment);

    List<Assignment> getAll(Integer id);
}
