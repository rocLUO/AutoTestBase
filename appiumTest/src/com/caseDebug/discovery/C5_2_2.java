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
 * Time: 9:57
 *
 * Description:
 */
public class C5_2_2 extends TestInfo {
    @Test(description = "工作圈-相册")
    public static void case5_2_2(AppiumDriver Driver) throws InterruptedException {

        try{
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            //点击 相册 icon
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_pic",Driver);
            Thread.sleep(2000);

            //点击坐标
            AppBase.clickXY(176,419,"选择图片,点击左上角",Driver);
            Thread.sleep(2000);

            //点击 确定
            AppBase.clickXY(894,1953,"点击确定",Driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

        } catch (Error e) {

            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
