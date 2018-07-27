package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.SelectAction;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/6
 * Time: 11:06
 *
 * Description:
 */
public class C3_2_2 extends TestInfo {
    @Test(description = "待办工作-抄送/快捷入口进入")
    public static void case3_2_2(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            OpenWork.entranceWork(Driver, "待办工作", 1);
            // 点击 more
            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Copy_Xpath, Driver);
            Thread.sleep(2000);

            SelectAction.searchMen(Driver, "autoAccunt01");
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(1000);

            AppBase.back(Driver);
            Thread.sleep(1000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
