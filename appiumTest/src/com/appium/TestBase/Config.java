package com.appium.TestBase;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

/*
 * appiumTest - com.appium.TestBase
 * author: luopeng
 * Date: 2018/7/11
 * Time: 10:28
 *
 * Description: Appium 脚本运行 配置前置信息
 */
public class Config extends TestInfo {

    public static void AppiumTestConfig(AppiumDriver Driver) throws MalformedURLException {

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

        Driver = new AndroidDriver(new URL(PhoneHost), cap);

    }
}
