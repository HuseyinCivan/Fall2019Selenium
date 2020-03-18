package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

//STATIC IMPORT OF ALL ASSERTIONS
import static org.testng.Assert.*;

public class LoginPageTests {
    private WebDriver driver;
    //https is a secure version of http protocol
    //http - it's hypertext tansfer protocol that every single website is using nowadays
    //https - data encripted, no chance for hackers to retrive info
    //http - data as a plane text, very easy to hack it
    private String URL="https://qa2.vytrack.com/user/login";
    // CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";



    private By usernameBy= By.id("prependedInput");
    private By passwordBy=By.id("prependedInput2");
    private By warningMessageBy=By.cssSelector("[class=\"alert alert-error\"]>div");
    // > in css selector means same thing as / in xpath - direct child


    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername(){
    driver.findElement(usernameBy).sendKeys("invalidusername");
    driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
       // assertEquals(warningElement.getText(),"Invalid user name or password.");
        assertTrue(warningElement.isDisplayed());

    }

    @Test(description = "Login as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager(){
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(2);

        String expected ="Dashboard";
        String actual=driver.getTitle();
        //easily find on inspect !! <title>
       assertEquals(actual,expected,"Page title is not correct");

    }






    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver= new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

    }
    @AfterMethod
    public void teardown(){
        //if webdriver object alive
        if(driver!= null){
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver=null;
        }

    }






}
