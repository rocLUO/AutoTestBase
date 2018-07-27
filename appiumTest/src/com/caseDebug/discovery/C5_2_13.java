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
 * Time: 14:20
 *
 * Description:
 */
public class C5_2_13 extends TestInfo{
    @Test(description = "工作圈-图片放大")
    public static void case5_2_13(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            //先发图确保有图可点
            AboutContent.newContent(Driver);

            //点击 相机
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_cameral",Driver);
            Thread.sleep(3000);

            //点击 拍摄
            AppBase.clickId("com.huawei.camera:id/shutter_button",Driver);
            Thread.sleep(5000);

            //确定 照片
            AppBase.clickId("com.huawei.camera:id/done_button",Driver);
            Thread.sleep(3000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

            //点击 图片 第一张图
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ImageView",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
