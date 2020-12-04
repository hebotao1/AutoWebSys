package com.auto.handle;

import com.auto.action.pojo.XiaoDuPojo;
import com.auto.entity.GetGoodsEle;
import com.auto.handle.impl.UseGoodsEleImpl;
import com.auto.util.DriverUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UseGoodsEle implements UseGoodsEleImpl {

    @Resource
    GetGoodsEle goodsEle;

    @Override    //点击左上角商品管理
    public void clickGoodManageButton(String xpath) {
        goodsEle.getGoodManageButton(xpath).click();
    }

    @Override //点击右上角新增优选
    public void clickRightAddGoodsButton(String xpath) {

        goodsEle.getRightAddGoodsButton(xpath).click();
    }

    @Override  //选择商品分类
    public void sendHotelTypeButton(String xpath) {

        goodsEle.getHotelTypeButton(xpath).click();
    }

    @Override  //点击确定
    public void clickGoodsTypeConfirmButton(String xpath) {
        goodsEle.getGoodsTypeConfirmButton(xpath).click();
    }

    @Override    //录入产品名称
    public void sendProjectNameInput(String xpath,String projectName) {

//        int su =  (int)(1+Math.random()*(10000-1+1));
//        projectName = projectName + su;
        goodsEle.getProjectNameInput(xpath).sendKeys(projectName);
    }


    @Override       //选择产品分类
    public void clickNewProjectClassSelect(String xpath,String strName) {

        try{
          goodsEle.getProjectClassSelect(xpath).click();
            Thread.sleep(1000);

            String str1 = "//label[contains(text(),'产品分类')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-dropdown']//ul[@class='ivu-select-dropdown-list']//li[text()='"+strName+"']";
            goodsEle.getBaseElement(By.xpath(str1)).click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Override       //选择产品分类
    public void clickProjectClassSelect(String xpath,String strName) {

        try{
            WebElement projectClassSelect = goodsEle.getProjectClassSelect(xpath);
            projectClassSelect.click();

            String str1 = "//label[contains(text(),'"+strName+"')]/following-sibling::div[@class='ivu-form-item-content']//div[@class='ivu-select-dropdown']//ul[@class='ivu-select-dropdown-list']//li[@class='ivu-select-item']";

            Thread.sleep(2000);
            List<WebElement> elements = goodsEle.getBaseElements(By.xpath(str1));

            if ( elements.size()>0){
                int su =  (int)(1+Math.random()*(elements.size()-1-1+1));
                System.out.println("下拉选择框最大长度：--" + elements.size());
                System.out.println("随机数：--"+su);
//                elements.get(su).click();
                elements.get(0).click();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override    //选择产品类型
    public void clickProjectType(String xpath) {
        try{
            goodsEle.getProjectType(xpath).click();
            List<WebElement> baseElements = goodsEle.getBaseElements(By.xpath("//div[@class='ivu-modal-content']//ul[@class='typeList']//li"));

            if ( baseElements.size()>0){
                int su =  (int)(1+Math.random()*(baseElements.size()-1-1+1));
                Thread.sleep(1000);
                baseElements.get(su).click();
            }
            Thread.sleep(1000);
            goodsEle.getBaseElement(By.xpath("//div[@class='foot']//button[@class='ivu-btn ivu-btn-primary']//span[text()='确定']")).click();
        }catch (Exception e){
            e.printStackTrace();
        }

    }



    @Override    //自定义原价
    public void sendOriginalPriceInput(String xpath) {
        int su =  (int)(1+Math.random()*(10000-1+1));
        goodsEle.getBaseElement(By.xpath(xpath)).sendKeys(su+"");

    }

    @Override   //点击设置规格
    public void clickSpecifications(String xpath) {
        goodsEle.getBaseElement(By.xpath(xpath)).click();;
    }



    @Override //点击新增规格组
    public void clickSpecificationsButton(String xpath){
        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }


    @Override //点击新增规格组
    public void  clickSpecificationsSub(String xpath){
        goodsEle.getBaseElement(By.xpath(xpath)).click();

    }


    @Override //
    public void clickAppSpecifications(String xpath,Integer size){
        WebElement baseElement = goodsEle.getBaseElement(By.xpath(xpath));
        ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("arguments[0].click();",baseElement);

//        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }

    @Override
    public void clickAppSpecificationsSelect(String xpath) {
        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }

    @Override
    public void selectAllAppSpecificationsSelect(String xpath) {
        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }

    @Override
    public void clickSpecificationsSave(String xpath) {
        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }


    @Override
    public void sendSpecificationsName(String xpath,String name){
        if( name.length()>=20){
            name = name.substring(0,20);
        }

        goodsEle.getBaseElement(By.xpath(xpath)).sendKeys(name);
    }


    public void clickSpecificationsSave2(String xpath){
        goodsEle.getBaseElement(By.xpath(xpath)).click();
    }

    @Override
    public void sendOtherPrice(String xpath, XiaoDuPojo pojo) {

        WebElement baseElement = goodsEle.getBaseElement(By.xpath(xpath));
        baseElement.click();
        baseElement.sendKeys(Keys.BACK_SPACE);
        String price = pojo.getPrice();

        if (price.contains(",")){
            String[] pricesplit = price.split(",");
            int i1 = Integer.parseInt(pricesplit[0]);
            double v = i1 * 0.01;
            baseElement.sendKeys(v+"");
        }else{
            double v =  Integer.parseInt(price) * 0.01;
            baseElement.sendKeys(v+"");
        }

//        String[] pricesplit = price.split(",");



    }

    //价格组
    public void selectSendSpecificationsPrice(String xpath, XiaoDuPojo pojo){

        String priceName =pojo.getPriceName();
        String price =pojo.getPrice();

        String[] priceNamesplit = priceName.split(",");
        String[] pricesplit = price.split(",");
        System.out.println("价格数组字符串："+price);
        System.out.println("价格数组："+pricesplit);
        Map<String,String> map = new HashMap<String,String>();

        for (int i =0 ;i <priceNamesplit.length;i++){
            String name ="";
            if (priceNamesplit[i].length()>=20){
                name = priceNamesplit[i].substring(0,20);
            }else{
                name = priceNamesplit[i];
            }
            map.put(name,  pricesplit[i]);
        }

        List<WebElement> eles = goodsEle.getBaseElements(By.xpath(xpath));

         for(int i =0;i<eles.size();i++){

             String name = eles.get(i).getAttribute("value");
             String  value = map.get(name);

             System.out.println("打印数据:"+name+"值："+value);
             int sum = i+1;
             WebElement baseElement = goodsEle.getBaseElement(By.xpath("//div[@class='dateList']//div[@class='visitorList']//div["+sum+"]//span[contains(text(),'售价')]/following-sibling::div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']"));
             baseElement.click();
             baseElement.sendKeys(Keys.BACK_SPACE);

//             ((JavascriptExecutor) DriverUtil.getDriver()).executeScript("arguments[0].value ='';",baseElement);
//             System.out.println("暂停1s");
//           baseElement.clear();

             int i1 = Integer.parseInt(value);
             double v = i1 * 0.01;

             baseElement.sendKeys(v+"");

         }
    }

    @Override //录入初始销售数量
    public void sendInitialSaleInput(String xpath) {
        int su =  (int)(1+Math.random()*(1000-1+1));
        WebElement ele = goodsEle.getBaseElement(By.xpath(xpath));
        ele.sendKeys(su+"");

    }

    @Override  // 录入出发地
    public void sendSetOutInput(String xpath) {
        WebElement ele = goodsEle.getSetOutInput(xpath);
        ele.sendKeys("深圳");
    }

    @Override   //选择日期[录入成本价，销售价]
    public void sendDatePriceButton(String xpath){

        int su =  (int)(1+Math.random()*(10000-1+1));
        goodsEle.getDatePriceButton(xpath).click();
        goodsEle.getBaseElement(By.xpath("//div[@class='ivu-form-item-content']//input[@class='ivu-input ivu-input-default ivu-input-with-suffix']")).click();
        goodsEle.getBaseElement(By.xpath("//div[@class='ivu-select-dropdown']//span[@class='ivu-date-picker-cells-cell']//em[text()='30']")).click();
       //销售价格
        goodsEle.getSalePrice("//div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']").sendKeys(su+"");
        //成本价格
        goodsEle.getCostPrice("//div/span[contains(text(),'成本价')]/following-sibling::div[@class='littleInput ivu-input-number ivu-input-number-default']//input[@class='ivu-input-number-input']").sendKeys(su+"");

    }


    @Override   //录入价格[录入成本价，销售价]
    public void sendPriceButton(String xpath,String xpath2){
        int su =  (int)(1+Math.random()*(10000-1+1));
        //销售价格
        goodsEle.getSalePrice(xpath).sendKeys(su+"");
        //成本价格
        goodsEle.getCostPrice(xpath2).sendKeys(su+"");

    }

    @Override   //支持取消订单
    public void sendCancelOrderInput(String xpath) {
        goodsEle.getCancelOrderInput(xpath).click();
    }

    @Override  //选择封面图片
    public void sendNewCoverPhotoButton(String xpath,XiaoDuPojo pojo) {
        String path = " E:\\shopImg\\"+pojo.getShopName()+"\\"+"封面图_"+pojo.getShopName()+".png";
        goodsEle.getCoverPhotoButton(xpath).sendKeys(path);


//        int su =  (int)(1+Math.random()*(100-1+1));
//
//
//        String path = " C:\\Users\\曹爽\\Desktop\\roll\\"+su+".jpg";
//        goodsEle.getCoverPhotoButton(xpath).sendKeys(path);
    }

    @Override  //选择封面图片
    public void sendCoverPhotoButton(String xpath) {

        int su =  (int)(1+Math.random()*(100-1+1));
        String path = " C:\\Users\\曹爽\\Desktop\\roll\\"+su+".jpg";
        goodsEle.getCoverPhotoButton(xpath).sendKeys(path);
    }

    @Override//选择展示图片
    public void sendNewBannerPhotoButton(String xpath,XiaoDuPojo pojo) {
        try{

            System.out.println("封面图"+pojo.getScollPicture());

            // 如果没有滑动图，选择封面图片
            if (pojo.getScollPicture()=="" || pojo.getScollPicture()==null){


                String path = " E:\\shopImg\\"+pojo.getShopName()+"\\"+"封面图_"+pojo.getShopName()+".png";
                goodsEle.getBannerPhotoButton(xpath).sendKeys(path);
                return;
            }


            String[] split = pojo.getScollPicture().split(",");

            for (int i =0;i<split.length;i++){

                if(i>=20){
                    break;
                }

                String path = " E:\\shopImg\\"+pojo.getShopName()+"\\"+ i +"_滑动图_"+pojo.getShopName()+".png";
                File file = new File(path);
                System.out.println("文件名称："+path);
                System.out.println("是否存在文件："+file.exists());

                goodsEle.getBannerPhotoButton(xpath).sendKeys(path);





        }
        }catch (Exception e){
            e.printStackTrace();
        }
    }




    @Override//选择展示图片
    public void sendBannerPhotoButton(String xpath) {
        try{
            for(int i =0;i<4;i++){
                Thread.sleep(500);
                int su =  (int)(1+Math.random()*(120-1+1));
                String path = " C:\\Users\\曹爽\\Desktop\\roll\\"+su+".jpg";
                goodsEle.getBannerPhotoButton(xpath).sendKeys(path);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override   //点击现场确认
    public void clickOnSiteConfirmation(String xpath) {
        goodsEle.getClickOnSiteConfirmation(xpath).click();
    }


    @Override   //预约使用
    public void clickAppointment(String xpath) {
        goodsEle.getClickAppointment(xpath).click();
    }

    @Override   //点击下一步
    public void clickNextStepButton(String xpath) {
      goodsEle.getNextStepButton(xpath).click();
    }



    @Override   //录入商品说明
    public void sendShopDetail(String xpath) {
      goodsEle.getShopDetail(xpath);
    }

    @Override   //录入详情图
    public void sendNewDetailPicture(String xpath,XiaoDuPojo pojo) {

        if ( pojo.getDetailPicture() == "" ||  pojo.getDetailPicture() == null){
            System.out.println(pojo.getShopName()+"详情图为null，跳过");
            return;
        }


        String[] split = pojo.getDetailPicture().split(",");
        for (int i =0;i<split.length;i++) {
            if(i>=20){
                break;
            }

            String path = " E:\\shopImg\\" + pojo.getShopName() + "\\" + i + "_详情图_" + pojo.getShopName() + ".png";

            System.out.println("导入详情图:"+path);
            goodsEle.getBannerPhotoButton(xpath).sendKeys(path);

        }
    }

    @Override   //录入详情图
    public void sendDetailPicture(String xpath) {

        for(int i =0;i<6;i++){
            int su =  (int)(1+Math.random()*(120-1+1));
            String path = " C:\\Users\\曹爽\\Desktop\\roll\\"+su+".jpg";
            goodsEle.getDetailPicture(xpath).sendKeys(path);
        }
    }

    // 导入pdf
    public  void sendPdfFile(String xpath){
        String path = "C:\\Users\\曹爽\\Desktop\\上线demo图片\\图片\\AA.pdf";
        goodsEle.getDetailPicture(xpath).sendKeys(path);


    }




    @Override   //点击提交产品
    public void clickCommitButton(String xpath) {
      goodsEle.getCommitButton(xpath);
    }



    @Override  //下架产品
    public void clickSetOutInput(String xpath) {
        sendSetUpOrSetDown(xpath,"已上架");

    }

    @Override  //上架产品
    public void clickSetUpInput(String xpath) {
        sendSetUpOrSetDown(xpath,"已下架");

    }

    @Override //删除商品
    public void clickGoodsDel(String xpath) {
        sendSetUpOrSetDown(xpath,"已下架");
    }


    public void  sendSetUpOrSetDown(String xpath,String type){
        try{
            //选择已上架 筛选条件
            Thread.sleep(1000);
            String  selectXp = "//div[@class='ivu-select ivu-select-single ivu-select-default']//div[@class='ivu-select-selection']";
            goodsEle.getBaseElement(By.xpath(selectXp)).click();
            Thread.sleep(1000);
            String selectDown = "//div[@class='ivu-select-dropdown']//ul[@class='ivu-select-dropdown-list']//li[text()='"+type+"']";
            goodsEle.getBaseElement(By.xpath(selectDown)).click();

            Thread.sleep(2000);
            // 获取分页条
            String xp = "//ul[@class='ivu-page']//li[@class='ivu-page-item' or @class='ivu-page-item ivu-page-item-active']";
            List<WebElement> baseElements = goodsEle.getBaseElements(By.xpath(xp));

            Integer maxSize = baseElements.size();
            String title =  baseElements.get(maxSize - 1).getAttribute("title");
            Integer maxPage  = Integer.valueOf(title);
            //循环点击每个分页条
            for (int i=1;i<=maxPage;i++){
                Thread.sleep(2000);
                String li = "//ul[@class='ivu-page']//li[@title='"+i+"']";
                goodsEle.getBaseElement(By.xpath(li)).click();


                //循环点击下架
                List<WebElement> setOutList = goodsEle.getBaseElements(By.xpath(xpath));
                if(setOutList!=null) {
                    if (setOutList.size() > 0) {
                        for (int j=0;j<setOutList.size();j++){
                            //点击下架
                            Thread.sleep(2000);
                            goodsEle.getBaseElement(By.xpath(xpath)).click();
//                            setOutList.get(j).click();
                            //点击确定
                            Thread.sleep(1000);
                            goodsEle.getBaseElement(By.xpath("//div[@class='ivu-modal-confirm-footer']//button[@class='ivu-btn ivu-btn-primary']//span[text()='确定']")).click();

                        }
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        XiaoDuPojo xiaoDuPojo = new XiaoDuPojo();

        xiaoDuPojo.setShopName("小度教育智能屏（独角兽）");
        xiaoDuPojo.setScollPicture("https://product-online.cdn.bcebos.com/1594381076360261.png,https://product-online.cdn.bcebos.com/1589382712972652.png,https://product-online.cdn.bcebos.com/1589382712672377.png,https://product-online.cdn.bcebos.com/1588848479418761.jpg,https://product-online.cdn.bcebos.com/1588151385317035.png,https://product-online.cdn.bcebos.com/1588765604659697.png,https://product-online.cdn.bcebos.com/1588151385544614.png,https://product-online.cdn.bcebos.com/1605687060385789.png");

        String[] split = xiaoDuPojo.getScollPicture().split(",");

        for (int i =0;i<split.length;i++){
            String path = " E:\\shopImg\\"+xiaoDuPojo.getShopName()+"\\"+"封面图_"+xiaoDuPojo.getShopName()+".png";
            System.out.println(path);
        }


    }
}

