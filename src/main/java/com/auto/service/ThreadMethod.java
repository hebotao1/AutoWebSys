package com.auto.service;


import com.auto.util.GetPathUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.List;

@Service
@EnableAsync
public class ThreadMethod {

    @Async
    public void  sendXml(){
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        //获取静态地址
        String path1 = GetPathUtil.getResourcesPath("testng3.xml");
        System.out.println(path1);

        suites.add(path1);

        testNG.setTestSuites(suites);
        testNG.run();
    }



}
