package com.automation.tests.vytrack.fleet;

import com.automation.pages.LoginPage;
import com.automation.pages.fleet.Vehicles_Model;
import com.automation.tests.vytrack.AbstractTestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Vehicles_Model_Test2 extends AbstractTestBase {

    @Test
    public void editTest(){
        LoginPage loginpage = new LoginPage();
        Vehicles_Model vehicles_model=new Vehicles_Model();
        loginpage.login();
        vehicles_model.navigateTo("Fleet","Vehicles Model");

        vehicles_model.clickAModelRandomly();

        vehicles_model.clickEditBtn();

        vehicles_model.clickSaveAndClose();

        String actualMessage = vehicles_model.readPopUpMessage();
        String expected = "Entity saved";
        Assert.assertTrue(actualMessage.contains(expected));
    }

    @Test
    public void deleteTest(){
        LoginPage loginpage = new LoginPage();
        Vehicles_Model vehicles_model=new Vehicles_Model();
        loginpage.login();
        vehicles_model.navigateTo("Fleet","Vehicles Model");

        vehicles_model.clickAModelRandomly();
        vehicles_model.clickDeleteBtn();
        vehicles_model.click_Yes_DeleteBtn();

        String actualMessage = vehicles_model.readPopUpMessage();
        String expected = "Vehicles Model deleted";
        Assert.assertTrue(actualMessage.contains(expected));
    }
}
