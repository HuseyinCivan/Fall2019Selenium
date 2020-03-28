package com.automation.tests.homework.homework_4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class Dates {

  WebDriver driver = Driver.getDriver();

    @Test
    public void verifyCurrentDate(){
      driver.get("http://practice.cybertekschool.com/dropdown");

//        Calendar now =Calendar.getInstance();
//        System.out.println(now.get(Calendar.YEAR));
//        System.out.println((now.get(Calendar.MONTH)+1));
//        System.out.println(now.get(Calendar.DATE));

//
//        //Getting the current date value
//        LocalDate currentdate = LocalDate.now();
//        System.out.println("Current date: "+currentdate);
//        //Getting the current day
//        int currentDay = currentdate.getDayOfMonth();
//        System.out.println("Current day: "+currentDay);
//        //Getting the current month
//        Month currentMonth = currentdate.getMonth();
//        System.out.println("Current month: "+currentMonth);
//        //getting the current year
//        int currentYear = currentdate.getYear();
//        System.out.println("Current month: "+currentYear);

     // String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));
     // System.out.println("expectedDate = " + expectedDate);

      String  day= String.valueOf(LocalDate.now().getDayOfMonth());
   //   String  day= LocalDate.now().getDayOfMonth()+"";
      String  month=LocalDate.now().getMonth().getValue()-1+"";
 //     System.out.println(LocalDate.now().getMonth().getValue());
      String year=String.valueOf(LocalDate.now().getYear());

      String actual_year=driver.findElement(By.id("year")).getAttribute("value");
      String actual_month=driver.findElement(By.id("month")).getAttribute("value");
      String actual_day=driver.findElement(By.id("day")).getAttribute("value");

      Assert.assertEquals(actual_day,day);
      Assert.assertEquals(actual_month,month);
      Assert.assertEquals(actual_year,year);

    }

    @Test
  public void verifyNumberOfDays(){
      driver.get("http://practice.cybertekschool.com/dropdown");
      WebElement year=driver.findElement(By.id("year"));
      Select selectYear= new Select(year);
      List<WebElement> allYears =driver.findElements(By.cssSelector("[id=\"year\"]>option"));
      Random random=new Random();

      for (int y = 0; y <10 ; y++) {

        int selectRandomYearByIndex = random.nextInt(allYears.size());
        selectYear.selectByIndex(selectRandomYearByIndex);

        WebElement month = driver.findElement(By.id("month"));
        Select selectMonth = new Select(month);

        //selectMonth.selectByVisibleText("January");

        for (int x = 0; x < 12; x++) {
          selectMonth.selectByIndex(x);
          YearMonth yearMonthObj = YearMonth.of(2020-selectRandomYearByIndex, (x + 1));
          int expected_DaysInMonth = yearMonthObj.lengthOfMonth();

          List<WebElement> daysOfMonth = driver.findElements(By.cssSelector("[id=\"day\"]>option"));
          int actual_DaysInMonth = daysOfMonth.size();

          Assert.assertEquals(actual_DaysInMonth, expected_DaysInMonth);

        }
        //// Get the number of days in that month
        //YearMonth yearMonthObject = YearMonth.of(1999, 2);
        //int daysInMonth = yearMonthObject.lengthOfMonth(); //28


      }
      driver.quit();

    }


}