package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByTextMultibleOptions {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        boolean isMultible = languagesSelect.isMultiple();
        System.out.println(isMultible);   //--> if it is true you can select more than one option

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //let's get all selected options

        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage : selectedLanguages){
            System.out.println("Selected Language is " +selectedLanguage.getText());
        }
        BrowserUtils.wait(3);


        languagesSelect.deselectByVisibleText("Java"); //to unselect something
        BrowserUtils.wait(3);

        languagesSelect.deselectAll();


















        BrowserUtils.wait(3);
        driver.quit();

    }

}
