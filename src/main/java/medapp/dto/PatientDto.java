package medapp.dto;

import lombok.Data;
import medapp.model.Assignment;

import java.util.List;

@Data
public class PatientDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Assignment> assignments;

    private Long assignmentId;
}
