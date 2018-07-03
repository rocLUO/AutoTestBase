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

public class C3_4_7 extends TestInfo {

    @Test(description = "我的发起-批注")
    public void case3_4_7(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver); // 我发起的
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            OpenAppList.viewWrokListByProtal(Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            // AppBase.clickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // Driver); // 打开流程
            Thread.sleep(3000);
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/comment", Driver);
            // 点击评论
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/input_box_view_input_sms", Driver);
            // 点击输入框，输入文字
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/input_box_view_send_sms", Driver);
            // 点击确定
        } catch (Error E) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(1000);
    }
}