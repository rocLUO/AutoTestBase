/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:59
 *
 * Description:
 */
package com.caseDebug.qiLiao;

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

public class C2_2_1_3 extends TestInfo {
    @Test(description = "群聊天-创建")
    public static void case2_2_1_3(AppiumDriver Driver) throws InterruptedException {
        try {

            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_CreatGroup_Id, Driver);
            Thread.sleep(2000);

            //选择 按人搜索
            AppBase.clickId(QiLiao_CreateGroup_men_Id,Driver);
            Thread.sleep(2000);

            //点击搜索iconn
            AppBase.clickXpath(SearchList_SearchIcon_Xpath,Driver);
            Thread.sleep(2000);

            //输入
            AppBase.inPutById(SearchList_SearchInput_Id,"autoAccunt",Driver);
            Thread.sleep(3000);

            //点击 回车 收起 键盘
            AppBase.clickXY(998,1914,"软键盘回车 收起键盘",Driver);
            Thread.sleep(2000);

            //默认选择 3 个人
            AppBase.clickXpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(1000);

            AppBase.clickXpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[2]",Driver);
            Thread.sleep(1000);

            AppBase.clickXpath("//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[3]",Driver);
            Thread.sleep(2000);

            //点击确定
            AppBase.clickXpath(SearchList_SearchDone_Xpath,Driver);
            Thread.sleep(2000);

            //选择确定
            AppBase.clickId(SearchList_SearchConfrim_Id,Driver);
            Thread.sleep(2000);

            //输入框输入字符
            AppBase.inPutById(QiLiao_TextInput_Id,"text",Driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId(QiLiao_SendText_Id,Driver);
            Thread.sleep(2000);


            AppBase.clickId("com.android.ayplatform" + type + ":id/rc_emoticon_toggle", Driver);
            // Driver.findElementById("com.android.ayplatform"+type+":id/rc_emoticon_toggle").click();
            // 点击表情
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.FrameLayout[10]/android.widget.ImageView",Driver);
            // 点击发送
            Thread.sleep(3000);

            AppBase.clickId(QiLiao_SendText_Id, Driver);
            // (new TouchAction(Driver)).tap(670, 698).perform();
            Thread.sleep(3000);

            AppBase.back(Driver);
            // Driver.findElementById("com.android.ayplatform"+type+":id/rc_layout_item_message").click();

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}