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
import org.apache.poi.ss.formula.functions.T;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

/**
 * @param:
 *
 * @auther: luopeng
 *
 * @date: 2018/7/6 10:51
 *
 * @description : 我发起的 工作 无 委托 选项 . 该条用例 废弃
 */

public class C3_4_3 extends TestInfo {

    @Test(description = "我的发起-委托")
    public static void case3_4_3(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            // 默认测试门户 快捷入口在下方
            OpenWork.entranceWork(Driver, "我发起的", 1);

            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            // 点击三个点
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Entrust_Xpath, Driver);

            // 选择人员
            SelectAction.choosesMen(Driver, "autoTest", "autoAccunt01", 2);
            Thread.sleep(3000);

            // 点击确定
            AppBase.inPutById(WorkFlow_InputWindow_Id,"text",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath,Driver);
            Thread.sleep(2000);
            AppBase.swipToDown(Driver);
            // 取消委托
            Thread.sleep(2000);

            AppBase.clickXpath(
                    "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                    Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='取消委托']", Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath, Driver);
            Thread.sleep(1000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}