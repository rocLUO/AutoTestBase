package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.ChangeAccount;
import com.method.LoginApp;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:49
 *
 * Description:
 */
public class C1_2_10 extends TestInfo{
    @Test(description = "个人资料-账号退出")
    public static void case1_2_10(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            ChangeAccount.reloadAccount(Driver, "luopeng1", "luopeng123");
            Thread.sleep(4000);

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
