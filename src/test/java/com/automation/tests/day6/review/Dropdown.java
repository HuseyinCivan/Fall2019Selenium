package com.automation.tests.day6.review;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        WebElement simpleDropDown=driver.findElement(By.id("dropdown"));
        Select selectSimpleDropDown= new Select(simpleDropDown);

        BrowserUtils.wait(1);

        selectSimpleDropDown.selectByVisibleText("Option 1");
        BrowserUtils.wait(1);
        selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(1);


        WebElement year= driver.findElement(By.id("year"));
        Select selectYear = new Select(year);

        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("1984");
        selectMonth.selectByVisibleText("June");
        selectDay.selectByVisibleText("5");

        //get all the months name

        List<WebElement> allSelectMonths = selectMonth.getOptions();

        for(int x=0; x<allSelectMonths.size();x++){
            String currentMonth= allSelectMonths.get(x).getText();
            selectMonth.selectByVisibleText(currentMonth);
        }

        List<WebElement> languages = driver.findElements(By.xpath("//select[@name=\"Languages\"]//option"));
        Select selectLanguages= new Select(driver.findElement(By.name("Languages")));

        for (int x=0;x<languages.size();x++) {
            System.out.println(languages.get(x).getText());

        }


 /*       selectLanguages.selectByIndex(0);
        selectLanguages.selectByIndex(1);
        selectLanguages.selectByIndex(2);
        selectLanguages.selectByIndex(3);
        selectLanguages.selectByIndex(4);*/

        for (int x = 0; x <languages.size() ; x++) {
            selectLanguages.selectByIndex(x);
        }

        driver.findElement(By.id("dropdownMenuLink")).click();

        List<WebElement> dropdownItems=driver.findElements(By.className("dropdown-item"));
        for (WebElement dropdownItem : dropdownItems) {
            System.out.println(dropdownItem.getAttribute("href"));
        }
driver.quit();



















    }
}
