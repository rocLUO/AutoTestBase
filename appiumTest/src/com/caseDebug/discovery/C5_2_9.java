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
 * Time: 14:27
 *
 * Description:
 */
public class C5_2_9 extends TestInfo {
    @Test(description = "工作圈-评论")
    public static void case5_2_9(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
            Thread.sleep(3000);

            //点击工作圈
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
            Thread.sleep(3000);

            Thread.sleep(waitTime);
            AboutContent.sendComment(Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
