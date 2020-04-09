package medapp.model;

import lombok.Data;

import javax.persistence.*;


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
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Column
    String status;

    @Column
    String patientName;

    @Column
    String comments;

    public Event(){};

}
