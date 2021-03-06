package com.medapp;


import com.medapp.dao.api.PatientDAO;
import com.medapp.dto.PatientDto;
import com.medapp.model.Patient;
import com.medapp.service.impl.PatientServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class PatientServiceTest {

    private static Patient patient1;
    private static Patient patient2;
    private static Patient newPatient;

    @Mock
    PatientDAO patientDAO;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Before
    public void init() {
        List<Patient> patients = new ArrayList<>();
        patient1 = new Patient(1L, "Ivan", "Ivanov");
        patient2 = new Patient(2L, "Petr", "Petrov");
        patients.add(patient1);
        patients.add(patient2);
        when(patientDAO.getAll()).thenReturn(patients);
        when(patientDAO.getById(1L)).thenReturn(patient1).thenReturn(null);
    }

    @Test
    public void addPatientTest() {
        patientService.add(patient1);
        verify(patientDAO, times(1)).addPatient(patient1);
    }

    @Test
    public void getPatientByIdTest() {
        patientService.getById(1L);
        assertEquals("Ivan", patient1.getFirstName());
        assertEquals("Ivanov", patient1.getLastName());
    }

    @Test
    public void deletePatientTest() {
        patientDAO.clear(1L);
    }

    @Test
    public void updatePatientTest() {
        patient2.setId(3L);
        patientDAO.update(patient2);

    }

    @Test
    public void getAllPatientsTest() {
        List<PatientDto> list = patientService.getAllPatients();
        assertEquals(2, list.size());
        verify(patientDAO, times(1)).getAll();
    }
}