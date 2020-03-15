package medapp.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private int id;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.PERSIST, CascadeType.MERGE,CascadeType.DETACH,
    CascadeType.REFRESH})
    @Getter
    @Setter
    private List<Assignment> assignments;

    @Column(name = "first_name")
    @Getter
    @Setter
    private String firstName ;

    @Column(name = "last_name")
    @Getter
    @Setter
    private String lastName;

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}