package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/10
 * Time: 19:02
 *
 * Description:
 */
public class C3_9_1 extends TestInfo {
    @Test(description = "过往工作-工作打开")
    public static void case3_9_10y(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            OpenWork.entranceWork(Driver,"过往工作",1);
            Thread.sleep(2000);

            AppBase.clearId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}