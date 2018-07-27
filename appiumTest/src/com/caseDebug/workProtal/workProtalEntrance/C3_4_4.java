/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:55
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenWork;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

/**
 * @param:
 *
 * @auther: luopeng
 *
 * @date: 2018/7/6 10:53
 *
 * @description : 我发起的 工作 无 回退 选项 . 该条用例 废弃
 */
public class C3_4_4 extends TestInfo {

    @Test(description = "我的发起-回退")
    public static void case3_4_4(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver);
            AppBase.clickXpath(MainPage_Bar_Protal_Xpath, Driver);
            Thread.sleep(2000);
            OpenWork.entranceWork(Driver, "我发起的", 1);

            Thread.sleep(2000);
            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='回退']", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath(Button_Confrim_Xpath, Driver);
            AppBase.back(Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}