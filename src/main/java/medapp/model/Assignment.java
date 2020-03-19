package medapp.model;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table
@Data
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column
    String type;

    @Column
    String name;

    @ManyToOne
    private Patient patient;

    public Assignment(){}
}
