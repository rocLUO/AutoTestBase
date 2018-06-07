/**
 * democase
 * testNgWeb
 * demo2.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年4月23日 上午9:59:27
 *
 * Created by LuoPeng
 */
package demotest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.webTestBase.WebBase;
import com.webTestBase.webTestInfo;

/**
 *@author luopeng
 *Last_Update 2018年4月23日上午9:59:27
 */
public class demo2 extends webTestInfo{
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		
		//定向驱动路径
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Java\\chromedriver.exe");
		//System.setProperty("webdriver.firefox.bin", "D:\\Program Files (x86)\\Java\\firefoxdriver.exe");
		
		//webdriver方法导入
		//WebDriver driver = new FireFox();
		//WebDriver driver = new InternetExplorerDriver();
		WebDriver driver = new ChromeDriver();
		
		//超时等待
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    //链接打开
		WebBase.LunchAdress("http://www.baidu.com",driver);
		
		//等待-显
		Thread.sleep(2000);
		
		//输入
		WebBase.InPutById("kw","selenium java",driver);
		Thread.sleep(2000);
		
		//点击
		WebBase.clickId("su",driver);
		Thread.sleep(2000);
		
		//关闭浏览器
		driver.close();
	}

}
