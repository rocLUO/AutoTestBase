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

public class C3_2_1 extends TestInfo {

    @Test(description = "代办工作-处理/快捷入口进入")
    public void case3_2_1(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            OpenAppList.viewWrokListByProtal(Driver);
            Thread.sleep(2000);

            // 快捷入口进入工作哦列表
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='待办工作']", Driver);
            Thread.sleep(2000);
            // 默认打开第一个工作
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);
            // 添加接收人
            AppBase.clickId("com.android.ayplatform" + type + ":id/org_add_user_imageView", Driver);
            Thread.sleep(2000);
            // 部门:autoTest 人员:autoAccunt01
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 7);
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/flow_detail_submit_Button", Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            Thread.sleep(1000);
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}