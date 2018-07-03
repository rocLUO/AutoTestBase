/*
 * appiumTest - com.testcase
 * author: luopeng
 * Date: 2018/6/25
 * Time: 14:00
 *
 * Description: 用例 工作圈基础内容
 *              case5.2.1
 *              case5.2.2
 *              case5.2.3
 *              case5.2.13
 *              case5.2.4
 *              case5.2.5
 *              case5.2.7
 *              case5.2.8
 *              case5.2.9
 *              case5.2.10
 *              case5.2.11
 *              case5.2.12
 *
 *
 */
package com.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.method.SelectAction;
import com.method.changeAccount;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class Case_workCircle extends TestInfo {

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

    @Test(description = "工作圈-文字信息")
    public void case5_2_1() throws InterruptedException {

    		Thread.sleep(waitTime);
        try{

            newContent();

            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);


        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "工作圈-相册")
    public void case5_2_2() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            newContent();

            //点击 相册 icon
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_pic",driver);
            Thread.sleep(2000);

            //点击坐标
            AppBase.clickXY(176,419,"选择图片,点击左上角",driver);
            Thread.sleep(2000);

            //点击 确定
            AppBase.clickXY(894,1953,"点击确定",driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

        } catch (Error e) {

            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "工作圈-照相")
    public void case5_2_3() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            newContent();

            //点击 相机
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_cameral",driver);
            Thread.sleep(3000);

            //点击 拍摄
            AppBase.clickId("com.huawei.camera:id/shutter_button",driver);
            Thread.sleep(5000);

            //确定 照片
            AppBase.clickId("com.huawei.camera:id/done_button",driver);
            Thread.sleep(3000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "工作圈-图片放大")
    public void case5_2_13() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
        	
        	//先发图确保有图可点
            newContent();

            //点击 相机
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_cameral",driver);
            Thread.sleep(3000);

            //点击 拍摄
            AppBase.clickId("com.huawei.camera:id/shutter_button",driver);
            Thread.sleep(5000);

            //确定 照片
            AppBase.clickId("com.huawei.camera:id/done_button",driver);
            Thread.sleep(3000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

            //点击 图片 第一张图
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.widget.ImageView",driver);
            Thread.sleep(2000);

            AppBase.Back(driver);
            Thread.sleep(2000);

            AppBase.Back(driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(2000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "工作圈-文字/定位")
    public void case5_2_4() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            newContent();

            //点击 定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_location_tv",driver);
            Thread.sleep(3000);

            //点击确定定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

            //输入文字
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",driver);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "工作圈-@")
    public void case5_2_5() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            newContent();

            //点击 @
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",driver);
            Thread.sleep(2000);

            //人员组织架构 人员选择-方法
            SelectAction.choosesMen(driver,"autoTest","autoAccunt01",2);
            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "工作圈-文字信息/相册/照相/定位/@")
    public void case5_2_6() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            newContent();

            //点击 定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_location_tv",driver);
            Thread.sleep(3000);

            //点击确定定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);

            //输入文字
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",driver);
            Thread.sleep(2000);

            //点击 @
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",driver);
            Thread.sleep(2000);

            //人员组织架构 人员选择-方法
            SelectAction.choosesMen(driver,"autoTest","autoAccunt01",2);
            Thread.sleep(2000);

            //点击 相机
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_cameral",driver);
            Thread.sleep(3000);

            //点击 拍摄
            AppBase.clickId("com.huawei.camera:id/shutter_button",driver);
            Thread.sleep(5000);

            //确定 照片
            AppBase.clickId("com.huawei.camera:id/done_button",driver);
            Thread.sleep(3000);

            //点击 相册 icon
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_pic",driver);
            Thread.sleep(2000);

            //点击坐标
            AppBase.clickXY(500,368,"选择图片,点击左上角第二张",driver);
            Thread.sleep(2000);

            //点击 确定
            //AppBase.clickId("com.android.ayplatform"+ type +":id/id_total_count",driver);
            AppBase.clickXY(885,1962,"点击 选择确定",driver);

            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(3000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "工作圈-删除")
    public void case5_2_7() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try{

            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,driver);
            Thread.sleep(3000);

            //点击工作圈
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",driver);
            Thread.sleep(2000);

            //删除第一条
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]",driver);
            Thread.sleep(3000);

            AppBase.clickXpath("//android.widget.Button[@text='确定']",driver);
            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "工作圈-点赞")
    public void case5_2_8() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,driver);
            Thread.sleep(3000);

            //点击工作圈
            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",driver);
            Thread.sleep(2000);

            //点赞第一条
            AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);
    }

    @Test(description = "工作圈-评论")
    public void case5_2_9() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
        	
        	sendComment();

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

    @Test(description = "工作圈-评论删除")
    public void case5_2_10() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {
        	sendComment();

            //点击第一条 工作圈 评论内容
            AppBase.clickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView",driver);
            Thread.sleep(2000);

            //点击弹窗中 删除
            AppBase.clickId("com.android.ayplatform"+ type +":id/custom_dialog_delete",driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }

        Thread.sleep(1000);
        driver.closeApp();
        Thread.sleep(2000);

    }

