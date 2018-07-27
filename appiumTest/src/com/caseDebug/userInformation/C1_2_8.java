package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.sun.jna.platform.win32.ShellAPI;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:47
 *
 * Description:
 */
public class C1_2_8 extends TestInfo {
    @Test(description = "个人资料-清除缓存")
    public static void case1_2_8(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(MyInfo_Tag_CleanMemory_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",Driver);
            Thread.sleep(2000);

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
    
}
