/**
 * com.readyData
 * appiumTest
 * reateNewWork_newProtal.java
 *
 * Created on 2018年7月3日 下午2:15:36
 *
 * Created by LuoPeng
 */
package com.readyData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.net.URL;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/*
 *@author luopeng
 *Last_Update 2018年7月3日下午2:15:36
 *
 */
public class reateNewWork_newProtal extends TestInfo{
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
				Thread.sleep(5000);
				
				AppBase.clickXpath("//android.widget.TextView[@text='门户']", driver);
				Thread.sleep(2000);

				//默认测试门户 快捷入口在下方
				AppBase.swipXY(585, 1805, 585, 249, driver);
				Thread.sleep(2000);

				//点击 快捷入口 默认第一个入口
				AppBase.clickXpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", driver);
				Thread.sleep(2000);

				//快捷入口配置 进入创建页
				//输入框,输入内容1
				driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]").sendKeys("TestTest");
				Thread.sleep(2000);

				//输入框,输入内容2
				driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]").sendKeys("TestTest");
				Thread.sleep(2000);

				//点击 添加接受人
				AppBase.clickId("com.android.ayplatform"+type+":id/org_add_user_imageView", driver);
				Thread.sleep(2000);

				//滑动到最下,默认接收测试帐号部门在最底
				AppBase.swipXY(504, 1752, 504, 347, driver);
				Thread.sleep(3000);

				//点击 "autotest" 部门
				AppBase.clickXpath("//android.widget.TextView[@text='autoTest']", driver);
				Thread.sleep(2000);

				//点击 接收人 autoAcunt01
				AppBase.clickXpath("//android.widget.TextView[@text='autoAccunt01']", driver);
				Thread.sleep(2000);

				//点击 确定 选择
				AppBase.clickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", driver);
				Thread.sleep(2000);

				//点击提交选择
				AppBase.clickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", driver);
				Thread.sleep(3000);

				AppBase.textPrint("is round -->"+i);
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
