package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class PracticeTests {
    private static WebDriver driver;
/*
- setup before/after methods
	- in before method. instantiate webdriver and navigate to: http://practice.cybertekschool.com/
	- in after method - just close webdriver.
- create a test called lofinTest
	- go to “Form Authentication” page
	- enter valid credentials
	- verify that following sub-header message is displayed: “Welcome to the Secure Area. When you are done click logout below.”
 */
    @BeforeMethod
    public void beforeMethod(){
        driver= DriverFactory.createDriver("chrome");

       // "IQ  = HOW TO HANDLE SSL ISSUES IN SELENIUM"

        //Chromeoptions - use to customize browser for tests
        ChromeOptions chromeOptions=new ChromeOptions();
        //to ignore "your connection is not private issue"

        chromeOptions.setAcceptInsecureCerts(true);
        //PROVIDE CHROMEoPTIONS OBJECT INTO CHROMODRIVER CONSTRUSTOR
        driver.get("http://practice.cybertekschool.com/");

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void loginTest(){

        driver.findElement(By.partialLinkText("Form Authentication")).click();
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.id("wooden_spoon")).click();

        String actual=driver.findElement(By.className("subheader")).getText();
        String expected="Welcome to the Secure Area. When you are done click logout below.";


//if assertion fails, it will throw exception and message will be printed
        Assert.assertEquals(actual,expected,"Sub-header message is not matching");



    }
    /**
     * TASK for 5 minutes
     * Given user is on the practice landing page
     * When user navigates to "Forgot password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void forgotPasswordTest(){
    }
    @Test
    public void forgotPassword(){
driver.findElement(By.partialLinkText("Forgot Password")).click();
driver.findElement(By.name("email")).sendKeys("asdf@asd.com",Keys.ENTER);

Assert.assertEquals("Your e-mail's been sent!",driver.findElement(By.name("confirmation_message")).getText());

    }

/*/**
 * TASK for 5 minutes
 * Given user is on the practice landing page
 * When user navigates to "Checkboxes" page
 * And clicks on checkbox #1
 * Then user verifies that checkbox #1 is selected
 */

@Test
public void checkBoxes(){
    driver.findElement(By.partialLinkText("Checkboxes")).click();
    BrowserUtils.wait(2);
    driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).click();
    BrowserUtils.wait(2);
    Assert.assertTrue(driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).get(0).isSelected());
}

}
