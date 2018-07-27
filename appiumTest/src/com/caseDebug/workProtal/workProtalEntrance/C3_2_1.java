/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:56
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

public class C3_2_1 extends TestInfo {

    @Test(description = "代办工作-处理/快捷入口进入")
    public static void case3_2_1(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            OpenWork.entranceWork(Driver, "待办工作", 1);
            // 添加接收人
            AppBase.clickId("com.android.ayplatform" + type + ":id/org_add_user_imageView", Driver);
            Thread.sleep(2000);
            // 部门:autoTest 人员:autoAccunt01
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 2);
            Thread.sleep(3000);
            AppBase.clickId(WorkFlow_Send_Id, Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            Thread.sleep(1000);
            AppBase.screenSnap(Driver);
        }
    }
}