package com.caseDebug.qiLiao;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.SelectAction;
import com.method.WorkEdit;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug.qiLiao
 * author: luopeng
 * Date: 2018/7/24
 * Time: 15:27
 *
 * Description:
 */
public class C2_3_5 extends TestInfo {
    @Test(description = "通讯录-组织架构-搜索")
    public static void case2_3_5(AppiumDriver Driver) throws InterruptedException {
        try {
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_QiLiao_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(QiLiao_MailList_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(QiLiao_CompanyList_Xpath,Driver);
            Thread.sleep(3000);

            SelectAction.searchMen(Driver,"autoAccunt01");
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