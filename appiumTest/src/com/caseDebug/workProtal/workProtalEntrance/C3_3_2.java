/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:47
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenWork;
import org.testng.annotations.Test;

import com.method.SelectAction;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_3_2 extends TestInfo {
	@Test(description = "最近处理-抄送")
    public static void case3_3_2(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "最近处理的", 1);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Copy_Xpath, Driver);
            Thread.sleep(2000);
            // 选择人员
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 2);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(1000);

            AppBase.back(Driver);
            Thread.sleep(1000);
            // Driver.swipe(, starty, endx, endy, duration);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}