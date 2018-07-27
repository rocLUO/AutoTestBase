/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:57
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenWork;
import com.method.SelectAction;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_2_3 extends TestInfo {
    @Test(description = "代办工作-委托/快捷入口进入")
    public static void case3_2_3(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "待办工作", 1);
            // 点击 more
            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Entrust_Xpath, Driver);
            Thread.sleep(2000);

            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 2);
            Thread.sleep(2000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);

            AppBase.inPutById(WorkFlow_InputWindow_Id, "testest", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);

            // 取消委托
            Thread.sleep(2000);
            AppBase.clickXpath(
                    "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='取消委托']", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}