package medapp.dto;

import lombok.Getter;
import lombok.Setter;

public class AssignmentDto {

    private Long id;

    @Getter
    @Setter
    private String type;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private int patient_id;
}
