package medapp.service.api;

import medapp.dto.AssignmentDto;
import medapp.model.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> getAll(Integer id);

    AssignmentDto getById(Long id);

    void add(AssignmentDto assignmentDto);

    void update(AssignmentDto assignment);

    void delete(Assignment assignment);
}
