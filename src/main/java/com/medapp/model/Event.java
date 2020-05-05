package com.medapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Data
@Table
@ToString
@NoArgsConstructor
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String date;

    @Column
    String time;

    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    @Column
    String status;

    @Column
    String patientName;

    @Column
    String comments;

    public Event(Long id, String patientName, Assignment assignment) {
        this.id = id;
        this.patientName = patientName;
        this.assignment = assignment;
    }
}
