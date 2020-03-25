package com.automation.tests.homework.homework_4;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Random;

public class test {
    private WebDriver driver;



    @Test
    public void test() {
        driver=DriverFactory.createDriver("chrome");
        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.manage().window().maximize();
        int i = 0;
        // while (i<=3){
        //wait.until(ExpectedConditions.elementToBeClickable(checkbox1));
        while (i <= 3) {
            Random random = new Random();
            int a = random.nextInt(5);
            String day = "";
            WebElement element = driver.findElement(By.xpath("(//table)[5]//tbody//tr[" + (a + 2) + "]//input"));
            element.click();
            WebElement element1 = driver.findElement(By.xpath("(//table)[5]//tbody//tr[" + (a + 2) + "]"));
            String eachDay = element1.getText();
            System.out.println(eachDay);
            if (eachDay.equals("Friday")) {
                i++;
            }
        }
    }
}