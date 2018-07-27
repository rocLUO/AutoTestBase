package com.method;

import com.appium.TestBase.AppBase;
import io.appium.java_client.AppiumDriver;

import java.sql.Driver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/15
 * Time: 10:08
 *
 * Description:门户组件操作
 */
public class OpenProtalComponent {

    public static void openMessageComponent(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/9 17:26
         *
         * @description :消息组件 点击全屏
         */
        try {

            AppBase.clickXpath("//android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]", Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
        }
    }


    public static void openWorkCompomment(AppiumDriver Driver, String WorkType, int WorkNum) throws InterruptedException {
        /**
         * @param: [Driver, WorkType, WorkNum]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/15 10:48
         *
         * @description :工作组件打开工作 : 门户页面 -> 点击工作组件 全屏 -> 点击选择工作 标签 -> 点击选择列表 工作
         */

        try {
            //工作组件默认在中下方,需滑动一次
            AppBase.swipToUp(Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.LinearLayout/android.widget.TextView[1][@text='全屏']", Driver);
            Thread.sleep(2000);

            if(WorkType == "我发起的") {
                AppBase.clickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]", Driver);
            }else if(WorkType == "最近处理") {
                AppBase.clickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]", Driver);
            }else if(WorkType == "待办工作") {
                AppBase.clickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]", Driver);
            }

            Thread.sleep(2000);
            AppBase.clickXpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout["+ WorkNum +"]", Driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
