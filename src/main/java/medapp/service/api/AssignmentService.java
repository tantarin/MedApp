package medapp.service.api;

import medapp.dto.AssignmentDto;
import medapp.exceptions.ServiceException;
import medapp.model.Assignment;

import java.util.List;

public interface AssignmentService {

    List<AssignmentDto> getAll(Long id);

    AssignmentDto getById(Long id);

    boolean add(AssignmentDto assignmentDto) throws ServiceException;

    void update(AssignmentDto assignment);

    void deleteById(Long assignmentId);

    Long getPatientId(Long assId);

    void deleteEventsByAssId(Long assId);

    void generateEventsByAssId(Long assId);
}
