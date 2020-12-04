package com.auto.entity.impl;

import org.openqa.selenium.WebElement;

public interface GetLoginEleImpl {

    public WebElement getUserNameEle(String xpath);

    public WebElement getPassWordEle(String xpath);

    public WebElement getLoginBtnEle(String xpath);


}
