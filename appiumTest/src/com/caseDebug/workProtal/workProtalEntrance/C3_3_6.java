/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:50
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

public class C3_3_6 extends TestInfo {

    @Test(description = "最近处理-历史记录")
    public static void case3_3_6(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            // 从门户快捷组件打开列表
            OpenWork.entranceWork(Driver, "最近处理的", 1);

            // 更多
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='历史记录']", Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(1000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            Thread.sleep(2000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
}