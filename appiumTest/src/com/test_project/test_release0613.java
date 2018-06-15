/**
 * com.luopeng
 * appiumTest
 * test0502.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月2日 上午9:32:12
 *
 * Created by LuoPeng
 */
package com.test_project;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.SelectAction;
import com.method.openAppList;
public class test_release0613 extends TestInfo {
    private static AppiumDriver driver;
    static int launchtime = 6000;
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
    @Test(description = "通讯录-成员信息发送")
        public void case2_1_6() throws InterruptedException {
        try {
            Thread.sleep(launchtime);
            // 启聊
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            // 通讯录
            Thread.sleep(2000);
            AppBase.ClickXpath(QiLiao_MailList_Xpath, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我的群组']", driver);
            // 测试企业--群组
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='autotest']", driver);
            // //输入框焦点
            // Thread.sleep(1000);
            // ClickId("com.android.ayplatform.pre:id/rc_edit_text");
            //
            // //输入框格式化
            // Thread.sleep(1000);
            // clearId("com.android.ayplatform.pre:id/rc_edit_text");
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(2000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/rc_edit_text", "testestest", driver);
            // 发送
            Thread.sleep(1000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_send_toggle", driver);
            // driver.swipe(, starty, endx, endy, duration);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "通讯录-成员通话跳转")
        public void case2_1_7() throws InterruptedException {
        driver.launchApp();
        try {
            // 上接case2.1.6
            Thread.sleep(launchtime);
            // 启聊
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath(QiLiao_MailList_Xpath, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='alex']", driver);
            // 商务通话
            Thread.sleep(2000);
            // ClickId("com.android.ayplatform"+type+":id/item_chat_colleaguedetail_content_call");
            AppBase.ClickXY(286, 1935, "点击通话", driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            Thread.sleep(1000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    // 确保 最近处理已有工作-不少于3个
    @Test(description = "最近处理-抄送")
        public void case3_3_2() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // 上接case2.1.6
            Thread.sleep(2000);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            // 从门户快捷组件打开列表
            openAppList.viewWrokListByProtal(driver);
            // 切换列表至 最近处理
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 点击more
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='抄送']", driver);
            // 选择人员
            SelectAction.choosesMen(driver, "//android.widget.TextView[@text='autoTest']",
                                "//android.widget.TextView[@text='autoAccunt01']");
            Thread.sleep(2000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            // driver.swipe(, starty, endx, endy, duration);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "最近处理-催办")
        public void case3_3_5() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            // 从门户快捷组件打开列表
            openAppList.viewWrokListByProtal(driver);
            // 切换列表至 最近处理
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 更多
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(1000);
            AppBase.ClickXpath("//android.widget.TextView[@text='催办']", driver);
            Thread.sleep(2000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(1000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/et_msg", "testestest", driver);
            Thread.sleep(1000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(1000);
            driver.closeApp();
            Thread.sleep(2000);
        }
        catch (Error e) {
            // TODO Auto-generated catch block
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "最近处理-历史记录")
        public void case3_3_6() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            // 从门户快捷组件打开列表
            openAppList.viewWrokListByProtal(driver);
            // 切换列表至 最近处理
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 更多
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(3000);
            AppBase.ClickXpath("//android.widget.TextView[@text='历史记录']", driver);
            Thread.sleep(2000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            driver.closeApp();
            Thread.sleep(2000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "最近处理-批注")
        public void case3_3_7() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            openAppList.viewWrokListByProtal(driver);
            // 切换列表至 最近处理
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 批注
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/comment", driver);
            Thread.sleep(2000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(1000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/input_box_view_input_sms", "testest", driver);
            Thread.sleep(1000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/input_box_view_send_sms", driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            driver.closeApp();
            Thread.sleep(2000);
        }
        catch (Error e) {
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "最近处理-取回")
        public void case3_3_3() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 更多
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(3000);
            // ClickXpath("//android.widget.TextVie[@text='取回']");
            AppBase.ClickXY(855, 431, "点击取回", driver);
            Thread.sleep(1000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "最近处理-中断")
        public void case3_3_4() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='最近处理']", driver);
            // 默认点击第一个工作
            Thread.sleep(2000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1_content",
            // driver);
            AppBase.ClickXpath(
                                "//android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            // 更多
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(3000);
            // ClickXpath("//android.widget.TextVie[@text='中断']");
            AppBase.ClickXY(819, 783, "点击中断", driver);
            Thread.sleep(1000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(1000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/et_msg", "testest", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(1000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
    }
    @Test(description = "我的发起-处理")
        public void case3_4_1() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            // 造草稿
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            Thread.sleep(2000);
            // 默认测试门户 快捷入口在下方
            openAppList.viewWrokListByProtal(driver);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            Thread.sleep(2000);
            // 点击 快捷入口 默认第一个入口
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            // 新建工作 内容编辑,人员提交
            SelectAction.newWorkTextInPut(driver, "Word1", "Word2", "//android.widget.TextView[@text='autoTest']",
                                "////android.widget.TextView[@text='autoAccunt01']");
            // 点击保存按钮
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_save_Button", driver);
            Thread.sleep(1000);
            driver.closeApp();
            Thread.sleep(2000);
            driver.launchApp();
            // 打开应用列表
            Thread.sleep(3000);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            Thread.sleep(2000);
            // 选择第一个草稿
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            // 点击发送
            AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "我的发起-抄送")
        public void case3_4_2() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver); // 我发起的
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            Thread.sleep(2000);
            // 默认测试门户 快捷入口在下方
            openAppList.viewWrokListByProtal(driver);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            Thread.sleep(3000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver); // 打开流程
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            // 点击更多
            Thread.sleep(3000);
            AppBase.ClickXpath("//android.widget.TextView[@text='抄送']", driver);
            // 点击抄送
            // // 防止组织架构无法自动加载
            // Thread.sleep(1000);
            // AppBase.swipXY(517, 376, 517, 1761, driver);
            //
            // Thread.sleep(2000);
            // AppBase.ClickXpath("//android.widget.TextView[@text='九五之尊']",
            // driver);
            //
            // // 选择 111
            // Thread.sleep(2000);
            // AppBase.ClickXpath("//android.widget.TextView[@text='111']",
            // driver);
            // 选择人员
            SelectAction.choosesMen(driver, "//android.widget.TextView[@text='autoTest']",
                                "//android.widget.TextView[@text='autoAccunt01']");
            // 确定
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", driver);
            Thread.sleep(1000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "我的发起-委托")
        public void case3_4_3() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            Thread.sleep(2000);
            // 默认测试门户 快捷入口在下方
            openAppList.viewWrokListByProtal(driver);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver); // 我发起的
            // AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow",
            // driver);
            Thread.sleep(3000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver); // 打开流程
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            // 点击三个点
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='委托']", driver);
            // 点击委托
            // // 防止组织架构无法自动加载
            // Thread.sleep(1000);
            // AppBase.swipXY(517, 376, 517, 1761, driver);
            //
            // Thread.sleep(2000);
            // AppBase.ClickXpath("//android.widget.TextView[@text='九五之尊']",
            // driver);
            //
            // // 选择 autotest 接受账号
            // Thread.sleep(2000);
            // AppBase.ClickXpath("//android.widget.TextView[@text='111']",
            // driver);
            // 选择人员
            SelectAction.choosesMen(driver, "//android.widget.TextView[@text='autoTest']",
                                "//android.widget.TextView[@text='autoAccunt01']");
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/org_search_display_submit", driver);
            // 点击确定
            // 取消委托
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_item1", driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='取消委托']", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(1000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "我的发起-回退")
        public void case3_4_4() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            Thread.sleep(2000);
            openAppList.viewWrokListByProtal(driver);
            // Thread.sleep(3000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            // 打开第一个 实例
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='回退']", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            AppBase.Back(driver);
            Thread.sleep(1000);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "我的发起-历史记录")
        public void case3_4_5() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            // driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的
            Thread.sleep(3000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver);
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/workbench_module_i_started_item1").click();//打开流程
            Thread.sleep(1000);
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/more").click();//点击三个点
            Thread.sleep(1000);
            AppBase.ClickXpath("//android.widget.TextView[@text='历史记录']", driver);
            // driver.findElementByXPath("//android.view.ViewGroup[3]").click();//点击历史记录
            Thread.sleep(2000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "我的发起-中断")
        public void case3_4_6() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver);
            // driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(3000);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/workbench_module_i_started_item1").click();//打开流程
            // 切换至 我发起的 列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/more").click();//点击三个点
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='中断']", driver);
            // driver.findElementByXPath("//android.view.ViewGroup[2]").click();//点击中断
            Thread.sleep(2000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(1000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/et_msg", "testestest", driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/et_msg").sendKeys("zyw");//点击确定
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(1000);
            /*
             * ClickXpath(
             * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
             * ); // driver.findElementByXPath(
             * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
             * ).click();//点击确定
             */
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(1000);
    }
    @Test(description = "我的发起-批注")
        public void case3_4_7() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver); // 我发起的
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            // AppBase.ClickId("com.android.ayplatform"+type+":id/workbench_module_i_started_item1",
            // driver); // 打开流程
            Thread.sleep(3000);
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/comment", driver);
            // 点击评论
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/input_box_view_input_sms", driver);
            // 点击输入框，输入文字
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/input_box_view_send_sms", driver);
            // 点击确定
        }
        catch (Error E) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(1000);
    }
    @Test(description = "我的发起-批注")
        public void case3_4_8() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver);
            // driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我发起的']", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath(
                                "//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",
                                driver);
            Thread.sleep(3000);
            //批注
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/comment", driver);
            Thread.sleep(3000);
            //表情
            AppBase.ClickId("com.android.ayplatform"+type+":id/input_box_view_image_face", driver);
            Thread.sleep(2000);
            AppBase.ClickXY(442, 1532, "点击表情", driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/input_box_view_send_sms", driver);

            // .click();// 点击删除
            Thread.sleep(3000);
            AppBase.Back(driver);
            Thread.sleep(2000);
            AppBase.Back(driver);
        }
        catch (Error e) {
            driver.closeApp();
            Thread.sleep(2000);
        }
    }
    // @Test(description = "标签切换")
    // public static void case3_1_1() throws InterruptedException {
    //
    // driver.launchApp();
    //
    // try {
    //
    // Thread.sleep(launchtime);
    // AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath, driver);
    //
    // Thread.sleep(3000);
    // AppBase.ClickXpath(MainPage_Tag_Already_Xpath, driver);
    //
    // Thread.sleep(3000);
    // AppBase.ClickXpath(MainPage_Tag_HoldOn_Xpath, driver);
    //
    // Thread.sleep(3000);
    //
    // // driver.swipe(, starty, endx, endy, duration);
    // } catch (Error e) {
    // AppBase.screenSnap(driver);
    // }
    //
    // driver.closeApp();
    // Thread.sleep(1000);
    //
    // }
    @Test(description = "代办工作-处理/快捷入口进入")
        public void case3_2_1() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);

