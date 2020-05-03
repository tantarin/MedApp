package medapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.model.Event;
import medapp.model.Patient;
import medapp.service.impl.AssignmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {

    private static Assignment assignment1;
    private static Assignment assignment2;
    private static AssignmentDto assignmentDto;
    private static Patient patient;
    private static List<Assignment> assignmentList;

    @Inject
    PatientDAO patientDAO;

    @Inject
    AssignmentDAO assignmentDAO;

    @InjectMocks
    AssignmentServiceImpl assignmentService;

    @Before
    public void init(){
        assignment1 = new Assignment(1L, "Fisioterapy");
        assignment2 = new Assignment(2L, "Massage");
        assignmentDto = new AssignmentDto(1L, "Fisioterapy",1L);
        patient = new Patient(1L, "Ivan","Ivanov");
        assignmentList = new ArrayList<>();
        assignmentList.add(assignment1);
        assignmentList.add(assignment2);
        when(patientDAO.getById(1L)).thenReturn(patient);
        when(assignmentDAO.getAll(patient.getId())).thenReturn(assignmentList);
        when(assignmentDAO.getById(1L)).thenReturn(assignment1);

    }

    @Test
    public void testAddAssignment(){
         assignmentService.add(assignmentDto);
         verify(assignmentDAO, times(1)).add(assignment1);
    }

    @Test
    public void getAssignmentByIdTest(){
        assignmentService.getById(1L);
        assertEquals("Fisioterapy", assignment1.getType());
    }

    @Test
    public void testDeleteAssignment(){
        assignmentDAO.delete(1L);
        when(assignmentDAO.getById(1L)).thenReturn(null);
    }

    @Test
    public void getAllAssignmentsByPatientTest(){
        assertEquals(assignmentService.getAll(patient.getId()), assignmentList);
    }
}
