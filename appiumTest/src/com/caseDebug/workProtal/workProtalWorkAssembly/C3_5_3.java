package com.caseDebug.workProtal.workProtalWorkAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;


/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 16:06
 *
 * Description:
 */
public class C3_5_3 extends TestInfo {
    @Test(description = "门户 工作组件-最近处理打开")
    public static void case3_5_3(AppiumDriver Driver) throws InterruptedException {

        try {

            Thread.sleep(waitTime);

            AppBase.clickXpath(Protal_WorkAssbmely_Alreaddy_Xpath,Driver);

            //非全屏 打开 已处理 第一个工作
            //切换 已完成
            AppBase.clickId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(4000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            //切换 进行中
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(4000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);


            //工作组件 全屏 打开第一个待办
            AppBase.swipToUp(Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkAssbmely_fullScreen_Xpath,Driver);
            Thread.sleep(2000);

            //切换 已完成
            AppBase.clickId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(4000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            //切换 进行中
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(4000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(Protal_WorkASSBMELY_CloseFullScreen_Xpath,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}
