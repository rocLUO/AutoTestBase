/**
 * com.luopeng
 * appiumTest
 * case3_2_.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月24日 下午3:13:00
 *
 * Created by LuoPeng
 */
package com.luopeng;

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

public class case3_3 extends TestInfo {
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
	
	@Test(description = "通讯录-成员信息发送")
	public void case2_1_6() throws InterruptedException {

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

			// //输入框焦点
			// Thread.sleep(1000);
			// ClickId("com.android.ayplatform.release:id/rc_edit_text");
			//
			// //输入框格式化
			// Thread.sleep(1000);
			// clearId("com.android.ayplatform.release:id/rc_edit_text");

			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/rc_edit_text", "testestest");

			// 发送
			Thread.sleep(1000);
			ClickId("com.android.ayplatform.release:id/rc_send_toggle");

			

			// driver.swipe(, starty, endx, endy, duration);
		} catch (Error e) {
			screenSnap();
		}
		
			driver.closeApp();
			Thread.sleep(2000);
	}

	@Test(description = "通讯录-成员通话跳转")
	public void case2_1_7() throws InterruptedException {
		
			driver.launchApp();
			
		try {
			
			// 上接case2.1.6

			Thread.sleep(3000);
			// 启聊
			ClickXpath(MainPage_Bar_QiLiao_Xpath);

			Thread.sleep(2000);
			ClickXpath(QiLiao_MailList_Xpath);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='alex-gj']");

			// 商务通话
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/item_chat_colleaguedetail_content_call");
			
			
			
		} catch (Error e) {
			screenSnap();
		}
			
			driver.closeApp();
			Thread.sleep(2000);
		
	}

	//确保 最近处理已有工作-不少于3个
	@Test(description = "最近处理-抄送")
	public void case3_3_2() throws InterruptedException {
			
			driver.launchApp();
		
		try {
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			
			Thread.sleep(3000);
			ClickXpath("//android.widget.TextView[@text='抄送']");
			
			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='测试部门1']");
			
			//选择 autotest 接受账号
			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='111']");
			
			//确定
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/orgstructure_colleagues_display_submit");
			
			Thread.sleep(1000);
			
			
			
			// driver.swipe(, starty, endx, endy, duration);
		} catch ( Error e) {
			screenSnap();
		}
	
			driver.closeApp();
			Thread.sleep(2000);
		
	}
	
	@Test(description = "最近处理-催办")
	public void case3_3_5() throws InterruptedException {

		try {
			
			driver.launchApp();
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			
			Thread.sleep(1000);
			ClickXpath("//android.widget.TextView[@text='催办']");
			
			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/et_msg","testestest");
			
			Thread.sleep(1000);
			ClickXpath("//android.widget.Button[@text='确定']");
			
			Thread.sleep(1000);
			
			driver.closeApp();
			Thread.sleep(2000);
			
		} catch ( Error e) {
			// TODO Auto-generated catch block
			screenSnap();
		}
		
	}
	
	@Test(description = "最近处理-历史记录")
	public void case3_3_6() throws InterruptedException {
		
		try {
			
			driver.launchApp();
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			
			Thread.sleep(3000);
			ClickXpath("//android.widget.TextView[@text='历史记录']");
			
			Thread.sleep(2000);
			Back();
			Thread.sleep(1000);
			Back();
			
			driver.closeApp();
			Thread.sleep(2000);
			
		} catch ( Error e) {
			screenSnap();
		}
		
	}
	
	@Test(description = "最近处理-批注")
	public void case3_3_7() throws InterruptedException {
		
		try {
			driver.launchApp();
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/comment");
			
			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/input_box_view_input_sms","testest");
			
			Thread.sleep(1000);
			ClickId("com.android.ayplatform.release:id/input_box_view_send_sms");
			
			Thread.sleep(1000);
			Back();
			Thread.sleep(1000);
			Back();
			
			driver.closeApp();
			Thread.sleep(2000);
			
		} catch ( Error e) {
			
		}
		
	}
	
	@Test(description = "最近处理-取回")
	public void case3_3_3() throws InterruptedException {
		
		try{
			driver.launchApp();
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			
			Thread.sleep(3000);
			ClickXpath("//android.widget.TextVie[@text='取回']");
			
			Thread.sleep(1000);
			ClickXpath("//android.widget.Button[@text='确定']");
			
			Thread.sleep(1000);
			
			Back();
			
		} catch (Error e) {
			screenSnap();
		}
			driver.closeApp();
			Thread.sleep(2000);
	}
	
	@Test(description = "最近处理-中断")
	public void case3_3_4() throws InterruptedException {
		
		try{
			
			driver.launchApp();
			
			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_Already_Xpath);
			
			//默认点击第一个工作
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1_content");
			
			//更多
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			
			Thread.sleep(3000);
			ClickXpath("//android.widget.TextVie[@text='中断']");
			
			Thread.sleep(1000);
			InPutById("com.android.ayplatform.release:id/et_msg","testest");
			
			Thread.sleep(2000);
			ClickXpath("//android.widget.Button[@text='确定']");
			
			Thread.sleep(1000);
			
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
	
	public void clearId(String Id) {
		try{
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
