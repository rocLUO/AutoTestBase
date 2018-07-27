package com.caseDebug.workProtal.workProtalMessageAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/6
 * Time: 16:57
 *
 * Description:
 */
public class C3_6_2 extends TestInfo {
    @Test (description = "消息组件-消息滑动")
    public void case3_6_2(AppiumDriver Driver) throws InterruptedException {
        try{

            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_Protal_Xpath,Driver);
            Thread.sleep(3000);

            AppBase.swipXY(967,928,139,928,Driver);
            Thread.sleep(2000);

            AppBase.swipXY(139,928,967,928,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
