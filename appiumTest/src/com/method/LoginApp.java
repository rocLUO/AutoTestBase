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

        try {
            Thread.sleep(2000);

            AppBase.clearId("com.android.ayplatform"+ type +":id/cardNumAuto",Driver);
            Thread.sleep(2000);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/cardNumAuto",username,Driver);
            Thread.sleep(20000);

            AppBase.inPutById("com.android.ayplatform"+ type +":id/Pass",password,Driver);
            Thread.sleep(2000);
            
            AppBase.clickXY(986, 1249, "收起 键盘", Driver);

            AppBase.clearId("com.android.ayplatform"+ type +":id/login",Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
