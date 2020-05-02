package medapp;

import com.google.gson.Gson;
import medapp.controller.PatientController;
import medapp.dao.api.PatientDAO;
import medapp.model.Patient;
import medapp.service.api.PatientService;
import medapp.service.impl.PatientServiceImpl;
import medapp.test.config.TestBeanConfig;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Matchers.any;

import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@WebAppConfiguration
@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {TestBeanConfig.class})
public class PatientServiceTest {

    private MockMvc mockMvc;

    @InjectMocks
    private PatientController patientController;
//
//    @Rule
//    public MockitoRule initRule = MockitoJUnit.rule();

//    @Before
//    public void init(){
//        MockitoAnnotations.initMocks(this);
//        mockMvc = MockMvcBuilders
//                .standaloneSetup(patientController)
//                .build();
//    }
//
    @Mock
    PatientDAO patientDAO;

    @InjectMocks
    private PatientServiceImpl patientService;

    @Test
    public void test(){
        System.out.println("hi");
    }

    @Test
    public void getAllPatientsTest() {
        Mockito.mock(PatientServiceImpl.class, Mockito.RETURNS_DEEP_STUBS);
        System.out.println("junit test4");
        List<Patient> patients = new ArrayList<>();
        Patient patient1 = new Patient("Ivan","Ivanov");
        Patient patient2 = new Patient("Petr","Petrov");
        patients.add(patient1);
        patients.add(patient2);
        when(patientDAO.getAll()).thenReturn(patients);
        //test
        List<Patient> list = patientService.getAllPatients();
        assertEquals(2, list.size());
        verify(patientDAO, times(1)).getAll();
    }
}