package medapp;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    AssignmentServiceTest.class,
        EventServiceTest.class,
        PatientServiceTest.class
})

public class RunAllTests {

}
