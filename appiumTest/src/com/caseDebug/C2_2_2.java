/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:56
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.SelectAction;
import com.method.OpenAppList;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C2_2_2 extends TestInfo {

    @Test(description = "代办工作-抄送/快捷入口进入")
    public void case2_2_2(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(2000);
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            OpenAppList.viewWrokListByProtal(Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='代办工作']", Driver);
            Thread.sleep(2000);
            // 默认打开第一个工作
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);
            // 点击 more
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='抄送']", Driver);
            Thread.sleep(2000);
            // 人员选择操作
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 7);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}