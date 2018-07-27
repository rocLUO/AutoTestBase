package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.sun.jna.platform.win32.ShellAPI;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/6
 * Time: 11:14
 *
 * Description:
 */
public class OpenWork extends TestInfo{

    public static void entranceWork(AppiumDriver Driver, String workType, int workListNum) throws InterruptedException {
        /**
         * @param: [Driver, workType, workListNum]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/9 17:28
         *
         * @description : 门户快捷入口打开工作 : 门户 -> 快捷入口 -> 应用列表 -> 筛选工作 -> 打开工作
         */
        // 从门户快捷组件打开列表
        OpenAppList.viewWrokListByProtal(Driver,3);
        // 切换列表至 最近处理
        Thread.sleep(3000);

        AppBase.clickId("com.android.ayplatform" + type + ":id/head_arrow", Driver);
        Thread.sleep(2000);

        AppBase.swipToUp(Driver);
        Thread.sleep(2000);

        //点击工作类型
        AppBase.clickXpath("//android.widget.TextView[@text='"+ workType +"']", Driver);
        // 默认点击第一个工作
        Thread.sleep(2000);

        AppBase.clickXpath(
                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+ workListNum +"]",
                Driver);
        // 点击more
        Thread.sleep(3000);
    }

    public static void AssemblyWork(AppiumDriver Driver, String workType, String workState, int WorkListNum) throws InterruptedException {
        /**
         * @param: [Driver, workType, workState, WorkListNum]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/9 17:29
         *
         * @description :门户工作组件打开工作 :　门户　->　工作组件全屏　->　工作标签切换　->　工作状态切换　->　打开工作
         */
        //工作组件 全屏 打开第一个待办
        AppBase.swipToUp(Driver);
        Thread.sleep(2000);

        //全屏 工作组件
        AppBase.clickXpath(Protal_WorkAssbmely_fullScreen_Xpath,Driver);
        Thread.sleep(2000);

        //工作标签 切换
        if (workType == "最近处理") {
            Thread.sleep(1000);
            AppBase.textPrint("点击 -> 最近处理");
            AppBase.clickXpath(Protal_WorkAssbmely_Alreaddy_Xpath,Driver);
            Thread.sleep(1000);
        } else if (workType == "我发起的") {
            Thread.sleep(1000);
            AppBase.textPrint("点击 -> 我发起的");
            AppBase.clickXpath(Protal_WorkAssbmely_Mylaunch_Xpath,Driver);
            Thread.sleep(1000);
        } else if (workType == "待办工作") {
            Thread.sleep(1000);
            AppBase.textPrint("点击 -> 待办工作");
            AppBase.clickXpath(Protal_WorkAssbmely_HoldOn_Xpath,Driver);
            Thread.sleep(1000);
        }

        //工作状态 切换
        if (workState == "进行中"){
            Thread.sleep(1000);
            AppBase.textPrint("选择 -> 进行中");
            AppBase.clickId("com.android.ayplatform"+ type +":id/running",Driver);
            Thread.sleep(2000);
        } else if (workState == "已完成") {
            Thread.sleep(1000);
            AppBase.textPrint("选择 -> 已完成");
            AppBase.clickId("com.android.ayplatform"+ type +":id/stop",Driver);
            Thread.sleep(2000);
        } else {
            Thread.sleep(1000);
            AppBase.textPrint("不选择 工作状态");
        }

        //选择 待办 标号
        AppBase.clickXpath("//android.widget.LinearLayout[1]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+ WorkListNum +"]",Driver);
        Thread.sleep(4000);
    }
}
