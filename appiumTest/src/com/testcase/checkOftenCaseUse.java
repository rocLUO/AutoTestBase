/*
 * appiumTest - com.testcase
 * author: luopeng
 * Date: 2018/6/14
 * Time: 14:41
 *
 * Description:
 */
package com.testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.net.URL;

import com.caseDebug.C2_1_5;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import com.caseDebug.*;

public class CheckOftenCaseUse extends TestInfo {

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
         * capabilities.setCapability("resetKyboard", "True");
         */
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

    }

    
    @Test(description = "通讯录-我的群组")
    public void case2_1_5() throws InterruptedException {
        C2_1_5.case2_1_5(driver);
    }
    
    @Test(description = "启聊导航栏切换与会话/通讯录切换")
    public void case2_1_1() throws InterruptedException {
    	C2_1_1.case2_1_1(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

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
}