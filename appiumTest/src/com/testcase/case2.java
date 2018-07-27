/**
 * com.testcase.demo
 * appiumTest
 * case2.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月16日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.testcase;

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


public class Case2 extends TestInfo {

	// 配合android键盘输入 driver 切换为 AndroidDriver
	 private static AppiumDriver driver;
	//private static AndroidDriver driver;

	// test case name
	String testTitle = "case2";

	// all waitFor MeThod time set (30s/60s)
	int waitTime = 30;

	// 登录方法账号信息配置
	String Account = "admin_pretest";
	String Password = "11111111";

	// 切换账号名
	String ForAccountName = "李根";

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

		login();
//		ChangeAccount();

		waitForXpath("待办工作", MainPage_Tag_Already_Xpath);
		clickXpath(MainPage_NewWork_Id);

		clickXpath("//android.widget.TextView[@text='想喝花雕么']");

		// 等待流程标题控件
		waitForId("com.android.ayplatform.release:id/title");

		// 字段输入
		driver.findElementById("com.android.ayplatform.release:id/view_stringui_valueEdt").clear();
		driver.findElementById("com.android.ayplatform.release:id/view_stringui_valueEdt").sendKeys("auto test");

		// 数字输入
		driver.findElementByXPath("//android.widget.LinearLayout[3]").clear();
		driver.findElementByXPath("//android.widget.LinearLayout[3]").sendKeys("123123");

		// 点击添加人员
		clickId("com.android.ayplatform.release:id/org_add_user_imageView");

		// 人员组织搜索页面-搜索
		clickId("com.android.ayplatform.release:id/workbench_head_edit");

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
		*/
		// 点击人名--只有一个结果
		clickId("com.android.ayplatform.release:id/item_orgstructure_colleague_name");

		// 点击提交
		clickId("com.android.ayplatform.release:id/org_search_display_submit");

		// 提交
		clickId(WorkFlow_Send_Id);
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
//			AppBase.snapshot();
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
//			AppBase.snapshot();
		}
	}

	public void clickXpath(String Xpath) {
		try {
			AppBase.textPrint("Click The Element For Xpath ->" + Xpath);
			driver.findElementByXPath(Xpath).click();
			AppBase.textPrint("Click Act Success!");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
//			AppBase.snapshot();
		}
	}

	public void clickId(String Id) {
		try {
			AppBase.textPrint("Click The Element For Id -> " +Id);
			driver.findElementById(Id).click();
			AppBase.textPrint("Click Act Success");
		} catch (Error e) {
			AppBase.textPrint("Click Fail");
			e.printStackTrace();
//			AppBase.snapshot();
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
//				AppBase.snapshot();
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
//				AppBase.snapshot();
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
//				AppBase.snapshot();
			}
			Thread.sleep(1000);
		}
	}
/*
	public void ChangeAccount() {
		AppBase.textPrint("Account Change Act start!");

		try {
			clickXpath(MainPage_preData_Xpath);
			waitForXpath("账号与安全", MyInfo_Tag_AccountSecurity_Xpath);

			clickXpath(MyInfo_Tag_AccountSecurity_Xpath);
			waitForId(PreData_AS_AccountChange_Id);

			clickId(PreData_AS_AccountChange_Id);
			// 切换账号
			waitForXpath(ForAccountName, "//android.widget.TextView[@text='" + ForAccountName + "']");
			clickXpath("//android.widget.TextView[@text='" + ForAccountName + "']");
			// 回到个人信息页,关闭个人信息弹窗
			waitForXpath("账号与安全", MyInfo_Tag_AccountSecurity_Xpath);
			driver.navigate().back();
			AppBase.textPrint("Account Change Act Success!");
		} catch (InterruptedException e) {
			AppBase.textPrint("Account Change Act Fail!");
			// TODO Auto-generated catch block
			e.printStackTrace();
			AppBase.snapshot();
		}
	}
*/
	// 账号登录
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
//			AppBase.snapshot();
		}

	}

	public void swipXY(int X1, int Y1, int X2, int Y2) {
		try {
			Thread.sleep(1000);
			driver.swipe(X1, Y1, X2, Y2, 500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			AppBase.textPrint("screeen shot Fail!");
			e.printStackTrace();
//			AppBase.snapshot();
		}
	}

	public void longPress(int time) {
		try {
		} catch (Error e) {
			AppBase.textPrint("Act is preform succesee!");
			e.printStackTrace();
//			AppBase.snapshot();
		}
	}

}
