package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class WebTables {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        //driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().version("79").setup();
        ChromeOptions chromeOptions=new ChromeOptions();

        //headless mode makes execution twice faster
        //it does everything except file uploading
        //set it to tru to make it work
        chromeOptions.setHeadless(false); //to run browaer without GUI. makes 2x faster

        driver=new ChromeDriver(chromeOptions);


        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown(){
        BrowserUtils.wait(2);
        driver.quit();
    }

    @Test
    public void getColumnNames(){
        //th - th represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());

        }

        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames),expected);
    }

    @Test
    public void verifyRowCount(){
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we get a size of this collection, it automatically equals to number of elements
        //expected 4 rows in the table

        Assert.assertEquals(rows.size(),4);

    }

    /**
     * To get specific column, skip row index, and just provide td index
     */
    @Test
    public void getSpecificColumn(){
        //td[5 - column with links]
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }
    /**
     * Go to tables example page
     * Delete record with jsmith@gmail.com	email
     * verify that number of rows is equal to 3
     * verify that jsmith@gmail.com	doesn't exit any more in the table
     */

    @Test
    public void deleteOne(){
        WebElement deleteBtn=driver.findElement(By.xpath("//table[1]//td[text()=\"jsmith@gmail.com\"]/..//a[text()=\"delete\"]"));
        deleteBtn.click();

        List<WebElement> rows = driver.findElements(By.xpath("(//tbody)[1]//tr"));
        Assert.assertTrue(rows.size()==3);


        //driver.findElement(By.xpath("//table[1]//tbody//tr//td[text()=\"jsmith@gmail.com\"]"));  // will give exeption


        //List<WebElement> emails = driver.findElements(By.xpath("//table[@id=\"table1\"]//td[text()=\"jsmith@gmail.com\"]"));

        //Assert.assertTrue(emails.isEmpty());

        List<WebElement> emails= driver.findElements(By.xpath("(//tbody)[1]//tr//td[3]"));
        Assert.assertTrue(!emails.contains("jsmith@gmail.com"));


    }

    @Test
    public void getColumnsIndexByName(){
        String columnName="Email";
        List<WebElement> columnNames= driver.findElements(By.xpath("//table[1]//th"));


        int index=0;
        for (int x = 0; x <columnNames.size() ; x++) {
            String actual=columnNames.get(x).getText();

            System.out.println(String.format("Column name: %s, position %s", actual, x));
          if(actual.equals(columnName)){
              index=x+1;
              break;
          }
        }
        Assert.assertEquals(index,3);
    }

    @Test
    public void getSpecificCell(){
        String expected="http://www.jdoe.com";
        int row=3;
        int column=5;
        String xpath = "//table[1]//tbody//tr["+row+"]//td["+column+"]";

        WebElement cell = driver.findElement(By.xpath(xpath));
       // System.out.println(cell.getText());

        Assert.assertEquals(cell.getText(),expected);

    }











}
//table[1]//td[text()="jdoe@hotmail.com"]/following-sibling::td/a[text()="delete"]
//table[1]//td[text()="fbach@yahoo.com"]/..//a[text()="delete"]
//table[1]//td[text()="fbach@yahoo.com"]/..//a[2]