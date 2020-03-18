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

public class AmazonTest3 {
    public static void main(String[] args) throws InterruptedException, IOException {

        List<String> asins = Files.readAllLines(Paths.get("C:\\Users\\h_civ\\IdeaProjects\\Fall2019Selenium\\src\\test\\java\\com\\automation\\tests\\amazon\\asin_TEST_available"));
        System.out.println("asins = " + asins);

        WebDriverManager.chromedriver().version("79").setup();
        WebDriver driver = new ChromeDriver();

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


        for (String asin : asins) {
            driver.findElement(By.id("twotabsearchtextbox")).clear();
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(asin, Keys.ENTER);
            Thread.sleep(500);

          //  try{
                try {
                    driver.findElements(By.xpath("//span[@cel_widget_id=\"SEARCH_RESULTS-SEARCH_RESULTS\"]//a[@class=\"a-link-normal\"]")).get(0).click();

                    //System.out.println(asin+ " --> HAS AMAZON PAGE");

                    driver.findElement(By.xpath("//div[@id=\"shippingMessageInsideBuyBox_feature_div\"]//span[@class=\"a-size-base\"]")).click();
                    System.out.println(asin);
                    Thread.sleep(500);

                    List<WebElement> priceDetails=driver.findElements(By.xpath("//div[@id=\"a-popover-content-9\"]//span[@class=\"a-size-base a-color-base\"]"));

                        System.out.println(driver.findElement(By.xpath("By.xpath(\"//div[@id=\\\"a-popover-content-9\\\"]//td[@class=\\\"a-span2 a-text-left\\\"]//span[1]")).getText());
                        System.out.println(driver.findElement(By.xpath("By.xpath(\"//div[@id=\\\"a-popover-content-9\\\"]//td[@class=\\\"a-span2 a-text-left\\\"]//span[2]")).getText());
                        System.out.println(driver.findElement(By.xpath("By.xpath(\"//div[@id=\\\"a-popover-content-9\\\"]//td[@class=\\\"a-span2 a-text-left\\\"]//span[3]")).getText());
                        System.out.println(driver.findElement(By.xpath("By.xpath(\"//div[@id=\\\"a-popover-content-9\\\"]//td[@class=\\\"a-span2 a-text-left\\\"]//span[4]")).getText());
                        System.out.println("\n______________________________\n");


                    //B003EMXR42
                    //B01ITRVWBQ
                    //B00WBATK0S
                    //B001E6VHB0



                }catch (Exception e) {
                    System.out.println(asin+" --> NO AMAZON PAGE");
                }

//                try{
//                    driver.findElement(By.xpath("//*[@id=\"shippingMessageInsideBuyBox_feature_div\"]/div/div/div/span[2]/a/span")).click();
//
//                    driver.findElement(By.xpath("//*[@id=\"a-popover-content-7\"]/table/tbody/tr[5]/td[3]/span")).getText();
//                    // List<WebElement> prices = driver.findElements(By.xpath("//div[@id=\"a-popover-content-7\"]//span[@class=\"a-size-base a-color-base\"]"));
//
//                    //System.out.println(prices.get(0).getText());
//
//
//                } catch (Exception e) {
//                    System.out.println(asin+" --> NO SHIPPING TO CANADA ");
//
//                }
//            }catch (Exception e){
////

//

 //          }

        }
    }
}
