package com.caseDebug.discovery;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AboutContent;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:22
 *
 * Description:
 */
public class C5_2_4 extends TestInfo {
    @Test(description = "工作圈-文字/定位")
    public static void case5_2_4(AppiumDriver Driver) throws InterruptedException {

        try{
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            //输入文字
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",Driver);
            Thread.sleep(2000);

            //点击 定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_location_tv",Driver);
            Thread.sleep(3000);

            //点击确定定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
