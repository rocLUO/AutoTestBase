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
 * Time: 9:45
 *
 * Description:
 */
public class C1_2_6 extends TestInfo{
    @Test(description = "个人资料-我的钱包(admin)")
    public static void case1_2_6(AppiumDriver Driver) throws InterruptedException {
        Thread.sleep(waitTime);

        try {

//            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng1");

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            AppBase.clickXpath(MyInfo_Tag_Pocket_Xpath,Driver);
            Thread.sleep(waitTime);
/*
            //点击充值
            AppBase.clickId("com.android.ayplatform"+ type +":id/tv_recharge",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //点击体现
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_getDeposit",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);
*/
            //1-------------------------------------
            //点击 我的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_my_rp",Driver);
            Thread.sleep(3000);

            //点击 发出的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_out",Driver);
            Thread.sleep(2000);

            //点击 收到的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_in",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //2-------------------------------------
            //点击 账户信息
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_accountInfo",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //3-------------------------------------
            //点击 交易记录
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_tradeDetail",Driver);
            Thread.sleep(3000);

            //点击 收入
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_in",Driver);
            Thread.sleep(2000);

            //点击 支出
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_out",Driver);
            Thread.sleep(2000);

            //点击 全部
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_all",Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //4-------------------------------------
            //点击 安全设置
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_secureSetting",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //5-------------------------------------
            //点击 银行卡设置
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_mybank",Driver);
            Thread.sleep(3000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.back(Driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",Driver);
            Thread.sleep(2000);

//            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng1");

        } catch (NoSuchSessionException e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }
}
