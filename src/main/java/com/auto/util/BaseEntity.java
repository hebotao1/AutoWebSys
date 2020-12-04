package com.auto.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BaseEntity {


    //通过隐式等待 找出对象
    public WebElement getBaseElement(By ele){
        return new WebDriverWait(DriverUtil.getDriver(), 30).until(
                ExpectedConditions.presenceOfElementLocated(ele));
    }

    //通过隐式等待 找出对象
    public List<WebElement>  getBaseElements(By ele){

        List<WebElement>  eles = DriverUtil.getDriver().findElements(ele);
        System.out.println("---------------"+eles.size());
        return eles;
    }


}
