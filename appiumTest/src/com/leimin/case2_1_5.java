
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

public class case2_1_5  extends TestInfo {
	private static AppiumDriver driver;
//雷敏通讯录我的群组
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
				driver.findElementByXPath("//android.widget.TextView[@text='启聊']").click();
		
				Thread.sleep(3000);
				driver.findElementByXPath("//android.widget.TextView[@text='通讯录']").click();

				Thread.sleep(3000);
				(new TouchAction(driver)).tap(162, 371).perform();
				Thread.sleep(3000);
				driver.swipe(382,665,4,92,500);
				Thread.sleep(3000);
				(new TouchAction(driver)).tap(267, 483).perform();
		
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
				//点击发送
				Thread.sleep(3000);
				driver.findElementById("com.android.ayplatform.release:id/send").click();
				
				//点击群组头像
				Thread.sleep(3000);
				driver.findElementById("com.android.ayplatform.release:id/chat_action_btn").click();
				//点击群组名称
				Thread.sleep(3000);
				//(new TouchAction(driver)).tap(120, 299).perform();
				driver.findElementById("com.android.ayplatform.release:id/item_message_value").click();
				//点击编辑
				Thread.sleep(3000);
				driver.findElementById("com.android.ayplatform.release:id/activity_modify_groupname_content").click();
			
				//删除
				Thread.sleep(3000);
				(new TouchAction(driver)).tap(660, 1097).perform();

				//点击关闭键盘
				Thread.sleep(3000);
				(new TouchAction(driver)).tap(660, 765).perform();
				
				//点击保存
				Thread.sleep(3000);
				driver.findElementById("com.android.ayplatform.release:id/doing").click();
	    
		}
	
		
	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");
		driver.quit();

	}
	
	
	/*
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
	*/
	

	
    /*
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
                AppBase.textPrint("Page--> " + driver.getTitle() + "  :loding error");
                driver.quit();
                AppBase.snapshot();
            }
            Thread.sleep(1000);
            AppBase.textPrint("XpathButton--> " + Name + "  :cannot found!");
        }
    }
    */
	/*
    public void CheckXpath(String Xpath,String Text){
    	try {
			AppBase.textPrint("Check The Text For Xpath!");
	      	assertEquals(driver.findElement(By.xpath(Xpath)).getText(), Text);
	      	AppBase.textPrint("Check Success!");
	    } catch (Error e) {
	    	AppBase.textPrint("Check Fail!");
	    	e.printStackTrace();
	    	AppBase.snapshot();
	    }
    }
    */
    
    


}
