package medapp.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "patients")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToOne(mappedBy = "patient",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Assignment assignment;

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