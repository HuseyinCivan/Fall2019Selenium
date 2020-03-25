package com.automation.tests.homework.homework_4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;

public class Days {
    private WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= DriverFactory.createDriver("chrome");
        BrowserUtils.wait(2);
        driver.manage().window().maximize();

    }
    //DAYS
    //1. go to http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox
    //2. Randomly select a checkbox. As soon as you check any day, print the name of the day
    //and uncheck immediately.
    //After you check and uncheck Friday for the third time, exit the program.
    //NOTE: Remember some checkboxes are not selectable. You need to find a way to ignore them
    //when they are randomly selected. It has to be dynamic. Do not hard code Saturday and Sunday.
    //Use values of certain attributes.
    @Test
    public void daysSelect() throws InterruptedException {

        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        BrowserUtils.wait(3);

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@type='checkbox']"));
        List<WebElement> checkboxNames= driver.findElements(By.xpath("//*[@type='checkbox']/following-sibling::label"));

        Random random=new Random();



        int countOfFriday=0;

        for (countOfFriday = 0; countOfFriday<3 ; ) {
            int index= random.nextInt(checkboxes.size());
            if(checkboxNames.get(index).getAttribute("for").contains("Friday")){
                countOfFriday++;

            }if(checkboxes.get(index).isEnabled()){
                checkboxes.get(index).click();
                System.out.println(checkboxNames.get(index).getText());
                checkboxes.get(index).click();
            }else {
                continue;
            }

        }

    }

    @AfterMethod
    public void teardown(){
        driver.quit();
    }

}

