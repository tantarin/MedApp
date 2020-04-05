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
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Column
    String status;

    @Column
    String type;

    public Event(){};

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", patient=" + patient +
                ", status='" + status + '\'' +
                '}';
    }
}
