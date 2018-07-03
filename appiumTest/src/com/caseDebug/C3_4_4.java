/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:55
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenAppList;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_4_4 extends TestInfo {

    @Test(description = "我的发起-回退")
    public void case3_4_4(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver);
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            Thread.sleep(2000);
            OpenAppList.viewWrokListByProtal(Driver);
            // Thread.sleep(3000);
            // AppBase.clickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // Driver);
            // 切换至 我发起的 列表
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            // 打开第一个 实例
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='回退']", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.Button[@text='确定']", Driver);
            AppBase.Back(Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}