package com.medapp.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventDto  implements Serializable {
    private static final long serialVersionUID = 1L;
    Long id;
    String date;
    String time ;
    private String assignmentName;
    String status;
    String patientName;
    String comments =" ";
}
