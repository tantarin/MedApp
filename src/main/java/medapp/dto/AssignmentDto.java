package medapp.dto;

import lombok.Data;
import medapp.model.Event;
import java.util.List;

@Data
public class AssignmentDto {

    public AssignmentDto(Long id, String[] weeks, Long patientId) {
        this.id = id;
        this.weeks = weeks;
        this.patientId = patientId;
    }
    public AssignmentDto(){

    }

    private Long id;
    private String type;
    private String name;
    private Long patientId;
    String [] weeks;
    List<Event> events;
    List<Integer> weeksInt;
    String dateFrom;
    String dateTo;
    String time1;
    String time2;
    String time3;
    String doze;
    String timePattern;
    String period;
}
