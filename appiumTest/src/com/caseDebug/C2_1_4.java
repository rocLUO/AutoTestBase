/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:00
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class C2_1_4 extends TestInfo {

    @Test(description = "群聊天-编辑")
    public void case2_1_4(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(2000);
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            // 上接着case2_1_23,已建立聊天组
            Thread.sleep(2000);
            // 讨论组无Id/xpath特征
            AppBase.clickXY(552, 315, "点击讨论组", Driver);
            Thread.sleep(2000);
            // 讨论组信息
            AppBase.clickId("com.android.ayplatform" + type + ":id/chat_action_btn", Driver);
            Thread.sleep(2000);
            // 点击群组名称 无id与xpath特征
            (new TouchAction(Driver)).tap(635, 528).perform();
            // clickXpath("//android.widget.TextView[@text='群组名称']");
            Thread.sleep(2000);
            // case2.1.23 已切换至unicode输入法
            AppBase.inPutById("com.android.ayplatform" + type + ":id/activity_modify_groupname_content", "testestest",
                    Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/doing", Driver);
            Thread.sleep(2000);
            // 后退至聊天列表
            AppBase.Back(Driver);
            Thread.sleep(1000);
            // 后退至主页面
            AppBase.Back(Driver);
        } catch (Error e) {
            Thread.sleep(2000);
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}