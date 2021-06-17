package com.auto.service;

import com.auto.AutoApplication;
import com.auto.util.DriverUtil;
import org.openqa.selenium.WebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;



@SpringBootTest(classes = AutoApplication.class)

public class TestReset  extends AbstractTestNGSpringContextTests {

    @Test
    public void testReset(){
        try {

            WebDriver driver = DriverUtil.getDriver();

            DriverUtil.openWindow("http://www.baidu.com/s?wd=abc");


            Thread.sleep(2000);


            DriverUtil.colseWindow(driver);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
