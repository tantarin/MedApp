package medapp.model;

import lombok.Data;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
@Data
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
    String time;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Assignment(){}

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
                ", time='" + time + '\'' +
                ", patient=" + patient +
                '}';
    }
}
