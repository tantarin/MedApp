package medapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "assignments")
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private int id;

    @Column(name = "type")
    @Getter
    @Setter
    String type;

    @Column(name = "name")
    @Getter
    @Setter
    String name;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id")
    @Getter
    @Setter
    private Patient patient;

    public Assignment(){}
}
