/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:59
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

public class C2_1_23 extends TestInfo {
    @Test(description = "群聊天-创建")
    public void case2_1_23(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(2000);
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            // Driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
            Thread.sleep(2000);
            AppBase.clickId(QiLiao_CreatGroup_Id, Driver);
            // Driver.findElementById("com.android.ayplatform"+type+":id/create_group").click();
            Thread.sleep(2000);
            // 点击人员-1
            AppBase.clickXY(543, 386, "选择人员-1", Driver);
            // 点击张宗超
            // (new TouchAction(Driver)).tap(399, 301).perform();
            Thread.sleep(2000);
            // 点击人员-2
            AppBase.clickXY(468, 594, "选择人员-2", Driver);
            // 点击杜磊
            // (new TouchAction(Driver)).tap(343, 513).perform();
            // 点击完成---此为动态控件 xpath无法定位
            Thread.sleep(2000);
            // clickId("com.android.ayplatform"+type+":id/head_right");
            AppBase.clickXY(992, 128, "点击完成", Driver);
            // clickXpath("//android.widget.TextView[@text='完成(2)']");
            // (new TouchAction(Driver)).tap(650, 89).perform();
            // 选定
            // ((AndroidDeviceActionShortcuts)
            // Driver).pressKeyCode(AndroidKeyCode.ENTER);
            // 确定
            // ((AndroidDeviceActionShortcuts)
            // Driver).pressKeyCode(AndroidKeyCode.ENTER);
            Thread.sleep(2000);
            // 点击 输入框-》光标显示/焦点
            AppBase.clickId("com.android.ayplatform" + type + ":id/rc_edit_text", Driver);
            // 切换 appium 输入
            Thread.sleep(2000);
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", Driver);
            Thread.sleep(2000);
            AppBase.inPutById("com.android.ayplatform" + type + ":id/rc_edit_text", "testtest", Driver);
            // 表情
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/rc_emoticon_toggle", Driver);
            // Driver.findElementById("com.android.ayplatform"+type+":id/rc_emoticon_toggle").click();
            // 点击表情
            Thread.sleep(3000);
            (new TouchAction(Driver)).tap(59, 843).perform();
            // 点击发送
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/rc_send_toggle", Driver);
            // (new TouchAction(Driver)).tap(670, 698).perform();
            Thread.sleep(3000);
            AppBase.Back(Driver);
            // Driver.findElementById("com.android.ayplatform"+type+":id/rc_layout_item_message").click();
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}