package com.auto.handle.impl;


import com.auto.action.pojo.XiaoDuPojo;

public interface UseGoodsEleImpl {

    //点击左上角商品管理
    public void clickGoodManageButton(String xpath);;


    //点击右上角新增优选
    public void clickRightAddGoodsButton(String xpath);


    //选择商品
    public void sendHotelTypeButton(String xpath);


    //点击确定
    public void clickGoodsTypeConfirmButton(String xpath);

    //录入产品名称
    public void sendProjectNameInput(String xpath,String projectName);

    //选择产品分类
    public void clickProjectClassSelect(String xpath,String strName);


    //选择4.1产品分类
    public void clickNewProjectClassSelect(String xpath,String strName);

    //选择产品类型
    public void clickProjectType(String xpath);



    //选择4.1产品类型

    //自定义原价
    public void sendOriginalPriceInput(String xpath);


    //点击设置规格
    public void clickSpecifications(String xpath);

    //点击新增规格组
    public void clickSpecificationsButton(String xpath);


    //点击新增二级规格组


    //填写规格组名称
    public void sendSpecificationsName(String xpath,String name);


    //点击保存
    public void clickSpecificationsSub(String xpath);


    //设置规格组
    public void clickAppSpecifications(String xpath,Integer size);


    //点击规格组-按钮
    public void clickAppSpecificationsSelect(String xpath);

    //全选选择规格
    public void selectAllAppSpecificationsSelect(String xpath);


    //点击保存按钮
    public void clickSpecificationsSave(String xpath);


    // 点击确认按钮
    public void clickSpecificationsSave2(String xpath);


    // 其他统一价格
    public void sendOtherPrice(String xpath, XiaoDuPojo pojo);

    // 循环规格组
    public void selectSendSpecificationsPrice(String xpath, XiaoDuPojo pojo);


    //录入初始销售数量
    public void sendInitialSaleInput(String xpath);


    //录入出发地
    public void sendSetOutInput(String xpath);


    //选择日期[录入成本价，销售价]
    public void sendDatePriceButton(String type);

    //选择价格[录入成本价，销售价]
    public void sendPriceButton(String type,String type2);


    //支持取消订单
    public void sendCancelOrderInput(String xpath);

    //选择封面图片
    public void sendCoverPhotoButton(String xpath);


    //4.1选择封面图片
    public void sendNewCoverPhotoButton(String xpath,XiaoDuPojo pojo);


    //选择展示图片
    public void sendBannerPhotoButton(String xpath);


    //4.1选择展示图片
    public void sendNewBannerPhotoButton(String xpath,XiaoDuPojo pojo);

    //选择现场确认
    public  void clickOnSiteConfirmation(String xpath);


    //选择预约使用
    public void clickAppointment(String xpath);



    //点击下一步
    public void  clickNextStepButton(String xpath);


    //录入商品说明
    public void sendShopDetail(String xpath);

    //录入详情图
    public void sendDetailPicture(String xpath);

    //4.1录入详情图
    public void sendNewDetailPicture(String xpath,XiaoDuPojo pojo);

    //导入pdf
    public void sendPdfFile(String xpath);

    //点击提交产品
    public void clickCommitButton(String xpath);


    //点击下架产品
    public void clickSetOutInput(String xpath);

    //点击上架产品
    public void clickSetUpInput(String xpath);


    //点击删除商品
    public void clickGoodsDel(String xpath);

}
