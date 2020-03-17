package medapp.dto;

import lombok.Getter;
import lombok.Setter;
import medapp.model.Assignment;

import java.util.List;

public class PatientDto {


    private int id;

    @Getter
    @Setter
    private String first_name;

    @Getter
    @Setter
    private String last_name;

    @Getter
    @Setter
    private List<Assignment> assignments;
}
