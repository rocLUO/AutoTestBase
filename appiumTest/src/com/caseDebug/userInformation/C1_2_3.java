package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:53
 *
 * Description:
 */
public class C1_2_3 extends TestInfo {
    @Test(description = "个人资料-个人资料显示(admin)")
    public static void case1_2_3(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try{
            Thread.sleep(waitTime);

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
