package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/2
 * Time: 15:04
 *
 * Description: app登录页 登录账号
 *              username 账号
 *              password 密码
 */
public class LoginApp extends TestInfo {

    public static void loginAccount(AppiumDriver Driver, String username, String password) throws InterruptedException {
        /**
         * @param: [Driver, username, password]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/9 17:24
         *
         * @description : 登录页 -> 输入帐号 -> 输入密码 -> 点击登录
         */
        try {
            Thread.sleep(2000);

            AppBase.clearId("com.android.ayplatform"+ type +":id/cardNumAuto",Driver);
            Thread.sleep(2000);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/cardNumAuto",username,Driver);
            Thread.sleep(2000);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/Pass",password,Driver);
            Thread.sleep(2000);
            
            AppBase.clickXY(986, 1249, "收起 键盘", Driver);

            AppBase.clearId("com.android.ayplatform"+ type +":id/login",Driver);
            Thread.sleep(waitTime);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }

    public static void logOutAccount(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/16 10:43
         *
         * @description : 退出当前登录帐号
         */
        try {
            AppBase.clickId("com.android.ayplatform" + type + ":id/user_avatar_layout", Driver);
            Thread.sleep(2000);

            AppBase.clickId(MyInfo_Logout_Id,Driver);
            Thread.sleep(3000);

            AppBase.clickXpath(Button_Confrim_Xpath,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
