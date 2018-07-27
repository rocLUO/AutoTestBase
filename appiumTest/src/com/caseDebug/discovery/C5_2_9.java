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
            AboutContent.sendComment(Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
