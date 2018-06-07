/**
 * com.demo
 * appiumTest
 * SearchKeyEventDemo.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月26日 上午11:42:20
 *
 * Created by LuoPeng
 */
package com.demo;

import org.testng.annotations.Test;

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

/*
 *@author luopeng
 *Last_Update 2018年4月26日上午11:42:20
 *
 */
public class SearchKeyEventDemo extends TestInfo {
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
		// cap.setCapability("unicodeKeyboard", true);
		// cap.setCapability("resetKeyboard", true);
		/*
		 * 中文输入,隐藏键盘启动 capabilities.setCapability("unicodeKeyboard", "True");
		 * capabilities.setCapability("resetKeyboard", "True");
		 */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	// 待办委托
	@Test(description = "搜索-键盘事件demo")
	public void keyevent() throws InterruptedException {

		// 点击主界面-搜索
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform.release:id/workbench_head_edit").click();

		// 点击搜索界面-搜索
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform.release:id/filter_edit").click();

		//切换输入法-》搜狗
		Thread.sleep(2000);
		excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME");
		
		// 再次点击输入框，调取键盘
		driver.findElementById("com.android.ayplatform.release:id/filter_edit").click();
		
		// 输入X
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
		// 点击右下角的搜索，即ENTER键
		Thread.sleep(2000);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(1000);
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.ENTER);
		
		Thread.sleep(2000);
		// driver.swipe(, starty, endx, endy, duration);
	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	//cmd调用 输入法键盘事件
	private void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}

	}
}