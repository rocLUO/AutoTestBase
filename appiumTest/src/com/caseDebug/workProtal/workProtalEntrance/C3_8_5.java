package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/10
 * Time: 18:19
 *
 * Description:
 */
public class C3_8_5 extends TestInfo {
    @Test(description = "经办工作-催办")
    public static void case3_8_5(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            OpenWork.entranceWork(Driver,"经办工作",1);
            Thread.sleep(2000);

            AppBase.clearId(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Urge_Xpath,Driver);
            Thread.sleep(2000);

            WorkEdit.workWindowTextInput(Driver,"testtest");
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
