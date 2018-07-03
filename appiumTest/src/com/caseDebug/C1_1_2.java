package com.caseDebug;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

import java.sql.Driver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:34
 *
 * Description:
 */
public class C1_1_2 extends TestInfo {
    public void case1_1_2(AppiumDriver Driver) throws InterruptedException {

        Driver.launchApp();
        Thread.sleep(waitTime);

        try {
            AppBase.clickXY(309,1080,"点击->账号安全",Driver);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

        Thread.sleep(1000);
        Driver.closeApp();
        Thread.sleep(2000);

    }
}
