
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

public class case2_1_3  extends TestInfo {
	private static AppiumDriver driver;
//雷敏 群组发文字消息和图片消息
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
		ClickId(QiLiao_CreatGroup_Id);
//		driver.findElementById("com.android.ayplatform.release:id/create_group").click();
/*
		//点击张宗超
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(399, 301).perform();
		//点击杜磊
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(343, 513).perform();
		//点击完成
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(650, 89).perform();
		//点击发送表情符
		
		//Thread.sleep(3000);
		//driver.findElementById("com.android.ayplatform.release:id/rc_emoticon_toggle").click();
		//点击输入框
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(170, 1225).perform();
		//点击h
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(430, 993).perform();
		
		//点击发送
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(670, 673).perform();

		//点击加号
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(661, 678).perform();
		
		//点击图片
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(98, 857).perform();
		//点击选中的图片
		Thread.sleep(3000);
		(new TouchAction(driver)).tap(444, 405).perform();
*/
		
		Thread.sleep(2000);
		// 点击人员-1
		ClickXY(543, 386);

		// 点击张宗超
		 (new TouchAction(driver)).tap(399, 301).perform();

		Thread.sleep(2000);
		// 点击人员-2
		ClickXY(468, 594);

		// 点击完成---此为动态控件 xpath无法定位
		Thread.sleep(2000);
		ClickXY(992, 128);
		
		Thread.sleep(2000);
		ClickId(QiLiao_More);
		
/* 拍照应用因机型不同,参数与UI不同.故不适用	
 
		//图片
		Thread.sleep(2000);
		ClickXpath(QiLaio_More_pic_Xpath);
		
		Thread.sleep(2000);
		

		//点击->拍照
		ClickXY(167,375);
		
		//进入相机应用
		Thread.sleep(3000);
		//通用拍照
		((AndroidDeviceActionShortcuts) driver).pressKeyCode(AndroidKeyCode.KEYCODE_CAMERA);
*/		
		
		ClickXpath("//android.widget.ImageView//android.widget.RelativeLayout[3]");
		
		Thread.sleep(2000);
		ClickId("com.android.ayplatform.release:id/send");
		
		//点击发送
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform.release:id/send").click();
		
		
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
