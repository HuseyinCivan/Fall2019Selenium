package com.automation.tests.amazon;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class getPrice {
private WebDriver driver;

    @BeforeTest
    public void beforeTest() {
         driver = DriverFactory.createDriver("chrome");

    }

    @Test
    public void getPriceDetails() throws InterruptedException {
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        //Thread.sleep(1000);

        driver.findElement(By.id("nav-packard-glow-loc-icon")).click();
        Thread.sleep(500);
        driver.findElement(By.id("GLUXCountryListDropdown")).click();
        Thread.sleep(500);
        driver.findElement(By.id("GLUXCountryList_45")).click();
        Thread.sleep(500);
        driver.findElement(By.name("glowDoneButton")).click();
        Thread.sleep(500);



            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B003EMXR42", Keys.ENTER);
            Thread.sleep(500);

            driver.findElements(By.xpath("//span[@cel_widget_id=\"SEARCH_RESULTS-SEARCH_RESULTS\"]//a[@class=\"a-link-normal\"]")).get(0).click();

            driver.findElement(By.xpath("//div[@id=\"shippingMessageInsideBuyBox_feature_div\"]//span[@class=\"a-size-base\"]")).click();

        List<WebElement> priceDetails=driver.findElements(By.xpath("//div[@id=\"a-popover-content-9\"]//td[@class=\"a-span2 a-text-left\"]//span"));
        for (int x = 1; x <=priceDetails.size() ; x++) {
            String price=priceDetails.get(x).getText();
            System.out.println(price);
        }


    }
}
