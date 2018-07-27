package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/14
 * Time: 13:57
 *
 * Description: 人员提交 与 人员选择 操作
 */
public class SelectAction extends TestInfo{

    public static void submission(AppiumDriver Driver, String Department, String Recipien) throws InterruptedException {
        /**
         * @param: [Driver, Department, Recipien]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/14 14:03
         *
         * @description : 工作提交接收人选择 : 组织架构页 -> 选择部门 -> 选择人员 -> 点击确定
         */

        //滑动到最下,默认接收测试帐号部门在最底
        AppBase.swipXY(504, 1752, 504, 347, Driver);
        Thread.sleep(3000);

        //点击 接收人 部门 Department -Xpath
        AppBase.clickXpath("//android.widget.TextView[@text='"+Department+"']", Driver);
        Thread.sleep(2000);

        //点击 接收人 Recipien -Xapth
        AppBase.clickXpath("//android.widget.TextView[@text='"+Recipien+"']", Driver);
        Thread.sleep(2000);

        //点击 确定 选择
        AppBase.clickId(Company_Select_done_Id,Driver);
        Thread.sleep(2000);
    }

    public static void choosesMen(AppiumDriver Driver, String department, String Name, int swipTime) throws InterruptedException {
        /**
         * @param: [Driver, department, recipoen, swipTime]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/14 16:33
         *
         * @description : 组织架构人员选择 : 组织架构页 -> 滑动选择部门 -> 选择人员 -> 点击确定
         */
        //老版本 组织架构//
        /*
        for(int i=0; i<swipTime; i++){
            if(swipTime==0){
                break;
            }
            //默认部门在最下方
            AppBase.swipToUp(Driver);
            Thread.sleep(2000);
        }

        //打开 部门
        AppBase.clickXpath("//android.widget.TextView[@text='"+department+"']", Driver);
        Thread.sleep(2000);

        //选择人员
        AppBase.clickXpath("//android.widget.TextView[@text='"+recipoen+"']", Driver);
        Thread.sleep(2000);

        //点击 确定
        AppBase.clickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", Driver);
        Thread.sleep(2000);
        */

        //新版本 组织架构//
        /**
         * @param: [Driver, department, recipoen, swipTime]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/27 15:11
         *
         * @description : 停止使用
         */

        AppBase.clickId(Company_SearchIcon_Id,Driver);
        Thread.sleep(2000);

        AppBase.inPutById(Company_SearchInput_Id,Name,Driver);
        Thread.sleep(2000);

        AppBase.clickXpath("//android.widget.TextView[@text='"+ Name + "']",Driver);
        Thread.sleep(2000);

        AppBase.clickId(Company_SearchSelect_done_Id,Driver);
        Thread.sleep(2000);
    }

    public static void searchMen(AppiumDriver Driver, String Name) throws InterruptedException {
        /**
         * @param: [Driver, Name]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 15:10
         *
         * @description : 组织架构页 搜索 选择人员 : 组织架构页 -> 点击 搜索ican -> 输入 name -> 选择 name -> 点击 确定
         */
        try {
            AppBase.clickId(Company_SearchIcon_Id,Driver);
            Thread.sleep(2000);

            AppBase.inPutById(Company_SearchInput_Id,Name,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='"+ Name + "']",Driver);
            Thread.sleep(2000);

            AppBase.clickId(Company_SearchSelect_done_Id,Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
        }
    }
}
