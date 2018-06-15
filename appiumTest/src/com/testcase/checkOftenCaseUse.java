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

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.method.SelectAction;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidKeyCode;
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
import com.method.openAppList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import javax.swing.plaf.synth.SynthRadioButtonMenuItemUI;

public class checkOftenCaseUse extends TestInfo {

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

    @Test(description = "test work")
    public void case_test() throws InterruptedException {

        try {
            Thread.sleep(3000);
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
        } catch (Error e) {
            AppBase.screenSnap(driver);
        }

        driver.closeApp();
        Thread.sleep(2000);
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}