package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebElement;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://google.com");
        Thread.sleep(2000);
        //By.name("q")  --> name="q"
        // name - it's one of the selenium locaters
        //there are 8 locators
        //to choose locator, just use By.locator
        WebElement search = driver.findElement(By.name("q"));
        //once we found an element, how to enter text ?

        //to enter text use sendKeys() method
        //how to press Enter after entering the text?
        //use Key.ENTER
        //keys.ENTER - perform keyboard click
        search.sendKeys("Java", Keys.ENTER);
        Thread.sleep(2000);

        //if see <a> element , it calls link
        //visible text of this link , can be used by selenium to find this elemnt
        WebElement news=driver.findElement(By.linkText("News"));
        news.click(); //

        Thread.sleep(2000);





        driver.quit();
    }
}
