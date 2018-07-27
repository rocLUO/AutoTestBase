package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/10
 * Time: 15:25
 *
 * Description:
 */
public class C3_8_3 extends TestInfo {
    @Test(description = "经办工作-取回")
    public static void case3_8_3(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            OpenWork.entranceWork(Driver, "经办工作",1);
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_More_Id,Driver);
            Thread.sleep(3000);

            //点击 取回
            AppBase.clickXpath(WorkFlow_Return_Xpath,Driver);
            Thread.sleep(3000);

            //点击确定
            AppBase.clickXpath(Button_Confrim_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
