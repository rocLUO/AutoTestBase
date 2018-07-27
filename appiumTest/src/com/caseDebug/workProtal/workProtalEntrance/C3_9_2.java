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
 * Time: 19:55
 *
 * Description:
 */
public class C3_9_2 extends TestInfo {
    @Test(description = "过往工作-历史记录")
    public static void case3_9_2(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {

            OpenWork.entranceWork(Driver,"历史纪录",1);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_History_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}