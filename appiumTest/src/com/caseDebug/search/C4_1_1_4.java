/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:57
 *
 * Description:
 */
package com.caseDebug.search;

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

public class C4_1_1_4 extends TestInfo {

    @Test(description = "搜索-人员搜索")
    public static void case4_1_1_4(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            AppBase.clickId(Protal_Search_Id, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='同事']", Driver);
            Thread.sleep(3000);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", Driver);
            // 点击搜索框
            AppBase.clickId("com.android.ayplatform" + type + ":id/filter_edit", Driver);
            // 搜索同事
            Thread.sleep(3000);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_C);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_C);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_N);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(2000);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.ENTER);
            Thread.sleep(2000);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.ENTER);
            // 点击 筛选
            // clickId(Search_main_filter_bottom);
            Thread.sleep(3000);
            // 给搜索到的同事
            AppBase.clickXpath("//android.widget.TextView[@text='autoaccunt01']", Driver);
            Thread.sleep(3000);
            // 点击-发送消息(xpath/id不可用)
            AppBase.clickXY(804, 1936, "点击发送消息", Driver);
            Thread.sleep(3000);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", Driver);
            // 点击输入框
            AppBase.clickId(QiLiao_TextInput_Id, Driver);
            Thread.sleep(2000);
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(1000);
            AppBase.inPutById(QiLiao_TextInput_Id, "testtest", Driver);
            // 发送
            Thread.sleep(2000);
            AppBase.clickId(QiLiao_SendText_Id, Driver);
            Thread.sleep(3000);
            AppBase.back(Driver);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}