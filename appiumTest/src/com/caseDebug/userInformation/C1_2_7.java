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
 * Time: 9:46
 *
 * Description:
 */
public class C1_2_7 extends TestInfo {
    @Test(description = "个人资料-我的二维码")
    public static void case1_2_7(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            //点击 侧滑页 二维码 按钮
            AppBase.clickId(PreData_qrcode_Id,Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

//            AppBase.clickXY(765,260,"点击 编辑 按钮",Driver);
            AppBase.clickId(PreData_EditIcon_Id,Driver);
            Thread.sleep(2000);

            //点击 名片
            AppBase.clickId(PreData_UseCard_Id,Driver);
            Thread.sleep(2000);

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
