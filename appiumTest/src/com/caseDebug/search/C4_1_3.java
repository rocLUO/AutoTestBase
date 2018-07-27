/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:58
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

import com.method.WorkEdit;
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

public class C4_1_3 extends TestInfo {

    @Test(description = "搜索-应用")
    public static void case4_1_3(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            AppBase.clickId(Protal_Search_Id, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='应用']", Driver);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", Driver);
            // 点击搜索框
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/filter_edit", Driver);
            Thread.sleep(2000);
            // 搜索应用
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_E);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_S);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            // 点击第二个-直接进入应用列表
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_workbench_search_result_app_with_submenu_rootMenu",Driver);
//            AppBase.clickXY(537, 1090, "点击工作", Driver);
            Thread.sleep(1000);
            //新建工作
            AppBase.clickId(AppCenter_createNewWorkByAppList_Id,Driver);
            Thread.sleep(3000);
            WorkEdit.newAutoTestWork(Driver,"123","123","autoTest","autoAccunt01");
            Thread.sleep(2000);
            AppBase.back(Driver);
            Thread.sleep(500);
            AppBase.back(Driver);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}