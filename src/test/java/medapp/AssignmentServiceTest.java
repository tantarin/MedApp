package medapp;

import medapp.dao.api.AssignmentDAO;
import medapp.dao.api.PatientDAO;
import medapp.dto.AssignmentDto;
import medapp.exceptions.DaoException;
import medapp.exceptions.ServiceException;
import medapp.model.Assignment;
import medapp.model.Patient;
import medapp.service.impl.AssignmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {

    private static Assignment assignment;
    private static AssignmentDto assignmentDto;
    private static Patient patient;
    private static List<Assignment> assignmentList;

    @Mock
    PatientDAO patientDAO;

    @Mock
    AssignmentDAO assignmentDAO;

    @InjectMocks
    AssignmentServiceImpl assignmentService;

    @Before
    public void init() throws DaoException {
        patient = new Patient(1L, "Ivan", "Ivanov");
        assignment = new Assignment(1L, "1 2", patient, "2020-05-04","2020-06-04");
        assignmentDto = new AssignmentDto(1L, new String[]{"10","20"}, 1L);
        assignmentList = new ArrayList<>();
        assignmentList.add(assignment);
        when(patientDAO.getById(1L)).thenReturn(patient);
        when(assignmentDAO.getAll(patient.getId())).thenReturn(assignmentList);
        when(assignmentDAO.getById(1L)).thenReturn(assignment);
        when(assignmentDAO.add(any())).thenReturn(assignment);
       // doNothing().when(assignmentService).generateEventsByAssId(1L);
    }

    @Test
    public void testAddAssignment() throws ServiceException, DaoException {
        boolean added = assignmentService.add(assignmentDto);
        assertThat(added, is(true));
    }

    @Test
    public void getAssignmentByIdTest() {
        assignmentService.getById(1L);
        assertEquals("1 2", assignment.getTimePattern());
    }

    @Test
    public void testDeleteAssignment() {
        assignmentDAO.delete(1L);

    }

    @Test
    public void getAllAssignmentsByPatientTest() {
        assertEquals(assignmentService.getAll(patient.getId()).size(), assignmentList.size());
    }
}
