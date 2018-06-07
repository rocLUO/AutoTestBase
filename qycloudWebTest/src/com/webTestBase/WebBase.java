/**
 * com.webTestBase
 * qycloudWebTest
 * WebBase.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月20日 下午5:35:19
 *
 * Created by LuoPeng
 */
package com.webTestBase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.webTestBase.screenShootF;

/**
 * @author luopeng Last_Update 2018年5月18日下午15:57:19
 */
public class WebBase extends webTestInfo {

	// intput text
	public static void textPrint(String Text) {
		Reporter.log(getCurrentSystemTime() + "...:" + Text + " ");
	}

	// get time
	public static String getCurrentSystemTime() {
		Date now = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
		String time = dateFormat.format(now);
		return time;
	}

	public static void sleep(int scend) throws InterruptedException {
		int time = scend * 1000;
		Thread.sleep(time);
		textPrint("wait for :" + scend + " scends");
	}

	public static void ScreenShoot(WebDriver Driver) {
		try {
			// ScreenShot(WebDriver dr, String dir)
			textPrint("already catch screen shot!");
			screenShootF.ScreenShotA(Driver, "C:\\selenium\\testShotPic\\");
			if (!(new File("C:\\selenium\\testShotPic\\").isDirectory())) { // 判断是否存在该目录
				new File("C:\\selenium\\testShotPic\\").mkdir(); // 如果不存在则新建一个目录
			}
		} catch (Error e) {
			e.printStackTrace();
			// 杈撳嚭褰撳墠椤甸潰鐨則itle
			textPrint("Page title is: " + Driver.getTitle());
			// 鍏抽棴鎵�鏈墂ebDriver杩涚▼锛岄��鍑�
			Driver.quit();
		}
	}

	public void checkPageName() throws InterruptedException {
		WebBase.textPrint("点击文稿!!");
		;
		inputTime();
	}

	// public void useLogin(String loginPage, String useName, String PASSW,
	// WebDriver Driver) throws InterruptedException {
	// try {
	// Driver.get(loginPage);
	// WebBase.textPrint("打开--> " + loginPage);
	// WebBase.sleep(2);
	//
	// // Page 1
	// handleA();
	// // waitForTitle();
	// clickId("userid");
	// WebBase.sleep(2);
	//
	// clearWordId("userid");
	// WebBase.sleep(2);
	//
	// InPutWordId("userid", useName);
	// WebBase.sleep(2);
	//
	// clearWordId("password");
	// WebBase.sleep(2);
	//
	// InPutWordId("password", PASSW);
	// WebBase.sleep(2);
	// WebBase.textPrint("---->please input the vroteWord!<----");
	// WebBase.sleep(2);
	// inputTime();
	// //验证码输入
	// // Driver.findElement(By.id("veryCode")).click();
	// // Driver.findElement(By.id("veryCode")).clear();
	// // Thread.sleep(2000);
	// // Driver.findElement(By.id("veryCode")).sendKeys("4474");
	// clickId("goLogin");
	// WebBase.textPrint("登录账号");
	// WebBase.sleep(6);
	// } catch(Error e) {
	// e.printStackTrace();
	// WebBase.ScreenShoot(Driver);
	// WebBase.textPrint("Use-> " + useName + " login -->Fail!");
	// Driver.quit();
	// }
	// }

