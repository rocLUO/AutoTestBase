/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:48
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

public class C3_3_5 extends TestInfo {

    @Test(description = "最近处理-催办")
    public void case3_3_5(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
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
            // 更多
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            Thread.sleep(1000);
            AppBase.clickXpath("//android.widget.TextView[@text='催办']", Driver);
            Thread.sleep(2000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);
            AppBase.inPutById("com.android.ayplatform" + type + ":id/et_msg", "testestest", Driver);
            Thread.sleep(1000);
            AppBase.clickXpath("//android.widget.Button[@text='确定']", Driver);
            Thread.sleep(1000);
            Driver.closeApp();
            Thread.sleep(2000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}