/**
 * com.readyData
 * appiumTest
 * createNewWork.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月24日 上午10:45:07
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
import io.appium.java_client.android.AndroidDriver;

public class createNewWork_release extends TestInfo {
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
	@Test(description = "主窗口与ifram之间的切换")
	public void NewWork() throws InterruptedException {

		int i = 1;
		while (1 < 2) {
			try {
				Thread.sleep(3000);
				AppBase.ClickId("com.android.ayplatform.release:id/click_img", driver);

				Thread.sleep(3000);
				AppBase.ClickXpath("//android.widget.TextView[@text='想喝花雕么']", driver);

				Thread.sleep(3000);
				driver.findElementByXPath(
						"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
						.sendKeys("test" + i);

				Thread.sleep(3000);
				// 添加接收人
				AppBase.ClickId("com.android.ayplatform.release:id/org_add_user_imageView", driver);

				Thread.sleep(3000);
				// ClickXpath("//android.widget.TextView[@text='测试部门1']");
				AppBase.ClickXpath("//android.widget.TextView[@text='九五之尊']", driver);
				// //上划
				// Thread.sleep(3000);
				// swipXY(536, 1805, 565, 341);
				//
				// //上划
				// Thread.sleep(1500);
				// swipXY(536, 1805, 565, 341);

				Thread.sleep(1000);
				AppBase.ClickXpath("//android.widget.TextView[@text='111']", driver);

				Thread.sleep(1000);
				// 确定
				AppBase.ClickId("com.android.ayplatform.release:id/orgstructure_colleagues_display_submit", driver);

				Thread.sleep(3000);
				AppBase.ClickId("com.android.ayplatform.release:id/flow_detail_submit_Button", driver);

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
