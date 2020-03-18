package com.automation.tests.homework;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Case_7 {
    private static WebDriver driver;
    String URL="https://practice-cybertekschool.herokuapp.com/";
    private By URLFileUploadBy=By.linkText("File Upload");
    private By chooseFile=By.id("file-upload");
    private By uploadBy=By.id("file-submit");
    private By fileUploadedMessageBy=By.tagName("h3");
    private By uploadedFileNameBy=By.id("uploaded-files");


    @Test
    public void testCase_7(){
        driver= DriverFactory.createDriver("chrome");
        driver.get(URL);
        driver.findElement(URLFileUploadBy).click();
        driver.findElement(chooseFile).sendKeys("C:\\Users\\h_civ\\Desktop\\testCase_7.txt");
        driver.findElement(uploadBy).click();

        String expectedMessage="File Uploaded!";
        String actualMessage=driver.findElement(fileUploadedMessageBy).getText();

        Assert.assertEquals(actualMessage,expectedMessage);

        String expectedFileName="testCase_7.txt";
        String actualFileName=driver.findElement(uploadedFileNameBy).getText();

        Assert.assertEquals(actualFileName,expectedFileName);

        driver.quit();

    }















}
