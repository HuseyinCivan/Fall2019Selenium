package com.automation.tests.homework.homework_4;

import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class Links {
    @Test
    public void links_w3schools(){
        WebDriver driver= Driver.getDriver();
        driver.get("https://www.w3schools.com/");
        List<WebElement> allLinks =  driver.findElements(By.tagName("a"));
        for (int x = 0; x < allLinks.size() ; x++) {
            if(allLinks.get(x).isDisplayed()){
                System.out.println(allLinks.get(x).getText());
                System.out.println(allLinks.get(x).getAttribute("href"));
            }
        }
driver.quit();
    }
}
