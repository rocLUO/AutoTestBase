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
package com.guojing;

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

import com.appium.TestBase.TestInfo;
import com.appium.TestBase.AppBase;

public class case1_2_2 extends TestInfo {
	private static AppiumDriver driver;

	// 郭靖
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

	@Test(description = "个性签名")
	public void case1_2_2() throws InterruptedException {

		/*
		 * 注:app端个人资料修改必须为本帐号登录,
		 *
		 * 托管帐号无法修改.此条不能直接接续,需切换回主帐号
		 */

		try {

			// 默认切换账号提前操作
			Thread.sleep(3000);
			ClickXpath(MainPage_preData_Xpath);
			Thread.sleep(2000);

			ClickXY(189, 1076, "点击-账号与安全");

			Thread.sleep(2000);
			ClickXY(980, 287, "切换账号");

			Thread.sleep(2000);
			ClickXY(926, 279, "点击本帐号");

			// 单击资料编辑按钮
			Thread.sleep(2000);
			ClickXY(765, 266, "点击资料编辑");
//			ClickXpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View");
			// driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View").click();//单击头像

			// 单击编辑按钮android
//			Thread.sleep(3000);
			// ClickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View");
//			(new TouchAction(driver)).tap(756, 256).perform();

			//切换默认输入
			excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME");
			
			
			// 选择个性签名
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/activity_ayprivate_accountinfo_qianming_tv");
			// (new TouchAction(driver)).tap(492, 450).perform();
			
			// 点击输入框，输入文字
			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/activity_ayprivate_modifysign_et","oH my god!");

			// 编辑完成确认
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/confirm_tv");
			// (new TouchAction(driver)).tap(975, 147).perform();
			// Thread.sleep(3000);
			// ClickId(" com.android.ayplatform.release:id/back");//编辑后返回
			// //(new TouchAction(driver)).tap(63, 134).perform();

			Thread.sleep(2000);
			Back();
			Thread.sleep(1000);
			Back();

		} catch (Error e) {
			screenSnap();
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	public void ClickId(String Id) {
		try {
			AppBase.textPrint("Click The Element For Id -> " + Id);
			driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			AppBase.screenSnap(driver);
		}
	}

	public void ClickXpath(String Xpath) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			AppBase.screenSnap(driver);
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

	public void Back() {
		driver.navigate().back();
	}

	public void ClickXY(int X, int Y, String explain) {

		try {

			(new TouchAction(driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y + "  this is -> " + explain);
		} catch (Error e) {
			screenSnap();
			AppBase.textPrint("click loacte act Fail!");
		}
	}
	
	private void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}

	}
	
	public void InPutById(String Id, String Text) {
		try {
			AppBase.textPrint("input text For Id! ->" + Id);
			driver.findElementById(Id).sendKeys(Text);
			AppBase.textPrint("input success!");

		} catch (Error e) {

			AppBase.textPrint("input fail!");
			e.printStackTrace();
			AppBase.screenSnap(driver);

		}
	}

}