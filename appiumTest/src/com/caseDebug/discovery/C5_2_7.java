package com.caseDebug.discovery;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:25
 *
 * Description:
 */
public class C5_2_7 extends TestInfo{
    @Test(description = "工作圈-删除")
    public static void case5_2_7(AppiumDriver Driver) throws InterruptedException {
        try{
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
            Thread.sleep(3000);

            //点击工作圈
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
            Thread.sleep(2000);

            //删除第一条
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(3000);

            AppBase.clickXpath(Button_Cancel_Xpath,Driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
