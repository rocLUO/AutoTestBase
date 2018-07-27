/*
 * appiumTest - com.test_project.Test_ForMod
 * author: luopeng
 * Date: 2018/7/19
 * Time: 9:05
 *
 * Description:
 */
package com.test_project.Test_ForMod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.caseDebug.workProtal.workProtalEntrance.*;
import org.apache.commons.io.FileUtils;
import org.hamcrest.Description;
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

public class Test_Protal_Entrance extends TestInfo {

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

    @Test(description = "代办工作-处理/快捷入口进入")
    public void case3_2_1() throws InterruptedException {
        C3_2_1.case3_2_1(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "待办工作-抄送/快捷入口进入")
    public void case3_2_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_2_2.case3_2_2(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "代办工作-委托/快捷入口进入")
    public void case3_2_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_2_3.case3_2_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "代办工作-回退/快捷入口进入")
    public void case3_2_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_2_4.case3_2_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "待办-批注")
    public void case3_2_8() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_2_8.case3_2_8(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "最近处理-取回")
    public void case3_3_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_3_3.case3_3_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "最近处理-中断")
    public void case3_3_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_3_4.case3_3_4(driver);

        AppBase.closeApp(driver);
    }

    /*
    @Test(description = "最近处理-催办")
    public void case3_3_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_3_5.case3_3_5(driver);

        AppBase.closeApp(driver);
    }
    */

    @Test(description = "最近处理-历史记录")
    public void case3_3_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_3_6.case3_3_6(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "最近处理-批注")
    public void case3_3_7() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_3_7.case3_3_7(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "我的发起-抄送")
    public void case3_4_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_4_2.case3_4_2(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "我的发起-历史记录")
    public void case3_4_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_4_5.case3_4_5(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "我的发起哦-中断")
    public void case3_4_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_4_6.case3_4_6(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "我的发起-批注")
    public void case3_4_7() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_4_7.case3_4_7(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "我的发起-删除流程")
    public void case3_4_8() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_4_8.case3_4_8(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-工作打开")
    public void case3_8_1() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_1.case3_8_1(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-历史记录")
    public void case3_8_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_2.case3_8_2(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-取回")
    public void case3_8_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_3.case3_8_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-抄送")
    public void case3_8_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_4.case3_8_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-催办")
    public void case3_8_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_5.case3_8_5(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-中断")
    public void case3_8_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_8_6.case3_8_6(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-评论")
    public void case3_9_1() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_9_1.case3_9_10y(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-历史记录")
    public void case3_9_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_9_2.case3_9_2(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-抄送")
    public void case3_9_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_9_3.case3_9_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-取回")
    public void case3_9_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_9_4.case3_9_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "经办工作-评论")
    public void case3_9_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C3_9_6.case3_9_6(driver);

        AppBase.closeApp(driver);
    }

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}