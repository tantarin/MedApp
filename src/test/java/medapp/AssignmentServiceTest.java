package medapp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import medapp.dao.api.AssignmentDAO;
import medapp.dto.AssignmentDto;
import medapp.model.Assignment;
import medapp.service.impl.AssignmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import javax.inject.Inject;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {

    private Assignment assignment;
    private AssignmentDto assignmentDto;

    @Inject
    AssignmentDAO assignmentDAO;

    @InjectMocks
    AssignmentServiceImpl mockAssignmentService;

    @Before
    public void init(){
        assignment = new Assignment(1L);
        assignmentDto = new AssignmentDto();

        when(assignmentDAO.add(assignment)).thenReturn(assignment);
        when(assignmentDAO.getById(1L)).thenReturn(assignment);

    }

    @Test
    public void testAddAssignment(){
            mockAssignmentService.add(assignmentDto);
          //assertNotNull();
          //assertEquals();
    }

    @Test
    public void testDeleteAssignment(){
        //assertNotNull();
        //assertEquals();
    }
}
