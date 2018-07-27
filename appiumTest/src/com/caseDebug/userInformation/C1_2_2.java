package com.caseDebug.userInformation;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AccountSetting;
import com.method.ChangeAccount;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.annotations.Test;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 9:40
 *
 * Description:
 */
public class C1_2_2 extends TestInfo{
    @Test(description = "个人资料-个性签名(admin)")
    public static void case1_2_2(AppiumDriver Driver) throws InterruptedException {
        try {

            Thread.sleep(waitTime);
            AccountSetting.openUserInfo(Driver,"luopeng1","luopeng123");
            /*
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng1");

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            //点击 侧滑页 编辑 按钮
            //AppBase.clickXY(765,260,"点击 编辑 按钮",Driver);
            AppBase.clickId(PreData_EditIcon_Id,Driver);
            Thread.sleep(2000);

            */

            //点击 签名 框
            AppBase.clickId(PreData_QianMing_Id,Driver);
            Thread.sleep(2000);

            //输入
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_ayprivate_modifysign_et","testtest",Driver);
            Thread.sleep(2000);

            //点击确定
            AppBase.clickId("com.android.ayplatform"+ type +":id/confirm_tv",Driver);
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
