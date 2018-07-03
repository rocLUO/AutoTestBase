package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/29
 * Time: 10:35
 *
 * Description:
 */
public class changeAccount extends TestInfo{

    /**
     * @param: 
     * 
     * @auther: luopeng
     * 
     * @date: 2018/6/29 10:45
     * 
     * @description :
     */
//    public static void switchAccount(AppiumDriver Driver, String AccountName, int SwipTime) throws InterruptedException {
    public static void switchAccount(AppiumDriver Driver, String 企业管理员正牌, int i) throws InterruptedException {


        try {

            //点击左上 头像图标 呼出操作工具栏
            AppBase.clickId("com.android.ayplatform"+ type +":id/user_avatar_layout",Driver);
            Thread.sleep(2000);

            //点击 账号与安全选项 弹窗图层控件信息无法获得 使用坐标点击
            AppBase.clickXY(280,1075,"点击->账号与安全",Driver);
            Thread.sleep(3000);

            //点击 帐号切换
            AppBase.clickXY(302,294,"点击 帐号切换",Driver);
            Thread.sleep(3000);

            //组织架构人员选择
            //上划 次数 -> SwipTime
//            for(int i=0;i<SwipTime;i++) {
//                AppBase.swipToUp(Driver);
//                Thread.sleep(2000);
//            }

            //点击 目标账号 -> AccountName
            
            //零时使用
            AppBase.clickXY(302,294,"点击 帐 帐号",Driver);
//            AppBase.clickXpath("//android.widget.TextView[@text='" + AccountName + "']",Driver);
            
            
            Thread.sleep(2000);

            //点击空白处 关闭弹窗页
            AppBase.clickXY(1000,900,"点击空白处 关闭弹窗页",Driver);
            Thread.sleep(2000);


        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }

    }

}
