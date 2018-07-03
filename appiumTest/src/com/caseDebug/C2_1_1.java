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

public class C2_1_1 extends TestInfo {

    @Test(description = "启聊导航栏切换与会话/通讯录切换")
    public static void case2_1_1(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(2000);
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            // Driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
            Thread.sleep(2000);
            AppBase.clickXpath(QiLiao_MailList_Xpath, Driver);
            // Driver.findElementByXPath("//android.widget.TextView[@text='通讯录']").click();
            Thread.sleep(2000);
            AppBase.clickXpath(QiLiao_Chat_Xpath, Driver);
            // Driver.findElementByXPath("//android.widget.TextView[@text='会话']").click();
            Thread.sleep(2000);
            AppBase.clickId(QiLiao_CreatGroup_Id, Driver);
            // Driver.findElementById("com.android.ayplatform:id/create_group").click();
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}