package com.medapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Assignment> assignments;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String ensNumber;

    @Column
    private String status;

    @Column
    private String doctor;

    @Column
    private String diagnosis;

    public Patient(Long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", assignments=" + assignments +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", ensNumber='" + ensNumber + '\'' +
                ", status='" + status + '\'' +
                ", doctor='" + doctor + '\'' +
                ", diagnosis='" + diagnosis + '\'' +
                '}';
    }
}