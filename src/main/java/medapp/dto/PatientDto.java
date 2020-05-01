package medapp.dto;

import lombok.Data;
import medapp.model.Assignment;

import java.util.List;

@Data
public class PatientDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String ensNumber;

    private String doctor;

    private List<Assignment> assignments;

    private Long assignmentId;

    private String status;

    public PatientDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PatientDto(){ }
}
