package com.auto.entity;

import com.auto.entity.impl.GetLoginEleImpl;
import com.auto.util.BaseEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.springframework.stereotype.Repository;

@Repository
public class GetLoginEle extends BaseEntity implements GetLoginEleImpl {

    @Override
    public WebElement  getUserNameEle(String xpath){
        return super.getBaseElement(By.xpath(xpath));
    }

    @Override
    public WebElement getPassWordEle(String xpath) {
        return super.getBaseElement(By.xpath(xpath));

    }

    @Override
    public WebElement getLoginBtnEle(String xpath) {
        return super.getBaseElement(By.xpath(xpath));
    }

}
