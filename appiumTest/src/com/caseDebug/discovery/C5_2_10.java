package com.caseDebug.discovery;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AboutContent;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:27
 *
 * Description:
 */
public class C5_2_10 extends TestInfo {
    @Test(description = "工作圈-评论删除")
    public static void case5_2_10(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",Driver);
            Thread.sleep(3000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(4000);

            AboutContent.sendComment(Driver);

            //点击第一条 工作圈 评论内容
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView",Driver);
            Thread.sleep(2000);

            //点击弹窗中 删除
            AppBase.clickId("com.android.ayplatform"+ type +":id/custom_dialog_delete",Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
