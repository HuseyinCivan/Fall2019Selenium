package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {

        //to start selenium script we need:
        //setup webdriver (browsrer driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium, everything starts from Webdriver interface

        driver.get("http://www.google.com");










    }
}
