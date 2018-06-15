/**
 * com.appium.TestBase
 * appiumTest
 * ActivityBase.java
 *
 * Copyright 2018 QYcloud Product test group
 *
 * Created on 2018年3月14日 下午3:28:05
 *
 * Created by LuoPeng
 */
package com.appium.TestBase;

/**
 *@author luopeng
 *Last_Update 2018年4月19日下午1:48:30
 */
public class TestInfo {

	//手机参数设置
	public String Platform = "Android";
	public String PhoneCode = "MKJNW17C20005057";
	public String ApkPackage = "com.android.ayplatform.release";
	public String ApkActivity = "com.android.ayplatform.activity.WelcomeActivity";
	public String Version = "8.0";

	//before start method act
	public static int waitTime = 60;

	//test lunch environment
	public static String type = ".release";

	// login method use
	public String Account = "admin_pretest";
	public String Password = "11111111";

	// change account name
	public String ForAccountName = "";

	//登录页
	public String LoginPage_Id = "com.android.ayplatform:id/cardNumAuto";
	public String LoginPage_Password = "com.android.ayplatform:id/Pass";
	public String LoginPage_LoginKey = "com.android.ayplatform:id/login";

	//主页面
	public String MainPage_NewWork_Id = "com.android.ayplatform:id/click_img";

	public static String MainPage_Tag_Already_Xpath = "//android.widget.TextView[@text='最近处理']";
	public static String MainPage_Tag_HoldOn_Xpath = "//android.widget.TextView[@text='待办工作']";
	public static String MainPage_Tag_MyLaunch_Xpath = "//android.widget.TextView[@text='我发起的']";

	public static String MainPage_Bar_Work_Xpath = "//android.widget.TextView[@text='工作']";
	public static String MainPage_Bar_QiLiao_Xpath = "//android.widget.TextView[@text='启聊']";
	public static String MainPage_Bar_DashBoard_Xpath = "//android.wmidget.TextView[@text='仪表盘']";
	public static String MainPage_Bar_App_Xpath = "//android.widget.TextView[@text='应用']";
	public static String MainPage_Bar_Discovery_Xpath = "//android.widget.TextView[@text='发现']";
	public static String MainPage_Bar_Protal_Xpath = "//android.widget.TextView[@text='门户']";

	public String MainPage_Search_Id = "com.android.ayplatform." +type+ ":id/workbench_head_edit";
	public String Protal_Search_Id = "com.android.ayplatform"+type+":id/actionFind";

	//主页面左上个头像->个人信息菜单
	public String MainPage_preData_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View";
	public String MainPage_preDate_coo = "76, 143";

	//主页面->点击新增工作
	public String NewWork_App_No1_Xpath = "//android.widget.TextView[@text='打开签到']";
	public String NewWork_App_No2_Xpath = "//android.widget.TextView[@text='工作计划']";
	public String NewWork_App_No3_Xpath = "//android.widget.TextView[@text='工作协同']";
	public String NewWork_App_No4_Xpath = "//android.widget.TextView[@text='员工薪资']";
	public String NewWork_App_No5_Xpath = "//android.widget.TextView[@text='请假申请']";
	public String NewWork_App_No6_Xpath = "//android.widget.TextView[@text='试用评估']";

	//工作圈
	public String Friends_Into_Id = "com.android.ayplatform:id/item_message_label";

	public String Friends_New_Id = "com.android.ayplatform:id/doing";
	public String friends_Back_Id = "com.android.ayplatform:id/back";

	//编辑界面
	public String Friends_Edit_Text_Id = "com.android.ayplatform:id/activity_published_talking_et";
	public String Friends_Edit_Pic_Id = "com.android.ayplatform:id/activity_published_talking_pic";
	public String FriendS_Edit_Shot_Id = "com.android.ayplatform:id/activity_published_talking_cameral";
	public String Friends_Edit_Alt_Id = "com.android.ayplatform:id/activity_published_talking_alt";
	public String Friends_Edit_Face_Id = "com.android.ayplatform:id/activity_published_talking_face";
	public String Friends_Edit_Location_Id = "com.android.ayplatform:id/activity_published_talking_location_tv";

	public String Friends_Edit_pre_Id = "com.android.ayplatform:id/head_right_doing";
	public String Friends_Edit_Back_Id = "com.android.ayplatform:id/back";

	//定位
	public String Friends_Location_Confirm = "com.android.ayplatform" +type+ ":id/head_right_doing";
	public String Friends_Location_Back = "com.android.ayplatform" +type+ ":id/back";

	//我的弹窗
	public String MyInfo_Tag_Message_Xpath = "//android.widget.TextView[@text='消息提醒']";
	public String MyInfo_Tag_Movement_Xpath = "//android.widget.TextView[@text='最新动态']";
	public String MyInfo_Tag_AccountSecurity_Xpath = "//android.widget.TextView[@text='账号与安全']";
	public String MyInfo_Tag_Pocket_Xpath = "//android.widget.TextView[@text='我的钱包']";
	public String MyInfo_Tag_AboutQY_Xpath = "//android.widget.TextView[@text='关于启业云']";

	public String MyInfo_Logo_Edit_Id = "com.android.ayplatform:id/item_private_head_edit";

