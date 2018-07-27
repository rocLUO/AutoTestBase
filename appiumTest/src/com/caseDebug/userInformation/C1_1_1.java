package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.ChangeAccount;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:31
 *
 * Description:
 */
public class C1_1_1 extends TestInfo{
    @Test(description = "帐号切换")
    public static void case1_1_1(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng123");
            Thread.sleep(2000);
            ChangeAccount.switchAccount(Driver,"企业管理员正牌",0);
            Thread.sleep(2000);
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng123");

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
