package com.automation.tests.homework;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.*;


public class TestCase_1_5 {

    private static WebDriver driver;
    private String URL="https://practice-cybertekschool.herokuapp.com/";

    private By registrationBy=By.linkText("Registration Form");
    private By dobBy=By.name("birthday");
    private By wrongDOBMessageBy=By.xpath("//small[@class=\"help-block\" and @data-bv-for=\"birthday\"][2]");
    private By cplusPlusBy= By.xpath("//label[@class=\"form-check-label\" and text()=\"C++\"]");
    private By javaBy=By.xpath("//label[@class=\"form-check-label\" and text()=\"Java\"]");
    private By javaScriptBy=By.xpath("//label[@class=\"form-check-label\" and text()=\"JavaScript\"]");
    private By firstNameBy=By.name("firstname");
    private By firstNameErrorMessage=By.xpath("//small[@data-bv-validator=\"stringLength\"][@data-bv-for=\"firstname\"]");
    private By lastNameBy=By.name("lastname");
    private By lastNameErrorMessage=By.xpath("//small[@class=\"help-block\"][@data-bv-for=\"lastname\"][@data-bv-validator=\"stringLength\"]");
    private By formControlBy=By.className("form-control");
    private By maleGenderBy=By.cssSelector("[value=\"male\"]");
    private By departmentBy=By.name("department");
    private By jobtitleBy=By.name("job_title");
    private By signUpBy=By.id("wooden_spoon");
    private By successBy=By.tagName("p");









    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        driver.get(URL);
        BrowserUtils.wait(3);
        driver.findElement(registrationBy).click();
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }
//##############################################################################
    @Test
    public void testCase_1(){

        driver.findElement(dobBy).sendKeys("wrong_dob");
        BrowserUtils.wait(2);


        BrowserUtils.wait(2);

        assertTrue(driver.findElement(wrongDOBMessageBy).isDisplayed());
    }

    @Test
    public void testCase_2(){

        WebElement actualCpusPlus=driver.findElement(cplusPlusBy);
        WebElement actualJava=driver.findElement(javaBy);
        WebElement actualJavaScript=    driver.findElement(javaScriptBy);


        assertTrue(actualCpusPlus.isDisplayed());
        assertTrue(actualJava.isDisplayed());
        assertTrue(actualJavaScript.isDisplayed());
    }

    @Test
    public void testCase_3(){

        driver.findElement(firstNameBy).sendKeys("A");
        assertTrue(driver.findElement(firstNameErrorMessage).isDisplayed());
    }

    @Test
    public void testCase_4(){

        driver.findElement(lastNameBy).sendKeys("A");
        assertTrue(driver.findElement(lastNameErrorMessage).isDisplayed());

    }

    @Test
    public void testCase_5(){

        List<WebElement> formControl = driver.findElements(formControlBy);
        //System.out.println(formControl.size());

        String[] formControlData={"Jon","Snow","JonSnow","jonsnow_1990@got.com","GameOfThrones","123-456-7890","01/01/1990"};

        for (int x = 0; x < 7; x++) {
           // System.out.println(formControl.get(x).getAttribute("name"));

          formControl.get(x).sendKeys(formControlData[x]);
           BrowserUtils.wait(1);
        }
        driver.findElement(maleGenderBy).click();

        Select departmentSelect=new Select(driver.findElement(departmentBy));
        departmentSelect.selectByValue("DE");

        Select jobSelect=new Select(driver.findElement(jobtitleBy));
        jobSelect.selectByVisibleText("SDET");

        driver.findElement(javaBy).click();
        BrowserUtils.wait(3);
        driver.findElement(signUpBy).click();

        BrowserUtils.wait(4);

        WebElement successMessage= driver.findElement(successBy);
        assertTrue(successMessage.isDisplayed());

    }











}
