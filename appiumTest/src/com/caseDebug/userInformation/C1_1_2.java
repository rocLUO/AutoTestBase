package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

import java.sql.Driver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 19:34
 *
 * Description:
 */
public class C1_1_2 extends TestInfo {
    @Test(description = "企业切换")
    public static void case1_1_2(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);

            //点击左上 头像图标 呼出操作工具栏
            AppBase.clickId("com.android.ayplatform" + type + ":id/user_avatar_layout", Driver);
            Thread.sleep(2000);

            //点击 账号与安全选项 弹窗图层控件信息无法获得 使用坐标点击
            //            AppBase.clickXY(280, 1075, "点击->账号与安全", Driver);
            AppBase.clickXpath(MyInfo_Tag_AccountSecurity_Xpath, Driver);
            Thread.sleep(3000);
        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
