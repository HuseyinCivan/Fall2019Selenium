package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test_Case_6 {

    private By emailBy=By.id("email");
    private String URLMail="https://www.tempmailaddress.com/";
    private String URLPractice="https://practice-cybertekschool.herokuapp.com/";
    private By signUpForBy=By.linkText("Sign Up For Mailing List");
    private By fullNameBy=By.name("full_name");
    private By email2By=By.name("email");
    private By submitBy=By.name("wooden_spoon");
    private By messageBy=By.name("signup_message");
    private By emailDoNotReplyBy=By.xpath("//tbody//tr[1]//td//span[@class=\"glyphicon glyphicon-envelope\"]");
    private By eMailFromBy=By.id("odesilatel");
    private By subjectBy=By.id("predmet");






 @Test
    public void testCase_6(){

     WebDriver driver= DriverFactory.createDriver("chrome");
     driver.get(URLMail);

     String email=driver.findElement(emailBy).getText();

     driver.get(URLPractice);
     driver.findElement(signUpForBy).click();
     BrowserUtils.wait(2);
     driver.findElement(fullNameBy).sendKeys("abc cdf");
     driver.findElement(email2By).sendKeys(email);
     driver.findElement(submitBy).click();
     BrowserUtils.wait(2);


     Assert.assertTrue(driver.findElement(messageBy).isDisplayed());
     BrowserUtils.wait(2);
     driver.navigate().to(URLMail);
     driver.navigate().refresh();
     BrowserUtils.wait(5);

     String senderEmailBy = driver.findElement(By.xpath("//*[@id=\"schranka\"]/tr[1]/td[1]/span")).getText();
     System.out.println(senderEmailBy);





   //   driver.findElement(emailDoNotReplyBy).click();

   //   String actualMailFrom=driver.findElement(eMailFromBy).getText();
    //  String expectedMailFrom="do-not-reply@practice.cybertekschool.com";

    //  Assert.assertEquals(actualMailFrom,expectedMailFrom);

    //  String actualSubjectBy=driver.findElement(subjectBy).getText();
    //  String expectedSubject="Thanks for subscribing to practice.cybertekschool.com!";

   //   Assert.assertEquals(actualSubjectBy,expectedSubject);

   //   driver.quit();











    }





}
