package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/11
 * Time: 10:48
 *
 * Description:
 */
public class C3_9_4 extends TestInfo {
    @Test(description = "过往工作-取回")
    public static void case3_9_4(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            OpenWork.entranceWork(Driver,"过往工作",1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Return_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_GetBack_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}