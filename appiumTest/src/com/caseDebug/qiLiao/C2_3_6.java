package com.caseDebug.qiLiao;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.qiLiao
 * author: luopeng
 * Date: 2018/7/24
 * Time: 15:36
 *
 * Description:
 */
public class C2_3_6 extends TestInfo {
    @Test(description = "通信录-我的群组-部门群聊-@人员")
    public static void case2_3_6(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(QiLiao_MailList_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='我的群组']",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("//android.widget.TextView[@text='autotest']",Driver);
            Thread.sleep(2000);

            AppBase.inPutById(QiLiao_TextInput_Id,"@",Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_AtSearch_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_AtSearchInPut_Id,Driver);
            Thread.sleep(2000);

            AppBase.inPutById(QiLiao_AtSearchInPut_Id,"autoAccunt01",Driver);
            Thread.sleep(2000);

            //点击输入法 搜索按钮
            ((AndroidDeviceActionShortcuts) Driver).pressKeyCode(AndroidKeyCode.ENTER);
            //AppBase.clickXY(989,1932,"点击搜索按钮",Driver);

            Thread.sleep(2000);
            AppBase.clickId(QiLiao_AtSeach_result_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_SendText_Id,Driver);
            Thread.sleep(2000);


        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

}