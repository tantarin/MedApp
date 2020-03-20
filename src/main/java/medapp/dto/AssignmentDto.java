package medapp.dto;


import lombok.Data;

@Data
public class AssignmentDto {

    private int id;
    private String type;
    private String name;
    private Long patientId;

}
