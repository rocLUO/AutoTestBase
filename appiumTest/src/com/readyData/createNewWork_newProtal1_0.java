package com.readyData;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;

import static com.appium.TestBase.AppBase.InPutByXpath;

/*
 * appiumTest - com.testcase
 * author: luopeng
 * Date: 2018/6/1
 * Time: 11:16
 *
 * Description: release make new protal
 */
public class createNewWork_newProtal1_0 extends TestInfo {

	//要循环次数->制造流程数
	int Round = 10;

	/**
	 *
	 * 功能描述: 
	 *
	 * @param: 
	 * 
	 * @auther: luopeng
	 * 
	 * @date: 2018/6/14 11:37
	 * 
	 * @description :
	 */
	public void newProtal_newWork_release(AppiumDriver Driver) throws InterruptedException {

		for(int i=0;i<Round;i++) {

			try {
				AppBase.ClickXpath("//android.widget.TextView[@text='门户", Driver);
				Thread.sleep(2000);

				//默认测试门户 快捷入口在下方
				AppBase.swipXY(585, 1805, 585, 249, Driver);
				Thread.sleep(2000);

				//点击 快捷入口 默认第一个入口
				AppBase.ClickXpath("//android.widget.FrameLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]", Driver);
				Thread.sleep(2000);

				//快捷入口配置 进入创建页
				//输入框,输入内容1
				AppBase.InPutByXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText", "TestTest", Driver);
				Thread.sleep(2000);

				//输入框,输入内容2
				AppBase.InPutByXpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText", "TestTest", Driver);
				Thread.sleep(2000);

				//点击 添加接受人
				AppBase.ClickId("com.android.ayplatform"+type+":id/org_add_user_imageView", Driver);
				Thread.sleep(2000);

				//滑动到最下,默认接收测试帐号部门在最底
				AppBase.swipXY(504, 1752, 504, 347, Driver);
				Thread.sleep(3000);

				//点击 "autotest" 部门
				AppBase.ClickXpath("//android.widget.TextView[@text='autoTest']", Driver);
				Thread.sleep(2000);

				//点击 接收人 autoAcunt01
				AppBase.ClickXpath("////android.widget.TextView[@text='autoAccunt01']", Driver);
				Thread.sleep(2000);

				//点击 确定 选择
				AppBase.ClickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", Driver);
				Thread.sleep(2000);

				//点击提交选择
				AppBase.ClickId("com.android.ayplatform"+type+":id/flow_detail_submit_Button", Driver);
				Thread.sleep(3000);

				AppBase.textPrint("is round -->"+i);
			}catch (Error e){
				e.printStackTrace();
				AppBase.textPrint("error is round -->"+i);
			}

		}
	}
}
