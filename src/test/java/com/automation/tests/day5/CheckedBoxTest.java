package com.automation.tests.day5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckedBoxTest {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        //verify that 1st checkbox is not selected and 2nd is selected

        driver.get("http://practice.cybertekschool.com/checkboxes");












    }
}
