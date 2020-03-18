package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest(){
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        List<WebElement> searchItems= driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems){
            String var = searchItem.getText();
            //if there is a text - print it
            if(!var.isEmpty()){
                System.out.println(var);
                //verify that every search result contains java
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }
        }

    }

    @Test(description = "Search for Java book on amazon")
    public void amazonSearch(){
        driver.get("http://amazon.com");
        BrowserUtils.wait(2);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);

        List<WebElement> searchItems=driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
        //click on the first item
        searchItems.get(0).click();

        WebElement productTitle = driver.findElement(By.id("title"));
        String productTitleString = productTitle.getText();
        System.out.println(productTitleString);

        Assert.assertTrue(productTitleString.contains("Java"));

    }

    @BeforeMethod
    public void  setuo(){
        WebDriverManager.chromedriver().version("79").setup();
        driver=new ChromeDriver();
    }

    @AfterMethod
    public void teardown(){
        //close browser and destroy driver object
        driver.quit();
    }

}
