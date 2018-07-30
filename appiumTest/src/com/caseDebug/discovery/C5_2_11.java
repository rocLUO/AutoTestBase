package com.caseDebug.discovery;

import com.method.AccountSetting;
import org.testng.annotations.Test;
import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AboutContent;
import com.method.ChangeAccount;

import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:29
 *
 * Description:工作圈 评论恢复 : 帐号1 发送朋友圈 -> 登录帐号2 评论该 朋友圈 ->切换回 帐号1 恢复朋友圈 评论
 */
public class C5_2_11 extends TestInfo{
    @Test(description = "工作圈-评论回复")
    public static void case5_2_11(AppiumDriver Driver) throws InterruptedException {

        try {

            //登录 帐号1
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng123");
            Thread.sleep(waitTime);

            //发送 一条工作圈
            AboutContent.sendWordContent(Driver,"text");
            Thread.sleep(2000);

            AppBase.back(Driver);

            //切换账户 至 帐号2
            ChangeAccount.reloadAccount(Driver,"luopeng2","luopeng123");
            Thread.sleep(2000);

            //评论 朋友圈
            AboutContent.sendComment(Driver);

            AppBase.back(Driver);
            Thread.sleep(2000);

            //登录 帐号1
            ChangeAccount.reloadAccount(Driver,"luopeng1","luopeng123");
            Thread.sleep(waitTime);

            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,Driver);
            Thread.sleep(3000);

            //点击工作圈
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",Driver);
            Thread.sleep(2000);

            //点击 单独打开第一条 工作圈
            AppBase.clickXpath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout",Driver);

            //点击回复第一条 工作圈 评论内容
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_postdetail_comment_iv",Driver);
//            AppBase.clickId("com.android.ayplatform"+ type +":id/post_comment_iv",Driver);
//            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]",Driver);
            Thread.sleep(2000);

            //输入内容
            AppBase.inPutById("com.android.ayplatform"+ type +":id/input_box_view_input_sms","testaaa",Driver);
            Thread.sleep(2000);

            //点击发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/input_box_view_send_sms",Driver);
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
