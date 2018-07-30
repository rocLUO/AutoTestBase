package com.caseDebug.discovery;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AboutContent;
import com.method.SelectAction;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:30
 *
 * Description:
 */
public class C5_2_12 extends TestInfo {
    @Test(description = "工作圈-@搜索")
    public static void case5_2_12(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            //点击  @ 图标
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",Driver);
            Thread.sleep(2000);

            SelectAction.searchMen(Driver,"autoAccunt01");
            Thread.sleep(2000);

            //点击 发布
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
