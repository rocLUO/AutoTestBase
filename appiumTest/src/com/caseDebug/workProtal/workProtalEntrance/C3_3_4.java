/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:52
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenWork;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_3_4 extends TestInfo {

    @Test(description = "最近处理-中断")
    public static void case3_3_4(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "最近处理的", 1);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(3000);

            AppBase.clickXpath(WorkFlow_Interrpt_Xpath,Driver);
            Thread.sleep(1000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);

            AppBase.inPutById(WorkFlow_InputWindow_Id, "testest", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);
            Thread.sleep(1000);

            //下拉刷新
            AppBase.swipToDown(Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(
                    "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='恢复流程']",Driver);
            Thread.sleep(2000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);

            AppBase.inPutById(WorkFlow_InputWindow_Id, "testest", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}