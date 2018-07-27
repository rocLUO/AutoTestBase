package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/10
 * Time: 16:58
 *
 * Description: 工作 编辑页 操作
 */
public class WorkEdit extends TestInfo {
    public static void newAutoTestWork(AppiumDriver Driver, String Text1, String Text2, String department, String recipien) throws InterruptedException {
        /**
         * @param: [Driver, Text1, Text2, department, recipien]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/14 14:03
         *
         * @description :　autotest 应用 新建工作编辑 : 输入字符1 -> 输入字符2 -> 添加接收人 -> 选择人员
         */
        //输入框,输入内容1
//        ClickWorkFieldNum(Driver,1);
        Driver.findElementByXPath("//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText").sendKeys("TestTest");
        Thread.sleep(2000);

        //输入框,输入内容2
//        ClickWorkFieldNum(Driver,2);
        Driver.findElementByXPath("//android.widget.RelativeLayout[2]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText").sendKeys("TestTest");

        Thread.sleep(2000);

        //点击 添加接受人
        AppBase.clickId("com.android.ayplatform"+type+":id/org_add_user_imageView", Driver);
        Thread.sleep(2000);

        //提交人员组织页面操作
        SelectAction.submission(Driver, department, recipien);

    }

    public static void workWindowTextInput(AppiumDriver Driver, String Text) throws InterruptedException {
        /**
         * @param: [Driver, Text]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/10 18:50
         *
         * @description :工作内容页文字输入弹窗 编辑与提交 : 输入字符 -> 点击 确定
         */

        AppBase.inPutById(WorkFlow_InputWindow_Id,Text,Driver);
        Thread.sleep(2000);

        AppBase.clickXpath(Button_Confrim_Xpath,Driver);
        Thread.sleep(2000);
    }

    public static void ClickWorkFieldNum(AppiumDriver Driver,int FieldNum) {
        AppBase.clickXpath("//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout["+ FieldNum +"]/android.widget.LinearLayout[2]",Driver);
    }

    public static void workEditFiedInput(AppiumDriver Driver,String Text) throws InterruptedException {
        /**
         * @param: [Driver, Text]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 11:41
         *
         * @description : 编辑器 字段操作 : 编辑器字段页 -> 输入内容 -> 点击 完成
         */
        try {
            AppBase.inPutById(EditField_input_Id,Text,Driver);
            Thread.sleep(2000);

            AppBase.clickId(EditField_done_Id,Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
        }

    }

    public static void workCompanyFieldInput(AppiumDriver Driver,String Department, String Recipoen, int SwipTime) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 13:53
         *
         * @description : 组织架构 字段操作 : 组织架构 页面 -> choosemen()
         */
        try {
            SelectAction.choosesMen(Driver,Department,Recipoen,SwipTime);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
        }
    }

    public static void workLocationField(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 14:00
         *
         * @description : 位置 字段操作 : 位置 字段弹窗 -> 点击 完成
         */
        try {
            AppBase.clickId(LocationField_done_Id,Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
        }

    }

    public static void workDateField(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 14:25
         *
         * @description : 日期 字段操作 : 日期 字段弹窗 -> 滑动 日 -> 切换 至时 -> 滑动 时 -> 点击 完成
         */
        try {
            AppBase.swipXY(548,1945,548,1785,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("android.widget.LinearLayout[2]",Driver);
            Thread.sleep(2000);

            AppBase.swipXY(422,1950,422,1785,Driver);
            Thread.sleep(2000);

            AppBase.clickId(DateField_done_Id,Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
        }
    }


}
