package com.automation.tests.warmup;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

public class AmazonAsinTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> asins = Files.readAllLines(Paths.get("C:\\Users\\h_civ\\IdeaProjects\\Fall2019Selenium\\src\\test\\java\\com\\automation\\tests\\warmup\\asinTest.txt"));
        System.out.println("asins = " + asins);

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://amazon.com");

        for (String asin : asins) {
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys(asin, Keys.ENTER);
            Thread.sleep(1000);

           try {
               driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]")).click();
           }catch (Exception e){
               driver.findElement(By.id("twotabsearchtextbox")).clear();
           }finally {
               driver.findElement(By.id("twotabsearchtextbox")).clear();
           }




        }










    }
}
