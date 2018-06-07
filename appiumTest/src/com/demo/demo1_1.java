/**
 * com.testcase.demo
 * appiumTest
 * case1.java
 * 
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月9日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.demo;

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

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

public class demo1_1 extends oneSssion {
	
	@Test(description = "case1_1 AA")
	public static void case1_1() throws InterruptedException {

		Thread.sleep(3000);
		driver.findElementByXPath(TestInfo.MainPage_Bar_QiLiao_Xpath).click();// 启聊

		Thread.sleep(3000);
		driver.findElementByXPath(TestInfo.MainPage_Bar_DashBoard_Xpath).click();// 仪表盘

		Thread.sleep(3000);
		driver.findElementByXPath(TestInfo.MainPage_Bar_App_Xpath).click();// 应用

		Thread.sleep(3000);
		driver.findElementByXPath(TestInfo.MainPage_Bar_Discovery_Xpath).click();// 发现

		Thread.sleep(3000);
		driver.findElementByXPath(TestInfo.MainPage_Bar_Work_Xpath).click();// 工作


	}


}
