package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxes {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(5);


        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));

       // checkBoxes.get(0).click();

        BrowserUtils.wait(2);

        //go over collections checkboxes

        for(int x=0; x<checkBoxes.size();x++){

            if(!checkBoxes.get(x).isSelected() && checkBoxes.get(x).isEnabled() && checkBoxes.get(x).isDisplayed() ){
                checkBoxes.get(x).click();
                System.out.println((x+1) + " checked box was clicked ! " );

            }else{
                System.out.println((x+1) + " checked box was not clicked ! " );
            }
        }



        BrowserUtils.wait(2);

     driver.quit();
    }
}
