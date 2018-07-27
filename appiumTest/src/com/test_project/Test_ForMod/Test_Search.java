/*
 * appiumTest - com.test_project.Test_ForMod
 * author: luopeng
 * Date: 2018/7/18
 * Time: 17:14
 *
 * Description:
 */
package com.test_project.Test_ForMod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.caseDebug.search.C4_1_1_4;
import com.caseDebug.search.C4_1_2_5;
import com.caseDebug.search.C4_1_3;
import com.caseDebug.search.C4_1_6;
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

public class Test_Search extends TestInfo {

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

    @Test(description = "搜索-人员搜索")
    public void case4_1_1_4() throws InterruptedException {
        C4_1_1_4.case4_1_1_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "搜索-工作")
    public void case4_1_2_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C4_1_2_5.case4_1_2_5(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "搜索-应用")
    public void case4_1_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C4_1_3.case4_1_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "搜索-历史搜索")
    public void case4_1_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C4_1_6.case4_1_6(driver);

        AppBase.closeApp(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}