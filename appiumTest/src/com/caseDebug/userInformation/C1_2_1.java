package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AccountSetting;
import com.method.ChangeAccount;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:38
 *
 * Description:
 */
public class C1_2_1 extends TestInfo{
    @Test(description = "个人资料-头像设置(admin)")
    public static void case1_2_1(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);
            AccountSetting.openUserInfo(Driver,"luopeng1","luopeng123");
            /*
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng1");

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            AppBase.clickXY(765,260,"点击 编辑 按钮",Driver);

            Thread.sleep(2000);
            */
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_ayprivate_accountinfo_avatar_linear",Driver);
            Thread.sleep(2000);

            //相册选取
            AppBase.clickId("com.android.ayplatform"+ type +":id/album_selection",Driver);
            Thread.sleep(2000);

            //选择相册
            AppBase.clickXY(485,332,"点击相册",Driver);
            Thread.sleep(2000);

            //选择图片
            AppBase.clickXY(225,393,"选择图片",Driver);
            Thread.sleep(2000);

            AppBase.clickXY(1005,72,"点击确定图片",Driver);
            Thread.sleep(2000);

            //确认编辑
            AppBase.clickId("com.android.ayplatform"+ type +":id/doing",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",Driver);
            Thread.sleep(2000);

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
