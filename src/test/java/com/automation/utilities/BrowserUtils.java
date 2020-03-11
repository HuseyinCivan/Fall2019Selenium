package com.automation.utilities;

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
}
