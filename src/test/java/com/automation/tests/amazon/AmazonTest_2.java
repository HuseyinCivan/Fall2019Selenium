package com.automation.tests.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AmazonTest_2 {
    public static void main(String[] args) throws InterruptedException, IOException {
        List<String> asins = Files.readAllLines(Paths.get("C:\\Users\\h_civ\\IdeaProjects\\Fall2019Selenium\\src\\test\\java\\com\\automation\\tests\\amazon\\asinTest.txt"));
        System.out.println("asins = " + asins);

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://amazon.com");
        Thread.sleep(1000);

        driver.findElement(By.id("nav-packard-glow-loc-icon")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("GLUXCountryListDropdown")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("GLUXCountryList_45")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("glowDoneButton")).click();
        Thread.sleep(1000);


        for (String asin : asins) {
            driver.findElement(By.id("twotabsearchtextbox")).clear();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(asin, Keys.ENTER);
            Thread.sleep(1000);
            try {
                driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a")).click();
                Thread.sleep(1000);

                try {
                    driver.findElement(By.xpath("//*[@id=\"shippingMessageInsideBuyBox_feature_div\"]/div/div/div/span[2]/a/span")).click();
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"a-popover-content-8\"]/table/tbody/tr[5]/td[3]/span")).getText());
                    System.out.println(driver.findElement(By.id("delivery-message")).getText());
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"productDetails_detailBullets_sections1\"]/tbody/tr[1]/td")));
                    System.out.println(driver.findElement(By.id("productTitle")).getText());
                    System.out.println();
                } catch (Exception e) {
                    System.out.println(driver.findElement(By.xpath("//*[@id=\"productDetails_detailBullets_sections1\"]/tbody/tr[1]/td")));
                    System.out.println("NO CANADA");
                    System.out.println(driver.findElement(By.id("productTitle")).getText());
                }


            } catch (Exception e) {

            }
        }





        //driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B00L9X6BXC", Keys.ENTER);

//        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("B07RDQF65N", Keys.ENTER);
//        Thread.sleep(1000);




driver.quit();
    }
}
