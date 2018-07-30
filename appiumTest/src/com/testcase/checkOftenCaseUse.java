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
import java.sql.Driver;

import com.caseDebug.discovery.*;
import com.caseDebug.qiLiao.*;
import com.caseDebug.search.C4_1_1_4;
import com.caseDebug.search.C4_1_2_5;
import com.caseDebug.search.C4_1_3;
import com.caseDebug.search.C4_1_6;
import com.caseDebug.userInformation.*;
import com.caseDebug.workProtal.workProtalEntrance.*;
import com.caseDebug.workProtal.workProtalWorkAssembly.C3_5_2;
import com.method.ChangeAccount;
import com.method.LoginApp;
import com.readyData.CreateNewWork_newProtal;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

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
         * capabilities.setCapa1ebility("resetKyboard", "True");
         */

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    
    @Test(description = "工作圈-文字信息")
    public void test() throws InterruptedException {
//        ChangeAccount.switchAccount(driver,"企业管理员正牌",1);
//        ChangeAccount.reloadAccount(driver,"luopeng2","luopeng2");
    	C2_3_6.case2_3_6(driver);
        //AppBase.closeApp(driver);
    }


    @AfterClass
    public void tearDown() throws Exception {
        AppBase.textPrint("test end!");
        driver.quit();
    }

}