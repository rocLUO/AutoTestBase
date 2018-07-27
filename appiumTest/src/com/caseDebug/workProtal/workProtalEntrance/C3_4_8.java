/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/3
 * Time: 18:56
 *
 * Description:
 */
package com.caseDebug.workProtal.workProtalEntrance;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import com.method.CreateWork;
import com.method.OpenWork;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

public class C3_4_8 extends TestInfo {

    @Test(description = "我的发起-(草稿)删除")
    public static void case3_4_8(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            //创建草稿
            CreateWork.createDraftWorkByEntrance(Driver,"word1","word2","autoTest","autoAccunt01");
            Thread.sleep(2000);

            //入口打开 保存草稿
            OpenWork.entranceWork(Driver, "我发起的", 1);
            Thread.sleep(3000);

            AppBase.clickId(WorkFlow_More_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(WorkFlow_Delete_Xpath,Driver);
            Thread.sleep(2000);

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