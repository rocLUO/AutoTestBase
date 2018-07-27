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
 * Time: 11:11
 *
 * Description:
 */
public class C3_2_4 extends TestInfo{
    @Test(description = "代办工作-回退/快捷入口进入")
    public static void case3_2_4(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "待办工作", 1);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='回退']", Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
