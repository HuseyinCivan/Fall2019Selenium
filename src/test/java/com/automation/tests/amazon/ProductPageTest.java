package com.automation.tests.amazon;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ProductPageTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("https://amazon.com");
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.findElement(By.id("nav-packard-glow-loc-icon")).click();
        Thread.sleep(500);
        driver.findElement(By.id("GLUXCountryListDropdown")).click();
        Thread.sleep(500);
        driver.findElement(By.id("GLUXCountryList_45")).click();
        Thread.sleep(500);
        driver.findElement(By.name("glowDoneButton")).click();
        Thread.sleep(500);

        driver.get("https://www.amazon.com/Jack-Jill-Toothpaste-Blueberry-Strawberry/dp/B00F6TZ9QK/ref=sr_1_1?keywords=B00F6TZ9QK&qid=1583984053&sr=8-1&th=1");

        driver.findElement(By.xpath("//div[@id=\"shippingMessageInsideBuyBox_feature_div\"]//a[@class=\"a-popover-trigger a-declarative\"]")).click();

        System.out.println(driver.findElement(By.xpath("//*[@id=\"a-popover-content-6\"]/table/tbody/tr[1]/td[3]/span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"a-popover-content-6\"]/table/tbody/tr[2]/td[3]/span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"a-popover-content-6\"]/table/tbody/tr[3]/td[3]/span")).getText());
        System.out.println(driver.findElement(By.xpath("//*[@id=\"a-popover-content-6\"]/table/tbody/tr[5]/td[3]/span")).getText());

    }
}
