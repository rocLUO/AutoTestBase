/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:52
 *
 * Description:
 */
package com.caseDebug;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.SelectAction;
import com.method.OpenAppList;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_4_1 extends TestInfo {

    @Test(description = "我的发起-处理")
    public void case3_4_1(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        Thread.sleep(waitTime);
        try {
            // 造草稿
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            Thread.sleep(2000);
            // 默认测试门户 快捷入口在下方
            OpenAppList.viewWrokListByProtal(Driver);
            // 切换至 我发起的 列表
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            Thread.sleep(2000);
            // 点击 快捷入口 默认第一个入口
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);
            // 新建工作 内容编辑,人员提交
            SelectAction.newWorkTextInPut(Driver, "Word1", "Word2", "//android.widget.TextView[@text='autoTest']",
                    "////android.widget.TextView[@text='autoAccunt01']");
            // 点击保存按钮
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/flow_detail_save_Button", Driver);
            Thread.sleep(1000);
            Driver.closeApp();
            Thread.sleep(2000);
            Driver.launchApp();
            // 打开应用列表
            Thread.sleep(3000);
            OpenAppList.viewWrokListByProtal(Driver);
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
            AppBase.clickId("com.android.ayplatform" + type + ":id/flow_detail_submit_Button", Driver);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Thread.sleep(1000);
        Driver.closeApp();
    }
}