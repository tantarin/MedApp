package medapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table
@Data
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;

    @Column(name = "type")
    String type;

    @Column(name = "name")
    String name;

    @ManyToOne
    private Patient patient;

    public Assignment(){}
}
