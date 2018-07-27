package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;

import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/6/14
 * Time: 11:18
 *
 * Description:从门户快捷入口新建实例,从应用新建实例
 */
public class CreateWork extends TestInfo{

    public static void createWorkByEntrance(AppiumDriver Driver, String Word1, String Word2, String theRecipien ,String theDepartment) throws InterruptedException {
        /**
         * @param: [Driver, Word1, Word2, theRecipien, theDepartment]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/14 11:34
         *
         * @description :从门户快捷入口新建实例,app使用autotest应用
         */
        try {
            OpenAppList.viewWrokListByProtal(Driver,1);
            Thread.sleep(2000);
            //快捷入口配置 进入创建页
            WorkEdit.newAutoTestWork(Driver, Word1, Word2, theRecipien, theDepartment);
            Thread.sleep(2000);
            //点击提交按钮
            AppBase.clickId(WorkFlow_Send_Id, Driver);
            Thread.sleep(2000);

        }catch (Error e){
            e.printStackTrace();
        }

    }

    public static void createWorkByAppCenter(AppiumDriver Driver, String Word1, String Word2, String theRecipien ,String theDepartment) throws InterruptedException {
        /**
         * @param: [Driver, Word1, Word2, theRecipien, theDepartment]
         *
         * @auther: luopeng
         *
         * @date: 2018/6/14 14:24
         *
         * @description :从应用中心 进入应用 新建工作
         */
        try {

            AppBase.clickXpath("MainPage_Bar_App_Xpath", Driver);
            Thread.sleep(3000);

            //默认autotest 应用在最下方
            AppBase.swipXY(525, 1846 ,525, 231, Driver);
            Thread.sleep(2000);

            //点击应用 autotest
            AppBase.clickXpath("//android.widget.TextView[@text='autotest']", Driver);
            Thread.sleep(2000);

            //点击实例 进入列表页
            AppBase.clickId("com.android.ayplatform"+type+":id/appcenter_myapp_detail_children_text", Driver);
            Thread.sleep(2000);

            //点击 新建 按钮
            AppBase.clickId("com.android.ayplatform"+type+":id/activity_info_new", Driver);
            Thread.sleep(2000);

            //快捷入口配置 进入创建页
            WorkEdit.newAutoTestWork(Driver, Word1, Word2, theRecipien, theDepartment);

            //点击提交按钮
            AppBase.clickId(WorkFlow_Send_Id, Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
        }

    }

    public static void createWorkByQuickAdd(AppiumDriver Driver, String WorkName, String Word1, String Word2, String theRecipien, String theDepartment) throws InterruptedException {
        /**
         * @param: [Driver, WorkName, word1, Word2, theRecipien, theDepartment]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/10 9:32
         *
         * @description : 通过门户快捷添加新建工作并提交 : 门户 -> 快捷添加 -> 进入应用列表/新建应用 -> 编辑工作页 -> 选择提交人 -> 提交
         */
        try {

            //点击 快捷入口
            AppBase.clickXpath(Protal_fastEntranceIcon_open_Xpath,Driver);
            //图标张开,再次点击
            AppBase.clickXpath(Protal_fastEntranceIcon_open_Xpath,Driver);

            //预设计
            AppBase.clickXpath("//android.widget.TextView[@text='"+ WorkName +"']",Driver);
            Thread.sleep(2000);

            WorkEdit.newAutoTestWork(Driver, Word1, Word2, theRecipien, theDepartment);
            //点击提交按钮
            AppBase.clickId(WorkFlow_Send_Id, Driver);
            Thread.sleep(2000);



        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void createDraftWorkByEntrance(AppiumDriver Driver, String Word1, String Word2, String theDepartment, String theRecipien) throws InterruptedException {
        /**
         * @param: [Driver, Word1, Word2, theDepartment, theRecipien]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/12 9:25
         *
         * @description :新建工作草稿 : 门户 -> 快捷入口 新建工作 -> 编辑内容 -> 点击保存
         */
        try {
            //新建工作
            OpenAppList.viewWrokListByProtal(Driver, 1);
            Thread.sleep(2000);

            //编辑内容
            WorkEdit.newAutoTestWork(Driver, Word1, Word2, theDepartment, theRecipien);
            Thread.sleep(2000);

            //点击保存
            AppBase.clickId(WorkFlow_Save_Id, Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
