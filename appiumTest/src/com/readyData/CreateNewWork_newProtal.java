/**
 * com.readyData
 * appiumTest
 * CreateNewWork_newProtal.java
 *
 * Created on 2018年7月3日 下午2:15:36
 *
 * Created by LuoPeng
 */
package com.readyData;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.net.URL;
import java.sql.Driver;

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
public class CreateNewWork_newProtal extends TestInfo{

	@Test(description = "主窗口与ifram之间的切换")
	public static void newWork(AppiumDriver Driver) throws InterruptedException {

		int i = 1;
		while (1 < 2) {
			try {
				Thread.sleep(5000);
				
				AppBase.clickXpath(MainPage_Bar_Protal_Xpath, Driver);
				Thread.sleep(2000);

				//默认测试门户 快捷入口在下方
				AppBase.swipXY(585, 1805, 585, 249, Driver);
				Thread.sleep(2000);

				//点击 快捷入口 默认第一个入口
				AppBase.clickXpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", Driver);
				Thread.sleep(2000);

				//快捷入口配置 进入创建页
				//输入框,输入内容1
				AppBase.inPutByXpath("//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText","TestTest",Driver);
				Thread.sleep(2000);

				//输入框,输入内容2
				AppBase.inPutByXpath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText","TestTest",Driver);
				Thread.sleep(2000);

//				//点击 添加接受人
//				AppBase.clickId("com.android.ayplatform"+type+":id/org_add_user_imageView", Driver);
//				Thread.sleep(2000);
//
//				//滑动到最下,默认接收测试帐号部门在最底
//				AppBase.swipXY(504, 1752, 504, 347, Driver);
//				Thread.sleep(3000);
//
//				//点击 "autotest" 部门
//				AppBase.clickXpath("//android.widget.TextView[@text='autoTest']", Driver);
//				Thread.sleep(2000);
//
//				//点击 接收人 autoAcunt01
//				AppBase.clickXpath("//android.widget.TextView[@text='autoAccunt01']", Driver);
//				Thread.sleep(2000);
//
//				//点击 确定 选择
//				AppBase.clickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", Driver);
//				Thread.sleep(2000);
//
//				//点击提交选择
//				AppBase.clickId(WorkFlow_Send_Id, Driver);
//				Thread.sleep(3000);
//
//				AppBase.textPrint("is round -->"+i);
				i++;
			} catch (Error e) {
				AppBase.screenSnap(Driver);
			}
		}
	}

	@AfterClass
	public void tearDown() throws Exception {
		AppBase.textPrint("test end!");

	}

}