            //快捷入口进入工作哦列表
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='待办工作']", driver);
            Thread.sleep(2000);
            //默认打开第一个工作
            AppBase.ClickXpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", driver);
            Thread.sleep(2000);
            //添加接收人
            AppBase.ClickId("com.android.ayplatform"+type+":id/org_add_user_imageView", driver);
            Thread.sleep(2000);
            //部门:autoTest 人员:autoAccunt01
            SelectAction.choosesMen(driver, "autoTest", "autoAccunt01");
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", driver);
            Thread.sleep(2000);
        }
        catch (Error e) {
            Thread.sleep(1000);
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "代办工作-抄送/快捷入口进入")
        public void case2_2_2() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='代办工作']", driver);
            Thread.sleep(2000);
            //默认打开第一个工作
            AppBase.ClickXpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", driver);
            Thread.sleep(2000);
            //点击 more
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='抄送']", driver);
            Thread.sleep(2000);
            //人员选择操作
            SelectAction.choosesMen(driver, "autoTest", "autoAccunt01");
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "代办工作-委托/快捷入口进入")
        public void case3_2_3() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath("//android.widget.TextView[@text='门户']", driver);
            openAppList.viewWrokListByProtal(driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/head_arrow", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='待办工作']", driver);
            Thread.sleep(2000);
            //默认打开第一个工作
            AppBase.ClickXpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", driver);
            Thread.sleep(2000);
            //点击 more
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='委托']", driver);
            Thread.sleep(2000);
            SelectAction.choosesMen(driver, "autoTest", "autoAccunt01");
            Thread.sleep(2000);
            AppBase.excuteAdbShell("io.appium.android.ime/.UnicodeIME", driver);
            AppBase.InPutById("com.android.ayplatform"+type+":id/et_msg", "testest", driver);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            // 取消委托
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/more", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='取消委托']", driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.Button[@text='确定']", driver);
            Thread.sleep(2000);
        }
        catch (Error e) {
        }
        driver.closeApp();
        Thread.sleep(2000);
    }
    @Test(description = "搜索-人员搜索")
        public void case4_1_1_4() throws InterruptedException {
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickId(Protal_Search_Id, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='同事']", driver);
            Thread.sleep(3000);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", driver);
            // 点击搜索框
            AppBase.ClickId("com.android.ayplatform"+type+":id/filter_edit", driver);
            // 搜索同事
            Thread.sleep(3000);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
            Thread.sleep(1000);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
            Thread.sleep(1000);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
            // 点击 筛选
            // ClickId(Search_main_filter_bottom);
            Thread.sleep(3000);
            // 给搜索到的同事
            AppBase.ClickXpath("//android.widget.TextView[@text='111']", driver);
            Thread.sleep(3000);
            // 点击-发送消息(xpath/id不可用)
            AppBase.ClickXY(804, 1936, "点击发送消息", driver);
            Thread.sleep(3000);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", driver);
            // 点击输入框
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_edit_text", driver);
            Thread.sleep(2000);
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(1000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/rc_edit_text", "testtest", driver);
            // 发送
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_send_toggle", driver);
            Thread.sleep(3000);
            AppBase.Back(driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
        // driver.swipe(, starty, endx, endy, duration);
    }
    @Test(description = "搜索-工作")
        public void case4_1_2_5() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            driver.findElementByXPath(MainPage_Search_Id).click();
            // Thread.sleep(3000);
            // driver.findElementById("com.android.ayplatform:id/activity_worksearch_rl").click();
            // 搜索工作
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='工作']", driver);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", driver);
            // 点击搜索框
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/filter_edit", driver);
            Thread.sleep(2000);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            Thread.sleep(2000);
            AppBase.ClickXY(476, 847, "点击第一个工作", driver);
            Thread.sleep(2000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "搜索-应用")
        public void case4_1_3() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickId(MainPage_Search_Id, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='应用']", driver);
            // 切换输入法
            AppBase.excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME", driver);
            // 点击搜索框
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/filter_edit", driver);
            Thread.sleep(2000);
            // 搜索应用
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_A);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_U);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_T);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_O);
            Thread.sleep(500);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            ((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
            // 点击第二个
            Thread.sleep(3000);
            AppBase.ClickXY(537, 1090, "点击工作", driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            // 点击新建工作
            Thread.sleep(500);
            AppBase.Back(driver);
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "搜索-历史搜索")
        public void case4_1_6() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickId(MainPage_Search_Id, driver);
            Thread.sleep(3000);
            // 紧跟case4_1_3,利用已有历史标签
            AppBase.ClickXpath("//android.widget.TextView[@text='auto']", driver);
            // 点击应用
            Thread.sleep(3000);
            AppBase.ClickXY(537, 1090, "点击工作", driver);
            Thread.sleep(2000);
            AppBase.Back(driver);
            Thread.sleep(1000);
            AppBase.Back(driver);
            // // 点击评论按钮
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(3000);
        driver.closeApp();
    }
    @Test(description = "启聊导航栏切换与会话/通讯录切换")
        public void case2_1_1() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            // driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
            Thread.sleep(2000);
            AppBase.ClickXpath(QiLiao_MailList_Xpath, driver);
            // driver.findElementByXPath("//android.widget.TextView[@text='通讯录']").click();
            Thread.sleep(2000);
            AppBase.ClickXpath(QiLiao_Chat_Xpath, driver);
            // driver.findElementByXPath("//android.widget.TextView[@text='会话']").click();
            Thread.sleep(2000);
            AppBase.ClickId(QiLiao_CreatGroup_Id, driver);
            // driver.findElementById("com.android.ayplatform:id/create_group").click();
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "群聊天-创建")
        public void case2_1_23() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            // driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
            Thread.sleep(2000);
            AppBase.ClickId(QiLiao_CreatGroup_Id, driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/create_group").click();
            Thread.sleep(2000);
            // 点击人员-1
            AppBase.ClickXY(543, 386, "选择人员-1", driver);
            // 点击张宗超
            // (new TouchAction(driver)).tap(399, 301).perform();
            Thread.sleep(2000);
            // 点击人员-2
            AppBase.ClickXY(468, 594, "选择人员-2", driver);
            // 点击杜磊
            // (new TouchAction(driver)).tap(343, 513).perform();
            // 点击完成---此为动态控件 xpath无法定位
            Thread.sleep(2000);
            // ClickId("com.android.ayplatform"+type+":id/head_right");
            AppBase.ClickXY(992, 128, "点击完成", driver);
            // ClickXpath("//android.widget.TextView[@text='完成(2)']");
            // (new TouchAction(driver)).tap(650, 89).perform();
            // 选定
            // ((AndroidDeviceActionShortcuts)
            // driver).pressKeyCode(AndroidKeyCode.ENTER);
            // 确定
            // ((AndroidDeviceActionShortcuts)
            // driver).pressKeyCode(AndroidKeyCode.ENTER);
            Thread.sleep(2000);
            // 点击 输入框-》光标显示/焦点
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_edit_text", driver);
            // 切换 appium 输入
            Thread.sleep(2000);
            AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", driver);
            Thread.sleep(2000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/rc_edit_text", "testtest", driver);
            // 表情
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_emoticon_toggle", driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/rc_emoticon_toggle").click();
            // 点击表情
            Thread.sleep(3000);
            (new TouchAction(driver)).tap(59, 843).perform();
            // 点击发送
            Thread.sleep(3000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_send_toggle", driver);
            // (new TouchAction(driver)).tap(670, 698).perform();
            Thread.sleep(3000);
            AppBase.Back(driver);
            // driver.findElementById("com.android.ayplatform"+type+":id/rc_layout_item_message").click();
        }
        catch (Error e) {
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "群聊天-编辑")
        public void case2_1_4() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            // 上接着case2_1_23,已建立聊天组
            Thread.sleep(2000);
            // 讨论组无Id/xpath特征
            AppBase.ClickXY(552, 315, "点击讨论组", driver);
            Thread.sleep(2000);
            // 讨论组信息
            AppBase.ClickId("com.android.ayplatform"+type+":id/chat_action_btn", driver);
            Thread.sleep(2000);
            // 点击群组名称 无id与xpath特征
            (new TouchAction(driver)).tap(635, 528).perform();
            // ClickXpath("//android.widget.TextView[@text='群组名称']");
            Thread.sleep(2000);
            // case2.1.23 已切换至unicode输入法
            AppBase.InPutById("com.android.ayplatform"+type+":id/activity_modify_groupname_content", "testestest",
                                driver);
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/doing", driver);
            Thread.sleep(2000);
            // 后退至聊天列表
            AppBase.Back(driver);
            Thread.sleep(1000);
            // 后退至主页面
            AppBase.Back(driver);
        }
        catch (Error e) {
            Thread.sleep(2000);
            AppBase.screenSnap(driver);
        }
        Thread.sleep(1000);
        driver.closeApp();
    }
    @Test(description = "通讯录-我的群组")
        public void case2_1_5() throws InterruptedException {
        Thread.sleep(2000);
        driver.launchApp();
        try {
            Thread.sleep(launchtime);
            // 启聊
            AppBase.ClickXpath(MainPage_Bar_QiLiao_Xpath, driver);
            // 通讯录
            Thread.sleep(2000);
            AppBase.ClickXpath(QiLiao_MailList_Xpath, driver);
            Thread.sleep(2000);
            AppBase.ClickXpath("//android.widget.TextView[@text='我的群组']", driver);
            // 测试企业--群组
            Thread.sleep(2000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/item_group_manager_name", driver);
            Thread.sleep(2000);
            AppBase.InPutById("com.android.ayplatform"+type+":id/rc_edit_text", "testestest", driver);
            // 发送
            Thread.sleep(1000);
            AppBase.ClickId("com.android.ayplatform"+type+":id/rc_send_toggle", driver);
            driver.closeApp();
        }
        catch (Error e) {
            AppBase.screenSnap(null);
        }
    }
    @AfterClass
        public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();
    }
    /*
     * public void changeAccount() {
     * AppBase.textPrint("Account Change Act start!");
     *
     * try { ClickXpath(MainPage_releaseData_Xpath); waitForXpath("账号与安全",
     * MyInfo_Tag_AccountSecurity_Xpath);
     *
     * ClickXpath(MyInfo_Tag_AccountSecurity_Xpath);
     * waitForId(releaseData_AS_AccountChange_Id);
     *
     * ClickId(releaseData_AS_AccountChange_Id); // 切换账号
     * waitForXpath(ForAccountName, "//android.widget.TextView[@text='" +
     * ForAccountName + "']"); ClickXpath("//android.widget.TextView[@text='" +
     * ForAccountName + "']"); // 回到个人信息页,关闭个人信息弹窗 waitForXpath("账号与安全",
     * MyInfo_Tag_AccountSecurity_Xpath); driver.navigate().back();
     * AppBase.textPrint("Account Change Act Success!"); } catch
     * (InterruptedException e) { AppBase.textPrint("Account Change Act Fail!");
     * // TODO Auto-generated catch block e.printStackTrace(); screenSnap(); } }
     */
    // account login
}