/**
 * com.appium.TestBase
 * com.testcase.demo
 * appiumTest
 * AppBase.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月12日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.appium.TestBase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class AppBase extends TestInfo {
	// intput text
	public static void textPrint(String Text) {
		Reporter.log(getCurrentSystemTime() + "...:" + Text + " ");
	}

	// get time
	public static String getCurrentSystemTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}

	// snapshot((TakesScreenshot)driver);
	// snapshot((TakesScreenshot) driver, "firstjt.png");
	// public static void snapshot(TakesScreenshot drivername, String filename)
	// {
	// // this method will take screen shot ,require two parameters ,one is
	// // driver name, another is file name
	//
	// String currentPath = System.getProperty("user.dir"); // get current work
	// // folder
	// File scrFile = drivername.getScreenshotAs(OutputType.FILE);
	// // Now you can do whatever you need to do with it, for example copy
	// // somewhere
	// try {
	// System.out.println("save snapshot path is:" + currentPath + "/" +
	// filename);
	// FileUtils.copyFile(scrFile, new File(currentPath + "\\" + filename));
	// } catch (IOException e) {
	// System.out.println("Can‘t save screenshot");
	// e.printStackTrace();
	// } finally {
	// System.out.println("screen shot finished, it‘s in " + currentPath + "
	// folder");
	// }
	// }

	// public static void snapshot() {
	// snapshot((TakesScreenshot) driver, getCurrentSystemTime()+".png");
	// }

	public static void Back(AppiumDriver Driver) {
		Driver.navigate().back();
	}

	public static void ClickXpath(String Xpath, AppiumDriver Driver) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			Driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			// screenSnap();
		}
	}

	public static void ClickId(String Id, AppiumDriver Driver) {
		try {
			AppBase.textPrint("Click The Element For Id -> " + Id);
			Driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			// screenSnap();
		}
	}

	public static void InPutById(String Id, String Text, AppiumDriver Driver) {
		try {
			AppBase.textPrint("input text For Id! ->" + Id);
			Driver.findElementById(Id).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			screenSnap(Driver);

		}
	}

	public void InPutByXpath(String Xpath, String Text, AppiumDriver Driver) {
		try {
			AppBase.textPrint("input text For Id! ->" + Xpath);
			Driver.findElementById(Xpath).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			screenSnap(Driver);

		}
	}

	public void clearId(String Id, AppiumDriver Driver) {
		try {
			AppBase.textPrint("clear by id ->" + Id);
			Driver.findElementById(Id).clear();
			AppBase.textPrint("clear act done!");
		} catch (Error e) {
			AppBase.textPrint("clear Fail!");
			e.printStackTrace();
			screenSnap(Driver);
		}
	}

	public static void swipXY(int X1, int Y1, int X2, int Y2, AppiumDriver Driver) throws InterruptedException {
		Driver.swipe(X1, Y1, X2, Y2, 500);
	}

	/*
	 * "fingers" how much fingers are you try to touch
	 *
	 * "element" witch element you want to use
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void TapClick(int fingers, WebElement element, int duration, AppiumDriver Driver)
			throws InterruptedException {
		Driver.tap(fingers, element, duration);
	}

	/*
	 * "fingers" how much fingers are you try to chouch
	 *
	 * "X/Y" is you touch location on screen
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void TapClickXY(int fingers, int X, int Y, int duration, AppiumDriver Driver) throws InterruptedException {

		Driver.tap(fingers, X, Y, duration);
	}

	public void enlargeXY(int X, int Y, AppiumDriver Driver) {
		Driver.zoom(X, Y);
	}

	public void reduceXY(int X, int Y, AppiumDriver Driver) {
		Driver.pinch(X, Y);
	}

	/*
	 * public void screenSnap() { File screen =
	 * driver.getScreenshotAs(OutputType.FILE); File screenFile = new
	 * File("F:\\test-output\\screen\\"+AppBase.getCurrentSystemTime()+".png");
	 * try { FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
	 * } catch (IOException e) { e.printStackTrace(); } }
	 */

	public static void snapshot(TakesScreenshot drivername, String filename, AppiumDriver Driver) {
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

	public static void screenSnap(AppiumDriver Driver) {
		snapshot((TakesScreenshot) Driver, AppBase.getCurrentSystemTime() + ".png", Driver);
	}

	public static void excuteAdbShell(String s, AppiumDriver Driver) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}

	}

	public static void ClickXY(int X, int Y, String explain, AppiumDriver Driver) {

		try {

			(new TouchAction(Driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y + "  this is -> " + explain);
		} catch (Error e) {
			screenSnap(Driver);
			AppBase.textPrint("click loacte act Fail!");
		}
	}

	public void waitForId(String Text, String Id, AppiumDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= waitTime) // 60秒市场区间
				fail("timeout->" + second);
			try {
				if (Text.equals(Driver.findElementById(Id)))
					break;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap(Driver);
			}
			Thread.sleep(1000); // 每隔1秒执行查找
		}
	}

	public void waitForId(String Id, AppiumDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= waitTime)
				fail("timeout->" + second);
			try {
				if (Id.equals(Driver.findElement(By.id(Id))))
					;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap(Driver);
			}
			Thread.sleep(1000);
		}
	}

	public void waitForXpath(String Text, String Xpath, AppiumDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= waitTime)
				fail("timeout->" + second);
			try {
				if (Text.equals(Driver.findElementByXPath(Xpath)))
					break;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");
				e.printStackTrace();
				screenSnap(Driver);
			}
			Thread.sleep(1000);
		}
	}

	public static void waitForLoadingElementById(String elementID, AppiumDriver Driver) {
		int i = 0;
		while (i < 5) {
			try {
				if (Driver.findElement(By.id(elementID)).isDisplayed()) {
					AppBase.textPrint(elementID + ",Element is show up！");
					break;
				}
			} catch (Exception e) {
				AppBase.textPrint(elementID + ",Element is is not show up！Waitting...");
				i++;
				screenSnap(Driver);
			}
		}
		if (i == 4)
			AppBase.textPrint(elementID + "search Element for 5 time ,and not show up yet");
	}

	// ElementType only support input "Xpath" and "Id"
	public void CheckFor(String ElementType, String ElementInfo, AppiumDriver Driver) {
		if (ElementType == "Xpath") {
			try {
				if (Driver.findElement(By.xpath(ElementInfo)).isDisplayed()) {
					AppBase.textPrint(ElementType + " Element is show up！");
					// break;
				}

			} catch (Exception e) {
				AppBase.textPrint(ElementType + ",Element is not show up！Waitting...");
				screenSnap(Driver);
			}
		} else if (ElementType == "Id") {
			try {
				if (Driver.findElement(By.id(ElementInfo)).isDisplayed()) {
					AppBase.textPrint(ElementType + " Element is show up!");
				}

			} catch (Exception e) {
				AppBase.textPrint(ElementType + " Element is not show up! Waitting...");
				screenSnap(Driver);
			}
		} else {
			AppBase.textPrint("Error ! The Element can't be recognition!");
			screenSnap(Driver);

		}
	}
}
