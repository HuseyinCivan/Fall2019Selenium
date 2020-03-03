package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {

        //setup chrome driver
        WebDriverManager.chromedriver().setup();
        //create chromedriver object
        WebDriver driver = new ChromeDriver();
       // ChromeDriver driver= new ChromeDriver();

        driver.get("http://google.com");



    }
}
