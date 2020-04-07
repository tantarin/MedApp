package medapp.dto;

import lombok.Data;

@Data
public class EventDto {
    String date;
    String time ;
    private String assignmentName;
    String status;
    String patientName;
}
