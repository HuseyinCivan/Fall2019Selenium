package com.automation.utilities;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtils {
    public static void main(String[] args) {
        System.out.println("System.getProperty(\"os.name\") = " + System.getProperty("os.name"));
    }
    public static void wait(int seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

    }
    public static List<String> getTextFromWebElements(List<WebElement> elements){
        List<String> textValues = new ArrayList<>();
        for (WebElement element : elements) {
            textValues.add(element.getText());
        }
        return textValues;
    }
}
