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
 * Time: 14:23
 *
 * Description:
 */
public class C5_2_5 extends TestInfo {
    @Test(description = "工作圈-@")
    public static void case5_2_5(AppiumDriver Driver) throws InterruptedException {
        try{
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            //点击 @
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",Driver);
            Thread.sleep(2000);

            //人员组织架构 人员选择-方法
            SelectAction.choosesMen(Driver,"autoTest","autoAccunt01",2);
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
