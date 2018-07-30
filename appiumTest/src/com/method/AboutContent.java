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

    /**
     * @param:
     *
     * @auther: luopeng
     *
     * @date: 2018/7/5 16:36
     *
     * @description : 进入编辑页: 打开 发现 -> 打开 工作全 -> 点击发布
     */

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

    public static void sendWordContent(AppiumDriver Driver,String Text) throws InterruptedException {

        try {
            AboutContent.newContent(Driver);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et",Text,Driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    /**
     * @param:
     *
     * @auther: luopeng
     *
     * @date: 2018/7/5 16:37
     *
     * @description : 工作圈第一条评论发布: 点击 第一条消息 评论 -> 输入字符 ->点击发送
     */

    public static void sendComment(AppiumDriver Driver) throws InterruptedException {
//        AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
//        Thread.sleep(3000);
//
//        //点击工作圈
//        AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
//        Thread.sleep(2000);

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