package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.OpenWork;
import com.method.WorkEdit;
import com.sun.jna.platform.win32.ShellAPI;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.AppiumExecutionMethod;
import org.testng.annotations.Test;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/17
 * Time: 10:10
 *
 * Description: 启聊操作
 */
public class AboutQiLiao extends TestInfo {

    public static void sendMessageByQiLiao(AppiumDriver Driver, String Text) throws InterruptedException {
        /**
         * @param: [Driver, Text]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 16:13
         *
         * @description : 启聊对话页 发送文字内容
         */
        try {

            Thread.sleep(2000);
            AppBase.inPutById(QiLiao_TextInput_Id, Text, Driver);

            Thread.sleep(2000);
            AppBase.clickId(QiLiao_SendText_Id, Driver);

            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void sendEmojiByQiLiao(AppiumDriver Driver, int EmojiNum) throws InterruptedException {
        /**
         * @param: [Driver, EmojiNum]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 16:20
         *
         * @description : 启聊对话页 发送emoji表情
         */
        try {

            Thread.sleep(2000);
            AppBase.clickId(QiLiao_Emoji_Id, Driver);

            Thread.sleep(2000);
            AppBase.clickXpath("android.widget.GridView/android.widget.FrameLayout[" + EmojiNum + "]", Driver);

            Thread.sleep(2000);
            AppBase.clickId(QiLiao_SendText_Id, Driver);

            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void sendVoiceByQiLiao(AppiumDriver Driver, int VoiceTime) throws InterruptedException {
        /**
         * @param: [Driver, VoiceTime]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 16:40
         *
         * @description : 启聊对话页 发送语音
         */
        try {
            Thread.sleep(2000);
            AppBase.clickId(QiLiao_VoiceSwitch_Id, Driver);

            Thread.sleep(2000);
            //AppBase.longClick(1, QiLiao_Talk_Id, 5, Driver);

            Thread.sleep(3000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void sendLocateByQiLiao(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 16:46
         *
         * @description : 启聊对话页 发送位置
         */
        try {
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_More_Id, Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_More_Id, Driver);
            Thread.sleep(4000);

            //点击 发送
            AppBase.clickId(Friends_Edit_pre_Id, Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void sendFileByQiLiao(AppiumDriver Driver, int swipNum, String PathName, String FileType) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 16:57
         *
         * @description : 启聊对话页 发送文件
         */
        try {
            FileAction.QiLiaoSendFile(Driver, swipNum, PathName, FileType);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void sendPhotoByQiLiao(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/24 17:01
         *
         * @description : 启聊对话页 发送图片
         */
        try {
            FileAction.QiLiaoSendPic(Driver);
            Thread.sleep(2000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}