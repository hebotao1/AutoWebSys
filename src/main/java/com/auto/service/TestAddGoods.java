package com.auto.service;

import com.auto.AutoApplication;
import com.auto.action.pojo.XiaoDuPojo;
import com.auto.handle.impl.UseGoodsEleImpl;
import com.auto.util.DriverUtil;
import com.auto.util.ExcelUtil;
import com.auto.util.TestngListener;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({TestngListener.class})
@SpringBootTest(classes = AutoApplication.class)
public class TestAddGoods extends AbstractTestNGSpringContextTests {


    @Autowired
    public UseGoodsEleImpl goodsEle;

//    @Autowired
//    public UseLoginEle useloginele;


//    @BeforeTest
//    public void testCaseLogin(){
//        DriverUtil.openWindow("http://118.89.40.223/login");
//
//        useloginele.SendUserName("//input[@placeholder='手机号']","13688888888");
//        useloginele.SendPassWord("//input[@placeholder='密码']","aaa888888");
//        useloginele.clickLoginBtn("//span[text()='登录']");
//
//    }

    @Test(groups = {"Hotel"})
    public void testCaseAddHotel() {

        try {

            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");

            goodsEle.clickRightAddGoodsButton("//button[@class='ivu-btn ivu-btn-default']//span[text()='+新增优选商品']");

            Thread.sleep(2000);
            goodsEle.sendHotelTypeButton(   "//div//ul//li[text()='酒店产品']");

            Thread.sleep(1000);
            goodsEle.clickGoodsTypeConfirmButton("//button//span[text()='确定']");

            Thread.sleep(1000);
            goodsEle.sendProjectNameInput("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default']","酒店产品");

            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'产品分类')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","产品分类");

            Thread.sleep(1000);
            //选择产品类型
            goodsEle.clickProjectType("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default' and @readonly='readonly']");

            Thread.sleep(1000);
            goodsEle.sendOriginalPriceInput("//div[@class='ivu-form-item']//label[contains(text(), '原价')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");

            Thread.sleep(1000);
            goodsEle.sendInitialSaleInput("//div[@class='ivu-form-item']//label[contains(text(), '初始销售量')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");

            Thread.sleep(1000);
            goodsEle.sendDatePriceButton("//div[@class='ivu-form-item-content']//span[text()='添加多个价格日期']");

            Thread.sleep(1000);
            goodsEle.sendCancelOrderInput("//div[@class='ivu-form-item-content']//span[@class='ivu-switch ivu-switch-default']");

            //document.getElementsByClassName('content')[0].scrollTop=10000
            ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("document.getElementsByClassName('content')[0].scrollTop=10000");

            Thread.sleep(1000);
            goodsEle.sendCoverPhotoButton("//div[@class='upload coverPhoto']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            Thread.sleep(1000);
            goodsEle.sendBannerPhotoButton("//label[contains(text(),'展示图片')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");
//            goodsEle.sendBannerPhotoButton("//div[@class='ivu-form-item-content']//li[@class='upload']//input[@class='ivu-upload-input']");

            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //详情图
            Thread.sleep(1000);
            goodsEle.sendDetailPicture("//label[contains(text(),'详情图')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //上传pdf
            Thread.sleep(1000);
            goodsEle.sendPdfFile("//label[contains(text(),'上传PDF')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //点击提交产品
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'提交产品')]");




        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Test(groups = {"Other"})
    public void testCaseAddOther() {
        try {

            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");

            goodsEle.clickRightAddGoodsButton("//button[@class='ivu-btn ivu-btn-default']//span[text()='+新增优选商品']");

            Thread.sleep(2000);
            goodsEle.sendHotelTypeButton(   "//div//ul//li[text()='其他产品']");

            Thread.sleep(1000);
            goodsEle.clickGoodsTypeConfirmButton("//button//span[text()='确定']");

            // 商品名称
            Thread.sleep(1000);
            goodsEle.sendProjectNameInput("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default']","其他产品");

            // 产品分类
            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'产品分类')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","产品分类");

            //选择产品类型
//            Thread.sleep(1000);
//            goodsEle.clickProjectType("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default' and @readonly='readonly']");

            //原价
            Thread.sleep(1000);
            goodsEle.sendOriginalPriceInput("//div[@class='ivu-form-item']//label[contains(text(), '原价')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");

            //初始销售量
            Thread.sleep(1000);
            goodsEle.sendInitialSaleInput("//div[@class='ivu-form-item']//label[contains(text(), '初始销售量')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");


            //点击现场确认
            Thread.sleep(1000);
            String str1 = "//div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']";
            String str2 = "//div/span[contains(text(),'成本价')]/following-sibling::div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']";
            goodsEle.sendPriceButton(str1,str2 );


            // 支持取消订单
            Thread.sleep(1000);
            goodsEle.sendCancelOrderInput("//div[@class='ivu-form-item-content']//span[@class='ivu-switch ivu-switch-default']");


            //滚动下拉
            //document.getElementsByClassName('content')[0].scrollTop=10000
            ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("document.getElementsByClassName('content')[0].scrollTop=10000");

            Thread.sleep(1000);
            goodsEle.sendCoverPhotoButton("//div[@class='upload coverPhoto']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            Thread.sleep(1000);
            goodsEle.sendBannerPhotoButton("//label[contains(text(),'展示图片')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");
//            goodsEle.sendBannerPhotoButton("//div[@class='ivu-form-item-content']//li[@class='upload']//input[@class='ivu-upload-input']");


            //点击现场确认
            Thread.sleep(1000);
            goodsEle.clickOnSiteConfirmation("//label[contains(text(),' 现场确认')]//input[@class='ivu-checkbox-input']");

            //点击预约使用
            Thread.sleep(1000);
            goodsEle.clickAppointment("//label[contains(text(),' 预约使用')]//input[@class='ivu-checkbox-input']");


            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //详情图
            Thread.sleep(1000);
            goodsEle.sendDetailPicture("//label[contains(text(),'详情图')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //上传pdf
            Thread.sleep(1000);
            goodsEle.sendPdfFile("//label[contains(text(),'上传PDF')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //点击提交产品
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'提交产品')]");

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test(groups = {"Other"})
    public void testCaseNewAddOther() {
        try {
            List<XiaoDuPojo> xiaoDuShopList = ExcelUtil.getXiaoDuShop();
            for(int i=0;i<xiaoDuShopList.size();i++){

                XiaoDuPojo pojo = xiaoDuShopList.get(i);

                goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");

                goodsEle.clickRightAddGoodsButton("//button[@class='ivu-btn ivu-btn-default']//span[text()='+新增优选商品']");

                System.out.println(pojo.getShopType1());
                goodsEle.sendHotelTypeButton("//div[@class='ivu-modal-body']//ul[@class='typeList']//li[text()=' "+pojo.getShopType1()+" ']");

                goodsEle.clickGoodsTypeConfirmButton("//div//button//span[text()='确定']");

                // 商品名称
                goodsEle.sendProjectNameInput("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default']",pojo.getShopName());

                // 产品分类
                Thread.sleep(1000);
                goodsEle.clickNewProjectClassSelect("//label[contains(text(),'产品分类')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']",pojo.getShopType2());

                //选择产品类型
//            Thread.sleep(1000);
//            goodsEle.clickProjectType("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default' and @readonly='readonly']");

                //原价
//                Thread.sleep(1000);
//                goodsEle.sendOriginalPriceInput("//div[@class='ivu-form-item']//label[contains(text(), '原价')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");


                //规格与价格 （点击设置规格）
                Thread.sleep(1000);
                goodsEle.clickSpecifications("//div[@class='line_setting']//span[text()='设置规格']");


                //新增规格组
                goodsEle.clickSpecificationsButton("//div[@class='specificationDeatail']//span[text()='新增规格组']");

                Thread.sleep(1000);
                goodsEle.sendSpecificationsName("//div[@class='ivu-modal-content']//div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default']",pojo.getPriceType());
                //点击保存
                goodsEle.clickSpecificationsSub("//div[@class='ivu-modal-footer']//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']");

//                Thread.sleep(1000);
//                goodsEle.sendSpecificationsName("//div[@class='ivu-modal-content']//div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default']",pojo.getShopType1());
//                //点击保存
//                goodsEle.clickSpecificationsSub("//div[@class='ivu-modal-footer']//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']");
//
                //录入新增规格框
                if  (pojo.getPriceName().contains(",")) {
                    String str1[] = pojo.getPriceName().split(",");

                    for (int z = 0; z < str1.length; z++) {
                        System.out.println("--:"+str1[z]);
                        //点击二级规格组
                        Thread.sleep(1000);
                        goodsEle.clickAppSpecifications("//div[@class='fullscreen']//ul[@class='contntList']//li[@class='add']",z);

                        //录入新增规格框
                        Thread.sleep(1000);
                        goodsEle.sendSpecificationsName("//div[@class='ivu-modal-content']//div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default']",str1[z]);


                        //点击保存
                        Thread.sleep(1000);
                        goodsEle.clickSpecificationsSub("//div[@class='ivu-modal-footer']//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']");
                    }

                }else{
                    //点击二级规格组
                    Thread.sleep(1000);
                    goodsEle.clickAppSpecifications("//div[@class='fullscreen']//ul[@class='contntList']//li[@class='add']",0);

                    //录入新增规格框
                    Thread.sleep(1000);
                    goodsEle.sendSpecificationsName("//div[@class='ivu-modal-content']//div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default']",pojo.getPriceName());


                    //点击保存
                    Thread.sleep(1000);
                    goodsEle.clickSpecificationsSub("//div[@class='ivu-modal-footer']//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']");

                }

                //点击保存
                goodsEle.clickSpecificationsSave("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[text()='保存']");

                //点击选择规格组按钮
                Thread.sleep(1000);
                goodsEle.clickAppSpecificationsSelect("//div[@class='dateList']//div[@class='line_settingText']//span[text()='选择规格组合']");

                //选择规格组
                Thread.sleep(1000);
                goodsEle.selectAllAppSpecificationsSelect("//div[@class='ivu-modal-content']//div[@class='ivu-table-header']//input[@class='ivu-checkbox-input']");


                //选择规格组 - 点击确认
                Thread.sleep(1000);
                goodsEle.clickSpecificationsSave2("//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']//span[text()='确认']");



                //dateList visitorList
                Thread.sleep(1000);
                goodsEle.selectSendSpecificationsPrice("//div[@class='dateList']//div[@class='visitorList']//input[@class='ivu-input ivu-input-default ivu-input-disabled']",pojo);
                ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("document.getElementsByClassName('content')[0].scrollTop=500");

                // 其他统一价格
                Thread.sleep(1000);
                goodsEle.sendOtherPrice("//div[@class='dateList']//div[@class='visitorList'][2]//input[@class='ivu-input-number-input']",pojo);


                //初始销售量
                Thread.sleep(1000);
                goodsEle.sendInitialSaleInput("//div[@class='ivu-form-item']//label[contains(text(), '初始销售量')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");




                //点击现场确认
//                Thread.sleep(1000);
//                String str1 = "//div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']";
//                String str2 = "//div/span[contains(text(),'成本价')]/following-sibling::div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']";
//                goodsEle.sendPriceButton(str1,str2 );


                // 支持取消订单
//                goodsEle.sendCancelOrderInput("//div[@class='ivu-form-item-content']//span[@class='ivu-switch ivu-switch-default']");


                //滚动下拉
                //document.getElementsByClassName('content')[0].scrollTop=10000
                ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("document.getElementsByClassName('content')[0].scrollTop=10000");


                //封面图片
                Thread.sleep(1000);
                goodsEle.sendNewCoverPhotoButton("//div[@class='upload coverPhoto']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']", pojo);

                //展示图片
                Thread.sleep(1000);
                goodsEle.sendNewBannerPhotoButton("//label[contains(text(),'展示图片')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']", pojo);
//            goodsEle.sendBannerPhotoButton("//div[@class='ivu-form-item-content']//li[@class='upload']//input[@class='ivu-upload-input']");


                //点击现场确认
//                Thread.sleep(1000);
//                goodsEle.clickOnSiteConfirmation("//label[contains(text(),' 现场确认')]//input[@class='ivu-checkbox-input']");

                //点击预约使用
//                Thread.sleep(1000);
//                goodsEle.clickAppointment("//label[contains(text(),' 预约使用')]//input[@class='ivu-checkbox-input']");


                //点击下一步
                Thread.sleep(1000);
                goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

                //详情图
                Thread.sleep(1000);
                goodsEle.sendNewDetailPicture("//label[contains(text(),'详情图')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']",pojo);

                //上传pdf
//                Thread.sleep(1000);
//                goodsEle.sendPdfFile("//label[contains(text(),'上传PDF')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

                //点击下一步
                Thread.sleep(1000);
                goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

                //点击提交产品
                Thread.sleep(1000);
                goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'提交产品')]");

            }



        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Test(groups = {"Travel"})
        public void testCaseAddTravel() {

        try {

            goodsEle.clickGoodManageButton("//div[@class='ivu-layout-sider-children']//span[text()='商品管理']");

            goodsEle.clickRightAddGoodsButton("//button[@class='ivu-btn ivu-btn-default']//span[text()='+新增优选商品']");

            Thread.sleep(2000);
            goodsEle.sendHotelTypeButton(   "//div//ul//li[text()='旅游产品']");

            Thread.sleep(1000);
            goodsEle.clickGoodsTypeConfirmButton("//button//span[text()='确定']");

            Thread.sleep(1000);
            goodsEle.sendProjectNameInput("//div[@class='ivu-input-wrapper ivu-input-wrapper-default ivu-input-type-text']//input[@class='ivu-input ivu-input-default']","旅游产品");

            //产品分类
            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'产品分类')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","产品分类");

            //选择产品性质
            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'产品性质')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","产品性质");

            Thread.sleep(1000);
            goodsEle.sendOriginalPriceInput("//label[contains(text(), '原价')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");

            Thread.sleep(1000);
            goodsEle.sendInitialSaleInput("//label[contains(text(), '初始销售量')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input-number-input']");

            Thread.sleep(1000);
            goodsEle.sendDatePriceButton("//div[@class='ivu-form-item-content']//span[text()='添加多个出发日期']");

            Thread.sleep(1000);
            goodsEle.sendCancelOrderInput("//div[@class='ivu-form-item-content']//span[@class='ivu-switch ivu-switch-default']");

            //document.getElementsByClassName('content')[0].scrollTop=10000
            ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("document.getElementsByClassName('content')[0].scrollTop=10000");

            //出发地
            goodsEle.sendSetOutInput("//label[contains(text(), '出发地')]/following-sibling::div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default']");

            //选择出游类别
            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'出游类别')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","出游类别");


            //选择供应商
            Thread.sleep(1000);
            goodsEle.clickProjectClassSelect("//label[contains(text(),'供应商')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-selection']","供应商");


            Thread.sleep(1000);
            goodsEle.sendCoverPhotoButton("//div[@class='upload coverPhoto']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            Thread.sleep(1000);
            goodsEle.sendBannerPhotoButton("//label[contains(text(),'展示图片')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");
//            goodsEle.sendBannerPhotoButton("//div[@class='ivu-form-item-content']//li[@class='upload']//input[@class='ivu-upload-input']");

            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //详情图
            Thread.sleep(1000);
            goodsEle.sendDetailPicture("//label[contains(text(),'详情图')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //上传pdf
            Thread.sleep(1000);
            goodsEle.sendPdfFile("//label[contains(text(),'上传PDF')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-upload ivu-upload-drag']//input[@class='ivu-upload-input']");

            //点击下一步
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'下一步')]");

            //点击提交产品
            Thread.sleep(1000);
            goodsEle.clickNextStepButton("//div[@class='bottom']//button[@class='ivu-btn ivu-btn-primary']//span[contains(text(),'提交产品')]");




        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    @AfterTest
    public void teardown() {
        DriverUtil.getDriver().quit();
        DriverUtil.getDriver().close();

    }

}
