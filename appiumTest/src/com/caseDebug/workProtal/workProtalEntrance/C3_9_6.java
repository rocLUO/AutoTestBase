package com.caseDebug.workProtal.workProtalEntrance;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.workProtal.workProtalEntrance
 * author: luopeng
 * Date: 2018/7/11
 * Time: 15:42
 *
 * Description:
 */
public class C3_9_6 extends TestInfo {
    @Test(description = "过往工作-评论")
    public static void case3_9_6(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {

            OpenWork.entranceWork(Driver,"过往工作",1);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Comment_Id,Driver);
            Thread.sleep(2000);

            AppBase.inPutById(Comment_InputText_Id,"text111",Driver);
            Thread.sleep(2000);

            AppBase.clickId(Comment_Send_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}
