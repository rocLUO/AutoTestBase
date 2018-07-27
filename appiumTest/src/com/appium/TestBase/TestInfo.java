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


	/*------------------------------手机公共参数----------------------------------*/
	public static String Platform = "Android";
	public static String PhoneCode = "MKJNW17C20005057";
	public static String ApkPackage = "com.android.ayplatform.release";
	public static String ApkActivity = "com.android.ayplatform.activity.WelcomeActivity";
	public static String Version = "8.0";

	//before start method act
	public static int waitTime = 5000;

	//test lunch environment
	public static String type = ".release";

	// login method use
	public static String Account = "admin_pretest";
	public static String Password = "11111111";

	// change account name
	public static String ForAccountName = "";
	public static String PhoneHost= "http://127.0.0.1:4723/wd/hub";
	/*------------------------------华为手机公共参数----------------------------------*/
	public static String HuaWei_Camera_Shoot_Id = "com.huawei.camera"+type+":id/shutter_button";
	public static String HuaWei_Camera_confrim_Id = "com.huawei.camera"+type+":id/done_button";

	/*------------------------------控件公共参数----------------------------------*/

	//登录页
	public static String LoginPage_Id = "com.android.ayplatform"+type+":id/cardNumAuto";
	public static String LoginPage_Password = "com.android.ayplatform"+type+":id/Pass";
	public static String LoginPage_LoginKey = "com.android.ayplatform"+type+":id/login";

	//主页面
	public static String MainPage_NewWork_Id = "com.android.ayplatform:id/click_img";

	public static String MainPage_Tag_Already_Xpath = "//android.widget.TextView[@text='最近处理']";
	public static String MainPage_Tag_HoldOn_Xpath = "//android.widget.TextView[@text='待办工作']";
	public static String MainPage_Tag_MyLaunch_Xpath = "//android.widget.TextView[@text='我发起的']";

	public static String MainPage_Bar_Work_Xpath = "//android.widget.TextView[@text='工作']";
	public static String MainPage_Bar_QiLiao_Xpath = "//android.widget.TextView[@text='启聊']";
	public static String MainPage_Bar_DashBoard_Xpath = "//android.wmidget.TextView[@text='仪表盘']";
	public static String MainPage_Bar_App_Xpath = "//android.widget.TextView[@text='应用']";
	public static String MainPage_Bar_Discovery_Xpath = "//android.widget.TextView[@text='发现']";
	public static String MainPage_Bar_Protal_Xpath = "//android.widget.TextView[@text='门户']";

	//搜索
	public static String MainPage_Search_Id = "com.android.ayplatform" +type+ ":id/workbench_head_edit";
	public static String Protal_Search_Id = "com.android.ayplatform"+type+":id/actionFind";

	//组织架构页 搜索 icon
	public static String Company_SearchIcon_Id = "com.android.ayplatform"+ type +":id/workbench_head_search";

	//人员搜索列表 搜索 icon
	public static String SearchList_SearchIcon_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	//人员搜索列表 搜索框
	public static String SearchList_SearchInput_Id = "com.android.ayplatform"+ type +":id/edit";
	//人员搜索 确认按钮
	public static String SearchList_SearchDone_Xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView";
	//人员选择 确认
	public static String SearchList_SearchConfrim_Id = "com.android.ayplatform"+ type +":id/create_group_member_selector_confirm_tv";

	//组织架构 搜索框
	public static String Company_SearchInput_Id = "com.android.ayplatform"+ type +":id/org_search_filter_edit";

	//组织架构搜索 确定
	public static String Company_SearchSelect_done_Id = "com.android.ayplatform"+ type +":id/org_search_display_submit";
	//组织架构选择 确定
	public static String Company_Select_done_Id = "com.android.ayplatform"+type+":id/orgstructure_colleagues_display_submit";

	//主页面左上个头像->个人信息菜单
	public static String MainPage_preData_Xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.support.v4.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.view.View";
	public static String MainPage_preDate_coo = "76, 143";

	//主页面->点击新增工作
	public static String NewWork_App_No1_Xpath = "//android.widget.TextView[@text='打开签到']";
	public static String NewWork_App_No2_Xpath = "//android.widget.TextView[@text='工作计划']";
	public static String NewWork_App_No3_Xpath = "//android.widget.TextView[@text='工作协同']";
	public static String NewWork_App_No4_Xpath = "//android.widget.TextView[@text='员工薪资']";
	public static String NewWork_App_No5_Xpath = "//android.widget.TextView[@text='请假申请']";
	public static String NewWork_App_No6_Xpath = "//android.widget.TextView[@text='试用评估']";

	//工作圈
	public static String Friends_Into_Id = "com.android.ayplatform"+type+":id/item_message_label";

	public static String Edit_confrim_Id = "com.android.ayplatform"+type+":id/doing";
	public static String Edit_Back_Id = "com.android.ayplatform"+type+":id/back";

	//编辑界面
	public static String Friends_Edit_Text_Id = "com.android.ayplatform:id/activity_published_talking_et";
	public static String Friends_Edit_Pic_Id = "com.android.ayplatform:id/activity_published_talking_pic";
	public static String FriendS_Edit_Shot_Id = "com.android.ayplatform:id/activity_published_talking_cameral";
	public static String Friends_Edit_Alt_Id = "com.android.ayplatform:id/activity_published_talking_alt";
	public static String Friends_Edit_Face_Id = "com.android.ayplatform:id/activity_published_talking_face";
	public static String Friends_Edit_Location_Id = "com.android.ayplatform:id/activity_published_talking_location_tv";

	public static String Friends_Edit_pre_Id = "com.android.ayplatform"+type+":id/head_right_doing";

	//定位
	public static String Friends_Location_Confirm = "com.android.ayplatform" +type+ ":id/head_right_doing";
	public static String Friends_Location_Back = "com.android.ayplatform" +type+ ":id/back";


	//侧滑页
	//我的弹窗
	public static String MyInfo_Tag_Message_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.TextView[2]";
	//最新动态
	public static String MyInfo_Tag_Movement_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.TextView[2]";
	//帐号安全
	public static String MyInfo_Tag_AccountSecurity_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.TextView[2]";
    //我的钱包
	public static String MyInfo_Tag_Pocket_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.LinearLayout/android.widget.TextView[2]";
	//清除缓存
	public static String MyInfo_Tag_CleanMemory_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[5]/android.widget.LinearLayout/android.widget.TextView[2]";
    //关于启业云
    public static String MyInfo_Tag_AboutQY_Xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.LinearLayout[7]/android.widget.LinearLayout/android.widget.TextView[2]";
	public static String MyInfo_Logo_Edit_Id = "com.android.ayplatform"+type+":id/item_private_head_edit";
	//来电提示 开关
    public static String MyInfo_callSwitch_Id = "com.android.ayplatform"+type+":id/menu_call_switch";


	public static String MyInfo_Logout_Id = "com.android.ayplatform"+ type +":id/fragment_home_private_logout";

	//个人资料页
    //签名
	public static String PreData_Signature_Id = "com.android.ayplatform"+type+":id/activity_ayprivate_accountinfo_qianming_tv";
	//头像
	public static String PreData_Avatar_Id = "	com.android.ayplatform"+type+":id/activity_ayprivate_accountinfo_avatar_linear";
	//名片
    public static String PreData_UseCard_Id = "com.android.ayplatform"+ type +":id/activity_ayprivate_accountinfo_qrcode";

	//侧滑弹窗
    //编辑按钮
    public static String PreData_EditIcon_Id = "com.android.ayplatform"+type+":id/item_private_head_edit";
    //二维码按钮
    public static String PreData_qrcode_Id = "com.android.ayplatform"+type+":id/item_private_head_qrcode";
	//个人签名
    public static String PreData_QianMing_Id= "com.android.ayplatform"+type+":id/activity_ayprivate_accountinfo_qianming_linear";

	public static String PreData_Avatar_Camera_Id = "com.android.ayplatform:id/photo";
	public static String PreData_Avatar_Gallery_Id = "com.android.ayplatform:id/album_selection";
	public static String PreData_Avatar_Cancel_Id = "com.android.ayplatform:id/cancel";

	public static String PreData_Back_Id = "com.android.ayplatform:id/back";

	//账号与安全
	//public static String PreData_AS_AccountChange_Id = "com.android.ayplatform" +type+ ":id/ayprivate_switch_account_tv";
    //public static String PreDate_as_AccountAndS
	public static String PreData_as_CompanyChange_Id = "com.android.ayplatform" +type+ ":id/ayprivate_switch_ent_tv";
	public static String PreData_as_AccountChange_Id = "android.ayplatform" +type+ ":id/ayprivate_switch_ent_layout";

	//流程提交
	public static String WorkFlow_Send_Id = "com.android.ayplatform"+type+":id/flow_detail_submit_Button";
	//流程保存
	public static String WorkFlow_Save_Id = "com.android.ayplatform"+type+":id/flow_detail_save_Button";

	//评论
	public static String WorkFlow_Comment_Id = "com.android.ayplatform"+type+":id/comment";

	//工作评论 Text输入框
	public static String Comment_InputText_Id = "com.android.ayplatform"+ type +":id/input_box_view_input_sms";
	public static String Comment_Send_Id = "com.android.ayplatform"+ type + ":id/input_box_view_send_sms";
	public static String Comment_Face_Id = "com.android.ayplatform"+ type + ":id/input_box_view_image_face";
	public static String Comment_At_Id = "com.android.ayplatform"+ type +":id/input_box_view_at";

	//更多
	public static String WorkFlow_More_Id = "com.android.ayplatform" + type + ":id/more";
	public static String WorkFlow_Back_Id = "com.android.ayplatform"+ type +":id/back";

	//工作操作
	public static String WorkFlow_Interrpt_Xpath = "//android.widget.TextView[@text='中断']";
	public static String WorkFlow_Copy_Xpath = "//android.widget.TextView[@text='抄送']";
	public static String WorkFlow_Entrust_Xpath = "//android.widget.TextView[@text='委托']";
	public static String WorkFlow_History_Xpath = "//android.widget.TextView[@text='历史记录']";
	public static String WorkFlow_Delete_Xpath = "//android.widget.TextView[@text='删除流程']";
	public static String WorkFlow_Return_Xpath = "//android.widget.TextView[@text='回退']";
	public static String WorkFlow_Urge_Xpath = "//android.widget.TextView[@text='催办']";
	public static String WorkFlow_GetBack_Xpath = "//android.widget.TextView[@text='取回']";

	//附件添加按钮
	public static String WorkFlow_Enclosure_Id = "com.android.ayplatform"+ type +":id/attach_ui_add";
	//附件类型
	public static String WorkFlow_Enclosure_camera = "com.android.ayplatform"+ type +":id/camera";
	public static String WorkFlow_Enclosure_photo = "com.android.ayplatform"+ type +":id/photo";
	public static String WorkFlow_Enclosure_file = "com.android.ayplatform"+ type +":id/file";

	//工作 确定/取消按钮
	public static String Button_Confrim_Xpath = "//android.widget.Button[@text='确定']";
	public static String Button_Cancel_Xpath = "//android.widget.Button[@text='取消']";

	//工作 操作 字段输入弹窗
	public static String WorkFlow_InputWindow_Id = "com.android.ayplatform"+ type +":id/et_msg";

	//工作 编辑 字段 输入框
	public static String EditField_input_Id = "com.android.ayplatform"+ type +":id/activity_textui_edt_content";
	//工作 编辑 字段 完成
	public static String EditField_done_Id = "com.android.ayplatform"+ type +":id/head_right_doing";
	//工作 位置 字段 完成
	public static String LocationField_done_Id = "com.android.ayplatform"+ type +":id/btnSubmit";
	//工作 日期 字段 添加按钮
	public static String DateField_create_Xpath = "//android.widget.TextView[@text='请选时间']";
	//工作 日期 字段 完成
	public static String DateField_done_Id = "com.android.ayplatform"+ type +":id/okButton";
	//工作 用户信息 字段 添加按钮
	public static String userField_create_Id = "com.android.ayplatform"+ type +":id/userInfo_ui_name";

	//启聊
	public static String QiLiao_CreatGroup_Id = "com.android.ayplatform" +type+ ":id/create_group";
	public static String QiLiao_Chat_Xpath = "//android.widget.TextView[@text='会话']";
	public static String QiLiao_MailList_Xpath = "//android.widget.TextView[@text='通讯录']";

	public static String QiLiao_MailSearch_Xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";

	public static String QiLiao_CreateGroup_men_Id = "com.android.ayplatform"+ type +":id/create_group_select_member";
	public static String QiLiao_CreateGroup_company_Id = "com.android.ayplatform"+ type +":id/create_group_select_org";

	public static String QiLiao_CompanyList_Xpath = "//android.widget.TextView[@text='组织架构']";

	//对话页
	public static String QiLiao_profile_Id = "com.android.ayplatform" +type+ ":id/chat_action_btn";

	public static String QiLiao_VoiceSwitch_Id = "com.android.ayplatform" +type+ ":id/rc_voice_toggle";
	public static String QiLiao_Emoji_Id = "com.android.ayplatform." +type+ ":id/rc_emoticon_toggle";
	public static String QiLiao_More_Id = "com.android.ayplatform" +type+ ":id/rc_plugin_toggle";
	//群组设置页
	public static String QiLiao_GroupSet_Id = "com.android.ayplatform"+ type +":id/chat_action_btn";
	//群组名
	public static String QiLiao_GroupSet_Name_Xpath = "//android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ImageView";
	//public static String QiLiao_GroupSet_Name_Id = "com.android.ayplatform"+type+":id/item_message_value";
	//群组民 编辑页
	public static String QiLiao_GroupSet_NameEdit_Id = "com.android.ayplatform"+ type +":id/activity_modify_groupname_content";
	//二维码名片
	public static String QiLiao_GroupSet_Card_Xpath = "//android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView";
	public static String QiLiao_GroupSet_AddMen_Xpath = "//android.widget.TextView[@text='添加成员']";
	public static String QiLiao_GroupSet_DeleteMen_Xpath = "//android.widget.TextView[@text='删除成员']";
	//消息免打扰开关
	public static String QiLiao_GroupSet_NoDisturbSwitch_Id = "com.android.ayplatform"+type+":id/message_notice_switch";
	//解散群组
	public static String QiLiao_GroupSet_DisMissGroup_Xpath = "//android.widget.LinearLayout[3]/android.widget.LinearLayout/android.widget.LinearLayout";

	//输入框
	public static String QiLiao_TextInput_Id = "com.android.ayplatform"+ type +":id/rc_edit_text";
	//发送 按钮
	public static String QiLiao_SendText_Id = "com.android.ayplatform"+ type +":id/rc_send_toggle";

	//会话
	public static String QiLiao_Talk_Id = "com.android.ayplatform" +type+ ":id/rc_audio_input_toggle";

	public static String QiLaio_More_pic_Xpath = "//android.widget.TextView[@text='图片']";

	public static String QiLiao_More_location_Xpath = "//android.widget.TextView[@text='位置']";

	public static String QiLiao_More_Money_Xpath = "//android.widget.TextView[@text='红包']";

	public static String QiLiao_More_File_Xpath = "//android.widget.TextView[@text='文件']";

	//启聊 图片选择发送
	public static String QiLiao_sendPic_Id = "com.android.ayplatform"+type+":id/send";

	//启聊 @ 人员搜索框
	public static String QiLiao_AtSearch_Id = "com.android.ayplatform"+type+":id/search_layout";
	//启聊 @ 人员搜索输入框
	public static String QiLiao_AtSearchInPut_Id = "com.android.ayplatform"+type+":id/search_at_member_et";
	//启聊 @ 人员搜索结果
	public static String QiLiao_AtSeach_result_Id = "com.android.ayplatform"+type+":id/tv_name";
	//文件操作

	public static String File_Send_local_Id = "com.android.ayplatform"+ type +":id/rc_ac_tv_file_manager_mobile_memory";

	public static String File_Send_Id = "com.android.ayplatform" + type + ":id/rc_ad_tv_file_list_select_state";

	//工作 附件 图片 编辑
	public static String File_PhotoEdit_usePic_Id = "com.android.ayplatform"+ type +":id/activity_photo_preview_use";
	public static String File_PhonoEidt_Edit_Id = "com.android.ayplatform"+ type +":id/activity_photo_preview_edit";
	public static String File_PhotoEdit_retake_Id = "com.android.ayplatform"+ type +":id/activity_photo_preview_retake";
	public static String File_PhotoEdit_locatin_Id = "com.android.ayplatform"+ type +":id/activity_photo_preview_addressTv";


	//签到相机
	public static String Sign_camera_shot_Id = "com.android.ayplatform" +type+ ":id/activity_work_camera_sgin_submit";
	public static String Sign_camera_switch_Id ="com.android.ayplatform" +type+ ":id/view_camera_head_right";
	public static String Sign_camera_flash_Id = "com.android.ayplatform" +type+ ":id/view_camera_head_left";
	public static String Sign_camera_location_Id = "com.android.ayplatform" +type+ ":id/activity_work_camera_sgin_address";

	//搜索
	public static String Search_main_app_Xpath = "//android.widget.TextView[@text='应用']";
	public static String Search_mian_work_Xpath = "//android.widget.TextView[@text='工作']";
	public static String Search_main_man_Xpath = "//android.widget.TextView[@text='同事']";

	//-筛选
	public static String Search_main_filter_bottom = "com.android.ayplatform" +type+ ":id/fragment_workbench_search_result_filter";
	
	
	//public static String Search_main_input_Id = "com.android.ayplatform" +type+ ":id/filter_edit";
	//public static String Search_main_input_Id = "//android.widget.EditText[@text='输入搜索内容']";
	public static String getSearch_main_Icon_Id = "com.android.ayplatform"+ type +":id/actionFind";
	public static String Search_mian_cancel_Id = "com.android.ayplatform" +type+ ":id/activity_cancel_tv";
	public static String Search_mian_back_Id ="com.android.ayplatform" +type+ ":id/activity_back_iv";

	//消息中心
	public static String Message_main_assign_Xpath = "//android.widget.TextView[@text='工作交办']";
	public static String Message_main_mentions_Xpath = "//android.widget.TextView[@text='提到我的']";
	public static String Message_main_dynamic_Xpath = "/android.widget.TextView[@text='工作动态']";
	public static String Message_main_OSchange_Xpath = "//android.widget.TextView[@text='组织架构变动']";
	public static String Message_main_SM_Xpath = "//android.widget.TextView[@text='系统消息']";
	public static String Message_main_MC_Xpath ="//android.widget.TextView[@text='我评论的']";

	public static String Message_back_Id = "com.android.ayplatform" +type+ ":id/back";

	//应用->列表->新建 release
	public static String AppCenter_createNewWorkByAppList_Id = "com.android.ayplatform" +type+ ":id/activity_info_new";

	//门户组件

	//门户切换
	public static String Protal_SwitchIcon_Id = "com.android.ayplatform"+type+":id/portal_header_view_switch";

	//消息组件 (第一个组件)
	public static String Protal_NewsAssbmely_fullScreen_Xpath = "//android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";

	//工作组件
	public static String Protal_WorkAssbmely_fullScreen_Xpath = "//android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.view.ViewGroup/android.support.v7.widget.RecyclerView/android.widget.FrameLayout[1]/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView[1]";
	public static String Protal_WorkASSBMELY_CloseFullScreen_Xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";

	public static String Protal_WorkAssbmely_HoldOn_Xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.LinearLayout/android.widget.TextView";
	public static String Protal_WorkAssbmely_Alreaddy_Xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.LinearLayout/android.widget.TextView";
	public static String Protal_WorkAssbmely_Mylaunch_Xpath = "//android.widget.LinearLayout[1]/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.RelativeLayout[3]/android.widget.LinearLayout/android.widget.TextView";

	public static String Protal_Message_fullScreen_Xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]";
	public static String Protal_Message_CloseFullScreen_Xpath = "//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView[2]";

	//新快捷入口
	public static String Protal_fastEntranceIcon_open_Xpath = "//android.widget.FrameLayout[1]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView";

	//快捷入口
	//测试门户入口预置参数
	//新建工作入口
}