	public void CheckForIdAtt(String Name, String Id, String V, WebDriver Driver) throws InterruptedException {
		if (Name == null && Id == null) {
			WebBase.textPrint("参数为null ");
		} else {
			WebBase.textPrint("字符参数为： " + Name);
			WebBase.textPrint("Id参数为： " + Id);
			WebBase.textPrint("数组参数为: " + V);
		}
		try {
			assertEquals(Name, Driver.findElement(By.id(Id)).getAttribute(V));
			WebBase.sleep(2);
		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);
			WebBase.textPrint("search textName-> " + Name + "  :Fail!");
			WebBase.textPrint("search IdName-> " + Id + "  :Fail!");
			WebBase.textPrint("search Attribute-> " + V + "  :Fail!");
			Driver.quit();
		}
	}

	// 根据ID验证元素存在
	public void CheckForId(String Name, String Id, WebDriver Driver) throws InterruptedException {
		if (Name == null && Id == null) {
			WebBase.textPrint("参数为null");
		} else {
			WebBase.textPrint("字符参数为： " + Name);
			WebBase.textPrint("Id参数为： " + Id);
		}
		try {
			assertEquals(Name, Driver.findElement(By.id(Id)).getText());
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);
		}
	}

	// 验证CSS定位元素
	public void CheckForCSS(String TextName, String CssButtonName, WebDriver Driver) throws InterruptedException {
		if (TextName == null && CssButtonName == null) {
			WebBase.textPrint("参数为null");
		} else {
			WebBase.textPrint("ID参数为： " + TextName);
			WebBase.textPrint("定位参数为： " + CssButtonName);
		}
		try {
			assertEquals(TextName, Driver.findElement(By.cssSelector(CssButtonName)).getText());
			WebBase.textPrint("search Css-->  " + TextName + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("search Css-> " + TextName + "  :Fail!");
			Driver.quit();
		}
	}

	// 验证linktext元素
	public void CheckForLinkText(String Linktext, WebDriver Driver) throws InterruptedException {
		if (Linktext == null) {
			WebBase.textPrint("参数为null");
		} else {
			WebBase.textPrint("ID参数为： " + Linktext);
		}
		try {
			assertEquals(Linktext, Driver.findElement(By.linkText(Linktext)).getText());
			WebBase.textPrint("search LinkText-->  " + Linktext + "  :sucesses");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();

			WebBase.textPrint("search LinkText-->  " + Linktext + "  :Fail!");
			Driver.quit();
		}
	}

	// 验证Xpath定位元素
	public void CheckForXpath(String Name, String Xpath, WebDriver Driver) throws InterruptedException {
		if (Name == null && Xpath == null) {
			WebBase.textPrint("参数为null");
		} else {
			WebBase.textPrint("ID参数为： " + Name);
			WebBase.textPrint("定位参数为： " + Xpath);
		}
		try {
			assertEquals(Name, Driver.findElement(By.xpath(Xpath)).getText());
			WebBase.textPrint("search Xpath-->  " + Name + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();

			WebBase.textPrint("search Xpath-->  " + Name + "  :Fail!");
			Driver.quit();
		}
	}

	// 检查页面title
	public void CheckTitle(String title, WebDriver Driver) throws InterruptedException {
		try {
			assertEquals(title, Driver.getTitle());
			WebBase.textPrint("search Title-->" + title + "  :sucesses");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			Assert.assertTrue(false);
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("search Title-->" + title + "  :Fail!");
			WebBase.textPrint("this Page title is: " + Driver.getTitle());
			Driver.quit();
		}
	}

	// 点击Id元素
	public static void clickId(String idName, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.id(idName)).click();
			WebBase.textPrint("click Id button-->" + idName + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("click Id button--> " + idName + "  :Fail!");
			Driver.quit();
		}
	}

	// click Css button
	public void clickCSS(String CssName, WebDriver Driver) throws InterruptedException {
		if (CssName == null) {
			WebBase.textPrint("参数为null");
		} else {
			WebBase.textPrint("参数为： " + CssName);
		}
		try {
			Driver.findElement(By.cssSelector(CssName)).click();
			WebBase.textPrint("click CssButton--> " + CssName + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("click CssButton--> " + CssName + "  :Fail!");
			Driver.quit();
		}
	}

	// click linktext
	public void clickLinkText(String text, WebDriver Driver) throws InterruptedException {
		try {
			WebElement contactLink = Driver.findElement(By.linkText(text));
			WebBase.textPrint("search linkText--> " + text + "  :sucesses!");
			contactLink.click();
			WebBase.textPrint("click linkText--> " + text + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("click linkText--> " + text + "  :Fail!");
			Driver.quit();
		}
	}

	public void clickAbotLinkText(String text, WebDriver Driver) throws InterruptedException {
		try {
			WebElement aboutLink = Driver.findElement(By.partialLinkText(text));
			aboutLink.click();
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("click linkText--> " + text + "  :Fail!");
			Driver.quit();
		}
	}

	public void clickXpath(String Xpath, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.xpath(Xpath)).click();
			WebBase.textPrint("click Xpath--> " + Xpath + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("click linkText--> " + Xpath + "  :Fail!");
			Driver.quit();
		}
	}

	// clear inputWord
	public void clearWordId(String idName, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.id(idName)).clear();
			WebBase.textPrint(idName + " <--clear" + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint(idName + " <--clear" + "  :Fail!");
			Driver.quit();
		}
	}

	public void clearWordCss(String CSS, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.cssSelector(CSS)).clear();
			WebBase.textPrint(CSS + " <--clear" + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint(CSS + " <--clear" + "  :Fail!");
			Driver.quit();
		}
	}

	// 双击指定ID元素
	public void DoubleClickId(String idName, WebDriver Driver) throws InterruptedException {
		try {
			Actions action = new Actions(Driver);
			action.doubleClick(Driver.findElement(By.id(idName)));
			WebBase.sleep(2);
			WebBase.textPrint("# Double click Id button-->" + idName + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("# Double click Id button--> " + idName + "  :Fail!");
			Driver.quit();
		}
	}

	// 等待title页面
	public void waitForTitle(String text, WebDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");

			try {
				if (text.equals(Driver.getTitle()))
					break;
				WebBase.textPrint("Page--> " + Driver.getTitle() + "  :loding sucesses!");
				WebBase.textPrint("等待了  :" + second + "  秒!");
				WebBase.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				WebBase.ScreenShoot(Driver);

				WebBase.textPrint("Page--> " + Driver.getTitle() + "  :loding error");
				Driver.quit();
			}
		}
	}

	// wait css button exits
	public void waitForCss(String text, String Css, WebDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				WebBase.textPrint("等待了  :" + second + "  秒!");
				if ("text".equals(Driver.findElement(By.cssSelector(Css)).getText()))
					break;
				WebBase.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				WebBase.ScreenShoot(Driver);

				WebBase.textPrint("Page--> " + Driver.getTitle() + "  :loding error");
				Driver.quit();
			}
			Thread.sleep(1000);
			WebBase.textPrint("CssButton--> " + text + "  :cannot found!");
		}
	}

	public void waitForXpath(String Name, String Xpath, WebDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (Name.equals(Driver.findElement(By.xpath(Xpath)).getText()))
					break;
				WebBase.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				WebBase.ScreenShoot(Driver);

				WebBase.textPrint("Page--> " + Driver.getTitle() + "  :loding error");
				Driver.quit();
			}
			Thread.sleep(1000);
			WebBase.textPrint("XpathButton--> " + Name + "  :cannot found!");
		}
	}

	public void waitForId(String Name, String Id, WebDriver Driver) throws InterruptedException {
		for (int second = 0;; second++) {
			if (second >= 60)
				fail("timeout");
			try {
				if (Name.equals(Driver.findElement(By.id(Id)).getText()))
					break;
				WebBase.sleep(2);

			} catch (Exception e) {
				Thread.sleep(1000);
				e.printStackTrace();
				WebBase.ScreenShoot(Driver);

				WebBase.textPrint("Page--> " + Driver.getTitle() + "  :loding error");
				Driver.quit();
			}
			Thread.sleep(1000);
			WebBase.textPrint("CssButton--> " + Name + "  :cannot found!");
		}
	}

	public void windowMaximize(WebDriver Driver) throws InterruptedException {
		Driver.manage().window().maximize();
		WebBase.sleep(2);

	}

	// open new tab
	public void NewTab(WebDriver Driver) throws InterruptedException {
		try {
			Actions OpenNewTab = new Actions(Driver);
			OpenNewTab.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
			WebBase.textPrint("#### Open New Tab Page! ####");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("*/*/* Open New Page is  :Fail! */*/*");
			Driver.quit();
		}
	}

	// 对Id元素输入字符
	public static void InPutById(String idName, String Word, WebDriver Driver) throws InterruptedException {

		try {
			Driver.findElement(By.id(idName)).sendKeys(Word);
			WebBase.textPrint(idName + "  <--input text-->  " + Word + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint(idName + " <--input text--> " + Word + "  :Fail!");
			Driver.quit();
		}
	}

	// 对Xpath定位元素输入字符
	public void InPutBypath(String Xpath, String Word, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.xpath(Xpath)).sendKeys(Word);
			WebBase.textPrint(Xpath + "  <--input text-->  " + Word + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint(Xpath + " <--input text--> " + Word + "  :Fail!");
			Driver.quit();
		}
	}

	// 对Css定位元素输入字符
	public void InputByCss(String Css, String Word, WebDriver Driver) throws InterruptedException {
		try {
			Driver.findElement(By.cssSelector(Css)).sendKeys(Word);
			WebBase.textPrint(Css + "  <--input text-->  " + Word + "  :sucesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint(Css + " <--input text--> " + Word + "  :Fail!");
			Driver.quit();
		}
	}

	public void inputTime() throws InterruptedException {
		WebBase.textPrint("you just have 5 second input votetext!");
		WebBase.sleep(2);
		WebBase.textPrint("only 5 s!");
		WebBase.sleep(1);
		WebBase.textPrint("only 4 s!");
		WebBase.sleep(1);
		WebBase.textPrint("only 3 s!");
		WebBase.sleep(1);
		WebBase.textPrint("only 2 s!");
		WebBase.sleep(1);
		WebBase.textPrint("only 1 s!");
		WebBase.sleep(1);
	}

	public void handleA(WebDriver Driver) throws InterruptedException {
		String now_handle = Driver.getWindowHandle();
		WebBase.textPrint(Driver.getTitle() + "-->  handle A is : " + now_handle);
		WebBase.sleep(2);

	}

	public void handleB(WebDriver Driver) throws InterruptedException {
		String sec_handle = Driver.getWindowHandle();
		WebBase.textPrint(Driver.getTitle() + "-->  handle B is : " + sec_handle);
		WebBase.sleep(2);

	}

	protected void setTextOnUEditor(String editorId, String text, WebDriver Driver) {
		boolean isSucceed = false;
		try {
			String javascript = "UE.getEditor('" + editorId + "').setContent('" + text + "');";
			WebBase.sleep(2);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("switch handle-->  :Fail!");
			WebBase.textPrint("this Page title is: " + Driver.getTitle());
			Driver.quit();
		}
	}

	// 切换页面句柄
	public void switchHandle(WebDriver Driver) throws InterruptedException {
		// 事实证明，newTab不需要切换handle也能在newPage 找到元素
		try {
			String orgContext = Driver.getWindowHandle();
			for (String context : Driver.getWindowHandles()) {
				if (context.equals(orgContext)) {
					continue;
				}
				Driver.switchTo().window(context);
			}
			WebBase.textPrint("switch handle-->  :success!");
			WebBase.textPrint("s Page title is: " + Driver.getTitle());
			WebBase.sleep(2);

		} catch (Error e) {
			e.printStackTrace();
			Assert.assertTrue(false);
			WebBase.ScreenShoot(Driver);

			WebBase.textPrint("switch handle-->  :Fail!");
			WebBase.textPrint("this Page title is: " + Driver.getTitle());
			Driver.quit();
		}
	}

	public void switchFrameById(String frameId, WebDriver Driver) throws InterruptedException {
		Driver.switchTo().frame(frameId);
		WebBase.textPrint("change frame By Id -->  " + frameId);
		WebBase.sleep(2);

	}

	public void switchFrameByindex(int index, WebDriver Driver) throws InterruptedException {
		Driver.switchTo().frame(index);
		WebBase.textPrint("change frame By Index -->  " + index);
		WebBase.sleep(2);

	}

	public void switchFrameByelement(WebElement element, WebDriver Driver) throws InterruptedException {
		Driver.switchTo().frame(element);
		WebBase.textPrint("change frame By element -->  " + element);
		WebBase.sleep(2);

	}

	public void switchFrameByXpath(String Xpath, WebDriver Driver) throws InterruptedException {
		try {
			Driver.switchTo().frame(Driver.findElement(By.xpath(Xpath)));
			WebBase.textPrint("change frame By Xpath -->  " + Xpath);
			WebBase.sleep(2);

		} catch (Error e) {
			WebBase.textPrint("chage frame By Xpath to -->  " + Xpath + "  --> is Fail !");
			e.printStackTrace();
			Assert.assertTrue(false);

			Driver.quit();
		}
	}

	public void switchFrameForXpath(String frameXpath, WebDriver Driver) throws InterruptedException {
		try {
			WebElement frame = Driver.findElement(By.xpath(frameXpath));
			Driver.switchTo().frame(frame);
			WebBase.textPrint("Find Frame For Xpath And change to  ->" + frameXpath + "  -->is scuesses!");
			WebBase.sleep(2);

		} catch (Error e) {
			WebBase.textPrint("Find Frame For Xpath And change to  ->" + frameXpath + "  -->is Fial!");
			e.printStackTrace();
			Assert.assertTrue(false);

			Driver.quit();
		}
	}

	public static void switchToWindow(String windowTitle, WebDriver Driver) {

		Set<String> windowHandles = Driver.getWindowHandles();
		try {
			for (String handler : windowHandles) {
				Driver.switchTo().window(handler);
				String title = Driver.getTitle();
				WebBase.sleep(2);

				if (windowTitle.equals(title)) {
					break;
					// or return;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);

		}
	}

	public void outOfFrame(WebDriver Driver) throws InterruptedException {
		Driver.switchTo().defaultContent();
		WebBase.textPrint("change frame By Default ");
		WebBase.sleep(2);

	}

	public void acceptPop(WebDriver Driver) throws InterruptedException {
		Driver.switchTo().alert().accept();
		WebBase.textPrint("accept Pop Window ");
		WebBase.sleep(2);

	}
	
	public static void LunchAdress(String Adress,WebDriver Driver){
		
		try{
		Driver.navigate().to(Adress);
		textPrint("Open Adress : "+Adress);
		} catch (Error e){
			
		}
	}
}
