package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploading {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(5);

       WebElement upload= driver.findElement(By.id("file-upload"));

        //https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
        //I am gonna upload pom.xml file
        String filePath = System.getProperty("user.dir")+"/pom.xml";
       // String filePath ="C:\\Users\\h_civ\\Desktop\\seda hp\\Downloads\\HP Downloads\\NVIDIA Graphics Driver Windows 10 v1903 - sp98825.exe";
        //cloud does not work ,must be at your computer
        System.out.println(filePath);

       upload.sendKeys(filePath);

        driver.findElement(By.id("file-submit")).click();


        BrowserUtils.wait(5);

        driver.quit();


    }
}
