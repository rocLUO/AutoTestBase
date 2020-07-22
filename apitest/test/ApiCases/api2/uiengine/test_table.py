#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/2 0002 上午 10:33
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_Main(self):
        '''获取应用主表
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：DF、WF自定义筛选入口进入时触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/uiengine/table/main/information/DFMoRenPeiZhiHanCong/0')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取应用主表')
        self.assertEqual('dfmaindefault', sendrequest.json()['result'][0], msg='【response】获取应用主表')

    def test_AccessRequired(self):
        '''Workflow条件控制从表必填(必填)
           应用访问地址：/app/!/workflow/CongBiaoZiYingYongBi
           平台应用场景：Workflow条件控制从表必填
        '''
        values = {
            'formData[0][name]': 'uiyinqingzhubiaowf_zhubiaozifuchuan',
            'formData[0][value]': '必填'
        }
        json = {"display": True, "required": True}
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/table/access/workflow/CongBiaoZiYingYongBi/42',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Workflow条件控制从表必填(必填)')
        self.assertEqual(json, sendrequest.json()['result']['uiyinqingzhubiaowf']['uiyinqingcongbiao'],
                         msg='【response】Workflow条件控制从表必填(必填)')

    def test_AccessNotRequired(self):
        '''Workflow条件控制从表必填(非必填)
           应用访问地址：/app/!/workflow/CongBiaoZiYingYongBi
           平台应用场景：Workflow条件控制从表非必填
        '''
        values = {
            'formData[0][name]': 'uiyinqingzhubiaowf_zhubiaozifuchuan',
            'formData[0][value]': ''
        }
        json = {"display": False, "required": False}
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/table/access/workflow/CongBiaoZiYingYongBi/42',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Workflow条件控制从表必填(非必填)')
        self.assertEqual(json, sendrequest.json()['result']['uiyinqingzhubiaowf']['uiyinqingcongbiao'],
                         msg='【response】Workflow条件控制从表必填(非必填)')

    def test_NoTableCheck(self):
        '''验证应用是否配置主表(应用没有配置主表)
           应用访问地址：/app/edit?id=169&type=information#!/step_1/YingYongShiFouPeiZhi
           平台应用场景：验证应用是否配置主表(应用没有配置主表),UI引擎配置界面点击左侧业务设计（默认视图）触发
        '''

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/uiengine/table/check/information/YingYongShiFouPeiZhi/0')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(500, sendrequest.json()['status'], msg='【status】验证应用是否配置主表(应用没有配置主表)')
        self.assertEqual('请设置业务主表', sendrequest.json()['msg'], msg='【response】验证应用是否配置主表(应用没有配置主表)')

    def test_HasTableCheck(self):
        '''验证应用是否配置主表(应用配置了主表)
           应用访问地址：/app/edit?id=168&type=information#!/step_1/UIYinQingZiYingYongY
           平台应用场景：验证应用是否配置主表(应用没有配置主表),UI引擎配置界面点击左侧业务设计（默认视图）触发
        '''

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/uiengine/table/check/information/UIYinQingZiYingYongY/0')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】验证应用是否配置主表(应用配置了主表)')

    def test_SaveSetting(self):
        '''表单配置保存
           应用访问地址：/uiengine/#!/information/DFBiaoDanPeiZhiBaoCu
           平台应用场景：默认视图——>表单配置——>保存
        '''
        values = {
            'params': '{"main":{"tableId":"uiyinqingzhubiao"},"extend":[{"tableId":"uiyinqingcongbiao",'
                      '"condition":{"display":[],"required":[],"displayType":"AND"},'
                      '"fields":[{"title":"从表字符串","table":"uiyinqingcongbiao","field":"congbiaozifuchuan"}],'
                      '"type":"subordinate","magnifierConfig":[]},{"tableId":"uiyinqingziyingyongy",'
                      '"condition":{"display":[],"required":[],"displayType":"AND"},'
                      '"fields":[{"title":"子应用字段","table":"uiyinqingziyingyongy",'
                      '"field":"ziyingyongziduan"}],"type":"subapp","magnifierConfig":[]}],"magnifierConfig":[],"documents":{"word":[],"export":[]}}'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/table/setting/information/DFBiaoDanPeiZhiBaoCu/0',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】表单配置保存')

    def test_SaveMain(self):
        '''业务表设计新增表单(workflow:主表绑定)
           应用访问地址：/app/edit?id=162&type=workflow#!/step_2/WFYeWuBiaoXinZengBia/39
           平台应用场景：默认视图——>业务表设计——>选择表
           选择表单：UI引擎主表
        '''
        values = {
            'params[extra]': 'uiyinqingzhubiao',
            'params[table]': 'uiyinqingzhubiao',
            'params[type]': 'main'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/uiengine/table/workflow/WFYeWuBiaoXinZengBia/39',
                                    data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】业务表设计新增表单(workflow:主表绑定)')
