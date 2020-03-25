package medapp.model;

import lombok.Data;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @OneToMany(mappedBy = "assignment",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Event> events;

    public Assignment(){}
}
