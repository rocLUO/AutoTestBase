package com.caseDebug.WorkPageEdit;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.FileAction;
import com.method.OpenAppList;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.WorkPageEdit
 * author: luopeng
 * Date: 2018/7/23
 * Time: 16:17
 *
 * Description:
 */
public class C7_1_1 extends TestInfo {
    @Test(description = "附件上传-文件-图片")
    public static void case7_1_1(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);
        try {

            OpenAppList.viewWrokListByProtal(Driver, 4);
            Thread.sleep(2000);

            FileAction.WorkFlowSendFile(Driver, 0, ".1 test send file", 2);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Send_Id, Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}