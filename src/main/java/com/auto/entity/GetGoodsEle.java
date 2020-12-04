package com.auto.entity;

import com.auto.entity.impl.GetGoodsEleImpl;
import com.auto.util.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Repository;

@Repository
public class GetGoodsEle extends BaseEntity implements GetGoodsEleImpl {
    @Override
    public WebElement getGoodManageButton(String xpath) {
       return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getRightAddGoodsButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getHotelTypeButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }




    @Override
    public WebElement getGoodsTypeConfirmButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getProjectNameInput(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getProjectClassSelect(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getProjectType(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getOriginalPriceInput(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getInitialSaleInput(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }


    @Override
    public WebElement getDatePriceButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getSalePrice(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getCostPrice(String xpath) {
        return super.getBaseElement(By.xpath(xpath));

    }

    @Override
    public WebElement getCancelOrderInput(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getCoverPhotoButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getBannerPhotoButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getNextStepButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getShopDetail(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getDetailPicture(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getCommitButton(String xpath) {
         return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getClickOnSiteConfirmation(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getClickAppointment(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getSetOutInput(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getSetUpInput(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement clickPageSize(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }




}
