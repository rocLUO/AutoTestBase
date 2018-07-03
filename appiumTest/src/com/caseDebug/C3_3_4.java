/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:52
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

public class C3_3_4 extends TestInfo {

    @Test(description = "最近处理-中断")
    public void case3_3_4(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_Already_Xpath, Driver);
            OpenAppList.viewWrokListByProtal(Driver);
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
            Thread.sleep(3000);
            // clickXpath("//android.widget.TextVie[@text='中断']");
            AppBase.clickXY(819, 783, "点击中断", Driver);
            Thread.sleep(1000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);
            AppBase.inPutById("com.android.ayplatform" + type + ":id/et_msg", "testest", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.Button[@text='确定']", Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
    }
}