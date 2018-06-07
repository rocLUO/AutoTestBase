/**
 * com.testcase.demo

 * appiumTest
 * case1.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018��3��29�� ����3:29:05
 *
 * Created by ZhangYiWen
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

import com.appium.TestBase.TestInfo;
import com.appium.TestBase.AppBase;

public class case3_17 extends TestInfo {
	private static AppiumDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", Platform);
		cap.setCapability("deviceName", PhoneCode);
		cap.setCapability("platformVersion", Version);
		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", ApkPackage);
		cap.setCapability("appActivity", ApkActivity);
		// A new session could not be created
		// cap.setCapability("appWaitActivity","com.android.ayplatform.activity.WelcomeActivity");
		// ÿ������ʱ����session������ڶ��κ����лᱨ�����½�session
		cap.setCapability("sessionOverride", true);
		// ���ÿ������APP��Ҫȷ��Ȩ������--�����ظ���װ
		cap.setCapability("noReset", true);
		cap.setCapability("noSign", true);
		/*
		 * ��������,���ؼ������� capabilities.setCapability("unicodeKeyboard",
		 * "True"); capabilities.setCapability("resetKeyboard", "True");
		 */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@Test(description = "标签切换")
	public static void case3_1_1() throws InterruptedException {

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_HoldOn_Xpath);

			Thread.sleep(3000);

			// driver.swipe(, starty, endx, endy, duration);

		} catch (Error e) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(1000);

	}

	@Test(description = "代办工作-处理")
	/* ���칤��-�����ύ */
	public void case3_2_1() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			// 待办
			ClickXpath(MainPage_Tag_HoldOn_Xpath);

			Thread.sleep(1000);
			// 默认打开第一项
			ClickXpath("com.android.ayplatform.release:id/workbench_module_item1");

			Thread.sleep(2000);
			driver.findElementByXPath(
					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
					.sendKeys("11111");

			Thread.sleep(3000);
			// 添加接收人
			ClickId("com.android.ayplatform.release:id/org_add_user_imageView");

			Thread.sleep(3000);
			ClickXpath("//android.widget.TextView[@text='测试部门1']");

			Thread.sleep(1000);
			ClickXpath("//android.widget.TextView[@text='111']");

			Thread.sleep(1000);
			// 确定
			ClickId("com.android.ayplatform.release:id/orgstructure_colleagues_display_submit");

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/flow_detail_submit_Button");

		} catch (Error e) {

			Thread.sleep(1000);
			screenSnap();

		}

		Thread.sleep(1000);
		driver.closeApp();

	}

	@Test(description = "代办工作-抄送")
	public void case2_2_2() throws InterruptedException {

		Thread.sleep(2000);
		driver.launchApp();

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

		driver.closeApp();
		Thread.sleep(2000);

	}

	@Test(description = "代办工作-委托")
	public void case3_2_3() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_item1");// 单击流程

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/more");// 可找到“抄送”的按钮

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='委托']");// 单击抄送

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
			// 点击确定输入
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);
			// 点击确定搜索
			((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_ENTER);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='111']");

			Thread.sleep(1000);
			ClickId("com.android.ayplatform.release:id/org_search_display_submit");

			Thread.sleep(2000);
			excuteAdbShell("adb shell ime set com.sohu.inputmethod.sogou/.SogouIME");
			InPutById("com.android.ayplatform.release:id/et_msg", "testest");

			ClickXpath("//android.widget.Button[@text='确定']");

		} catch (Error e) {

		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

	// �˺ŵ�¼
	public void login() throws InterruptedException {
		// �û�������
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys("15380424938");
		Thread.sleep(2000);
		// ��������
		driver.findElementById("com.android.ayplatform:id/Pass").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/Pass").sendKeys("luo199259");
		Thread.sleep(2000);
		// HTC U11 �ر����뷨����
		driver.navigate().back();
		Thread.sleep(2000);
		// ��¼
		driver.findElementById("com.android.ayplatform:id/login").click();
		Thread.sleep(2000);
	}

	// ��ͼ

	// �ȴ�xpath�ؼ�����
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
				AppBase.textPrint("Page--> " + driver.getTitle() + "  :loding error");
				driver.quit();
				AppBase.snapshot();
			}
			Thread.sleep(1000);
			AppBase.textPrint("XpathButton--> " + Name + "  :cannot found!");
		}
	}

	public void CheckXpath(String Xpath, String Text) {
		try {
			AppBase.textPrint("Check The Text For Xpath!");
			assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
			AppBase.textPrint("Check Success!");
		} catch (Error e) {
			AppBase.textPrint("Check Fail!");
			e.printStackTrace();
			AppBase.snapshot();
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
			AppBase.snapshot();

		}
	}

	public void clearId(String Id) {
		try {
			AppBase.textPrint("clear by id ->" + Id);
			driver.findElementById(Id).clear();
			AppBase.textPrint("clear act done!");
		} catch (Error e) {
			AppBase.textPrint("clear Fail!");
			e.printStackTrace();
			AppBase.snapshot();
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

	public void Back() {
		driver.navigate().back();
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
}
