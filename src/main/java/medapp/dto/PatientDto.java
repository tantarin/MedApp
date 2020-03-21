package medapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import medapp.model.Assignment;

import java.util.List;

@Data
public class PatientDto {

    private Long id;

    private String firstName;

    private String lastName;

    private List<Assignment> assignments;

    private Integer assignmentId;
}
