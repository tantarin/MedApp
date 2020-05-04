package medapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@ToString
@NoArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    String type;

    @Column
    String name;

    @Column
    String dateFrom;

    @Column
    String dateTo;

    @Column
    String doze;

    @Column
    String timePattern;

    @Column
    String time1;

    @Column
    String time2;

    @Column
    String time3;

    @Column
    String period;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Event> events;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", dateFrom='" + dateFrom + '\'' +
                ", dateTo='" + dateTo + '\'' +
                ", doze='" + doze + '\'' +
                ", timePattern='" + timePattern + '\'' +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                ", period='" + period + '\'' +
                ", events=" + events +
                ", patient=" + patient +
                '}';
    }

    public Assignment(Long id, String timePattern, Patient patient, String dateFrom, String dateTo) {
        this.id = id;
        this.timePattern = timePattern;
        this.patient = patient;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

}
