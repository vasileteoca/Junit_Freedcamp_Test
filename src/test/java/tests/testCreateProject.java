package tests;

import pages.pageTemplate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import testDataContainer.testDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

@RunWith(JUnit4.class)
public class testCreateProject {

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.get(System.getProperty("default.url"));
        getDriver.manage().window().maximize();
    }

    @Test
    public void createProject() throws IOException {
        //____________________________LOGIN_____________________________________________________
        pageTemplate.loginDropDownButton().click();
        pageTemplate.emailField().sendKeys(testDataContainer.email);
        pageTemplate.passwordField().sendKeys(testDataContainer.password);
        pageTemplate.loginButton().click();
        //______________________________________________________________________________________
        //___________________________CREATE_PROJECT_____________________________________________
        pageTemplate.newProjectButton().click();
        pageTemplate.projectNameField().sendKeys(testDataContainer.projectName);
        pageTemplate.projectDescription().sendKeys(testDataContainer.projectDescription);
        pageTemplate.taskListSelectButton().click();
        pageTemplate.nextButton().submit();
        pageTemplate.nextButtonTwo().click();
        //______________________________________________________________________________________
        //___________________________NEWLY_CREATED_PROJECT_VERIFICATION_________________________
        Assert.assertTrue(pageTemplate.congratulations().getText().equals("Congratulations!"));
        //______________________________________________________________________________________
    }

    @After
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}
