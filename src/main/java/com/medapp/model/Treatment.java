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
public class Treatment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    String type;

    @Column
    String name;

    @OneToMany(mappedBy = "treatment", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<Assignment> assignments;
}
