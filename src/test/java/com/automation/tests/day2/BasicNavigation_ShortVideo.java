package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation_ShortVideo {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        String url = "http://google.com";
        String url2= "http://amazon.com";
        driver.get(url);

        Thread.sleep(3000);

        driver.navigate().to(url2);

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(3000);

        driver.navigate().forward();
        Thread.sleep(3000);

        driver.navigate().refresh();




        Thread.sleep(3000);

        driver.close();

        //
        //





    }
}
