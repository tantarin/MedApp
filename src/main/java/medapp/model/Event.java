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

    public Event() {
    }


    public Event(Long id, String patientName, Assignment assignment) {
        this.id = id;
        this.patientName = patientName;
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", assignment=" + assignment +
                ", status='" + status + '\'' +
                ", patientName='" + patientName + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }
}
