package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.List;
import java.util.Random;

public class Vehicles_Model extends AbstractPageBase {


    @FindBy(xpath = "//table/tbody/tr/td[2]")
    private List<WebElement> modelNames;

    @FindBy(css = "[title=\"Edit Vehicles Model\"]")
    private WebElement editBtn;

    @FindBy(css = "[class=\"btn btn-success action-button\"]")
    private WebElement saveAndCloseBtn;

    @FindBy(css = "[class=\"flash-messages-holder\"]")
    private WebElement savedMessage;

    @FindBy(css = "[title=\"Delete Vehicles Model\"]")
    private WebElement deleteBtn;

    @FindBy(css = "[class=\"btn ok btn-danger\"]")
    private WebElement yes_delete_btn;

    @FindBy(css = "[class=\"flash-messages-holder\"]")
    private WebElement popUpMessage;

    public void clickEditBtn(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(editBtn)).click();
    }

    public void clickSaveAndClose(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(saveAndCloseBtn)).click();
    }

    public void clickAModelRandomly(){
        Random random=new Random();
        int indexOfModel = random.nextInt(modelNames.size());
        modelNames.get(indexOfModel).click();
    }

    public String  readPopUpMessage(){
        wait.until(ExpectedConditions.visibilityOf(popUpMessage));
        return popUpMessage.getText();
    }

    public void clickDeleteBtn (){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(deleteBtn)).click();
    }

    public void click_Yes_DeleteBtn(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(yes_delete_btn)).click();
    }
}
