/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:01
 *
 * Description:
 */
package com.caseDebug.qiLiao;

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

public class C2_3_1 extends TestInfo {
    @Test(description = "通讯录-我的群组")
    public static void case2_3_1(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            // 启聊
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            // 通讯录
            Thread.sleep(2000);
            AppBase.clickXpath(QiLiao_MailList_Xpath, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我的群组']", Driver);
            // 测试企业--群组
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/item_group_manager_name", Driver);
            Thread.sleep(2000);
            AppBase.inPutById(QiLiao_TextInput_Id, "testestest", Driver);
            // 发送
            Thread.sleep(1000);
            AppBase.clickId(QiLiao_SendText_Id, Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}