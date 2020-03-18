package com.automation.tests.day8.testNGTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {


    @Test(description = "Verify page title",dataProvider = "testData")
    public void test1(String url, String title){
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        Assert.assertTrue(driver.getTitle().contains(title));
        driver.quit();
    }
    @DataProvider(name = "testData")
    public Object[][] testData(){
        return new Object[][]{  {"http://www.google.com","Google"},
                                {"http://amazon.com",    "Amazon"},
                                {"http://etsy.com",      "Etsy"},
                                {"http://ebay.com",      "Ebay"},
                                {"http://cybertekschool.com","Cybertek"}
        };

    }

}
