/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:54
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.OpenWork;
import com.method.SelectAction;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_4_2 extends TestInfo {

    @Test(description = "我的发起-抄送")
    public static void case3_4_2(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath(MainPage_Bar_Protal_Xpath, Driver);
            Thread.sleep(2000);

            // 默认测试门户 快捷入口在下方
            OpenWork.entranceWork(Driver, "我发起的", 1);

            Thread.sleep(3000);

            // 点击更多
            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(3000);

            // 点击抄送
            AppBase.clickXpath(WorkFlow_Copy_Xpath, Driver);
            Thread.sleep(2000);

            // 选择人员
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 3);
            // 确定
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(1000);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}