/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:58
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

import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
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

public class C4_1_2_5 extends TestInfo {

    @Test(description = "搜索-工作")
    public void case4_1_2_5(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(2000);
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickId(Protal_Search_Id, Driver);
            // Thread.sleep(3000);
            // Driver.findElementById("com.android.ayplatform:id/activity_worksearch_rl").click();
            // 搜索工作
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='工作']", Driver);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", Driver);
            // 点击搜索框
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/filter_edit", Driver);
            Thread.sleep(2000);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            Thread.sleep(2000);
            AppBase.clickXY(476, 847, "点击第一个工作", Driver);
            Thread.sleep(2000);
            AppBase.Back(Driver);
            Thread.sleep(1000);
            AppBase.Back(Driver);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}