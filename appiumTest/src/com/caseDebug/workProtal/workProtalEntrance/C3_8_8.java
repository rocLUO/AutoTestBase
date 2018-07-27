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
 * Time: 18:44
 *
 * Description:
 */
public class C3_8_8 extends TestInfo {
    @Test(description = "经办工作-评论")
    public static void case3_8_8(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {
            //打开工作
            OpenWork.entranceWork(Driver,"经办工作",1);
            Thread.sleep(2000);

            //打开评论页
            AppBase.clickId(WorkFlow_Comment_Id,Driver);
            Thread.sleep(2000);

            //输入字符
            AppBase.inPutById(Comment_InputText_Id,"text",Driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId(Comment_Send_Id,Driver);
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