package com.caseDebug.workProtal.workProtalWorkAssembly;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;


/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 15:48
 *
 * Description:
 */
public class C3_5_2 extends TestInfo {
    @Test (description = "门户 工作组件-我的代办打开")
    public static void case3_5_2(AppiumDriver Driver) throws InterruptedException {

        try {
        	
        	Thread.sleep(waitTime);
        	
            //非全屏 打开第一个待办
            AppBase.clickXpath("//android.widget.FrameLayout[2]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.LinearLayout[1]",Driver);
            Thread.sleep(4000);

            AppBase.clickId(WorkFlow_Back_Id,Driver);
            Thread.sleep(2000);
            
            //工作组件 全屏 打开第一个待办
            OpenWork.AssemblyWork(Driver,"待办工作","",1);

            AppBase.clickId(WorkFlow_Back_Id,Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
