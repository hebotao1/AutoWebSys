package com.auto.entity.impl;

import org.openqa.selenium.WebElement;

public interface GetGoodsEleImpl {


    //点击左上角商品管理
    public WebElement getGoodManageButton(String xpath);;


 //点击右上角新增优选
    public WebElement getRightAddGoodsButton(String xpath);


    //选择商品
    public WebElement getHotelTypeButton(String typeName);


    //点击确定
    public WebElement getGoodsTypeConfirmButton(String xpath);

    //录入产品名称
    public WebElement getProjectNameInput(String projectName);

    //选择产品分类
    public WebElement getProjectClassSelect(String xpath);

    //选择产品类型
    public WebElement getProjectType(String xpath);


    //自定义原价
    public WebElement getOriginalPriceInput(String xpath);


    //录入初始销售数量
    public WebElement getInitialSaleInput(String xpath);



    //选择日期[录入成本价，销售价]
    public WebElement getDatePriceButton(String type);



    //录入售价
   public WebElement getSalePrice(String xpath);


   //录入成本价
   public WebElement getCostPrice(String xpath);


    //支持取消订单
    public WebElement getCancelOrderInput(String xpath);

    //选择封面图片
    public WebElement getCoverPhotoButton(String xpath);



    //选择展示图片
    public WebElement getBannerPhotoButton(String xpath);


    //点击下一步
    public WebElement  getNextStepButton(String xpath);


    //录入商品说明
    public WebElement getShopDetail(String xpath);

    //录入详情图
    public WebElement getDetailPicture(String xpath);


    //点击提交产品
    public WebElement getCommitButton(String xpath);


    //获取现场确认
   public WebElement getClickOnSiteConfirmation(String xpath);



   // 获取预约使用
   public WebElement getClickAppointment(String xpath);


   // 下架产品
   public WebElement getSetOutInput(String xpath);

    // 上架产品
    public WebElement getSetUpInput(String xpath);

    public WebElement clickPageSize(String xpath);




}
