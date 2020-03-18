package com.automation.tests.vytrack.activities;
/*

 * TASK
 *
 * Scenario: Verify for store manager
 *
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed

  */


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {
    private By usernameBy = By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");

    private WebDriver driver;
    private Actions action;

    private String username = "storemanager85";
    private String password = "UserUser123";

    private By activitiesBy=By.xpath("//span[@class=\"title title-level-1\" and contains(text(),\"Activities\")]");

    //private By logCallBynBy=By.cssSelector("a[title=\"Log call\"]");
    private By calenderEventBy=By.cssSelector("[title=\"Create Calendar event\"]");

    private By currentUserBy=By.cssSelector("#user-menu>a");
    private By ownerNameBy= By.xpath("//div[@class=\"controls\"]//span[@class=\"select2-chosen\"]");
    private By titleBy=By.name("oro_calendar_event_form[title]");
    private By startDateBy=By.cssSelector("[id*=\"date_selector_oro_calendar_event_form_start-uid\"]");
    private By startTimeBy=By.cssSelector("[id*=\"time_selector_oro_calendar_event_form_start-uid\"]");


    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        action=new Actions(driver);

        BrowserUtils.wait(3);

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);

        BrowserUtils.wait(5);
        action.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }
    @Test
    public void verifycalendartEvent(){

        WebElement calendarEventBtn = driver.findElement(calenderEventBy);
        Assert.assertTrue(calendarEventBtn.isDisplayed());


    }


    /**
     * Test Case: Default options
     * Login as sales manager
     * Go to Activities --> Calendar Events
     * Click on Create Calendar Event
     * Default owner name should be current user
     * Default title should be blank
     * Default start date should be current date
     * Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues(){

        driver.findElement(calenderEventBy).click();
        BrowserUtils.wait(3);
        String currentUserName=driver.findElement(currentUserBy).getText();
        //System.out.println("currentUserName = " + currentUserName);
        String ownerName= driver.findElement(ownerNameBy).getText().trim();

        Assert.assertEquals(currentUserName,ownerName);

//Default title should be blank
        WebElement titleElement=driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");

        Assert.assertEquals(actualDate,expectedDate);

        String expectedTime= LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime=driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime,expectedTime);

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

//Test Case: Default options
//Login as sales manager
//Go to Activities --> Calendar Events
//Click on Create Calendar Event
//Default owner name should be current user
//Default title should be blank
//Default start date should be current date
//Default start time should be current time




}