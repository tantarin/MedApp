package medapp.dto;

import lombok.Data;
import medapp.model.Event;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Data
public class AssignmentDto {

    private Long id;
    private String type;
    private String name;
    private Long patientId;
    String [] weeks;
    List<Integer> weeksInt;
    String dateFrom;
    String dateTo;
    String time1;
    String time2;
    String time3;
    List<Event> events;
}
