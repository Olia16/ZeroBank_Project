package com.project.utils;

import org.openqa.selenium.JavascriptExecutor;

public class BrowserUtils {

    public static void sleep(int sec){
        try{
            Thread.sleep(sec*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception happened in sleep method");
        }
    }

    public static void scrollDown(int pixels){
        JavascriptExecutor js = (JavascriptExecutor)Driver.getDriver();
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }

}
