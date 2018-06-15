package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/14
 * Time: 11:12
 *
 * Description: 从门户快捷入口打开应用列表,从应用打开门户列表
 */
public class openAppList extends TestInfo{

    /**
     * @param:
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 14:28
     *
     * @description : 从门户->快捷入口组件 进入应用实例列表
     */
    public static void viewWrokListByProtal(AppiumDriver Driver) throws InterruptedException {

        try{
            AppBase.ClickXpath(MainPage_Bar_Protal_Xpath, Driver);
            Thread.sleep(2000);

            //默认测试门户 快捷入口在下方
            AppBase.swipXY(585, 1805, 585, 249, Driver);
            Thread.sleep(2000);

            //点击 快捷入口 列表页 默认第三个入口
            AppBase.ClickXpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[3]", Driver);
            Thread.sleep(2000);


        } catch (Error e){
            e.printStackTrace();
        }


    }

    /**
     * @param:
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 14:28
     *
     * @description :从 应用中心-> 应用 进入实例列表
     */
    public static void viewWorkListByAppCeneter(AppiumDriver Driver) throws InterruptedException {

        try {
            AppBase.ClickXpath("MainPage_Bar_App_Xpath", Driver);
            Thread.sleep(3000);

            //默认autotest 应用在最下方
            AppBase.swipXY(525, 1846 ,525, 231, Driver);
            Thread.sleep(2000);

            //点击应用 autotest
            AppBase.ClickXpath("//android.widget.TextView[@text='autotest']", Driver);
            Thread.sleep(2000);

            //点击实例 进入列表页
            AppBase.ClickId("com.android.ayplatform"+type+":id/appcenter_myapp_detail_children_text", Driver);
        } catch (Error e) {
            e.printStackTrace();
        }

    }
}
