package com.caseDebug.workProtal.workProtalWorkAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 15:03
 *
 * Description:
 */
public class C3_5_1 extends TestInfo {
    @Test(description = "门户 工作组件-标签切换")
    public static void case3_5_1(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);

            AppBase.clickXpath(Protal_WorkAssbmely_Alreaddy_Xpath,Driver);
            Thread.sleep(2000);
            AppBase.clearId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_Mylaunch_Xpath,Driver);
            Thread.sleep(2000);
            Thread.sleep(2000);
            AppBase.clearId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_HoldOn_Xpath,Driver);

            AppBase.swipToUp(Driver);
            Thread.sleep(2000);

            //组件全屏打开
            AppBase.clickXpath(Protal_WorkAssbmely_fullScreen_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_Alreaddy_Xpath,Driver);
            Thread.sleep(2000);
            Thread.sleep(2000);
            AppBase.clearId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_Mylaunch_Xpath,Driver);
            Thread.sleep(2000);
            Thread.sleep(2000);
            AppBase.clearId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_HoldOn_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkASSBMELY_CloseFullScreen_Xpath,Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
