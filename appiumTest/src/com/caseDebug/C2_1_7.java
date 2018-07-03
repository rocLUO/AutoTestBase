/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:47
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Driver;

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

public class C2_1_7 extends TestInfo {

    @Test(description = "通讯录-成员通话跳转")
    public void case2_1_7(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            // 上接case2.1.6
            Thread.sleep(waitTime);
            // 启聊
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath(QiLiao_MailList_Xpath, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='alex']", Driver);
            // 商务通话
            Thread.sleep(2000);
            // clickId("com.android.ayplatform"+type+":id/item_chat_colleaguedetail_content_call");
            AppBase.clickXY(286, 1935, "点击通话", Driver);
            Thread.sleep(1000);
            AppBase.Back(Driver);
            Thread.sleep(1000);
            AppBase.Back(Driver);
            Thread.sleep(1000);
            AppBase.Back(Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}