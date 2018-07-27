/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:00
 *
 * Description:
 */
package com.caseDebug.qiLiao;

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

public class C2_2_4 extends TestInfo {

    @Test(description = "群聊天-编辑")
    public static void case2_2_4(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            //建立聊天组-----
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

            //选择确定-------
            AppBase.clickId(SearchList_SearchConfrim_Id,Driver);
            Thread.sleep(2000);

            // 点击讨论组无,新建不用进入
//            AppBase.clickXpath("//android.widget.ListView/android.widget.RelativeLayout[1]",Driver);
            Thread.sleep(2000);

            // 讨论组信息
            AppBase.clickId(QiLiao_GroupSet_Id,Driver);
//            AppBase.clickId("com.android.ayplatform" + type + ":id/chat_action_btn", Driver);
            Thread.sleep(2000);

            // 点击群组名称 无id与xpath特征
//            AppBase.clickXpath(QiLiao_GroupSet_Name_Xpath,Driver);
//            (new TouchAction(Driver)).tap(635, 528).perform();
//            AppBase.clickXpath("//android.widget.TextView[@text='群组名称']",Driver);
            AppBase.clickXY(734,805,"点击群组名称",Driver);
            Thread.sleep(2000);

            // case2.1.23 已切换至unicode输入法
            AppBase.inPutById(QiLiao_GroupSet_NameEdit_Id, "testestest",
                    Driver);
            Thread.sleep(2000);

            AppBase.clickId(Edit_confrim_Id, Driver);
            Thread.sleep(2000);

            // 后退至聊天列表
            AppBase.back(Driver);
            Thread.sleep(1000);
            // 后退至主页面
            AppBase.back(Driver);
        } catch (Error e) {
            Thread.sleep(2000);
            AppBase.screenSnap(Driver);
        }
    }
}