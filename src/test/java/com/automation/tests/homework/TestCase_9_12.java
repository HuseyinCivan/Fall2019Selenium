package com.automation.tests.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestCase_9_12 {
    private static WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com/";
    private By statusCodeBy=By.linkText("Status Codes");

    private By code200By=By.linkText("200");
    private By code301By=By.linkText("301");
    private By code404By=By.linkText("404");
    private By code500By=By.linkText("500");

    private By statusMessageBy=By.cssSelector("#content>div>p");
    private By hereBy=By.linkText("here");

    @BeforeTest
    public void setup(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
        driver.findElement(statusCodeBy).click();

    }
    @AfterTest
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }

    @Test(priority = 1)
    public void testCase_9(){
        driver.findElement(code200By).click();
        String actual=driver.findElement(statusMessageBy).getText();
        String expected="This page returned a 200 status code.";
        Assert.assertTrue(actual.contains(expected));
        driver.findElement(hereBy).click();

    }
    @Test(priority = 2)
    public void testCase_10(){
        driver.findElement(code301By).click();
        String actual=driver.findElement(statusMessageBy).getText();
        String expected="This page returned a 301 status code.";
        Assert.assertTrue(actual.contains(expected));
        driver.findElement(hereBy).click();
    }
    @Test(priority = 3)
    public void testCase_11(){
        driver.findElement(code404By).click();
        String actual=driver.findElement(statusMessageBy).getText();
        String expected="This page returned a 404 status code.";
        Assert.assertTrue(actual.contains(expected));
        driver.findElement(hereBy).click();
    }
    @Test(priority = 4)
    public void testCase_12(){
        driver.findElement(code500By).click();
        String actual=driver.findElement(statusMessageBy).getText();
        String expected="This page returned a 500 status code.";
        Assert.assertTrue(actual.contains(expected));

    }

}
