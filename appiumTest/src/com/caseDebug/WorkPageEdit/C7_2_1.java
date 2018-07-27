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
 * Time: 16:37
 *
 * Description:
 */
public class C7_2_1 extends TestInfo {
    @Test(description = "附件上传-相册-图片选择")
    public static void XXXX(AppiumDriver Driver) throws InterruptedException {
        try {
            OpenAppList.viewWrokListByProtal(Driver,4);
            Thread.sleep(2000);

            FileAction.WorkFlowSendPhoto(Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Send_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}