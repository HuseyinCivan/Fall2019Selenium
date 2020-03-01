package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        //to start selenium script we need:
        //setup webdriver (browsrer driver) and create webdriver object

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        // in selenium, everything starts from Webdriver interface
        //Chromedriver extends RemoteWebDriver --> implements Webdriver

        driver.get("http://www.google.com");

        driver.manage().window().maximize(); // to maximize browser
        driver.manage().window().fullscreen();


        String title = driver.getTitle();

        System.out.println("title is = " + title);


        String expectedTitle = "Google";

        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED !");
        } else {
            System.out.println("TEST FAILED !");
        }

        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("Test Passed ! ");
        } else {
            System.out.println("Test failed !");
        }
        verifyEquals(driver.getTitle().toLowerCase(),"amazon");

        driver.navigate().back();

        verifyEquals(driver.getTitle(), "Google");


        Thread.sleep(3000);  // for demo with 3 sec.

        driver.close();


    }

    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED"+" based on "+arg1+" vs "+" "+arg2);
        } else {
            System.out.println("TEST FAILED"+" based on "+arg1+" vs "+" "+arg2);
        }


    }
}
