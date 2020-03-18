package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BEFORE SUITE");
    }

    @AfterSuite
    public void afterSuite(){
        System.out.println("AFTER SUITE");
    }

    //runs only onece @Beforeclass and @BeforeMethod
    @BeforeTest
    public void beforeTest(){
        System.out.println("BEFORE TEST");
    }


    //runs only once in the class before method and before any test
    //regardless on number of test it runs only once
    @BeforeClass
    public void beforeClass(){
        //something that should be done only once in the class before all tests
        System.out.println("BEFORE CLASS");
    }

    @AfterClass
    public void afterClass(){
        //something that should be done only once in the class after all tests
        System.out.println("AFTER CLASS");
    }


    //runs before everytest automatically
    //works as a pre-condition or setup
    @BeforeMethod
    public void setup(){
        System.out.println("BEFORE METHOD");
    }

    //runs automatically after test
    @AfterMethod
    public void teardown(){
        System.out.println("AFTER METHOD");
    }

   @Test
    public void test1(){
       System.out.println("TEST1");
        String expected="apple";
        String actual="apple";
        Assert.assertEquals(actual,expected);

    }
    @Test
    public void test2(){
        System.out.println("TEST2");
        int num1=5;
       int num2=10;
       //it calls hard assertion
        //if assertion fails - it stops the execution (due to exception)
       Assert.assertTrue(num1<num2);
    }


}
