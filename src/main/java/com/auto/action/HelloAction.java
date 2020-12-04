package com.auto.action;


import com.auto.action.pojo.GoodsPage;
import com.auto.handle.UseLoginEle;
import com.auto.util.DriverUtil;
import com.auto.util.GetPathUtil;
import com.auto.util.ModifyXmlFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.testng.TestNG;

import javax.servlet.ServletContext;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("index")
public class HelloAction {

    @Autowired
    public UseLoginEle useLoginEle;



    @RequestMapping("/index")
    public String requestIndex() {
        return "home/index";
    }

    @RequestMapping("/addGoods")
    public String requestAddGoods() {
        return "home/addGoods";
    }


    @RequestMapping("/updateGoods")
    public String requestUpdateGoods() {
        return "home/updateGoods";
    }


    @RequestMapping("/addGoodsinfo")
    @ResponseBody
    public String addGoods(@RequestBody(required=false) GoodsPage page){
        ModifyXmlFile.removeXml();
        ModifyXmlFile.creatXml(page);
        setXml();
        return "Succsuss";
    }


    @RequestMapping("/addNewGoodsinfo")
    @ResponseBody
    public String addNewGoods(@RequestBody(required=false) GoodsPage page){
        ModifyXmlFile.removeXml();

        System.out.println("测试地址："+page.getLoginUrl());
        ModifyXmlFile.creatXml(page);
        setXml();
        return "Succsuss";
    }



    @RequestMapping("/updateGoodsinfo")
    @ResponseBody
    public String updateGoods(@RequestBody(required=false) GoodsPage page){
        ModifyXmlFile.removeXml();
        ModifyXmlFile.creatXml(page);
        setXml();


        return "Succsuss";
    }


    @RequestMapping("/stopGoodOt")
    @ResponseBody
    public String stopGoodOt(@RequestBody(required=false) GoodsPage page){

        DriverUtil.getDriver().close();
        DriverUtil.getDriver().quit();

        return "Succsuss";
    }


    public static void  setXml(){
        TestNG testNG = new TestNG();
        List<String> suites = new ArrayList<String>();
        //获取静态地址
        String path1 = GetPathUtil.getResourcesPath("testng2.xml");
//       String path1 =  Thread.currentThread().getContextClassLoader().getResource("testng.xml").getPath();
       System.out.println(path1);


//        suites.add(".\\src\\main\\resources\\testng.xml");

        suites.add(path1);

        testNG.setTestSuites(suites);
        testNG.run();
    }

    // 登录流程

//    @RequestMapping("testlogin")
//    @ResponseBody
//    public String testLogin(){
//
//        TestNG testNG = new TestNG();
//        List<String> suites = new ArrayList<String>();
//        //添加文件到suite
//        suites.add(".\\src\\main\\resources\\testng.xml");
//        testNG.setTestSuites(suites);
//        testNG.run();
//
//        return "finshLogin";
//    }


//    @RequestMapping("test")
//    public  String test(){
//         TestNG testNG = new TestNG();
//         List<String> suites = new ArrayList<String>();
//         //添加文件到suite
//         suites.add(".\\src\\main\\resources\\testng.xml");
//         testNG.setTestSuites(suites);
//         testNG.run();
//        return "helloWrod";
//    }


}
