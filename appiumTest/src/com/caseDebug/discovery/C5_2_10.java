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

            AboutContent.sendComment(Driver);

            //点击第一条 工作圈 评论内容
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView[1]",Driver);
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
