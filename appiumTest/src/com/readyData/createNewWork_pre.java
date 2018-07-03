/**
 * com.readyData
 * appiumTest
 * createNewWork_pre.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年5月2日 上午10:50:46
 *
 * Created by LuoPeng
 */
package com.readyData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class createNewWork_pre extends TestInfo {
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

	/*
	 * @author luopeng Last_Update 2018年4月24日上午10:50:13
	 *
	 * 发起流程:想喝花雕么
	 *
	 */
	@Test(description = "pre环境 流程新建")
	public void NewWork() throws InterruptedException {

		Thread.sleep(3000);
		AppBase.clickXY(747, 1944, "点击->应用", driver);
		Thread.sleep(3000);
		// 上划
		AppBase.swipXY(524, 1862, 524, 217, driver);
		Thread.sleep(2000);
		// 重复
		AppBase.swipXY(524, 1862, 524, 217, driver);

		int i = 0;
		while (i < 1) {
			try {
				Thread.sleep(2000);
				AppBase.clickXpath("//android.widget.TextView[@text='autotest']", driver);

				Thread.sleep(2000);
				// 点击工作
				AppBase.clickXY(338, 404, "点击工作", driver);

				Thread.sleep(3000);
				AppBase.clickId("com.android.ayplatform.pre:id/activity_info_new", driver);
				Thread.sleep(2000);

				AppBase.excuteAdbShell("adb shell ime set io.appium.android.ime/.UnicodeIME", driver);
				Thread.sleep(1000);
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
						.sendKeys("test" + i);

				Thread.sleep(3000);
				// 添加接收人
				AppBase.clickId("com.android.ayplatform.pre:id/org_add_user_imageView", driver);

				Thread.sleep(3000);
				// clickXpath("//android.widget.TextView[@text='测试部门1']");
				AppBase.clickXpath("//android.widget.TextView[@text='九五之尊']", driver);
				// //上划
				// Thread.sleep(3000);
				// swipXY(536, 1805, 565, 341);
				//
				// //上划
				// Thread.sleep(1500);
				// swipXY(536, 1805, 565, 341);

				Thread.sleep(3000);
				AppBase.clickXpath("//android.widget.TextView[@text='111']", driver);

				Thread.sleep(3000);
				// 确定
				AppBase.clickId("com.android.ayplatform.pre:id/orgstructure_colleagues_display_submit", driver);

				Thread.sleep(3000);
				//提交
				//				clickId("com.android.ayplatform.pre:id/flow_detail_submit_Button");

				//保存
				AppBase.clickId("com.android.ayplatform.pre:id/flow_detail_save_Button", driver);
				Thread.sleep(1000);
				AppBase.Back(driver);
				Thread.sleep(1000);
				AppBase.Back(driver);
				Thread.sleep(1000);

				i++;
			} catch (Error e) {
				AppBase.screenSnap(driver);
			}
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}
}
