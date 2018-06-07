/**
 * com.testcase.demo
 * appiumTest
 * case1.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月9日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.zhangzongchao;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

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

public class case2_2_1 extends TestInfo {
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

	@Test(description = "发现导航栏切换")
	public static void case2_2_1() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Bar_QiLiao_Xpath).click();// 启聊

		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Bar_DashBoard_Xpath).click();// 仪表盘

		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Bar_App_Xpath).click();// 应用

		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Bar_Discovery_Xpath).click();// 发现

		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Bar_Work_Xpath).click();// 工作

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	/*
	 * //账号登录 public void login() throws InterruptedException { // 用户名输入
	 * Thread.sleep(5000);
	 * driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
	 * Thread.sleep(2000);
	 * driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys(
	 * "15380424938"); Thread.sleep(2000); // 密码输入
	 * driver.findElementById("com.android.ayplatform:id/Pass").clear();
	 * Thread.sleep(2000);
	 * driver.findElementById("com.android.ayplatform:id/Pass").sendKeys(
	 * "luo199259"); Thread.sleep(2000); // HTC U11 关闭输入法键盘
	 * driver.navigate().back(); Thread.sleep(2000); // 登录
	 * driver.findElementById("com.android.ayplatform:id/login").click();
	 * Thread.sleep(2000); }
	 */

	/*
	 * // 等待xpath控件出现 public void waitForXpath(String Name, String Xpath) throws
	 * InterruptedException { for (int second = 0;; second++) { if (second >=
	 * 60) fail("timeout"); try { if
	 * (Name.equals(driver.findElementByXPath(Xpath))) break; Thread.sleep(2);
	 * 
	 * } catch(Exception e) { Thread.sleep(1000); e.printStackTrace();
	 * AppBase.textPrint("Page--> " + driver.getTitle() + "  :loding error");
	 * driver.quit(); AppBase.snapshot(); } Thread.sleep(1000);
	 * AppBase.textPrint("XpathButton--> " + Name + "  :cannot found!"); } }
	 */
	/*
	 * public void CheckXpath(String Xpath,String Text){ try {
	 * AppBase.textPrint("Check The Text For Xpath!");
	 * assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
	 * AppBase.textPrint("Check Success!"); } catch (Error e) {
	 * AppBase.textPrint("Check Fail!"); e.printStackTrace();
	 * AppBase.snapshot(); } }
	 */

}
