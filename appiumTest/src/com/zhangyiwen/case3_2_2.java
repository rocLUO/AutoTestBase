/**
 * com.testcase.demo
 * appiumTest
 * case1.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月9日 下午3:28:05
 *
 * Created by zhangyiwen
 */
package com.zhangyiwen;

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
 *Last_Update 2018年4月26日下午2:57:33
 *
 */
public class case3_2_2 extends TestInfo {
	private static AppiumDriver driver;

	// 抄送
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
//		cap.setCapability("unicodeKeyboard", true);
//		cap.setCapability("resetKeyboard", true);
		/*
		 * 中文输入,隐藏键盘启动 capabilities.setCapability("unicodeKeyboard", "True");
		 * capabilities.setCapability("resetKeyboard", "True");
		 */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
	}

	@Test(description = "代办工作-抄送")
	public void case3_2_2() throws InterruptedException {

//		Thread.sleep(2000);
//		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_item1");// 单击流程

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/more");// 可找到“抄送”的按钮

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='抄送']");// 单击抄送

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_head_search");// 单击搜索

			// 输入法切换
			Thread.sleep(2000);
			excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME");

			// keyevent
			Thread.sleep(500);
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
			Thread.sleep(500);
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
			Thread.sleep(500);
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_1);
			Thread.sleep(500);
			//点击确定输入
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
			//点击确定搜索
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='111']");
			Thread.sleep(500);
			ClickId("com.android.ayplatform.release:id/org_search_display_submit");
			// 搜索“xue”
			// (new TouchAction(driver)).tap(512, 1009).perform();
			// (new TouchAction(driver)).tap(350, 1012).perform();
			// (new TouchAction(driver)).tap(509, 789).perform();
			// (new TouchAction(driver)).tap(52, 675).perform();
			// (new TouchAction(driver)).tap(653, 1120).perform();
			// Thread.sleep(3000);
			// driver.findElementByXPath("//hierarchy/android.widget.FrameLayout/");//选择“薛飞”
			// Thread.sleep(3000);
			// driver.findElementByXPath("//hierarchy/android.widget.FrameLayout");//单击“确定”
			// Thread.sleep(1000);

		} catch (Error e) {
			screenSnap();
		}

//		driver.closeApp();
		Thread.sleep(2000);

		// driver.swipe(, starty, endx, endy, duration);
	}

	@AfterClass
	public void tearDown() throws Exception {
		textPrint("test end!");
		driver.quit();

	}

	// 账号登录
	public void login() throws InterruptedException {
		// 用户名输入
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys("admin_pretest");
		Thread.sleep(2000);
		// 密码输入
		driver.findElementById("com.android.ayplatform:id/Pass").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/Pass").sendKeys("11111111");
		Thread.sleep(2000);
		// HTC U11 关闭输入法键盘
		driver.navigate().back();
		Thread.sleep(2000);
		// 登录
		driver.findElementById("com.android.ayplatform:id/login").click();
		Thread.sleep(2000);
	}

	// 输入字符
	public static void textPrint(String Text) {
		System.out.println(getCurrentSystemTime() + "...:" + Text + " ");
	}

	// 获取时间
	public static String getCurrentSystemTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}

	// 截图
	// snapshot((TakesScreenshot)driver);
	public static void snapshot() {
		String currentpath = System.getProperty("user.dir");// get current work
															// folder
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("save snapshot path is:" + currentpath + "\\" + getCurrentSystemTime() + "\n");
			FileUtils.copyFile(scrFile, new File(currentpath + "\\" + getCurrentSystemTime()));// save
																								// screenshot
		} catch (IOException e) {
			System.out.println("Cannot take screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("already saved screenshot in:" + currentpath);
		}
	}

	// 等待xpath控件出现
	public void waitForXpath(String Name, String Xpath) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (Name.equals(driver.findElementByXPath(Xpath)))
					break;
				Thread.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				textPrint("Page--> " + driver.getTitle() + "  :loding error");
				driver.quit();
				snapshot();
			}
			Thread.sleep(1000);
			textPrint("XpathButton--> " + Name + "  :cannot found!");
		}
	}

	public void CheckXpath(String Xpath, String Text) {
		try {
			textPrint("Check The Text For Xpath!");
			assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
			textPrint("Check Success!");
		} catch (Error e) {
			textPrint("Check Fail!");
			e.printStackTrace();
			snapshot();
		}
	}

	public void ClickId(String Id) {
		try {
			AppBase.textPrint("Click The Element For Id -> " + Id);
			driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			screenSnap();
		}
	}

	// cmd调用 输入法键盘事件
	private void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}

	}

	public static void ClickXpath(String Xpath) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			AppBase.snapshot();
		}
	}

	public static void snapshot(TakesScreenshot drivername, String filename) {
		// this method will take screen shot ,require two parameters ,one is
		// driver name, another is file name

		String currentPath = System.getProperty("user.dir"); // get current work
																// folder
		File scrFile = drivername.getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy
		// somewhere
		try {
			System.out.println("save snapshot path is:" + currentPath + "/" + filename);
			FileUtils.copyFile(scrFile, new File(currentPath + "\\" + filename));
		} catch (IOException e) {
			System.out.println("Can‘t save screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("screen shot finished, it‘s in " + currentPath + " folder");
		}
	}

	public static void screenSnap() {
		snapshot((TakesScreenshot) driver, AppBase.getCurrentSystemTime() + ".png");
	}
}
