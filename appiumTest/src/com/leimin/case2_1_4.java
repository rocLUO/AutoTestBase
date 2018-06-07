
package com.leimin;

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

public class case2_1_4  extends TestInfo {
	private static AppiumDriver driver;
//雷敏 群聊天编辑
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
		 中文输入,隐藏键盘启动
		capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		}
	

	
	@Test
	public void plus()throws InterruptedException {
		
		Thread.sleep(3000);
		ClickXpath(MainPage_Bar_QiLiao_Xpath);
//		driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
			
		Thread.sleep(3000);
		//讨论组无Id/xpath特征
		ClickXY(552,315);
//		driver.findElementById("com.android.ayplatform.release:id/create_group").click();
//		//点击张宗超
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(399, 301).perform();
//		//点击杜磊
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(343, 513).perform();
//		//点击完成
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(650, 89).perform();
		
		//点击群组头像
		Thread.sleep(3000);
		ClickId("com.android.ayplatform.release:id/chat_action_btn");
//		driver.findElementById("com.android.ayplatform.release:id/chat_action_btn").click();
		
		//点击群组名称  无id与xpath特征
		Thread.sleep(3000);
//		ClickXpath("//android.widget.ImageView[@index='2']");
		(new TouchAction(driver)).tap(635, 528).perform();
//		driver.findElementById("om.android.ayplatform.release:id/item_message_value").click();
		
//		//点击编辑
//		Thread.sleep(3000);
//		driver.findElementById("com.android.ayplatform.release:id/activity_modify_groupname_content").click();
	
//		//删除
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 1097).perform();
//		//点击关闭键盘
//		Thread.sleep(3000);
//		(new TouchAction(driver)).tap(660, 765).perform();
		
		Thread.sleep(2000);
		InPutById("com.android.ayplatform.release:id/activity_modify_groupname_content","testestest");
		
		//点击保存
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform.release:id/doing").click();
		
		Thread.sleep(2000);
		//后退至聊天列表
		Back();
		Thread.sleep(1000);
		//后退至主页面
		Back();
		
		}
	
		
	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

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

	public void ClickXY(int X, int Y) {

		try {

			(new TouchAction(driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y);

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
