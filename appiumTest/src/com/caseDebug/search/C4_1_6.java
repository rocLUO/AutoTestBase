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

public class C4_1_6 extends TestInfo {
    @Test(description = "搜索-历史搜索")
    public static void case4_1_6(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            AppBase.clickId(Protal_Search_Id, Driver);
            Thread.sleep(3000);
            // 紧跟case4_1_3,利用已有历史标签
            AppBase.clickXpath("//android.widget.TextView[@text='auto']", Driver);
            // 点击应用
            Thread.sleep(3000);
            AppBase.clickXY(537, 1090, "点击工作", Driver);
            Thread.sleep(2000);
            AppBase.back(Driver);
            Thread.sleep(1000);
            AppBase.back(Driver);
            // // 点击评论按钮
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}