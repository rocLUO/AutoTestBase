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
 * Time: 19:59
 *
 * Description:
 */
public class C3_9_3 extends TestInfo {
    @Test(description = "过往工作-抄送")
    public static void case3_9_3(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            OpenWork.entranceWork(Driver,"过往工作",1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Copy_Xpath,Driver);
            Thread.sleep(2000);

            WorkEdit.workWindowTextInput(Driver,"texttext");
            Thread.sleep(2000);

            AppBase.clickXpath(Button_Confrim_Xpath,Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}