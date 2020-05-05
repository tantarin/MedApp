package com.medapp.dto;

import lombok.Data;

@Data
public class FilterDto {
    private String byDay = "no filter";
    private String byHour = "no filter";
    private String byPatient = "";
}
