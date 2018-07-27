/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:50
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

public class C3_3_7 extends TestInfo {

    @Test(description = "最近处理-批注")
    public static void case3_3_7(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            OpenWork.entranceWork(Driver, "最近处理的", 1);

            // 批注
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_Comment_Id, Driver);
            Thread.sleep(2000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);

            AppBase.inPutById(Comment_InputText_Id, "testest", Driver);
            Thread.sleep(1000);

            AppBase.clickId(Comment_Send_Id, Driver);
            Thread.sleep(1000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(1000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}