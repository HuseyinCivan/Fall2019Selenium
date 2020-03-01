package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
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

        driver.findElement(By.xpath("//input[@title=\"Search\"]")).sendKeys("hello world");
        driver.findElement(By.name("btnK")).click();

        driver.navigate().refresh(); //to reload page
        System.out.println("driver.getCurrentUrl() GOOGLE = " + driver.getCurrentUrl());

        driver.manage().window().maximize(); // to maximize browser
        driver.manage().window().fullscreen();
        driver.manage().window().maximize();




        String title = driver.getTitle();

        System.out.println("title is = " + title);


        String expectedTitle = "Google";

        if (expectedTitle.equals(title)) {
            System.out.println("TEST PASSED !");
        } else {
            System.out.println("TEST FAILED !");
        }
        Thread.sleep(3000);  // for demo with 3 sec.
        driver.navigate().to("http://amazon.com");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone x 16gb");
        driver.findElement(By.className("nav-input")).click();


 //       if (driver.getTitle().toLowerCase().contains("amazon")) {
        if(driver.getTitle().toLowerCase().contains("amazon")){
            System.out.println("Test Passed ! ");
        } else {
            System.out.println("Test failed !");
        }
        verifyEquals(driver.getTitle().toLowerCase(),"amazon");
        Thread.sleep(3000);  // for demo with 3 sec.
        driver.navigate().back();
        Thread.sleep(3000);  // for demo with 3 sec.
        verifyEquals(driver.getTitle(), "Google");
        Thread.sleep(3000);  // for demo with 3 sec.
        driver.navigate().forward();
        verifyEquals(driver.getTitle().toLowerCase(),"amazon");


        Thread.sleep(3000);  // for demo with 3 sec.

        //must be at the end !
        driver.close();


    }

    //    /**
//     * Check if to strings are same. If print TEST PASSED! message.
//     * Otherwise, print TEST FAILED message
//     * @param arg1
//     * @param arg2
//     */
    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("TEST PASSED"+" based on "+arg1+" vs "+" "+arg2);
        } else {
            System.out.println("TEST FAILED"+" based on "+arg1+" vs "+" "+arg2);
        }


    }
}
//Vasyl
//package com.automation.tests.day2;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//public class BasicNavigation {
//    public static void main(String[] args) throws Exception{
//        //to start selenium script we need:
//        //setup webdriver (browser driver) and create webdriver object
//        WebDriverManager.chromedriver().setup();
//        WebDriver driver = new ChromeDriver();
//        //In selenium, everything starts from WebDriver interface'
//        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
//        driver.get("http://google.com");//to open a website
//        driver.manage().window().maximize();//to maximize browser
////        driver.manage().window().fullscreen();
//        Thread.sleep(3000);//for demo, wait 3 seconds
//        //method that return page title
//        //you can also see it as tab name, in the browser
//        String title = driver.getTitle();//returns <title>Some title</title> text
//        String expectedTitle = "Google";//we provide it
//        System.out.println("Title is..."+title);
//        if(expectedTitle.equals(title)){
//            System.out.println("TEST PASSED!");
//        }else{
//            System.out.println("TEST FAILED!");
//        }
//        //go to another website within the same window
//        driver.navigate().to("http://amazon.com");
//        Thread.sleep(3000);//for demo, wait 3 seconds
//        if(driver.getTitle().toLowerCase().contains("amazon")){
//            System.out.println("TEST PASSED!");
//        }else{
//            System.out.println("TEST FAILED!");
//        }
//        //comeback to google
//        driver.navigate().back();
//        Thread.sleep(3000);//for demo, wait 3 seconds
//        //checking if page title is equals to Google
//        //.getTitle() - returns page title
//        verifyEquals(driver.getTitle(), "Google");
//        //move forward in the browser history
//        //again, going to amazon
//        driver.navigate().forward();
//        Thread.sleep(3000);//for demo, wait 3 seconds
//        System.out.println("Title: "+driver.getTitle());
//        //driver.getTitle() - returns page title of the page that is currently opened
//        //must be at the end
//        driver.close();//to close browser
//        //browser cannot close itself
//    }
//    /**
//     * Check if to strings are same. If print TEST PASSED! message.
//     * Otherwise, print TEST FAILED message
//     * @param arg1
//     * @param arg2
//     */
//    public static void verifyEquals(String arg1, String arg2){
//        if(arg1.equals(arg2)){
//            System.out.println("TEST PASSED!");
//        }else{
//            System.out.println("TEST FAILED!");
//        }
//    }
