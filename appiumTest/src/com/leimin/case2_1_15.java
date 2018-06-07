
package com.leimin;

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

public class case2_1_15 extends TestInfo {
	private static AppiumDriver driver;

	// 雷敏 启聊和通讯录的切换
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
	}

	@Test(description = "启聊导航栏切换与会话/通讯录切换")
	public void case2_1_1() throws InterruptedException {

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Bar_QiLiao_Xpath);
			// driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();

			Thread.sleep(2000);
			ClickXpath(QiLiao_MailList_Xpath);
			// driver.findElementByXPath("//android.widget.TextView[@text='通讯录']").click();

			Thread.sleep(2000);
			ClickXpath(QiLiao_Chat_Xpath);
			// driver.findElementByXPath("//android.widget.TextView[@text='会话']").click();

			Thread.sleep(2000);
			ClickId(QiLiao_CreatGroup_Id);
			// driver.findElementById("com.android.ayplatform:id/create_group").click();

		} catch (Error e) {

			screenSnap();
		}

		Thread.sleep(1000);
		driver.closeApp();

	}

	@Test(description = "群聊天-创建")
	public void case2_1_23() throws InterruptedException {

		Thread.sleep(2000);
		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Bar_QiLiao_Xpath);
			// driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();

			Thread.sleep(2000);
			ClickId(QiLiao_CreatGroup_Id);
			// driver.findElementById("com.android.ayplatform.release:id/create_group").click();

			Thread.sleep(2000);
			// 点击人员-1
			ClickXY(543, 386, "选择人员-1");

			// 点击张宗超
			// (new TouchAction(driver)).tap(399, 301).perform();

			Thread.sleep(2000);
			// 点击人员-2
			ClickXY(468, 594, "选择人员-2");

			// 点击杜磊
			// (new TouchAction(driver)).tap(343, 513).perform();

			// 点击完成---此为动态控件 xpath无法定位
			Thread.sleep(2000);
			// ClickId("com.android.ayplatform.release:id/head_right");
			ClickXY(992, 128, "点击完成");
			// ClickXpath("//android.widget.TextView[@text='完成(2)']");

			// (new TouchAction(driver)).tap(650, 89).perform();

			// 选定
			// ((AndroidDeviceActionShortcuts)
			// driver).pressKeyCode(AndroidKeyCode.ENTER);
			// 确定
			// ((AndroidDeviceActionShortcuts)
			// driver).pressKeyCode(AndroidKeyCode.ENTER);

			Thread.sleep(2000);
			// 点击 输入框-》光标显示/焦点
			ClickId("com.android.ayplatform.release:id/rc_edit_text");

			// 切换 appium 输入
			Thread.sleep(2000);
			excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME");

			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/rc_edit_text", "testtest");

			// 表情
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/rc_emoticon_toggle");
			// driver.findElementById("com.android.ayplatform.release:id/rc_emoticon_toggle").click();

			// 点击表情
			Thread.sleep(3000);
			(new TouchAction(driver)).tap(59, 843).perform();

			// 点击发送
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/rc_send_toggle");
			// (new TouchAction(driver)).tap(670, 698).perform();

			Thread.sleep(3000);
			Back();
			// driver.findElementById("com.android.ayplatform.release:id/rc_layout_item_message").click();

		} catch (Error e) {

			screenSnap();

		}

		Thread.sleep(1000);
		driver.closeApp();
	}

	@Test(description = "群聊天-编辑")
	public void case2_1_4() throws InterruptedException {

		Thread.sleep(2000);
		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Bar_QiLiao_Xpath);

			// 上接着case2_1_23,已建立聊天组

			Thread.sleep(2000);
			// 讨论组无Id/xpath特征
			ClickXY(552, 315, "点击讨论组");

			Thread.sleep(2000);
			// 讨论组信息
			ClickId("com.android.ayplatform.release:id/chat_action_btn");

			Thread.sleep(2000);
			// 点击群组名称 无id与xpath特征
			(new TouchAction(driver)).tap(635, 528).perform();
			// ClickXpath("//android.widget.TextView[@text='群组名称']");

			Thread.sleep(2000);
			// case2.1.23 已切换至unicode输入法
			InPutById("com.android.ayplatform.release:id/activity_modify_groupname_content", "testestest");

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/doing");

			Thread.sleep(2000);
			// 后退至聊天列表
			Back();
			Thread.sleep(1000);
			// 后退至主页面
			Back();

		} catch (Error e) {

			Thread.sleep(2000);
			screenSnap();

		}

		Thread.sleep(1000);
		driver.closeApp();
	}

	@Test(description = "通讯录-我的群组")
	public void case2_1_5() throws InterruptedException {

		Thread.sleep(2000);
		driver.launchApp();

		try {

			Thread.sleep(3000);
			// 启聊
			ClickXpath(MainPage_Bar_QiLiao_Xpath);

			// 通讯录
			Thread.sleep(2000);
			ClickXpath(QiLiao_MailList_Xpath);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='我的群组']");

			// 测试企业--群组
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/item_group_manager_name");

			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/rc_edit_text", "testestest");

			// 发送
			Thread.sleep(1000);
			ClickId("com.android.ayplatform.release:id/rc_send_toggle");

			driver.closeApp();

		} catch (Error e) {

			screenSnap();

		}

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

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
				AppBase.textPrint("Page--> " + driver.getTitle() + "  :loding error");
				driver.quit();
				AppBase.screenSnap(driver);
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
			AppBase.screenSnap(driver);
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

	public static void ClickXpath(String Xpath) {
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

	public void ClickXY(int X, int Y, String explain) {

		try {

			(new TouchAction(driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y + "  this is -> " + explain);
		} catch (Error e) {
			screenSnap();
			AppBase.textPrint("click loacte act Fail!");
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

	private void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}
	}

	public void Back() {
		driver.navigate().back();
	}

}
