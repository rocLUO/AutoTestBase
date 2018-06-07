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

public class case3_4_3 extends TestInfo {
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
	 * @author luopeng Last_Update 2018年4月25日上午10:44:22
	 *
	 * 委托
	 *
	 */
	@Test(description = "我的发起-委托")
	public void plus() throws InterruptedException {

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

		/*
		 * 
		 * Thread.sleep(3000); InPutByXpath("//android.widget.LinearLayout[2]",
		 * "zyw");// 输入框里输入zyw
		 * 
		 * Thread.sleep(3000);
		 * ClickId("com.android.ayplatform.release:id/org_search_confirm");//
		 * 点击搜索
		 * 
		 * Thread.sleep(3000); ClickXpath(
		 * "//hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout/android.widget.RelativeLayout"
		 * );// 选中人
		 */

		Thread.sleep(3000);
		ClickId("com.android.ayplatform.release:id/org_search_display_submit");// 点击确定

		/*
		 * Thread.sleep(3000); ClickXpath(
		 * "//hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[2]"
		 * );// 点击确定
		 */
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

		}

	}

	public void swipXY(int X1, int Y1, int X2, int Y2) throws InterruptedException {
		driver.swipe(X1, Y1, X2, Y2, 1000);
	}

}
