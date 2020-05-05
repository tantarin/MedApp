package com.medapp.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@Data
@ToString
@NoArgsConstructor
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
    String dateFrom;

    @Column
    String dateTo;

    @Column
    String doze;

    @Column
    String timesPerWeek;

    @Column
    String morningTime;

    @Column
    String afternoonTime;

    @Column
    String eveningTime;

    @OneToMany(mappedBy = "assignment", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Event> events;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "treatment_id")
    private Treatment treatment;

    public Assignment(Long id, String timesPerWeek, Patient patient, String dateFrom, String dateTo) {
        this.id = id;
        this.timesPerWeek = timesPerWeek;
        this.patient = patient;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

}
