/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:48
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

/**
 * @param:
 *
 * @auther: luopeng
 *
 * @date: 2018/7/6 10:14
 *
 * @description :  最近处理 标签 工作 无 催办 选项.该条用例作废
 */

public class C3_3_5 extends TestInfo {

    @Test(description = "最近处理-催办")
    public static void case3_3_5(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            // 从门户快捷组件打开列表
            OpenWork.entranceWork(Driver, "最近处理的", 1);

            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(1000);

            AppBase.clickXpath(WorkFlow_Urge_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);

            AppBase.inPutById(WorkFlow_InputWindow_Id, "testestest", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);
            Thread.sleep(1000);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}