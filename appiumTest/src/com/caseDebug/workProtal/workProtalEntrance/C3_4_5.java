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
 * Time: 13:41
 *
 * Description:
 */
public class C3_4_5 extends TestInfo {

    @Test(description = "我的发起-历史记录")
    public static void case3_4_5(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver);
            OpenWork.entranceWork(Driver, "我发起的", 1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='历史记录']", Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}
