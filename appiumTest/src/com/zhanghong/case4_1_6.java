package com.zhanghong;

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
import java.util.concurrent.TimeUnit;

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

public class case4_1_6 extends TestInfo {
	private static AppiumDriver driver;

	@BeforeClass
	public void setup() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.BROWSER_NAME, "");
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
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(description= "搜索-历史搜索")
	public void case4_1_6() throws InterruptedException {

		try {

			Thread.sleep(3000);
			ClickId(MainPage_Search_Id);

			Thread.sleep(3000);
			// 紧跟case4_1_3,利用已有历史标签
			ClickXpath("//android.widget.TextView[@text='auto']");
			// driver.findElementById("com.android.ayplatform:id/activity_worksearch_rl").click();

			// 点击应用
			Thread.sleep(3000);
			ClickXY(537, 1090, "点击工作");

			// driver.findElementById("com.android.ayplatform:id/filter_edit").click();
			// Thread.sleep(3000);
			// // 输入1，点击搜索
			// (new TouchAction(driver)).tap(205, 788).perform();
			// (new TouchAction(driver)).tap(46, 672).perform();
			// (new TouchAction(driver)).tap(671, 1125).perform();
			//
			// // 返回工作台页面
			// Thread.sleep(3000);
			// driver.findElementById("com.android.ayplatform:id/activity_back_iv").click();
			// // 再次进入搜索
			// Thread.sleep(3000);
			// driver.findElementByXPath(MainPage_Search_Id).click();
			// // 搜索历史
			// Thread.sleep(3000);
			// driver.findElementByXPath(
			// "//android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[1]")
			// .click();
			// Thread.sleep(3000);
			// driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]")
			// .click();
			Thread.sleep(2000);
			Back();

			Thread.sleep(1000);
			Back();
			// // 点击评论按钮
			// driver.findElementById("com.android.ayplatform:id/comment").click();

			// driver.swipe(, starty, endx, endy, duration);

		} catch (Error e) {
			screenSnap();
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		textPrint("test end!");
		driver.quit();

	}

	// 账号登录
	public void login() throws InterruptedException {
		// 用户名输入
		Thread.sleep(5000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/cardNumAuto").sendKeys("admin_pretest");
		Thread.sleep(2000);
		// 密码输入
		driver.findElementById("com.android.ayplatform:id/Pass").clear();
		Thread.sleep(2000);
		driver.findElementById("com.android.ayplatform:id/Pass").sendKeys("11111111");
		Thread.sleep(2000);
		// HTC U11 关闭输入法键盘
		driver.navigate().back();
		Thread.sleep(2000);
		// 登录
		driver.findElementById("com.android.ayplatform:id/login").click();
		Thread.sleep(2000);
	}

	// 输入字符
	public static void textPrint(String Text) {
		System.out.println(getCurrentSystemTime() + "...:" + Text + " ");
	}

	// 获取时间
	public static String getCurrentSystemTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}

	// 截图
	// snapshot((TakesScreenshot)driver);
	public static void snapshot() {
		String currentpath = System.getProperty("user.dir");// get current work
															// folder
		File scrFile = driver.getScreenshotAs(OutputType.FILE);
		try {
			System.out.println("save snapshot path is:" + currentpath + "\\" + getCurrentSystemTime() + "\n");
			FileUtils.copyFile(scrFile, new File(currentpath + "\\" + getCurrentSystemTime()));// save
																								// screenshot
		} catch (IOException e) {
			System.out.println("Cannot take screenshot");
			e.printStackTrace();
		} finally {
			System.out.println("already saved screenshot in:" + currentpath);
		}
	}

	// 等待xpath控件出现
	public void waitForXpath(String Name, String Xpath) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (Name.equals(driver.findElementByXPath(Xpath)))
					break;
				Thread.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				textPrint("Page--> " + driver.getTitle() + "  :loding error");
				driver.quit();
				snapshot();
			}
			Thread.sleep(1000);
			textPrint("XpathButton--> " + Name + "  :cannot found!");
		}
	}

	public void CheckXpath(String Xpath, String Text) {
		try {
			textPrint("Check The Text For Xpath!");
			assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
			textPrint("Check Success!");
		} catch (Error e) {
			textPrint("Check Fail!");
			e.printStackTrace();
			snapshot();
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

	private void excuteAdbShell(String s) {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec(s);
		} catch (Exception e) {
			System.out.println("执行命令:" + s + "出错");
		}

	}

	public void ClickXY(int X, int Y, String explain) {

		try {

			(new TouchAction(driver)).tap(X, Y).perform();
			AppBase.textPrint("click locate ->" + X + " , " + Y + "  this is -> " + explain);
		} catch (Error e) {
			screenSnap();
			AppBase.textPrint("click loacte act Fail!");
		}
	}

}
