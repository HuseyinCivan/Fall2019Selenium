package com.automation.tests.day6.review;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");

        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(1);

        List<WebElement> buttons= driver.findElements(By.tagName("button"));

        driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
        BrowserUtils.wait(1);


        driver.switchTo().alert().accept();
        BrowserUtils.wait(1);

        System.out.println(driver.findElement(By.id("result")).getText());


        driver.findElement(By.xpath("//button[@onclick=\"jsConfirm()\"]")).click();
        driver.switchTo().alert().dismiss();
        System.out.println(driver.findElement(By.id("result")).getText());



        buttons.get(2).click();
        BrowserUtils.wait(1);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello World");
        alert.accept();
        System.out.println(driver.findElement(By.id("result")).getText());



        driver.quit();








    }
}
