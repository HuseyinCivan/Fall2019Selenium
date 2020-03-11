package com.automation.tests.amazon;

        import io.github.bonigarcia.wdm.WebDriverManager;
        import org.openqa.selenium.By;
        import org.openqa.selenium.Keys;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.edge.EdgeDriver;

        import java.io.IOException;
        import java.nio.file.Files;
        import java.nio.file.Paths;
        import java.util.List;

public class AmazonAsinTest {
    public static void main(String[] args) throws IOException, InterruptedException {

        List<String> asins = Files.readAllLines(Paths.get("C:\\Users\\h_civ\\IdeaProjects\\Fall2019Selenium\\src\\test\\java\\com\\automation\\tests\\warmup\\asinTest.txt"));
        System.out.println("asins = " + asins);

        WebDriverManager.chromedriver().version("79").setup();
        //WebDriverManager.edgedriver().setup();
        WebDriver driver=new ChromeDriver();
        //WebDriver driver=new EdgeDriver();

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
            try {
                driver.findElement(By.id("twotabsearchtextbox")).sendKeys(asin, Keys.ENTER);
                Thread.sleep(1000);



                driver.findElement(By.xpath("//*[@id=\"search\"]/div[1]/div[2]/div/span[4]/div[1]/div[1]/div/span/div/div/div[2]/div[1]/div/div/span/a")).click();
            }catch (Exception e){

            }finally {
                driver.findElement(By.id("twotabsearchtextbox")).clear();
            }

        }


    }
}
