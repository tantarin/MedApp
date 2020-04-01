package medapp.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@Table
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String date;

    @Column
    String time;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column
    String status;

    public Event(){};
}
