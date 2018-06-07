package com.testNgDemo;
/**
 * com.testcase.demo
 * appiumTest
 * NgDemo.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月2日 下午4:28:05
 *
 * Created by LuoPeng
 */

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.TestInfo;
import com.appium.TestBase.AppBase;

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


public class testNgDemo extends TestInfo {


	//private static AppiumDriver driver;
	//androidDriver already succeed AppiumDriver method
	public static AndroidDriver driver;

	// test case name
	String testTitle = "case2";


	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", Platform);
		cap.setCapability("deviceName", PhoneCode);
		cap.setCapability("platformVersion", Version);
		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", ApkPackage);// release
																			// build
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

		AppBase.textPrint("test case name " + testTitle + " is start ");

	}

	/*
	 * release 版本 登录-》切换账号-》新建流程-》提交
	 */
	@Test
	public void plus() throws InterruptedException {

		//login();
		//changeAccount();

		//waitForXpath("待办工作", MainPage_Tag_Already_Xpath);
		Thread.sleep(2000);
		ClickXpath(MainPage_NewWork_Id);
		
		Thread.sleep(3000);
		AppBase.textPrint("success");

		/*
		ClickXpath("//android.widget.TextView[@text='想喝花雕么']");

		// 等待流程标题控件
		waitForId("com.android.ayplatform.release:id/title");

		// 字段输入
		driver.findElementById("com.android.ayplatform.release:id/view_stringui_valueEdt").clear();
		driver.findElementById("com.android.ayplatform.release:id/view_stringui_valueEdt").sendKeys("auto test");

		// 数字输入
		driver.findElementByXPath("//android.widget.LinearLayout[3]").clear();
		driver.findElementByXPath("//android.widget.LinearLayout[3]").sendKeys("123123");

		// 点击添加人员
		ClickId("com.android.ayplatform.release:id/org_add_user_imageView");

		// 人员组织搜索页面-搜索
		ClickId("com.android.ayplatform.release:id/workbench_head_edit");

		// 键盘事件--成员目标 test-1
		// 如果调试失败,建议使用坐标点击替代
		/*
		// t
		driver.pressKeyCode(48);
		// e
		driver.pressKeyCode(33);
		// s
		driver.pressKeyCode(47);
		// t
		driver.pressKeyCode(48);
		// 1
		driver.pressKeyCode(8);
		// 搜索
		driver.pressKeyCode(66);
		*//*
		// 点击人名--只有一个结果
		ClickId("com.android.ayplatform.release:id/item_orgstructure_colleague_name");

		// 点击提交
		ClickId("com.android.ayplatform.release:id/org_search_display_submit");

		// 提交
		ClickId(WorkFlow_Send_Id);
		*/
		
	}

	@AfterClass
	public void tearDown() throws Exception {

		driver.navigate().back();
		driver.navigate().back();
		AppBase.textPrint("test end!");
		driver.quit();

	}

	public void CheckXpath(String Xpath, String Text) {
		try {
			AppBase.textPrint("Check The Text For Xpath! ->" +Xpath);
			assertEquals(driver.findElementByXPath(Xpath).getText(), Text);
			AppBase.textPrint("Check Success!");
		} catch (Error e) {
			AppBase.textPrint("Check Fail!");
			e.printStackTrace();
			screenSnap();
		}

	}

	public void CheckId(String Id, String Text) {
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



	public void ClickXpath(String Xpath) {
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

	public void ClickId(String Id) {
		try {
			AppBase.textPrint("Click The Element For Id -> " +Id);
			driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
			screenSnap();
		}
	}

	public void waitForId(String Text, String Id) throws InterruptedException{
		for (int second = 0;; second++) {
			if (second >= waitTime)// 60秒市场区间
				fail("timeout->" + second);
			try {
				if (Text.equals(driver.findElementById(Id)))
					break;
			} catch (Error e) {
				AppBase.textPrint("finding Element Fail");			e.printStackTrace();
				e.printStackTrace();
				screenSnap();
			}
			Thread.sleep(1000);// 每隔1秒执行查找

		}
	}

	public void waitForId(String Id) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= waitTime)
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
			if (second >= waitTime)
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
/*
	public void changeAccount() {
		AppBase.textPrint("Account Change Act start!");

		try {
			ClickXpath(MainPage_preData_Xpath);
			waitForXpath("账号与安全", MyInfo_Tag_AccountSecurity_Xpath);

			ClickXpath(MyInfo_Tag_AccountSecurity_Xpath);
			waitForId(PreData_AS_AccountChange_Id);

			ClickId(PreData_AS_AccountChange_Id);
			// 切换账号
			waitForXpath(ForAccountName, "//android.widget.TextView[@text='" + ForAccountName + "']");
			ClickXpath("//android.widget.TextView[@text='" + ForAccountName + "']");
			// 回到个人信息页,关闭个人信息弹窗
			waitForXpath("账号与安全", MyInfo_Tag_AccountSecurity_Xpath);
			driver.navigate().back();
			AppBase.textPrint("Account Change Act Success!");
		} catch (InterruptedException e) {
			AppBase.textPrint("Account Change Act Fail!");
			// TODO Auto-generated catch block
			e.printStackTrace();
			screenSnap();
		}
	}
*/
	// account login
	public void login() {
		AppBase.textPrint("login Act start!");
		// 用户名输入
		try {
			Thread.sleep(5000);

			driver.findElementById(LoginPage_Id).clear();
			Thread.sleep(2000);
			driver.findElementById(LoginPage_Id).sendKeys(Account);
			Thread.sleep(2000);
			// 密码输入
			driver.findElementById(LoginPage_Password).clear();
			Thread.sleep(2000);
			driver.findElementById(LoginPage_Password).sendKeys(Password);
			Thread.sleep(2000);
			// HTC U11 关闭输入法键盘
			driver.navigate().back();
			Thread.sleep(2000);
			// 登录
			driver.findElementById(LoginPage_LoginKey).click();
			Thread.sleep(2000);
			AppBase.textPrint("login Act Succesee!");
		} catch (InterruptedException e) {
			AppBase.textPrint("login Act Fail!");
			// TODO Auto-generated catch block
			e.printStackTrace();
			screenSnap();
		}

	}

	public void swipXY(int X1, int Y1, int X2, int Y2) throws InterruptedException {
		driver.swipe(X1, Y1, X2, Y2, 500);
	}

	/*"fingers" how much fingers are you try to touch
	 *
	 *"element" witch element you want to use
	 *
	 *"duration" how much time you want to press the phone
	 */
	public void TapClick(int fingers, WebElement element, int duration ) throws InterruptedException {
		driver.tap(fingers, element, duration);
	}

	/*"fingers" how much fingers are you try to chouch
	 *
	 *"X/Y" is you touch location on screen
	 *
	 *"duration" how much time you want to press the phone
	 */
	public void TapClickXY(int fingers, int X, int Y, int duration) throws InterruptedException {

		driver.tap(fingers, X, Y, duration);
	}

	public void enlargeXY(int X, int Y) {
		driver.zoom(X,Y);
	}

	public void reduceXY(int X, int Y) {
		driver.pinch(X,Y);
	}

	public void screenSnap() {
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File("f:\\appiumTestRuslt\\"+AppBase.getCurrentSystemTime()+".png");
		try {
		    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
		} catch (IOException e) {
		    e.printStackTrace();
		}
	}


}
