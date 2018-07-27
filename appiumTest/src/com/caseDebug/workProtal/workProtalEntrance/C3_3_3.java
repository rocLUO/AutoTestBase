/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:51
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

public class C3_3_3 extends TestInfo {
    @Test(description = "最近处理-取回")
    public static void case3_3_3(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "最近处理的", 1);
            // 更多
            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_GetBack_Xpath,Driver);
            Thread.sleep(1000);

            AppBase.clickXpath(Button_Cancel_Xpath, Driver);
            Thread.sleep(1000);

            AppBase.back(Driver);
            Thread.sleep(1000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}