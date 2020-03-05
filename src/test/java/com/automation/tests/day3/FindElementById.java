package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

        Thread.sleep(2000);



       if( driver.findElement(By.tagName("h4")).getText().equals("Welcome to the Secure Area. When you are done click logout below.") ){
           System.out.println("TEST PASSED");
       }else {
           System.out.println("TEST FAILED");
       }


        //let's click on Logout button. It looks like a button, but it's actually a link
        //every element with <a> tag is a link
        //if you have couple spaces in the text, just use partialLinkText instead of linkText
        //linkText - equals()
        //partialLinkText - contains() -not complete match required

       WebElement logout = driver.findElement(By.partialLinkText("Logout"));

       String href = logout.getAttribute("href");
       String className = logout.getAttribute("class");
        System.out.println("href = " + href);
        System.out.println("className = " + className);

        logout.click();

        //lets enter invalid credentioals

        driver.findElement(By.name("username")).sendKeys("wrong");
        driver.findElement(By.name("password")).sendKeys("wrong");

        driver.findElement(By.id("wooden_spoon")).click();

        Thread.sleep(2000);

        WebElement errorMessage =driver.findElement(By.id("flash"));    // --> By.id("flash-messages") yapinca da calisti

        System.out.println("errorMessage = " + errorMessage.getText());





        Thread.sleep(2000);
        driver.quit();



    }
}
