package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;


public class UnitTestPractice {

    public static void main(String[] args) {
        //unit test
        //to check if our method works properly
        //if assertion fails, that means our method doesn;t work correctly
        //that means we have to fix the method

        String expected="cba";
        String toReverse="abc";
        String actual =reverseString(toReverse);
        //Assertion
        verifyEquals(expected,actual);





    }



    public static boolean verifyEquals(String expected, String actual){
        if(expected.equals(actual)){
            System.out.println("TEST PASSED");
            return true;
        }else{
            System.out.println("TEST FAILED");
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
            return false;
        }
    }
    //annotation
@Test(description = "Verify if method can reverse a string")
    public void test(){
        String expected="elppa";
        String actual= reverseString("apple");
        //it coming from testng, junit also has this class
        //you can compare any data type here, string,primitives,arrays,objects
        //to verify if expected result is equals to actual
    Assert.assertEquals(actual,expected);



    }

    @Test
    public void test2(){
        String expected ="rac";
        String actual=reverseString("car");
        Assert.assertEquals(expected,actual);

    }





    /***
     * This method stands for reversing string
     * @param str
     * @return
     */
    public static String reverseString(String str){
        String reversed="";
        for(int x=str.length()-1;x>=0;x--){
            reversed+=str.charAt(x);
        }
        return reversed;
    }


}
