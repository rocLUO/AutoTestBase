package com.caseDebug.workProtal.workProtalMessageAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/6
 * Time: 16:12
 *
 * Description:
 */
public class C3_6_1 extends TestInfo {
    @Test (description = "消息组件-消息打开")
    public void case3_6_1(AppiumDriver Driver) throws InterruptedException {

        try {

            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_Protal_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("com.android.ayplatform"+ type +":id/item_title_tv",Driver);
            Thread.sleep(2000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
