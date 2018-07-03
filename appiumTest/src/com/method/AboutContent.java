/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/3
 * Time: 20:30
 *
 * Description:
 */
package com.method;

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

public class AboutContent extends TestInfo {
    public static void newContent(AppiumDriver Driver) throws InterruptedException {

        AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
        Thread.sleep(3000);

        //点击工作圈
        AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
        Thread.sleep(2000);

        //点击发布
        AppBase.clickId("com.android.ayplatform"+ type +":id/doing",Driver);
        Thread.sleep(2000);

    }

    public static void sendComment(AppiumDriver Driver) throws InterruptedException {
        AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
        Thread.sleep(3000);

        //点击工作圈
        AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
        Thread.sleep(2000);

        //点击 评论
        AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[3]",Driver);
        Thread.sleep(2000);

        //输入字符
        AppBase.inPutById("com.android.ayplatform"+ type +":id/input_box_view_input_sms","testtest",Driver);
        Thread.sleep(2000);

        AppBase.clickId("com.android.ayplatform"+ type +":id/input_box_view_send_sms",Driver);
        Thread.sleep(2000);
    }
}