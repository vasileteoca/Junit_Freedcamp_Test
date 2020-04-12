package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.testCreateProject;
import tests.testLogIn;
import tests.testAddTask;

@RunWith(Suite.class)

@Suite.SuiteClasses({
        testLogIn.class,
        testCreateProject.class,
        testAddTask.class
})
public class freedcampTestSuite {
}
