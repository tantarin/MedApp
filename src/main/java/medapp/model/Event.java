package medapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table
public class Event {
    @Id
    Long id;

    @Column
    String date;

    @Column
    String time;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Column
    Long assignmentId;

    public Event(){};
}
