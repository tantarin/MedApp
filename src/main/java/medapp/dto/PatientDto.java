package medapp.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import medapp.model.Assignment;

import java.util.List;

@Data
public class PatientDto {

    private int id;

    private String first_name;

    private String last_name;

    private List<Assignment> assignments;
}
