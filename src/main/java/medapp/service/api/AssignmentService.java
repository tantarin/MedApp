package medapp.service.api;

import medapp.dto.AssignmentDto;
import medapp.model.Assignment;

import java.util.List;

public interface AssignmentService {

    List<Assignment> getAll(Long id);

    AssignmentDto getById(Long id);

    void add(AssignmentDto assignmentDto);

    void update(AssignmentDto assignment);

    void deleteById(Long id);

    Long getPatientId(Long assId);
}