	public String MyInfo_Logout_Id = "com.android.ayplatform:id/fragment_home_private_logout";

	//个人资料页
	public String PreData_Signature_Id = "com.android.ayplatform:id/activity_ayprivate_accountinfo_qianming_tv";
	public String PreData_Avatar_Id = "	com.android.ayplatform:id/activity_ayprivate_accountinfo_avatar_linear";

	public String PreData_Avatar_Camera_Id = "com.android.ayplatform:id/photo";
	public String PreData_Avatar_Gallery_Id = "com.android.ayplatform:id/album_selection";
	public String PreData_Avatar_Cancel_Id = "com.android.ayplatform:id/cancel";

	public String PreData_Back_Id = "com.android.ayplatform:id/back";

	//账号与安全
//	public String PreData_AS_AccountChange_Id = "com.android.ayplatform." +type+ ":id/ayprivate_switch_account_tv";
	public String PreData_as_CompanyChange_Id = "com.android.ayplatform." +type+ ":id/ayprivate_switch_ent_tv";

	//流程提交
	public String WorkFlow_Send_Id = "com.android.ayplatform." +type+ ":id/flow_detail_submit_Button";
	//流程保存
	public String WordFlow_Save_Id = "com.android.ayplatform:id/flow_detail_save_Button";



	public String WorkFlow_Comment_Id = "com.android.ayplatform:id/comment";
	public String WorKFlow_More_Id = "com.android.ayplatform:id/more";
	public String WorkFlow_Back_Id = "com.android.ayplatform:id/back";

	//工作建议
	public String WorkFlow_Advice_Id = "com.android.ayplatform:id/slave_add_TextView";

	//启聊
	public String QiLiao_CreatGroup_Id = "com.android.ayplatform." +type+ ":id/create_group";
	public String QiLiao_Chat_Xpath = "//android.widget.TextView[@text='会话']";
	public String QiLiao_MailList_Xpath = "//android.widget.TextView[@text='通讯录']";

	//对话页
	public String QiLiao_profile_Id = "com.android.ayplatform." +type+ ":id/chat_action_btn";
	public String QiLiao_Back_Id = "com.android.ayplatform." +type+ ":id/back";

	public String QiLiao_VoiceSwitch_Id = "com.android.ayplatform." +type+ ":id/rc_voice_toggle";
	public String QiLiao_Emoticon_Id = "com.android.ayplatform." +type+ ":id/rc_emoticon_toggle";
	public String QiLiao_More = "com.android.ayplatform." +type+ ":id/rc_plugin_toggle";

	//说话
	public String QiLiao_Talk_Id = "com.android.ayplatform" +type+ ":id/rc_audio_input_toggle";

	public String QiLaio_More_pic_Xpath = "//android.widget.TextView[@text='图片']";

	public String QiLiao_More_location_Xpath = "//android.widget.TextView[@text='位置']";

	public String QiLiao_More_Money_Xpath = "//android.widget.TextView[@text='红包']";

	//签到相机
	public String Sign_camera_shot_Id = "com.android.ayplatform" +type+ ":id/activity_work_camera_sgin_submit";
	public String Sign_camera_switch_Id ="com.android.ayplatform" +type+ ":id/view_camera_head_right";
	public String Sign_camera_flash_Id = "com.android.ayplatform" +type+ ":id/view_camera_head_left";
	public String Sign_camera_location_Id = "com.android.ayplatform" +type+ ":id/activity_work_camera_sgin_address";

	//搜索
	public String Search_main_app_Xpath = "//android.widget.TextView[@text='应用']";
	public String Search_mian_work_Xpath = "//android.widget.TextView[@text='工作']";
	public String Search_main_man_Xpath = "//android.widget.TextView[@text='同事']";

	//-筛选
	public String Search_main_filter_bottom = "com.android.ayplatform" +type+ ":id/fragment_workbench_search_result_filter";
	
	
	//public String Search_main_input_Id = "com.android.ayplatform" +type+ ":id/filter_edit";
	//public String Search_main_input_Id = "//android.widget.EditText[@text='输入搜索内容']";
	public String Search_mian_cancel_Id = "com.android.ayplatform" +type+ ":id/activity_cancel_tv";
	public String Search_mian_back_Id ="com.android.ayplatform" +type+ ":id/activity_back_iv";

	//消息中心
	public String Message_main_assign_Xpath = "//android.widget.TextView[@text='工作交办']";
	public String Message_main_mentions_Xpath = "//android.widget.TextView[@text='提到我的']";
	public String Message_main_dynamic_Xpath = "/android.widget.TextView[@text='工作动态']";
	public String Message_main_OSchange_Xpath = "//android.widget.TextView[@text='组织架构变动']";
	public String Message_main_SM_Xpath = "//android.widget.TextView[@text='系统消息']";
	public String Message_main_MC_Xpath ="//android.widget.TextView[@text='我评论的']";

	public String Message_back_Id = "com.android.ayplatform" +type+ ":id/back";

	//应用->列表->新建 release
	public String AppCenter_createNewWorkByAppList_Id = "com.android.ayplatform" +type+ ":id/activity_info_new";


}
