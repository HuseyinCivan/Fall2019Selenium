package com.automation.tests.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AmazonTest3 {
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
                driver.findElements(By.xpath("//span[@cel_widget_id=\"SEARCH_RESULTS-SEARCH_RESULTS\"]//a[@class=\"a-link-normal\"]")).get(0).click();

            } catch (Exception e) {

            }





        }
    }
}
