package com.automation.tests.homework.homework_4;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Amazon {
    WebDriver driver = Driver.getDriver();

    @BeforeMethod
    public void setup(){
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

    }
    @AfterMethod
    public void teardown(){
 //     driver.quit();
    }

    @Test
    public void verifyDepartmentsDropdownDefaultValue(){
        WebElement departmentDropDown= driver.findElement(By.xpath("//div[@id=\"nav-search\"]//div[@class=\"nav-search-facade\"]"));
        String actual =departmentDropDown.getText();
        String expected ="All";
        Assert.assertEquals(actual,expected);

        List<WebElement> dropDownOptions = driver.findElements(By.cssSelector("[aria-describedby=\"searchDropdownDescription\"]>option"));
//        for (int x = 0; x <dropDownOptions.size() ; x++) {
//            System.out.println(dropDownOptions.get(x).getText());
//        }
        for (int x = 0; x < dropDownOptions.size()-1 ; x++) {
            String value= dropDownOptions.get(x).getText();
            String nextValue = dropDownOptions.get(x+1).getText();

            if(value.compareTo(nextValue)>0){
                System.out.println("TEST PASSED");
                break;
            }
        }

    }
@Test
    public void mainDepartments(){
        driver.get("https://www.amazon.com/gp/site-directory");
        List<WebElement> mainDepartments = driver.findElements(By.cssSelector("[class=\"fsdDeptTitle\"]"));
//    for (int x = 0; x <mainDepartments.size() ; x++) {
//
//        System.out.println(mainDepartments.get(x).getText());
//
//    }

    List<WebElement> departmentDropDownMenu = driver.findElements(By.cssSelector("[aria-describedby=\"searchDropdownDescription\"]>option"));

    List<String> allDepartmentsOnDropdownMenu = new ArrayList<>();
    for (int i = 0; i <departmentDropDownMenu.size() ; i++) {
       // System.out.println(departmentDropDownMenu.get(i).getText());
        allDepartmentsOnDropdownMenu.add(departmentDropDownMenu.get(i).getText());

    }

    for (int y = 0; y < mainDepartments.size() ; y++) {

        //belows are not on dropdown menu !
//        if(!allDepartmentsOnDropdownMenu.contains(mainDepartments.get(y).getText())){
//            System.out.print(mainDepartments.get(y).getText());
//            System.out.println(" --> Test Failed ! ");
//        }
        Assert.assertTrue(departmentDropDownMenu.contains(mainDepartments.get(y)));

    }

}
@Test
    public void testCart(){

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
        searchBar.sendKeys("wooden spoon");

        driver.findElement(By.cssSelector("[value=\"Go\"]")).click();

        //    for (int x = 0; x <searchResults.size() ; x++) {
//        System.out.print(x+1);
//        System.out.print(" ---> ");
//        System.out.println(searchResults.get(x).getText());
//    }
    for (int i = 0; i <10 ; i++) {
        List<WebElement> searchResults = driver.findElements(By.xpath("//div[contains(@data-asin,\"B\")]//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));

        Random random = new Random();
        int indexOfSearchReasult = random.nextInt(searchResults.size());
        String expected_productName = searchResults.get(indexOfSearchReasult).getText();
        searchResults.get(indexOfSearchReasult).click();

        WebElement qtyBtn = driver.findElement(By.xpath("//div[@id=\"quantityRelocate_feature_div\"]//span[@class=\"a-dropdown-prompt\"]"));
        Assert.assertEquals(qtyBtn.getText(), "1");
        WebElement productName = driver.findElement(By.id("productTitle"));
        String actual_ProductName = productName.getText();

        Assert.assertEquals(expected_productName, actual_ProductName);

        WebElement addToCartBtn = driver.findElement(By.id("add-to-cart-button"));
        Assert.assertTrue(addToCartBtn.isDisplayed());
        driver.navigate().back();
    }
}
@Test
    public void prime(){
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
    searchBar.sendKeys("wooden spoon");

    driver.findElement(By.cssSelector("[value=\"Go\"]")).click();

    WebElement firstSearchResult = driver.findElement(By.xpath("(//div[contains(@data-asin,\"B\")]//span[@class=\"a-size-base-plus a-color-base a-text-normal\"])[1]"));
    String firstSearchResultName=firstSearchResult.getText();

    WebElement firstSeachResultPrime =driver.findElement(By.xpath("(//div[contains(@data-asin,\"B\")]//i[@aria-label=\"Amazon Prime\"])[1]"));
    Assert.assertTrue(firstSeachResultPrime.isDisplayed());

    WebElement primeCheckBox=driver.findElement(By.xpath("//div[@id=\"primeRefinements\"]//i[@class=\"a-icon a-icon-checkbox\"]"));
    primeCheckBox.click();

    firstSeachResultPrime =driver.findElement(By.xpath("(//div[contains(@data-asin,\"B\")]//i[@aria-label=\"Amazon Prime\"])[1]"));
    Assert.assertTrue(firstSeachResultPrime.isDisplayed());

    List<WebElement> brandList = driver.findElements(By.cssSelector("[aria-labelledby=\"p_89-title\"]>li>span>a>div"));
    brandList.get(brandList.size()-1).click();

    List<WebElement> searchResults = driver.findElements(By.xpath("//span[@class=\"a-size-base-plus a-color-base a-text-normal\"]"));
    String firstResultName =searchResults.get(0).getText();

    Assert.assertTrue(!firstResultName.equals(firstSearchResultName));

}
@Test
    public void moreSpoons(){

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
    searchBar.sendKeys("wooden spoon");

    driver.findElement(By.cssSelector("[value=\"Go\"]")).click();

    List<WebElement> brands = driver.findElements(By.cssSelector("[aria-labelledby=\"p_89-title\"]>li"));
    WebElement primeBtn = driver.findElement(By.cssSelector("[aria-labelledby=\"p_89-title\"]"));
    primeBtn.click();

    List<WebElement> primeBtnAfterPrimeSelected = driver.findElements(By.cssSelector("[aria-labelledby=\"p_89-title\"]>li"));

    for (int x = 0; x < brands.size() ; x++) {
        System.out.println(brands.get(x).getAttribute("aria-label"));
        Assert.assertTrue(brands.contains(primeBtnAfterPrimeSelected.get(x)));
    }

}

@Test
    public void cheapSpoons(){

    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    WebElement searchBar = driver.findElement(By.id("twotabsearchtextbox"));
    searchBar.sendKeys("wooden spoon");

    driver.findElement(By.cssSelector("[value=\"Go\"]")).click();

    // not appear !!!
//  WebElement under25 = driver.findElement(By.xpath("//div[@id=\"priceRefinements\"]//*[text()=\"Under $25\"]"));
//   under25.click();

    List<WebElement> pricesWhole = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
    List<WebElement> priceFraction= driver.findElements(By.xpath("//span[@class='a-price-fraction']"));

    // System.out.println(pricesWhole.size());
  for (int x = 0; x < pricesWhole.size() ; x++) {
       double fullPrice = Double.parseDouble(pricesWhole.get(x).getText())  +  (Double.parseDouble(priceFraction.get(x).getText())/100) ;
       System.out.println(fullPrice);

    // Assert.assertTrue(   fullPrice < 25   );

   }

}
}
