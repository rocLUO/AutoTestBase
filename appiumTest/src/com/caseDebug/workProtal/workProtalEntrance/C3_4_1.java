/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:52
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.CreateWork;
import com.method.OpenWork;
import com.method.OpenAppList;
import com.method.WorkEdit;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

/**
 * @param:
 *
 * @auther: luopeng
 *
 * @date: 2018/7/6 10:27
 *
 * @description : 我发起的 工作 无处理 选项 .该条用例作废
 */

public class C3_4_1 extends TestInfo {
/*
    @Test(description = "我的发起-处理")
    public static void case3_4_1(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            // 造草稿
            AppBase.clickXpath(MainPage_Bar_Protal_Xpath, Driver);
            Thread.sleep(2000);

            // 默认测试门户 快捷入口在下方
            CreateWork.createDraftWorkByEntrance(Driver,"text1","text2","autoTest","autoAccunt01");
            Thread.sleep(2000);

            Driver.closeApp();
            Thread.sleep(2000);

            Driver.launchApp();
            // 打开应用列表
            Thread.sleep(3000);

            OpenAppList.viewWrokListByProtal(Driver,3);
            Thread.sleep(2000);

            // 切换至 我发起的 列表
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            Thread.sleep(2000);

            // 选择第一个草稿
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);

            // 点击发送
            AppBase.clickId(WorkFlow_Send_Id, Driver);

        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
    }
    */
}