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

public class case3_4_2 extends TestInfo {
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
	 * 抄送
	 *
	 */
	@Test(description = "我的发起-抄送")
	public void plus() throws InterruptedException {

		Thread.sleep(3000);
		AppBase.ClickXpath(MainPage_Tag_MyLaunch_Xpath,driver);// 我发起的

		Thread.sleep(3000);
		AppBase.ClickId("com.android.ayplatform.release:id/workbench_module_i_started_item1",driver);// 打开流程

		Thread.sleep(3000);
		AppBase.ClickId("com.android.ayplatform.release:id/more",driver);// 点击更多

		Thread.sleep(3000);
		AppBase.ClickXpath("//android.widget.TextView[@text='抄送']",driver);// 点击抄送

		// 防止组织架构无法自动加载
		Thread.sleep(1000);
		AppBase.swipXY(517, 376, 517, 1761,driver);

		Thread.sleep(2000);
		AppBase.ClickXpath("//android.widget.TextView[@text='测试部门1']",driver);

		// 选择 111
		Thread.sleep(2000);
		AppBase.ClickXpath("//android.widget.TextView[@text='111']",driver);

		// 确定
		Thread.sleep(2000);
		AppBase.ClickId("com.android.ayplatform.release:id/orgstructure_colleagues_display_submit",driver);

		Thread.sleep(1000);

	}

	private void waitForId(String string) {
		// TODO Auto-generated method stub

	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}

}
