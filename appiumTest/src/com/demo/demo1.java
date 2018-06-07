package com.demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.net.URL;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.appium.TestBase.AppBase;


public class demo1 {
	private AppiumDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
		cap.setCapability("platformName", "Android"); // 指定测试平台
		cap.setCapability("deviceName", "MKJNW17C20005057"); // 指定测试机的ID,通过adb命令`adb
																// devices`获取
		cap.setCapability("platformVersion", "8.0");

		// 将上面获取到的包名和Activity名设置为值
		cap.setCapability("appPackage", "com.android.ayplatform");
		cap.setCapability("appActivity", "com.android.ayplatform.activity.WelcomeActivity");

		// A new session could not be created
		// cap.setCapability("appWaitActivity","com.android.ayplatform.activity.WelcomeActivity");

		// 每次启动时覆盖session，否则第二次后运行会报错不能新建session
		cap.setCapability("sessionOverride", true);
		// 解决每次启动APP需要确认权限问题--即不重复安装
		cap.setCapability("noReset", true);
		cap.setCapability("noSign", true);

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);

	}

	@Test
	public void plus() throws InterruptedException {

		/*
		 * int width=driver.manage().window().getSize().width;
		 * 
		 * int height=driver.manage().window().getSize().height;
		 * 
		 * int y1 = height*3/4; //上滑的开始点，从y1开始也就是屏幕的四分之三处
		 * 
		 * int y2 = height*1/4; //上滑的结束点，到y2结束也就是屏幕的四分之一处
		 * 
		 * TouchAction tAction = new TouchAction(driver);
		 * 
		 * tAction.press(width/2,y1).waitAction(200).moveTo(width/2,y2).release(
		 * ).perform();
		 */
		//login();

		Thread.sleep(3000);
		// AppiumBase.clickText("最近处理");
		driver.findElementByXPath("//android.widget.TextView[@text='我发起的']").click();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.widget.TextView[@text='待办工作']").click();
		// 选择已办流程
		driver.findElementById("com.android.ayplatform:id/workbench_module_item1_content").click();
		Thread.sleep(3000);
		/*
		 * driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.TextView")
		 * .click(); Thread.sleep(3000); driver.findElementByXPath(
		 * "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout[5]/android.widget.LinearLayout/android.widget.ImageView")
		 * .click();
		 */
		Thread.sleep(3000);
		driver.swipe(500, 1634, 500, 144, 200);
		Thread.sleep(3000);
		driver.swipe(500, 1634, 500, 144, 200);
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform:id/slave_add_TextView").click() ;
		Thread.sleep(5000);
		// 点击输入内容
		// driver.findElementById("com.android.ayplatform:id/view_textui_valueTv").click();
		(new TouchAction(driver)).tap(437, 437).perform();
		Thread.sleep(5000);
		// 请输入内容
		driver.findElementById("com.android.ayplatform:id/activity_textui_edt_content").sendKeys("testestest");
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/head_right_doing").click();
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/slave_new_save").click();
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/flow_detail_submit_Button").click();
		Thread.sleep(3000);
		/*
		 * Thread.sleep(5000);
		 * driver.findElementById("com.android.ayplatform:id/click_img").click()
		 * ; Thread.sleep(3000); driver.findElementById(
		 * "com.android.ayplatform:id/workbench_menu_item_bg").click();
		 * Thread.sleep(5000); driver.findElementById(
		 * "com.android.ayplatform:id/item_flow_type_TextView").click();
		 * Thread.sleep(3000); driver.findElementById(
		 * "com.android.ayplatform:id/flow_detail_submit_Button").click();
		 * Thread.sleep(3000); driver.swipe(500, 1634, 500, 144, 5);
		 * Thread.sleep(3000); //受理 driver.findElementById(
		 * "com.android.ayplatform:id/work_node_more_View").click();
		 * Thread.sleep(3000); driver.swipe(500, 1634, 500, 144, 5);
		 * Thread.sleep(3000);
		 * 
		 */
	}

	@AfterClass
	public void tearDown() throws Exception {

		driver.quit();

	}
	
	//账号登录
	public void login() throws InterruptedException {
		// 用户名输入
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys("15380424938");
		Thread.sleep(2000);
		// 密码输入
		driver.findElementById("com.android.ayplatform:id/Pass").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/Pass").sendKeys("luo199259");
		Thread.sleep(2000);
		// HTC U11 关闭输入法键盘
		driver.navigate().back();
		Thread.sleep(2000);
		// 登录
		driver.findElementById("com.android.ayplatform:id/login").click();
		Thread.sleep(2000);
	}
	
	public void PageCheck() {
		
	}
	

}
