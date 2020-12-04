package com.auto.service;

import com.auto.AutoApplication;
import com.auto.handle.impl.UseGoodsEleImpl;
import com.auto.util.DriverUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

// 商品操作
@SpringBootTest(classes = AutoApplication.class)
public class TestGoodsOperation extends AbstractTestNGSpringContextTests {


    @Autowired
    public UseGoodsEleImpl goodsEle;

    @Test
    public void  testCaseGoodsOtUp(){
        try{
            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");
            goodsEle.clickSetUpInput("//div[@class='ivu-table-cell-slot']//button[@class='ivu-btn ivu-btn-text']//span[text()='上架']");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testCaseGoodsDown(){
        try{
            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");
            goodsEle.clickSetOutInput("//div[@class='ivu-table-cell-slot']//button[@class='ivu-btn ivu-btn-text']//span[text()='下架']");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCaseGoodsDel(){
        try{
            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");
            goodsEle.clickGoodsDel("//div[@class='ivu-table-cell-slot']//button[@class='ivu-btn ivu-btn-text']//span[text()='删除']");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest
    public void teardown() {
        DriverUtil.getDriver().quit();
        DriverUtil.getDriver().close();

    }
}
