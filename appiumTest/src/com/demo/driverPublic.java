/**
 * com.demo
 * appiumTest
 * driverPublic.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月27日 上午11:20:21
 *
 * Created by LuoPeng
 */
package com.demo;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/*
 *@author luopeng
 *Last_Update 2018年4月27日上午11:20:21
 *
 */
public class driverPublic {
	public AppiumDriver driver;
	
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", "Android"); // 指定测试平台
		cap.setCapability("deviceName", "MKJNW17C20005057"); // 指定测试机的ID,通过adb命令`adb
																// devices`获取
		cap.setCapability("platformVersion", "8.0");

		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", "com.android.ayplatform");
		cap.setCapability("appActivity", "com.android.ayplatform.activity.WelcomeActivity");

		// A new session could not be created
		// cap.setCapability("appWaitActivity","com.android.ayplatform.activity.WelcomeActivity");

		// 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		cap.setCapability("sessionOverride", true);
		// 解决每次启动APP需要确认权限问题--即不重复安装
		cap.setCapability("noReset", true);
		cap.setCapability("noSign", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}
}
