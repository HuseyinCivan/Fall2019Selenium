package com.automation.tests.warmup;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class Day12_Warm_Up {
    private static WebDriver driver;

    @BeforeMethod
    public void beforeMethod(){
        driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");

    }
    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }

    @Test
    public void lastNameSortCheck(){

        driver.findElement(By.xpath("//table[1]//span[text()=\"Last Name\"]")).click();

        List<WebElement> lastNames = driver.findElements(By.xpath("//table[1]//tr/td[1]"));

        for (int i = 0; i < lastNames.size()-1; i++) {
            //take a string
            String value = lastNames.get(i).getText();
            //take a following string
            String nextValue= lastNames.get(i+1).getText();
            //if difference is negative - order value is BEFORE nextValue in alphabetical order
            //if difference is negative - order value is AFTER nextValue in alphabetical order
            //if difference is negative - order value is AND nextValue ARE EQUALS

            Assert.assertTrue(value.compareTo(nextValue)<=0);
        }

    }

}
