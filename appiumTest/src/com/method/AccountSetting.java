package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/16
 * Time: 15:19
 *
 * Description:
 */
public class AccountSetting extends TestInfo {
    public static void openUserInfo(AppiumDriver Driver,String loginName, String loginPass) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            //使用 luopeng1 帐号登录
            ChangeAccount.reloadAccount(Driver,loginName,loginPass);

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            //点击 icon
            AppBase.clickId(PreData_EditIcon_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}