package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/29
 * Time: 10:35
 *
 * Description:
 */
public class ChangeAccount extends TestInfo {

    public static void switchAccount(AppiumDriver Driver, String AccuntName, int i) throws InterruptedException {
        /**
         * @param: [Driver, AccuntName]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/29 10:45
         *
         * @description :切换帐号 : 点击个人设置图标 -> 点击帐号与安全 -> 点击帐号切换 -> 点击 帐号 -> 点击空白处
         */

        try {

            //点击左上 头像图标 呼出操作工具栏
            AppBase.clickId("com.android.ayplatform" + type + ":id/user_avatar_layout", Driver);
            Thread.sleep(2000);

            //点击 账号与安全选项 弹窗图层控件信息无法获得 使用坐标点击
            //            AppBase.clickXY(280, 1075, "点击->账号与安全", Driver);
            AppBase.clickXpath(MyInfo_Tag_AccountSecurity_Xpath, Driver);
            Thread.sleep(3000);

            //点击 帐号切换
            AppBase.clickXY(302, 294, "点击 帐号切换", Driver);
            Thread.sleep(3000);

            //组织架构人员选择
            if (AccuntName == "企业管理员正牌") {
                AppBase.clickXY(302, 294, "点击 企业管理员正牌 帐号", Driver);
            } else if (AccuntName == "auto123") {
                AppBase.clickXY(268, 494, "点击 auto123 帐号", Driver);
            } else {
                AppBase.textPrint("帐号 选择 错误,请重新配置");
            }

            //点击 目标账号 -> AccountName
            //零时使用
            //            AppBase.clickXY(302,294,"点击 帐号",Driver);
            //            AppBase.clickXpath("//android.widget.TextView[@text='" + AccountName + "']",Driver);

            Thread.sleep(2000);

            //点击空白处 关闭弹窗页
            AppBase.clickXY(1000, 900, "点击空白处 关闭弹窗页", Driver);
            Thread.sleep(2000);

        } catch(Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }

    public static void reloadAccount(AppiumDriver Driver, String AccountName, String Password) throws InterruptedException {
        /**
         * @param: [Driver, AccountName, Password]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/18 15:09
         *
         * @description : 退出当前帐号,并重新登录一个帐号
         */
        try {
            Thread.sleep(2000);
            //退出 当前帐号
            LoginApp.logOutAccount(Driver);

            //登录帐号
            LoginApp.loginAccount(Driver, AccountName, Password);

            Thread.sleep(waitTime);

        } catch(Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }

    public static void switchCompany(AppiumDriver Driver) throws InterruptedException {

        try {

            //点击左上 头像图标 呼出操作工具栏
            AppBase.clickId("com.android.ayplatform" + type + ":id/user_avatar_layout", Driver);
            Thread.sleep(2000);

            //点击 账号与安全选项 弹窗图层控件信息无法获得 使用坐标点击
            //            AppBase.clickXY(280, 1075, "点击->账号与安全", Driver);
            AppBase.clickXpath(MyInfo_Tag_AccountSecurity_Xpath, Driver);
            Thread.sleep(3000);

        } catch(Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}