package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:52
 *
 * Description:
 */
public class C1_3_1_6 extends TestInfo {
    @Test(description = "消息中心-工作交办/提到我的/工作动态/组织架构变动/系统消息/系统消息/我评论的")
    public static void case1_3_1_6(AppiumDriver Driver) throws InterruptedException {

        try {
            Thread.sleep(waitTime);

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(3000);

            AppBase.clickXpath(MyInfo_Tag_Message_Xpath,Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='工作交办']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='提到我的']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='工作动态']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='组织架构变动']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='系统消息']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.TextView[@text='我评论的']",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",Driver);
            Thread.sleep(2000);

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
