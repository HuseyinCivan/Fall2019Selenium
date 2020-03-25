package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class Test_Case_6_3 {
    private static WebDriver driver;
    @Test
    public void test(){

        driver.get("https://www.tempmailaddress.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        String emailAddress = driver.findElement(By.id("email")).getText();
        System.out.println("Email :"+emailAddress);
        BrowserUtils.wait(5);
        driver.navigate().to("https://practice-cybertekschool.herokuapp.com/");
        BrowserUtils.wait(5);
        WebElement signUpForMailingList=driver.findElement(By.linkText("Sign Up For Mailing List"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", signUpForMailingList);
        System.out.println(signUpForMailingList.isDisplayed());
        signUpForMailingList.click();
        BrowserUtils.wait(2);
        WebElement fullName=driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mike Johnson");
        WebElement email= driver.findElement(By.name("email"));
        email.sendKeys(emailAddress);
        WebElement signupBtn= driver.findElement(By.name("wooden_spoon"));
        signupBtn.click();
        BrowserUtils.wait(3);
        WebElement signupMessage=driver.findElement(By.name("signup_message"));
        Assert.assertTrue(signupMessage.isDisplayed());
        BrowserUtils.wait(3);
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(5);
//verifying email address
        WebElement emailAd = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
        System.out.println("displayed :"+emailAd.isDisplayed());
        System.out.println("emailAd :"+emailAd.getText());
        String displayedEmail = emailAd.getText().trim();
        Assert.assertEquals(displayedEmail,"do-not-reply@practice.cybertekschool.com");
//verifying SUBJECT
        List<WebElement> subjectValue = Collections.singletonList(driver.findElement(By.xpath("//table/tbody/tr[1]/td/following-sibling::td")));
        System.out.println(subjectValue.get(0).getText());
        String subjectText = subjectValue.get(0).getText();
        System.out.println("subjectText :"+subjectText);
        Assert.assertEquals(subjectText,"Thanks for subscribing to practice.cybertekschool.com!");
    }
}
