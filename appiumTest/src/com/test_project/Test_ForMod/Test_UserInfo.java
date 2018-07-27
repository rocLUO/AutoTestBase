/*
 * appiumTest - com.test_project
 * author: luopeng
 * Date: 2018/7/18
 * Time: 14:43
 *
 * Description:
 */
package com.test_project.Test_ForMod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import com.caseDebug.userInformation.*;
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

public class Test_UserInfo extends TestInfo {

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

    @Test(description = "帐号切换")
    public void case1_1_1() throws InterruptedException {
        C1_1_1.case1_1_1(driver);

        AppBase.closeApp(driver);
    }
/*
    @Test(description = "企业切换")
    public void case1_1_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_1_2.case1_1_2(driver);

        AppBase.closeApp(driver);
    }
*/
    @Test(description = "个人资料-头像设置(admin)")
    public void case1_2_1() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_1.case1_2_1(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-个性签名(admin)")
    public void case1_2_2() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_2.case1_2_2(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-个人资料显示(admin)")
    public void case1_2_3() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_3.case1_2_3(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-我的动态(admin)")
    public void case1_2_4() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_4.case1_2_4(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-版本信息")
    public void case1_2_5() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_5.case1_2_5(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-我的钱包(admin)")
    public void case1_2_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_6.case1_2_6(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-我的二维码")
    public void case1_2_7() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_7.case1_2_7(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-清除缓存")
    public void case1_2_8() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_8.case1_2_8(driver);
    }

    @Test(description = "个人资料-来电提示")
    public void case_1_2_9() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_9.case1_2_9(driver);

        AppBase.closeApp(driver);
    }

    @Test(description = "个人资料-账号退出")
    public void case1_2_10() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_2_10.case1_2_10(driver);

        AppBase.closeApp(driver);
    }
/*
    @Test(description = "消息中心-工作交办/提到我的/工作动态/组织架构变动/系统消息/系统消息/我评论的")
    public void case1_3_1_6() throws InterruptedException {
        AppBase.launchApp(driver);

        C1_3_1_6.case1_3_1_6(driver);

        AppBase.closeApp(driver);
    }
*/

    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();

    }
}