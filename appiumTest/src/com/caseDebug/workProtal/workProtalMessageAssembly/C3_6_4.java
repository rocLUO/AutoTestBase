package com.caseDebug.workProtal.workProtalMessageAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/6
 * Time: 17:22
 *
 * Description:
 */
public class C3_6_4 extends TestInfo {
    @Test (description = "消息组件-回复")
    public void case3_6_4(AppiumDriver Driver) throws InterruptedException {
        try {

            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_Protal_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_Message_fullScreen_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.Button[@text='回复']",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_Message_CloseFullScreen_Xpath,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
