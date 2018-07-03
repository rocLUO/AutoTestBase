/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:54
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

public class C3_4_3 extends TestInfo {

    @Test(description = "我的发起-委托")
    public void case3_4_3(AppiumDriver Driver) throws InterruptedException {
        Driver.launchApp();
        try {
            Thread.sleep(waitTime);
            AppBase.clickXpath("//android.widget.TextView[@text='门户']", Driver);
            Thread.sleep(2000);
            // 默认测试门户 快捷入口在下方
            OpenAppList.viewWrokListByProtal(Driver);
            // 切换至 我发起的 列表
            AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='我发起的']", Driver);
            // AppBase.clickXpath(MainPage_Tag_MyLaunch_Xpath, Driver); // 我发起的
            // AppBase.clickId("com.android.ayplatform"+type+":id/head_arrow",
            // Driver);
            Thread.sleep(3000);
            // AppBase.clickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // Driver); // 打开流程
            AppBase.clickXpath(
                    "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            // 点击三个点
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='委托']", Driver);
            // 点击委托
            // // 防止组织架构无法自动加载
            // Thread.sleep(1000);
            // AppBase.swipXY(517, 376, 517, 1761, Driver);
            //
            // Thread.sleep(2000);
            // AppBase.clickXpath("//android.widget.TextView[@text='九五之尊']",
            // Driver);
            //
            // // 选择 autotest 接受账号
            // Thread.sleep(2000);
            // AppBase.clickXpath("//android.widget.TextView[@text='111']",
            // Driver);
            // 选择人员
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 7);
            Thread.sleep(3000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/org_search_display_submit", Driver);
            // 点击确定
            // 取消委托
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/workbench_module_item1", Driver);
            Thread.sleep(2000);
            AppBase.clickId("com.android.ayplatform" + type + ":id/more", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.TextView[@text='取消委托']", Driver);
            Thread.sleep(2000);
            AppBase.clickXpath("//android.widget.Button[@text='确定']", Driver);
            Thread.sleep(1000);
        } catch (Error e) {
            AppBase.screenSnap(Driver);
        }
        Driver.closeApp();
        Thread.sleep(2000);
    }
}