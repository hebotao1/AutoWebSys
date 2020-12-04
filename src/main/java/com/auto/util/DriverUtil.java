package com.auto.util;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Parameters;


public class DriverUtil{

    private static WebDriver driver ;

    private DriverUtil(){}



    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver","E:\\javaFile\\chromedriver.exe");// chromedriver服务地址
            driver = new ChromeDriver();
        }
        return driver;
    }

    public  static void openWindow(String url){
//         url = "http://www.baidu.com";
        if (driver == null){
            getDriver();
        }
        driver.get(url); // 打开指定的网站
        driver.manage().window().maximize();
    }


    public static void main(String[] args) {
        DriverUtil.getDriver();
        DriverUtil.openWindow("http://118.89.40.223/login");



    }

}
