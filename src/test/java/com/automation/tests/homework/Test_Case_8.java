package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Case_8 {
    private static WebDriver driver;
    String URL="https://practice-cybertekschool.herokuapp.com/";
    private By autoCompleteBy=By.linkText("Autocomplete");
    private By countryBy=By.id("myCountry");
    private By submitBy=By.cssSelector("[class=\"btn btn-primary\"]");
    private By resultBy=By.id("result");



    @Test
    public void testCase_8(){
    driver= DriverFactory.createDriver("chrome");
    driver.get(URL);
    driver.findElement(autoCompleteBy).click();
    driver.findElement(countryBy).sendKeys("United States of America");
    driver.findElement(submitBy).click();
    BrowserUtils.wait(2);

    String actual=driver.findElement(resultBy).getText();
    String expected="You selected: United States of America";
    Assert.assertEquals(actual,expected);

    }

}

