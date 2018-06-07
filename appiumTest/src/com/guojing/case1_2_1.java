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

public class case1_2_1 extends TestInfo {
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

	@Test(description = "头像设置")
	// 头像设置_选择相册
	public void case1_2_1() throws InterruptedException {

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
//			ClickXpath(MyInfo_Tag_AccountSecurity_Xpath);
			
			//locate [117,1003][885,1158]
			ClickXY(189, 1076, "点击-账号与安全");

			Thread.sleep(2000);
			ClickXY(980,287,"切换账号");
			
			Thread.sleep(2000);
			ClickXY(926,279,"点击本帐号");

			// 单击资料编辑按钮
			Thread.sleep(2000);
			ClickXY(765,266,"点击资料编辑");
//			ClickXpath("com.android.ayplatform.release:id/item_private_head_edit");
			// driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View").click();//单击头像

			// 单击编辑按钮android
			Thread.sleep(2000);
			// ClickXpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View");
			
//			(new TouchAction(driver)).tap(756, 256).perform();

			// 选择头像设置
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/activity_ayprivate_accountinfo_avatar_linear");
			// (new TouchAction(driver)).tap(605, 294).perform();

			// 选择相册照片
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/album_selection");
			// (new TouchAction(driver)).tap(567, 1660).perform();

			// 选择相册
			Thread.sleep(2000);
			ClickXY(160,357,"点击相册");
//			ClickXpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.LinearLayout/android.view.ViewGroup/android.widget.GridView/android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.ImageView");
			// (new TouchAction(driver)).tap(181, 1395).perform();

			// 选择图片
			Thread.sleep(2000);
			ClickXY(498,399,"点击图片");
//			ClickXpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[1]/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView");
			// (new TouchAction(driver)).tap(635, 261).perform();

			// 确认->andrpid控件
			Thread.sleep(2000);
			ClickId("com.android.gallery3d:id/head_select_right");
//			ClickXpath(
//					"	/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/miui.view.ViewPager/android.widget.RelativeLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[1]/android.widget.LinearLayout");
			
			//确认->剪裁
//			Thread.sleep(3000);
//			ClickXpath(
//					"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.GridView/android.widget.RelativeLayout[1]/android.widget.ImageView");
			
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/doing");
			// (new TouchAction(driver)).tap(1013, 147).perform();//截取图片确认
			// Thread.sleep(3000);
			// ClickId(" com.android.ayplatform.release:id/back");
			// (new TouchAction(driver)).tap(63, 134).perform();//截取图片返回

			Thread.sleep(3000);
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

	public void InPutById(String Id, String Text) {
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

	public void InPutByXpath(String Xpath, String Text) {
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

	public void CheckXpath(String Xpath, String Text) {
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

	public void ClickXY(int X, int Y, String explain) {

		try {

			(new TouchAction(driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y + "  this is -> " + explain);
		} catch (Error e) {
			screenSnap();
			AppBase.textPrint("click loacte act Fail!");
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
			screenSnap();
		}
	}

	public void waitForId(String Text, String Id) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= waitTime)// 60秒市场区间
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
	public void CheckFor(String ElementType, String ElementInfo) {
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

	/*
	 * "fingers" how much fingers are you try to touch
	 *
	 * "element" witch element you want to use
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void TapClick(int fingers, WebElement element, int duration) throws InterruptedException {
		driver.tap(fingers, element, duration);
	}

	/*
	 * "fingers" how much fingers are you try to chouch
	 *
	 * "X/Y" is you touch location on screen
	 *
	 * "duration" how much time you want to press the phone
	 */
	public void TapClickXY(int fingers, int X, int Y, int duration) throws InterruptedException {

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