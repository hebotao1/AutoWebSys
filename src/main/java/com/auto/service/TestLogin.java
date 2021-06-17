package com.auto.service;

import com.auto.AutoApplication;
import com.auto.handle.UseLoginEle;
import com.auto.util.DriverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


@SpringBootTest(classes = AutoApplication.class)
public class TestLogin extends AbstractTestNGSpringContextTests  {

    @Autowired
    public UseLoginEle useloginele;


//    @BeforeTest
//    public void beforeTest(){
//        DriverUtil.openWindow("http://118.89.40.223/login");
//
//    }


//    @BeforeMethod
//    public void beforeMethod() {
//    }

    @Parameters({"url","loginName","p   assword"})
    @Test
    public void testCaseLogin(String url ,String loginName,String password) {

        DriverUtil.openWindow(url);

        useloginele.SendUserName("//input[@placeholder='手机号']",loginName);
        useloginele.SendPassWord("//input[@placeholder='密码']",password);
        useloginele.clickLoginBtn("//span[text()='登录']");
    }
}
