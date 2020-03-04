package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws InterruptedException {
       // WebDriver driver = DriverFactory.createADriver("chrome");

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");
        Thread.sleep(3000);


        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(2000);

        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");

        Thread.sleep(2000);

        driver.findElement(By.id("wooden_spoon")).click();



       if( driver.findElement(By.tagName("h4")).getText().equals("Welcome to the Secure Area. When you are done click logout below.") ){
           System.out.println("TEST PASSED");
       }else {
           System.out.println("TEST FAILED");
       }


        Thread.sleep(2000);
        driver.quit();



    }
}