//    @Test(description = "工作圈-评论回复")
//    public void case5_2_11() throws InterruptedException {
//
//        driver.launchApp();
//        Thread.sleep(waitTime);
//
//        try {
//        	
//        	sendComment();
//
//            //切换账户 至 骆2
//            changeAccount.switchAccount(driver);
//            Thread.sleep(2000);
//
//            AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,driver);
//            Thread.sleep(3000);
//
//            //点击工作圈
//            AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",driver);
//            Thread.sleep(2000);
//
//            //点击回复第一条 工作圈 评论内容
//            AppBase.clickXpath("android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]/android.widget.RelativeLayout[2]/android.widget.LinearLayout",driver);
//            Thread.sleep(2000);
//
//            //输入内容
//            AppBase.inPutById("com.android.ayplatform"+ type +":id/input_box_view_input_sms","testaaa",driver);
//            Thread.sleep(2000);
//
//            //点击发送
//            AppBase.clickId("com.android.ayplatform"+ type +":id/input_box_view_send_sms",driver);
//            Thread.sleep(2000);
//            
//            AppBase.Back(driver);
//
//        } catch (Error e) {
//            e.printStackTrace();
//            AppBase.screenSnap(driver);
//        }
//
//        Thread.sleep(1000);
//        driver.closeApp();
//
//    }

    @Test(description = "工作圈-@搜索")
    public void case5_2_12() throws InterruptedException {

        driver.launchApp();
        Thread.sleep(waitTime);

        try {

            newContent();

            //点击  @ 图标
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",driver);
            Thread.sleep(2000);

            SelectAction.choosesMen(driver,"autoTest","autoAccunt01",2);
            Thread.sleep(2000);

            //点击 发布
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",driver);
            Thread.sleep(2000);
            
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(driver);
        }
            
        Thread.sleep(1000);
        AppBase.screenSnap(driver);

    }

    public static void newContent() throws InterruptedException {

        AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,driver);
        Thread.sleep(3000);

        //点击工作圈
        AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",driver);
        Thread.sleep(2000);

        //点击发布
        AppBase.clickId("com.android.ayplatform"+ type +":id/doing",driver);
        Thread.sleep(2000);

    }
    
    public static void sendComment() throws InterruptedException {
        AppBase.clickXpath(MainPage_Bar_Discovery_Xpath,driver);
        Thread.sleep(3000);

        //点击工作圈
        AppBase.clickId("com.android.ayplatform"+ type +":id/item_message_label",driver);
        Thread.sleep(2000);

        //点击 评论
        AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[3]",driver);
        Thread.sleep(2000);

        //输入字符
        AppBase.inPutById("com.android.ayplatform"+ type +":id/input_box_view_input_sms","testtest",driver);
        Thread.sleep(2000);
        
        AppBase.clickId("com.android.ayplatform"+ type +":id/input_box_view_send_sms",driver);
        Thread.sleep(2000);
        
        
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}