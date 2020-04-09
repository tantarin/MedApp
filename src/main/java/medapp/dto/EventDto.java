package medapp.dto;

import lombok.Data;

@Data
public class EventDto {
    Long id;
    String date;
    String time ;
    private String assignmentName;
    String status;
    String patientName;
    String comments =" ";
}
