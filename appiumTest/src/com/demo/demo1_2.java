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

public class demo1_2 extends oneSssion {


	@Test(description = "case1_2 AA")
	public static void case1_2() throws InterruptedException {

		Thread.sleep(3000);
		ClickXpath(TestInfo.MainPage_Bar_Discovery_Xpath); // switch Discovery bar
		Thread.sleep(3000);

		ClickXpath("//android.widget.TextView[@text='工作圈']");
		Thread.sleep(3000);
		ClickId("com.android.ayplatform.release:id/doing"); // new

		Thread.sleep(2000);
		clearId("com.android.ayplatform.release:id/activity_published_talking_et");
		InPutById("com.android.ayplatform.release:id/activity_published_talking_et", "123456654321");

		Thread.sleep(2000);
		ClickId("com.android.ayplatform.release:id/head_right_doing"); // send

	}

}
