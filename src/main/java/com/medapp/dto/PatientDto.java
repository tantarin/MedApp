package com.medapp.dto;

import com.medapp.model.Assignment;
import lombok.Data;

import java.util.List;

@Data
public class PatientDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String ensNumber;

    private String doctor;

    private List<Assignment> assignments;

    private Long assignmentId;

    private String status;

    private String diagnosis;

    public PatientDto(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public PatientDto(){ }
}
