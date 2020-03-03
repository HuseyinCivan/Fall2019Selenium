package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToTheNewWindow {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");

       Thread.sleep(5000);

        //every window has some id, this id calls window handle
        //based on window handle we can switch in between windows

        String windowHandle = driver.getWindowHandle();

        //getWindowHandles()  returns id's of all currently opened windows
        //Set - does not allow dublicates

        System.out.println(windowHandle);
        Set<String> windowHandles = driver.getWindowHandles();

        System.out.println(windowHandles);
        System.out.println("BEFORE SWITCH "+driver.getCurrentUrl());
        // since we have all windows
        // and we know id of original window ,
        // we can say switch to something that is not equals old window id

        for (String windowId : windowHandles){
            //if it is not an old window ,then switch
            if( ! windowId.equals(windowHandle)){
                //jump to the new window
            driver.switchTo().window(windowId);
            }
        }

        System.out.println("AFTER SWITCH "+driver.getCurrentUrl());

  //      driver.close();
        driver.quit();




    }

    /***
     *
     * @param pageTitle
     * @param driver
     */
    public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
    }
}