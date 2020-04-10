package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.VehiclesPage;
import com.automation.tests.vytrack.AbstractTestBase;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VehicleServiceLog extends AbstractTestBase {

    /*
    log in as driver
     */
    @Test
    public void verifyLoginServiceLog(){

        LoginPage loginpage = new LoginPage();
        VehiclesPage vehiclesPage= new VehiclesPage();

        loginpage.login("user19","UserUser123");
        vehiclesPage.navigateTo("Fleet","Vehicle Services Logs");

        String actual = Driver.getDriver().getTitle();
        String expected = "Vehicle Services Logs - Entities - System - Car - Entities - System";

        Assert.assertEquals(actual,expected);
    }
    /*
    log in as unauthorized user
     */
    @Test
    public void verifyLoginServiceLog2(){
        LoginPage loginPage=new LoginPage();
        VehiclesPage vehiclesPage= new VehiclesPage();

        loginPage.login();
        vehiclesPage.navigateTo("Fleet","Vehicle Services Logs");

        String actualMessage = Driver.getDriver().findElement(By.xpath("//*[@class=\"message\" and contains(text(),\"permission\")]")).getText();
        String expectedMessage = "You do not have permission to perform this action.";

        Assert.assertEquals(actualMessage,expectedMessage);


    }


}
