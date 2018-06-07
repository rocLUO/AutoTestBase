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
package com.xuefei;

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

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

public class case3_4 extends TestInfo {
	private static AppiumDriver driver;

	// 工作圈
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

	/*
	 * @author luopeng Last_Update 2018年4月24日上午9:44:22
	 *
	 * 流程体提交
	 *
	 */
	@Test(description = "我的发起-处理")
	public void case3_4_1() throws InterruptedException {

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);
			// driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");
			// driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();//打开流程
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/flow_detail_submit_Button");
			// driver.findElementById("com.android.ayplatform.release:id/flow_detail_submit_Button").click();//点击提交

		} catch (Error e) {
			screenSnap();
		}

		Thread.sleep(1000);
		driver.closeApp();
		Thread.sleep(2000);

	}

	@Test(description = "我的发起-抄送")
	public void case3_4_2() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);// 我发起的

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");// 打开流程

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");// 点击更多

			Thread.sleep(3000);
			ClickXpath("//android.widget.TextView[@text='抄送']");// 点击抄送

			// 防止组织架构无法自动加载
			Thread.sleep(1000);
			swipXY(517, 376, 517, 1761);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='测试部门1']");

			// 选择 111
			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='111']");

			// 确定
			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/orgstructure_colleagues_display_submit");

			Thread.sleep(1000);

		} catch (Error e) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(2000);
	}

	@Test(description = "我的发起-委托")
	public void case3_4_3() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);// 我发起的

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");// 打开流程

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/more");// 点击三个点

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='委托']");// 点击委托

			// 防止组织架构无法自动加载
			Thread.sleep(1000);
			swipXY(517, 376, 517, 1761);

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='测试部门1']");

			// 选择 autotest 接受账号
			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='111']");

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/org_search_display_submit");// 点击确定

			Thread.sleep(1000);

		} catch (Error e) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(2000);
	}

	@Test(description = "我的发起-回退")
	public void case3_4_4() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/more");

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='回退']");

			Thread.sleep(2000);
			ClickXpath("//android.widget.Button[@text='确定']");

			Back();

			Thread.sleep(1000);

		} catch (Error e) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(2000);
	}

	@Test(description = "我的发起-历史记录")
	public void case3_4_5() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);
			// driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");
			// driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();//打开流程

			Thread.sleep(1000);
			ClickId("com.android.ayplatform.release:id/more");
			// driver.findElementById("com.android.ayplatform.release:id/more").click();//点击三个点

			Thread.sleep(1000);
			ClickXpath("//android.widget.TextView[@text='历史记录']");
			// driver.findElementByXPath("//android.view.ViewGroup[3]").click();//点击历史记录

			Thread.sleep(2000);
			Back();

			Thread.sleep(1000);
			Back();

		} catch (Error e) {
			screenSnap();
		}

		Thread.sleep(1000);
		driver.closeApp();
		Thread.sleep(2000);
	}

	@Test(description = "我的发起-中断")
	public void case3_4_6() throws InterruptedException {
		
		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);
			// driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//我发起的

			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");
			// driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();//打开流程

			Thread.sleep(2000);
			ClickId("com.android.ayplatform.release:id/more");
			// driver.findElementById("com.android.ayplatform.release:id/more").click();//点击三个点

			Thread.sleep(2000);
			ClickXpath("//android.widget.TextView[@text='中断']");
			// driver.findElementByXPath("//android.view.ViewGroup[2]").click();//点击中断

			Thread.sleep(2000);
			InPutById("com.android.ayplatform.release:id/et_msg", "testestest");
			// driver.findElementById("com.android.ayplatform.release:id/et_msg").sendKeys("zyw");//点击确定

			Thread.sleep(2000);
			ClickXpath("//android.widget.Button[@text='确定']");

			Thread.sleep(1000);
			/*
			 * ClickXpath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
			 * ); // driver.findElementByXPath(
			 * "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
			 * ).click();//点击确定
			 */

		} catch (Error e) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(1000);
	}

	@Test(description = "我的发起-批注")
	public void case3_4_7() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();// 我发起的
			Thread.sleep(3000);
			driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();// 打开流程
			Thread.sleep(3000);
			driver.findElementById("com.android.ayplatform.release:id/comment").click();// 点击评论
			Thread.sleep(3000);
			driver.findElementById("com.android.ayplatform.release:id/input_box_view_input_sms").sendKeys("zyw");// 点击输入框，输入文字
			Thread.sleep(3000);
			driver.findElementById("com.android.ayplatform.release:id/input_box_view_send_sms").click();// 点击确定

		} catch (Error E) {
			screenSnap();
		}

		driver.closeApp();
		Thread.sleep(1000);

	}

	@Test(description = "我的发起-批注")
	public void case3_4_8() throws InterruptedException {

		driver.launchApp();

		try {

			Thread.sleep(3000);
			ClickXpath(MainPage_Tag_MyLaunch_Xpath);
			// driver.findElementByXPath(MainPage_Tag_MyLaunch_Xpath).click();//
			// 我发起的
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1");
			// driver.findElementById("com.android.ayplatform.release:id/workbench_module_i_started_item1").click();//
			// 打开流程
			Thread.sleep(3000);
			ClickId("com.android.ayplatform.release:id/more");
			// driver.findElementById("com.android.ayplatform.release:id/more").click();//
			// 点击三个点
			Thread.sleep(3000);
			ClickXpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[6]/android.widget.TextView[2]");
			// driver.findElementByXPath(
			// "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.ListView/android.view.ViewGroup[6]/android.widget.TextView[2]")
			// .click();// 点击删除
			Thread.sleep(3000);
			ClickXpath(
					"/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]");
			// driver.findElementByXPath(
			// "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]")
			// .click();// 点击确定

		} catch (Error e) {
			driver.closeApp();
			Thread.sleep(1000);
		}
	}

	private void waitForId(String string) {
		// TODO Auto-generated method stub

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
			AppBase.snapshot();
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
			AppBase.snapshot();
		}
	}

	public void swipXY(int X1, int Y1, int X2, int Y2) throws InterruptedException {
		driver.swipe(X1, Y1, X2, Y2, 1000);
	}

	public void Back() {
		driver.navigate().back();
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
