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
public class testAddCommentToTask {

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
    public void addCommentToTask() throws IOException {

        //________________________________LOGIN___________________________________
        pageTemplate.loginDropDownButton().click();
        pageTemplate.emailField().sendKeys(testDataContainer.email);
        pageTemplate.passwordField().sendKeys(testDataContainer.password);
        pageTemplate.loginButton().click();
       //_________________________________________________________________________
        //PageTemplate.dismiss().click();                     --SPAM DISMISS
        //___________________________SELECT_PROJECT_______________________________
        pageTemplate.selectProject().click();
        //________________________________________________________________________
        //____________________________ADD_COMMENT_________________________________
        int i = 0;
        for (WebElement task : pageTemplate.taskContainer()){
            i = pageTemplate.taskContainer().indexOf(task);
        }
        pageTemplate.taskContainer().get(i).click();
        getDriver.switchTo().frame(pageTemplate.iframeComment());
        pageTemplate.commendBody().sendKeys(testDataContainer.commentBody);
        getDriver.switchTo().parentFrame();
        pageTemplate.addCommentButton().submit();
        //________________________________________________________________________
        //______________________COMMENT_VERIFICATION______________________________
        int j =0;
        for(WebElement comment: pageTemplate.commentList()){
            i = pageTemplate.commentList().indexOf(comment);
        }
        Assert.assertTrue(pageTemplate.commentList().get(i).getText().contains(testDataContainer.commentBody));
        //________________________________________________________________________
    }

    @After
    public void afterMethod() throws IOException {
        DriverBuilder.kill();
    }
}