package com.caseDebug.workProtal;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.workProtal
 * author: luopeng
 * Date: 2018/7/26
 * Time: 16:33
 *
 * Description:
 */
public class C3_1_1 extends TestInfo {
    @Test(description = "门户切换")
    public static void case3_1_1(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AppBase.clickId(Protal_SwitchIcon_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='testauto']",Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}