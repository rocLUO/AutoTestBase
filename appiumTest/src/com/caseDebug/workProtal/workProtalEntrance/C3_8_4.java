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
 * Date: 2018/7/10
 * Time: 17:34
 *
 * Description:
 */
public class C3_8_4 extends TestInfo {
    @Test(description = "经办工作-抄送")
    public static void case3_8_4(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            OpenWork.entranceWork(Driver,"经办工作",1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Copy_Xpath,Driver);
            Thread.sleep(2000);

            //组织架构人员选择
            SelectAction.choosesMen(Driver,"autoTest","autoAccunt01",2);

            AppBase.back(Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
