package com.auto.handle;

import com.auto.entity.GetLoginEle;
import com.auto.handle.impl.UseLoginEleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UseLoginEle implements UseLoginEleImpl {

    @Autowired
    public GetLoginEle getLoginEle;

    @Override
    public void SendUserName(String path, String userName) {
        getLoginEle.getLoginBtnEle(path).sendKeys(userName);
    }

    @Override
    public void SendPassWord(String path,String passWord) {
        getLoginEle.getPassWordEle(path).sendKeys(passWord);
    }

    @Override
    public void clickLoginBtn(String path) {
        getLoginEle.getLoginBtnEle(path).click();
    }
}
