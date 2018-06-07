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

import com.appium.TestBase.TestInfo;

public class case4_1_5 extends TestInfo {
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
		 中文输入,隐藏键盘启动
		capabilities.setCapability("unicodeKeyboard", "True");
        capabilities.setCapability("resetKeyboard", "True");
        */
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);

	}

	@Test
	public void case4_1_3()throws InterruptedException {
		
	
		Thread.sleep(3000);
		driver.findElementByXPath(MainPage_Search_Id).click();
		
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform:id/activity_worksearch_rl").click();
		
		//搜索应用
		Thread.sleep(3000);
		driver.findElementById("com.android.ayplatform:id/filter_edit").click();
		Thread.sleep(3000);
		//输入1，点击搜索
		(new TouchAction(driver)).tap(205, 788).perform();
		(new TouchAction(driver)).tap(46, 672).perform();
		(new TouchAction(driver)).tap(671, 1125).perform();
		Thread.sleep(3000);
		driver.findElementByXPath("//android.support.v7.widget.RecyclerView/android.widget.LinearLayout[2]").click();
		Thread.sleep(3000);
		//点击评论按钮
		driver.findElementById("com.android.ayplatform:id/comment").click();
		Thread.sleep(3000);
		
		
		//driver.swipe(, starty, endx, endy, duration);
	}

	@AfterClass
	public void tearDown() throws Exception {
		textPrint("test end!");
		driver.quit();

	}
	
	//账号登录
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
	
	//输入字符
	public static void textPrint(String Text) {
		System.out.println(getCurrentSystemTime()+"...:"+Text+" ");
	}
	
	//获取时间
    public static String getCurrentSystemTime() {
        Date now = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        String time = dateFormat.format(now);
        return time;
    }
    
    //截图
    //snapshot((TakesScreenshot)driver);
    public static void snapshot() {
        String currentpath = System.getProperty("user.dir");// get current work folder
        File scrFile = driver.getScreenshotAs(OutputType.FILE); 
        try {
            System.out.println("save snapshot path is:" + currentpath + "\\" + getCurrentSystemTime() + "\n");
            FileUtils.copyFile(scrFile, new File(currentpath + "\\" + getCurrentSystemTime()));// save screenshot
        } catch (IOException e) {
            System.out.println("Cannot take screenshot");
            e.printStackTrace();
        } finally{
            System.out.println("already saved screenshot in:" + currentpath); 
       }
    }
	
    
    // 等待xpath控件出现
    public void waitForXpath(String Name, String Xpath) throws InterruptedException {
        for (int second = 0;; second++) {
            if (second >= 60) fail("timeout");
            try {
                if (Name.equals(driver.findElementByXPath(Xpath))) break;
                Thread.sleep(2);

            } catch(Exception e) {
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
    
    public void CheckXpath(String Xpath,String Text){
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
    
    
    


}
