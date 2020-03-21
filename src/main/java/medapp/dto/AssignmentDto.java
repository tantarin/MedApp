package medapp.dto;


import lombok.Data;

@Data
public class AssignmentDto {

    private Long id;
    private String type;
    private String name;
    private Long patientId;

    @Override
    public String toString() {
        return "AssignmentDto{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", patientId=" + patientId +
                '}';
    }
}
