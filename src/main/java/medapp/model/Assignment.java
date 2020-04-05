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
    Date dateFrom;

    @Column
    Date dateTo;

    @Column
    String doze;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    public Assignment(){}
}
