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
 * Time: 14:33
 *
 * Description:
 */
public class C3_8_2 extends TestInfo {
    @Test(description = "经办工作-历史记录")
    public static void case3_8_2(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);
            // 默认测试门户 快捷入口在下方
            OpenWork.entranceWork(Driver, "经办工作", 1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id, Driver);
            Thread.sleep(2000);

            //点击 历史记录
            AppBase.clickXpath(WorkFlow_History_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
