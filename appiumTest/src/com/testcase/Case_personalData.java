/*
 * appiumTest - com.testcase
 * author: luopeng
 * Date: 2018/6/29
 * Time: 14:35
 *
 * Description: 用例 个人资料 基础内容
 *
 *
 *
 *
 */
package com.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.net.URL;

import com.method.ChangeAccount;
import com.method.LoginApp;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Case_personalData extends TestInfo {

    private static AppiumDriver driver;

    @BeforeClass
    public void setup() throws Exception {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.BROWSER_NAME, "");
        cap.setCapability("platformName", Platform);
        cap.setCapability("deviceName", PhoneCode);
        cap.setCapability("platformVersion", Version);
        // 将上面获取到的包名和Activity名设置为值
        cap.setCapability("appPackage", ApkPackage);
        cap.setCapability("appActivity", ApkActivity);
        // A new session could not be created
        // cap.setCapability("appWaitActivity","com.android.ayplatform.activity.WelcomeActivity");
        // 每次启动时覆盖session，否则第二次后运行会报错不能新建session
        cap.setCapability("sessionOverride", true);
        // 解决每次启动APP需要确认权限问题--即不重复安装
        cap.setCapability("noReset", true);
        cap.setCapability("noSign", true);
        /*
         * 中文输入,隐藏键盘启动 capabilities.setCapability("unicodeKeyboard", "True");
         * capabilities.setCapability("resetKeyboard", "True");
         */
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    @Test(description = "个人资料-账号切换(test account star)")
    public void case1_1_1() throws InterruptedException {

        try {
            ChangeAccount.switchAccount(driver,"企业管理员正牌",0);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-企业切换")
    public void case1_1_2() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
            AppBase.clickXY(309,1080,"点击->账号安全",driver);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-头像设置(admin)")
    public void case1_2_1() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(765,260,"点击 编辑 按钮",driver);
            Thread.sleep(2000);

            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_ayprivate_accountinfo_avatar_linear",driver);
            Thread.sleep(2000);

            //相册选取
            AppBase.clickId("com.android.ayplatform"+ type +":id/album_selection",driver);
            Thread.sleep(2000);

            //选择相册
            AppBase.clickXY(485,332,"点击相册",driver);
            Thread.sleep(2000);

            //选择图片
            AppBase.clickXY(225,393,"选择图片",driver);
            Thread.sleep(2000);

            AppBase.clickXY(1005,72,"点击确定图片",driver);
            Thread.sleep(2000);

            //确认编辑
            AppBase.clickId("com.android.ayplatform"+ type +":id/doing",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-个性签名(admin)")
    public void case1_2_2() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(765,260,"点击 编辑 按钮",driver);
            Thread.sleep(2000);

            //点击 签名 框
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_ayprivate_accountinfo_qianming_linear",driver);
            Thread.sleep(2000);

            //输入
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_ayprivate_modifysign_et","testtest",driver);
            Thread.sleep(2000);

            //点击确定
            AppBase.clickId("com.android.ayplatform"+ type +":id/confirm_tv",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "个人资料-个人资料显示(admin)")
    public void case1_2_3() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-我的动态(admin)")
    public void case1_2_4() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(244,894,"点击最新动态",driver);
            Thread.sleep(2000);

            AppBase.clickId("\tcom.android.ayplatform"+ type +":id/back",driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "个人资料-版本信息")
    public void case1_2_5() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(296,1739,"点击 关于启业云",driver);
            Thread.sleep(2000);

            //点击简介
            AppBase.clickId("com.android.ayplatform"+ type +":id/aboutqycloud_introduce_layout",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "个人资料-我的钱包(admin)")
    public void case1_2_6() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(228,1244," 点击 我的钱包",driver);
            Thread.sleep(2000);

            //点击充值
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_wallet_recharge",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //点击体现
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_getDeposit",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //1-------------------------------------
            //点击 我的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_my_rp",driver);
            Thread.sleep(2000);

            //点击 发出的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_out",driver);
            Thread.sleep(2000);

            //点击 收到的红包
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_in",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //2-------------------------------------
            //点击 账户信息
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_accountInfo",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //3-------------------------------------
            //点击 交易记录
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_tradeDetail",driver);
            Thread.sleep(2000);

            //点击 收入
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_in",driver);
            Thread.sleep(2000);

            //点击 支出
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_out",driver);
            Thread.sleep(2000);

            //点击 全部
            AppBase.clickId("com.android.ayplatform"+ type +":id/ll_all",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //4-------------------------------------
            //点击 安全设置
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_secureSetting",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            //5-------------------------------------
            //点击 银行卡设置
            AppBase.clickId("com.android.ayplatform"+ type +":id/rl_mybank",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-我的二维码")
    public void case1_2_7() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(804,135,"点击 我的二维码",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(765,260,"点击 编辑 按钮",driver);
            Thread.sleep(2000);

            AppBase.clickId("com.android.ayplatform.release:id/activity_ayprivate_accountinfo_qrcode",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-清除缓存")
    public void case1_2_8() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(212,1408,"点击清除缓存",driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-来电提示")
    public void case1_2_9() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(800,1575,"开启 来电提示",driver);
            Thread.sleep(2000);

            AppBase.clickXY(759,1575,"关闭 来电提示",driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
        e.printStackTrace();
        AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "个人资料-账号退出")
    public void case1_2_10() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(456,1906,"点击 退出当前账号",driver);
            Thread.sleep(2000);

            AppBase.clickXY(784,1128," 点击 确定",driver);
            Thread.sleep(2000);

            LoginApp.loginAccount(driver,"admin_pretest","11111111");
            Thread.sleep(4000);
            
            

        } catch (Error e) {
        e.printStackTrace();
        AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "消息中心-工作交办/提到我的/工作动态/组织架构变动/系统消息/系统消息/我评论的")
    public void case1_3_1_6() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
            //点击 头像
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",driver);
            Thread.sleep(2000);

            AppBase.clickXY(262,739,"点击 消息中心",driver);
            Thread.sleep(2000);

            AppBase.clickId("//android.widget.TextView[@text='工作交办']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickId("//android.widget.TextView[@text='提到我的']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickId("//android.widget.TextView[@text='工作动态']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickId("//android.widget.TextView[@text='组织架构变动']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickId("//android.widget.TextView[@text='系统消息']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clearId("//android.widget.TextView[@text='我评论的']",driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.back(driver);
            Thread.sleep(2000);

            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",driver);
            Thread.sleep(2000);

        } catch (Error e) {
        e.printStackTrace();
        AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "消息中心-消息编辑")
    public void case1_3_7() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

        } catch (Error e) {
        e.printStackTrace();
        AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}