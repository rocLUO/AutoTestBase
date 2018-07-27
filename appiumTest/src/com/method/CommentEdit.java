package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import io.appium.java_client.AppiumDriver;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/10
 * Time: 18:49
 *
 * Description: 工作 讨论页 操作
 */
public class CommentEdit extends TestInfo {

    public static void editWord(AppiumDriver Driver, String Word1) throws InterruptedException {
        /**
         * @param: [Driver, Word1]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/13 11:03
         *
         * @description : 工作 批注(讨论)页 : 输入框输入 字符串 -> 点击发送
         */
        try {
            //输入字符
            AppBase.inPutById(Comment_InputText_Id,"text",Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void editAtByChoose(AppiumDriver Driver, String department, String recipoen, int swiptime) throws InterruptedException {
        /**
         * @param: [Driver, department, recipoen, swiptime]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/13 11:04
         *
         * @description : 工作 批注(讨论)页 : 点击 @ -> 点击 组织架构 -> 选择人员
         */
        try {

            AppBase.clickId(Comment_At_Id,Driver);
            Thread.sleep(2000);

            //点击->查看组织架构
            AppBase.clickXpath("//android.widget.TextView[@text='查看组织架构']",Driver);
            Thread.sleep(2000);

            SelectAction.choosesMen(Driver,department,recipoen,swiptime);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
    public static void editAtBySearch(AppiumDriver Driver, String Name) throws InterruptedException {
        /**
         * @param: [Driver, Name]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/13 11:05
         *
         * @description : 引用 Selection.searchMen
         */
        try{
            SelectAction.searchMen(Driver,Name);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void editFace(AppiumDriver Driver,String FaceNum) throws InterruptedException {
        try {
            AppBase.clickId(Comment_Face_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickXpath("android.widget.LinearLayout["+ FaceNum +"]/android.widget.ImageView",Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
