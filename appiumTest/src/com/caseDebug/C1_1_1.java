package com.caseDebug;

import com.appium.TestBase.AppBase;
import com.method.changeAccount;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:31
 *
 * Description:
 */
public class C1_1_1 {
    public void case1_1_1(AppiumDriver Driver) throws InterruptedException {

        try {
            changeAccount.switchAccount(Driver,"企业管理员正牌",0);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

        Thread.sleep(1000);
        Driver.closeApp();
        Thread.sleep(2000);

    }
}
