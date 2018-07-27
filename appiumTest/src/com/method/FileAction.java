package com.method;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.sun.jna.platform.win32.ShellAPI;
import io.appium.java_client.AppiumDriver;

import java.io.File;
import java.nio.file.Path;

/*
 * appiumTest - com.method
 * author: luopeng
 * Date: 2018/7/11
 * Time: 15:51
 *
 * Description:
 */
public class FileAction extends TestInfo {
    public static void QiLiaoSendFile(AppiumDriver Driver, int SwipNum, String PathName, String FileType) throws InterruptedException {
        /**
         * @param: [Driver, SwipNum, FileName, FileNum]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/11 16:36
         *
         * @description : 启聊内发送文件图片 : 启聊页 -> 点击 更多 -> 点击 文件 -> 点击 本地目录 -> 点击 文件夹 -> 选择文件 -> 发送
         */
        try {
            Thread.sleep(2000);

            AppBase.clickXpath(QiLiao_More_File_Xpath,Driver);
            Thread.sleep(2000);

            AppBase.clickId(File_Send_local_Id,Driver);
            Thread.sleep(2000);

            for(int i=0; i<SwipNum; i++){
                AppBase.swipToUp(Driver);
            }

            AppBase.clickXpath("//android.widget.TextView[@text='" + PathName + "']",Driver);
            Thread.sleep(2000);

            //文件类型 FileType
            if (FileType == "JpgPic") {
                AppBase.clickXpath("//android.widget.TextView[@text='testPic01.jpg']",Driver);
            } else if (FileType == "PngPic") {
                AppBase.clickXpath("//android.widget.TextView[@text='testPic01.png']",Driver);
            } else if (FileType == "Video") {
                AppBase.clickXpath("//android.widget.TextView[@text='testVideo01.mp4']",Driver);
            } else if (FileType == "Excel") {
                AppBase.clickXpath("//android.widget.TextView[@text='testExcel01.xlsx']",Driver);
            } else if (FileType == "Word") {
                AppBase.clickXpath("//android.widget.TextView[@text='testWord01.docx']",Driver);
            }

            Thread.sleep(2000);

            //AppBase.clickXpath("//android.widget.ListView/android.widget.LinearLayout[" + FileNum + "]/android.widget.ImageView[2]",Driver);
            //Thread.sleep(2000);

            //AppBase.clickId(File_Send_Id,Driver);
            //Thread.sleep(6000);

            //AppBase.clickId(WorkFlow_Back_Id,Driver);
            //Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);

        }
    }

    public static void QiLiaoSendPic(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/25 9:47
         *
         * @description : 启聊 发送图片
         */
        try {
            Thread.sleep(2000);

            AppBase.clickXpath(QiLaio_More_pic_Xpath,Driver);
            Thread.sleep(2000);

            //默认选择第一张图
            AppBase.clickXpath("//android.widget.RelativeLayout[2]/android.widget.RelativeLayout/android.widget.ImageView",Driver);
            Thread.sleep(2000);

            AppBase.clickId(QiLiao_sendPic_Id,Driver);
            Thread.sleep(2000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void WorkFlowSendFile(AppiumDriver Driver, int SwipNum, String FileName, int num) throws InterruptedException {
        /**
         * @param: [Driver, SwipNum, FileName, num]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/11 17:15
         *
         * @description : 工作编辑 添加附件 文件 : 工作编辑页 -> 点击 附件 -> 点击 文件 -> 点击文件夹 -> 选择 文件
         */
        try {
            //点击 工作编辑页 添加 附件 图标
            AppBase.clickId(WorkFlow_Enclosure_Id,Driver);
            Thread.sleep(2000);

            //选择 发送 附件类型 file
            AppBase.clickId(WorkFlow_Enclosure_file,Driver);
            Thread.sleep(2000);

            for(int i=0; i<SwipNum; i++){
                AppBase.swipToUp(Driver);
            }

            //点击 文件夹
            AppBase.clickXpath("//android.widget.TextView[@text='" + FileName + "']",Driver);
            Thread.sleep(2000);

            int fileNum = num +1;
            //点击选择文件
            AppBase.clickXpath("//android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout["+ fileNum +"]",Driver);
            Thread.sleep(6000);

            //点击确定
            AppBase.clickId("com.android.ayplatform"+type+":id/activity_file_choose_selectFinish",Driver);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void WorkFlowSendPhoto(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/11 17:26
         *
         * @description :工作编辑 添加附件 图片 : 工作编辑页 -> 点击 附件 -> 点击 相册 -> 点击图片 -> 选择 使用图片
         */
        try {
            //点击 工作编辑页 添加 附件 图标
            AppBase.clickId(WorkFlow_Enclosure_Id,Driver);
            Thread.sleep(2000);

            //选择 发送 附件类型 file
            AppBase.clickId(WorkFlow_Enclosure_photo,Driver);
            Thread.sleep(2000);

            AppBase.clickXY(256,489,"点击 相册 图片",Driver);
            Thread.sleep(2000);

            AppBase.clickId(File_PhotoEdit_usePic_Id,Driver);
            Thread.sleep(6000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }

    public static void WorkFlowCamera(AppiumDriver Driver) throws InterruptedException {
        /**
         * @param: [Driver]
         *
         * @auther: luopeng
         *
         * @date: 2018/7/11 17:36
         *
         * @description :工作编辑 添加附件 拍摄 : 工作编辑页 -> 点击 附件 -> 点击 拍摄 -> 系统相机页 点击shoot -> 选择 yes -> 图片 编辑页 选择使用图片
         */

        try {
            //点击 工作编辑页 添加 附件 图标
            AppBase.clickId(WorkFlow_Enclosure_Id,Driver);
            Thread.sleep(2000);

            //选择 发送 附件类型 camera
            AppBase.clickId(WorkFlow_Enclosure_camera,Driver);
            Thread.sleep(3000);

            //点击 相机 拍摄 按钮
            AppBase.clickId(HuaWei_Camera_Shoot_Id,Driver);
            Thread.sleep(6000);

            AppBase.clickId(HuaWei_Camera_confrim_Id,Driver);
            Thread.sleep(2000);

            AppBase.clickId(File_PhotoEdit_usePic_Id,Driver);
            Thread.sleep(6000);

        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
