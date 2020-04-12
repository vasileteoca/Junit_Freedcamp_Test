package tests;

import pages.pageTemplate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.openqa.selenium.WebElement;
import testDataContainer.testDataContainer;
import utils.DriverBuilder;
import utils.Helpers;

import java.io.IOException;

import static utils.DriverBuilder.getDriver;

@RunWith(JUnit4.class)
public class testAddTask {

    @Before
    public void beforeMethod() throws IOException {
        System.out.println("This method is called before each test executes");
        Helpers.getPropValues();
        DriverBuilder.setDriver();
        DriverBuilder.setDriverDefaultWait(10);
        getDriver.manage().window().maximize();
        getDriver.get(System.getProperty("default.url"));
    }

    @Test
    public void addTask() throws IOException {
        //____________LOGIN_______________________________________________________
        pageTemplate.loginDropDownButton().click();
        pageTemplate.emailField().sendKeys(testDataContainer.email);
        pageTemplate.passwordField().sendKeys(testDataContainer.password);
        pageTemplate.loginButton().click();
        pageTemplate.selectProject().click();
        //_________________________________________________________________________
        //PageTemplate.dismiss().click();     -- SPAM DISMISS
        //_____________SELECT_PROJECT_____________________________________________
        pageTemplate.selectProject().click();
        //________________________________________________________________________
        //_____________ADD_TASK___________________________________________________
        pageTemplate.addTaskButton().click();
        getDriver.switchTo().activeElement();
        pageTemplate.taskTitleField().sendKeys(testDataContainer.taskTitle);
        getDriver.switchTo().frame(pageTemplate.iframe());
        pageTemplate.taskDescriptionField().sendKeys(testDataContainer.taskDescription);
        getDriver.switchTo().parentFrame();
        pageTemplate.taskPriorityDropdown().sendKeys(testDataContainer.taskPriority);
        getDriver.switchTo().parentFrame();
        pageTemplate.saveTaskButton().click();
        getDriver.switchTo().parentFrame();
        Assert.assertTrue(pageTemplate.taskName().getText().equals(testDataContainer.taskTitle));
        //________________________________________________________________________
        //___________VERIFICATION_OF_THE_NEWLY_CREATED_TASK_______________________
        getDriver.switchTo().parentFrame();

        int i = 0;
        for (WebElement task : pageTemplate.taskContainer()){
            i = pageTemplate.taskContainer().indexOf(task);
            System.out.println(i);
        }

        WebElement taskName = pageTemplate.taskContainer().get(i);
        //PageTemplate.taskContainer().get(i).getText();
        Assert.assertTrue(taskName.getText().equals(testDataContainer.taskTitle));
        //_______________________________________________________________________
    }

    @After
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}