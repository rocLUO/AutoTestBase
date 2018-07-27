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

public class C3_4_7 extends TestInfo {

    @Test(description = "我的发起-批注")
    public static void case3_4_7(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_Protal_Xpath, Driver);
            Thread.sleep(2000);

            OpenWork.entranceWork(Driver, "我发起的", 1);

            Thread.sleep(3000);
            AppBase.clickId(WorkFlow_Comment_Id, Driver);
            // 点击评论
            Thread.sleep(3000);
            AppBase.inPutById(Comment_InputText_Id,"TEXT",Driver);
            // 点击输入框，输入文字
            Thread.sleep(3000);
            AppBase.clickId(Comment_Send_Id, Driver);
            // 点击确定
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}