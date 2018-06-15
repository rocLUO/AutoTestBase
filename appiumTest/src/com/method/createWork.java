package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/14
 * Time: 11:18
 *
 * Description:从门户快捷入口新建实例,从应用新建实例
 */
public class createWork extends TestInfo{
    /**

     * @auther: luopeng
     *
     * @param: theDepartment : 接收人部门 xpath
     * @param: theRecipien : 接收人 xpath
     * @param: Word1 : autotest 实例 第一个输入框字段
     * @param: Word2 : autotest 实例 第二个输入框字段
     *
     * @date: 2018/6/14 11:34
     *
     * @description :从门户快捷入口新建实例,app使用autotest应用
     */
    public static void createWorkByProtal(AppiumDriver Driver, String Word1, String Word2, String theRecipien ,String theDepartment) throws InterruptedException {

        try {
            AppBase.ClickXpath("//android.widget.TextView[@text='门户", Driver);
            Thread.sleep(2000);

            //默认测试门户 快捷入口在下方
            AppBase.swipXY(585, 1805, 585, 249, Driver);
            Thread.sleep(2000);

            //点击 快捷入口 默认第一个入口
            AppBase.ClickXpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", Driver);
            Thread.sleep(2000);

            //快捷入口配置 进入创建页
            SelectAction.newWorkTextInPut(Driver, Word1, Word2, theRecipien, theDepartment);

            //点击提交按钮
            AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", Driver);
            Thread.sleep(2000);

        }catch (Error e){
            e.printStackTrace();
        }

    }

    /**
     * @param: theDepartment : 接收人部门 xpath
     * @param: theRecipien : 接收人 xpath
     * @param: Word1 : autotest 实例 第一个输入框字段
     * @param: Word2 : autotest 实例 第二个输入框字段
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 14:24
     *
     * @description :
     */
    public static void createWorkByAppCenter(AppiumDriver Driver, String Word1, String Word2, String theRecipien ,String theDepartment) throws InterruptedException {

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
            Thread.sleep(2000);

            //点击 新建 按钮
            AppBase.ClickId("com.android.ayplatform"+type+":id/activity_info_new", Driver);
            Thread.sleep(2000);

            //快捷入口配置 进入创建页
            SelectAction.newWorkTextInPut(Driver, Word1, Word2, theRecipien, theDepartment);

            //点击提交按钮
            AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
        }

    }


}
