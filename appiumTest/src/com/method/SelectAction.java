package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/14
 * Time: 13:57
 *
 * Description:
 */
public class SelectAction extends TestInfo{

    /**
     * @param: Text1 : 输入字段1
     * @param: Text2 : 输入字段2
     * @param: department : 接收人部门 xpath
     * @param: recipien : 接收人 xpath
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 14:03
     *
     * @description : 新建 autotest 实例后,实例内容编辑
     */
    public static void newWorkTextInPut(AppiumDriver Driver, String Text1, String Text2, String department, String recipien) throws InterruptedException {
        //输入框,输入内容1
        AppBase.inPutByXpath("//android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText", "TestTest", Driver);
        Thread.sleep(2000);

        //输入框,输入内容2
        AppBase.inPutByXpath("//android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText", "TestTest", Driver);
        Thread.sleep(2000);

        //点击 添加接受人
        AppBase.clickId("com.android.ayplatform"+type+":id/org_add_user_imageView", Driver);
        Thread.sleep(2000);

        //提交人员组织页面操作
        submission(Driver, department, recipien);

    }

    /**
     * @param Recipien 接收人 Xpath
     * @param Department 接收人部门 Xpath
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 14:03
     *
     * @description : 提交按钮后,人员组织页面操作
     */
    public static void submission(AppiumDriver Driver, String Department, String Recipien) throws InterruptedException {

        //滑动到最下,默认接收测试帐号部门在最底
        AppBase.swipXY(504, 1752, 504, 347, Driver);
        Thread.sleep(3000);

        //点击 接收人 部门 Department -Xpath
        AppBase.clickXpath(Department, Driver);
        Thread.sleep(2000);

        //点击 接收人 Recipien -Xapth
        AppBase.clickXpath(Recipien, Driver);
        Thread.sleep(2000);

        //点击 确定 选择
        AppBase.clickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", Driver);
        Thread.sleep(2000);
    }

    /**
     * @param:
     *
     * @auther: luopeng
     *
     * @date: 2018/6/14 16:33
     *
     * @description : 抄送/委托 人员选择 下滑次数
     */
    public static void choosesMen(AppiumDriver Driver, String department, String recipoen, int swipTime) throws InterruptedException {

        for(int i=0; i<swipTime; i++){
            if(swipTime==0){
                break;
            }
            //默认部门在最下方
            AppBase.swipToUp(Driver);
            Thread.sleep(2000);
        }

        //打开 部门
        AppBase.clickXpath("//android.widget.TextView[@text='"+department+"']", Driver);
        Thread.sleep(2000);

        //选择人员
        AppBase.clickXpath("//android.widget.TextView[@text='"+recipoen+"']", Driver);
        Thread.sleep(2000);

        //点击 确定
        AppBase.clickId("com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit", Driver);
        Thread.sleep(2000);
    }
}
