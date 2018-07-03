/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:47
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.SelectAction;
import com.method.OpenAppList;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_3_2 extends TestInfo {

    public void case3_3_2(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            // 上接case2.1.6
            Thread.sleep(2000);
            // AppBase.clickXpath(MainPage_Tag_Already_Xpath, Driver);
            // 从门户快捷组件打开列表
            OpenAppList.viewWrokListByProtal(Driver);
            // 切换列表至 最近处理
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='最近处理']", Driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.clickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // Driver);
            AppBase.clickXpath(
                    "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            // 点击more
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='抄送']", Driver);
            // 选择人员
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 7);
            Thread.sleep(2000);
            AppBase.Back(Driver);
            Thread.sleep(1000);
            // Driver.swipe(, starty, endx, endy, duration);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}