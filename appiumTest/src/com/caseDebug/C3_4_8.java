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

import com.method.OpenAppList;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_4_8 extends TestInfo {

    @Test(description = "我的发起-批注")
    public void case3_4_8(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver);
            // Driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            OpenAppList.viewWrokListByProtal(Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(3000);
            // 批注
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/comment", Driver);
            Thread.sleep(3000);
            // 表情
            AppBase.clickId("com.android.ayplatform" + type + ":id/input_box_view_image_face", Driver);
            Thread.sleep(2000);
            AppBase.clickXY(442, 1532, "点击表情", Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/input_box_view_send_sms", Driver);

            // .click();// 点击删除
            Thread.sleep(3000);
            AppBase.Back(Driver);
            Thread.sleep(2000);
            AppBase.Back(Driver);
        } catch (Error e) {
            Driver.closeApp();
            Thread.sleep(2000);
        }
    }
}