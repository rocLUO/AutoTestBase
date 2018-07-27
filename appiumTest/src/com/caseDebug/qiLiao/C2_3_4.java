package com.caseDebug.qiLiao;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.qiLiao
 * author: luopeng
 * Date: 2018/7/24
 * Time: 15:07
 *
 * Description:
 */
public class C2_3_4 extends TestInfo {
    @Test(description = "通讯录-搜索")
    public static void case2_3_4(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_MailList_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_MailSearch_Xpath, Driver);
            Thread.sleep(2000);

            AppBase.inPutById(SearchList_SearchInput_Id, "autoAccunt", Driver);
            Thread.sleep(2000);

            //点击第一个搜索结果
            AppBase.clickXpath("//android.widget.TextView[@text='autoAccunt01']", Driver);
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