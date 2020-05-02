package medapp;

import medapp.controller.AssignmentController;
import medapp.dao.api.AssignmentDAO;
import medapp.service.impl.AssignmentServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;

@RunWith(MockitoJUnitRunner.class)
public class AssignmentServiceTest {

    @Inject
    AssignmentDAO assignmentDAO;

    @InjectMocks
    AssignmentServiceImpl assignmentService;

    @Before
    public void setup(){

    }

    @Test
    public void testAddAssignment(){

    }

    @Test
    public void testDeleteAssignment(){

    }
}
