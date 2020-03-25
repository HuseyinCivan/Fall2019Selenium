package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.createDriver("chrome");
        wait=new WebDriverWait(driver,10);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }
    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }


    @Test
    public void checkBoxTest(){

        WebElement checkAllBtn=driver.findElement(By.id("ctl00_MainContent_btnCheckAll"));
        checkAllBtn.click();
        List<WebElement> checkButtons = driver.findElements(By.cssSelector("[type=\"checkbox\"]"));

//        boolean allSelected=false;

//        for (WebElement checkButton : checkButtons) {
//            allSelected=checkButton.isSelected();
//            if(allSelected==false){
//                break;
//            }
//        }

//        Assert.assertTrue(allSelected=true);

        for (WebElement checkButton : checkButtons) {
            Assert.assertTrue(checkButton.isSelected());
        }
    }

    @Test
    public void updateZipCode(){

        String actual=driver.findElement(By.xpath("//*[text()=\"Steve Johns\"]/following-sibling::td[7]")).getText();

        Assert.assertEquals(actual,"21233");

        WebElement updateBtn = driver.findElement(By.xpath("//*[text()=\"Steve Johns\"]/following-sibling::td[11]"));
        updateBtn.click();

        WebElement zipCode=driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));
        zipCode.clear();
        zipCode.sendKeys("20002");

        WebElement update2Btn=driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton"));
        update2Btn.click();

        actual=driver.findElement(By.xpath("//*[text()=\"Steve Johns\"]/following-sibling::td[7]")).getText();
        Assert.assertEquals(actual,"20002");



    }





}