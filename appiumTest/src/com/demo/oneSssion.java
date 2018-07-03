/**
 * com.testcase.demo
 * appiumTest
 * oneSssion.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月25日 上午11:14:56
 *
 * Created by LuoPeng
 */
package com.demo;

import org.testng.annotations.Test;
import org.testng.log4testng.Logger;
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

/*
 *@author luopeng
 *Last_Update 2018年4月25日上午11:14:56
 *
 */
public class oneSssion extends TestInfo{

	protected static AppiumDriver driver;

	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", "Android"); // 指定测试平台
		cap.setCapability("deviceName", "MKJNW17C20005057"); // 指定测试机的ID,通过adb命令`adb
																// devices`获取
		cap.setCapability("platformVersion", "8.0");

		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", "com.android.ayplatform.release");
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

	@Test(description = "main Test Suit")
	public void plus() throws InterruptedException {

		demo1_1.case1_1();

		Thread.sleep(3000);

		driver.closeApp();

		Thread.sleep(2000);

		driver.launchApp();

		demo1_2.case1_2();

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	public static void inPutById(String Id, String Text) {
		try {
			AppBase.textPrint("input text For Id! ->" + Id);
			driver.findElementById(Id).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			screenSnap();

		}
	}

	public void inPutByXpath(String Xpath, String Text) {
		try {
			AppBase.textPrint("input text For Id! ->" + Xpath);
			driver.findElementById(Xpath).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			screenSnap();

		}
	}

	public void checkXpath(String Xpath, String Text) {
		try {
			AppBase.textPrint("Check The Text For Xpath! ->" + Xpath);
			assertEquals(driver.findElementByXPath(Xpath).getText(), Text);
			AppBase.textPrint("Check Success!");
		} catch (Error e) {
			AppBase.textPrint("Check Fail!");
			e.printStackTrace();
			screenSnap();
		}

	}

	public void checkId(String Id, String Text) {
		try {
			AppBase.textPrint("check The Text For Id ->" + Id);
			assertEquals(driver.findElementById(Id).getText(), Text);
			AppBase.textPrint("Check Success!");
		} catch (Error e) {
			AppBase.textPrint("Check Fail!");
			e.printStackTrace();
			screenSnap();
		}
	}

	public static void clickXpath(String Xpath) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			screenSnap();
		}
	}

	public static void clickId(String Id) {
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

	public static void clearId(String Id) {
		try {
			AppBase.textPrint("clear by id ->" + Id);
			driver.findElementById(Id).clear();
			AppBase.textPrint("clear act done!");
		} catch (Error e) {
			AppBase.textPrint("clear Fail!");
			e.printStackTrace();
			screenSnap();
		}
	}

	public void waitForId(String Text, String Id) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= TestInfo.waitTime)// 60秒市场区间
				fail("timeout->" + second);
			try {
				if (Text.equals(driver.findElementById(Id)))
					break;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap();
			}
			Thread.sleep(1000);// 每隔1秒执行查找

		}
	}

	public void waitForId(String Id) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= TestInfo.waitTime)
				fail("timeout->" + second);
			try {
				if (Id.equals(driver.findElement(By.id(Id))))
					;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap();
			}
			Thread.sleep(1000);
		}
	}

	public void waitForXpath(String Text, String Xpath) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= TestInfo.waitTime)
				fail("timeout->" + second);
			try {
				if (Text.equals(driver.findElementByXPath(Xpath)))
					break;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap();
			}
			Thread.sleep(1000);
		}
	}

	public static void waitForLoadingElementById(String elementID) {
		int i = 0;
		while (i < 5) {
			try {
				if (driver.findElement(By.id(elementID)).isDisplayed()) {
					AppBase.textPrint(elementID + ",Element is show up！");
					break;
				}
			} catch (Exception e) {
				AppBase.textPrint(elementID + ",Element is is not show up！Waitting...");
				i++;
				screenSnap();
			}
		}
		if (i == 4)
			AppBase.textPrint(elementID + "search Element for 5 time ,and not show up yet");
	}

	// ElementType only support input "Xpath" and "Id"
	public void checkFor(String ElementType, String ElementInfo) {
		if (ElementType == "Xpath") {
			try {
				if (driver.findElement(By.xpath(ElementInfo)).isDisplayed()) {
					AppBase.textPrint(ElementType + " Element is show up！");
					// break;
				}

			} catch (Exception e) {
				AppBase.textPrint(ElementType + ",Element is not show up！Waitting...");
				screenSnap();
			}
		} else if (ElementType == "Id") {
			try {
				if (driver.findElement(By.id(ElementInfo)).isDisplayed()) {
					AppBase.textPrint(ElementType + " Element is show up!");
				}

			} catch (Exception e) {
				AppBase.textPrint(ElementType + " Element is not show up! Waitting...");
				screenSnap();
			}
		} else {
			AppBase.textPrint("Error ! The Element can't be recognition!");
			screenSnap();

		}
	}

	public void swipXY(int X1, int Y1, int X2, int Y2) throws InterruptedException {
		driver.swipe(X1, Y1, X2, Y2, 500);
	}

	/*
	 * "fingers" how much fingers are you try to touch
	 *
	 * "element" witch element you want to use
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void tapClick(int fingers, WebElement element, int duration) throws InterruptedException {
		driver.tap(fingers, element, duration);
	}

	/*
	 * "fingers" how much fingers are you try to chouch
	 *
	 * "X/Y" is you touch location on screen
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void tapClickXY(int fingers, int X, int Y, int duration) throws InterruptedException {

		driver.tap(fingers, X, Y, duration);
	}

	public void enlargeXY(int X, int Y) {
		driver.zoom(X, Y);
	}

	public void reduceXY(int X, int Y) {
		driver.pinch(X, Y);
	}

	/*
	 * public void screenSnap() { File screen =
	 * driver.getScreenshotAs(OutputType.FILE); File screenFile = new
	 * File("F:\\test-output\\screen\\"+AppBase.getCurrentSystemTime()+".png");
	 * try { FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
	 * } catch (IOException e) { e.printStackTrace(); } }
	 */

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

	public void Back() {

		driver.navigate().back();
	}
}
