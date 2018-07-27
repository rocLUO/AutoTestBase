/*
 * appiumTest - com.test_project
 * author: luopeng
 * Date: 2018/7/18
 * Time: 13:31
 *
 * Description:
 */
package com.test_project.Test_ForMod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.caseDebug.discovery.*;
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

public class Test_Discovery extends TestInfo {

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
        C5_2_1.case5_2_1(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-相册")
    public void case5_2_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_2.case5_2_2(driver);

        AppBase.closeApp(driver);

    }

    @Test(description = "工作圈-照相")
    public void case5_2_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_3.case5_2_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-文字/定位")
    public void case5_2_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_4.case5_2_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-@")
    public void case5_2_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_5.case5_2_5(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-文字信息/相册/照相/定位/@")
    public void case5_2_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_6.case5_2_6(driver);

        AppBase.closeApp(driver);

    }

    @Test(description = "工作圈-删除")
    public void case5_2_7() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_7.case5_2_7(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-点赞")
    public void case5_2_8() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_8.case5_2_8(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-评论")
    public void case5_2_9() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_9.case5_2_9(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-评论删除")
    public void case5_2_10() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_10.case5_2_10(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-评论回复")
    public void case5_2_11() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_11.case5_2_11(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-@搜索")
    public void case5_2_12() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_12.case5_2_12(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "工作圈-图片放大")
    public void case5_2_13() throws InterruptedException {
        AppBase.launchApp(driver);

        C5_2_13.case5_2_13(driver);

        AppBase.closeApp(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}