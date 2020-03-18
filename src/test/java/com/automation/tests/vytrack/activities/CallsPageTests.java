package com.automation.tests.vytrack.activities;


/*
Scenario: Verify for store manager
Login as story manager
Go to Activities --> Calls
Verify that Log Call button is displayed

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

public class CallsPageTests {
private By usernameBy = By.id("prependedInput");
private By passwordBy=By.id("prependedInput2");

private WebDriver driver;
private Actions action;

private String username = "storemanager85";
private String password = "UserUser123";

private By activitiesBy=By.xpath("//span[@class=\"title title-level-1\" and contains(text(),\"Activities\")]");

private By logCallBynBy=By.cssSelector("a[title=\"Log call\"]");


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

    driver.findElement(By.linkText("Calls")).click();
    BrowserUtils.wait(5);

}
@Test
public void verifyLogButton(){

    WebElement logCallBtnElement = driver.findElement(logCallBynBy);
    Assert.assertTrue(logCallBtnElement.isDisplayed());


}




@AfterMethod
    public void teardown(){
    driver.quit();
}



}
