package medapp.model;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "patient",cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Assignment> assignments;

    @Column
    private String firstName ;

    @Column
    private String lastName;

    @Column
    private String ensNumber;

    @Column
    private String status;

    @Column
    private String doctor;

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