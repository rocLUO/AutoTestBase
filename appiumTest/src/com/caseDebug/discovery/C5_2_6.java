package com.caseDebug.discovery;

import com.appium.TestBase.AppBase;
import com.appium.TestBase.TestInfo;
import com.method.AboutContent;
import com.method.SelectAction;
import io.appium.java_client.AppiumDriver;
import org.testng.annotations.Test;

import java.sql.Driver;

/*
 * appiumTest - com.caseDebug
 * author: luopeng
 * Date: 2018/7/5
 * Time: 14:24
 *
 * Description:
 */
public class C5_2_6 extends TestInfo {
    @Test(description = "工作圈-文字信息/相册/照相/定位/@")
    public static void case5_2_6(AppiumDriver Driver) throws InterruptedException {
        try{
            Thread.sleep(waitTime);

            AboutContent.newContent(Driver);

            //点击 定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_location_tv",Driver);
            Thread.sleep(6000);

            //点击确定定位
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);

            //输入文字
            AppBase.inPutById("com.android.ayplatform"+ type +":id/activity_published_talking_et","testestest",Driver);
            Thread.sleep(2000);

            //点击 @
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_alt",Driver);
            Thread.sleep(2000);

            //人员组织架构 人员选择-方法
            SelectAction.choosesMen(Driver,"autoTest","autoAccunt01",2);
            Thread.sleep(2000);

            //点击 相机
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_cameral",Driver);
            Thread.sleep(5000);

            //点击 拍摄
            AppBase.clickId("com.huawei.camera:id/shutter_button",Driver);
            Thread.sleep(5000);

            //确定 照片
            AppBase.clickId("com.huawei.camera:id/done_button",Driver);
            Thread.sleep(3000);

            //点击 相册 icon
            AppBase.clickId("com.android.ayplatform"+ type +":id/activity_published_talking_pic",Driver);
            Thread.sleep(2000);

            //点击坐标
            AppBase.clickXY(500,368,"选择图片,点击左上角第二张",Driver);
            Thread.sleep(2000);

            //点击 确定
            //AppBase.clickId("com.android.ayplatform"+ type +":id/id_total_count",Driver);
            AppBase.clickXY(885,1962,"点击 选择确定",Driver);

            Thread.sleep(2000);

            //发送
            AppBase.clickId("com.android.ayplatform"+ type +":id/head_right_doing",Driver);
            Thread.sleep(3000);
        } catch (Error e) {
            e.printStackTrace();
            AppBase.screenSnap(Driver);
        }
    }
}
