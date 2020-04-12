package pages;

import org.openqa.selenium.*;

import java.util.List;

import static utils.DriverBuilder.getDriver;

public class pageTemplate {

    public static WebElement loginDropDownButton() { return getDriver.findElement(By.cssSelector("header>ul>li:nth-child(2)>a"));}

    public static WebElement emailField() { return getDriver.findElement(By.id("login_username"));}

    public static WebElement passwordField() { return getDriver.findElement(By.id("login_password"));}

    public static WebElement loginButton() { return getDriver.findElement(By.cssSelector("fieldset div:nth-child(4)"));}

    public static WebElement welcomeLabel() { return getDriver.findElement(By.cssSelector("div.flex.align-center.content-between.pt2.greeting_dashboard > h1 > b"));}

    public static WebElement dismiss() { return getDriver.findElement(By.cssSelector("body > header > div.fc_header_right > ul > li.user_upgrade > div > div.u-cyber-action > a.u-cyber-dismiss"));}

    public static WebElement newProjectButton() { return getDriver.findElement(By.cssSelector("#widgets > div > div.flex.align-center.content-between.pt2.greeting_dashboard > div > div.btn-group > a.btn.btn-positive.new_project"));}

    public static WebElement projectNameField() { return getDriver.findElement(By.cssSelector("input[name='project_name']"));}

    public static WebElement projectDescription() { return getDriver.findElement(By.cssSelector("input[name='project_description']"));}

    public static WebElement taskListSelectButton () { return getDriver.findElement(By.cssSelector("#wizard_form > fieldset > div.preferred_style.no_gantt > div.view_div.list > div"));}

    public static WebElement nextButton() { return  getDriver.findElement(By.cssSelector("#wizard_form > fieldset > div.footer > button"));}

    public static WebElement nextButtonTwo() { return getDriver.findElement(By.cssSelector("#wizard_form > div.footer > button"));}

    public static WebElement congratulations() { return getDriver.findElement(By.cssSelector("#wizard_step > h1"));}

    public static WebElement selectProject() { return getDriver.findElement(By.cssSelector("#widget_6710738 > div > ul > li:nth-child(1)"));}

    public static WebElement addTaskButton() { return getDriver.findElement(By.cssSelector("#content_inner_wrap > main > div.action_bar.body_width.dynamic_action > div.action_bar_right > a.btn.btn-positive.fkit_modal"));}

    public static WebElement taskTitleField() { return getDriver.findElement(By.id("todo_title"));}

    public static WebElement iframe() { return getDriver.findElement(By.cssSelector("#cke_1_contents > iframe"));}

    public static WebElement iframeComment() { return getDriver.findElement(By.cssSelector("iframe.cke_wysiwyg_frame"));}

    public static WebElement taskDescriptionField() { return getDriver.findElement(By.cssSelector("body"));}

    public static WebElement taskPriorityDropdown() { return getDriver.findElement(By.id("priority"));}

    public static WebElement saveTaskButton() { return getDriver.findElement(By.id("add_edit_btn"));}

    public static WebElement taskName() { return getDriver.findElement(By.cssSelector("div:nth-child(1) > div > p > a"));}

    public static List<WebElement> taskContainer() { return getDriver.findElements(By.cssSelector("div > p > a"));}

    public static WebElement commendBody() { return getDriver.findElement(By.cssSelector("body"));}

    public static WebElement addCommentButton() { return  getDriver.findElement(By.cssSelector("div.right > input"));}

    public static List<WebElement> commentList() { return getDriver.findElements(By.cssSelector("ul li div div div span p"));}
}