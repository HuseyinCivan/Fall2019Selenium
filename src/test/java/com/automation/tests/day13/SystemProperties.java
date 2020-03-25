package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {

    @Test
    public void test(){
        //C:\Users\h_civ\IdeaProjects\Fall2019Selenium\pom.xml
        //System.out.println(System.getProperty("user.dir") + "/pom.xml"
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        //flexible path to dowload folder
        //System.out.println(System.getProperty("user.home")+"/Downloads"
        System.out.println(System.getProperty("user.home"));

        String pathToDownloads=System.getProperty("user.home")+"\\Downloads";
        System.out.println(pathToDownloads);

        System.out.println(System.getProperty("os.arch"));

    }
}
