package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/6
 * Time: 13:49
 *
 * Description:
 */
public class C3_2_8 extends TestInfo{
    @Test(description = "待办-批注")
    public static void case3_2_8(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            OpenWork.entranceWork(Driver, "待办工作", 1);

            // 批注
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_Comment_Id, Driver);
            Thread.sleep(2000);

            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(2000);

            AppBase.inPutById(Comment_InputText_Id, "testest", Driver);
            Thread.sleep(2000);

            AppBase.clickId(Comment_Send_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(1000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}
