#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:43
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''流程实例ID数据复制
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           平台应用场景：流程单条数据支持复制
           main_字符串：复制流程
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance_copy/QuanZiDuanLiuCheng/21')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程实例ID数据复制')
        self.assertEqual('选项2', sendrequest.json()['result']['wfmain']['maindanxuan'], msg='【response】流程实例ID数据复制')
        self.assertEqual('吉林省 通化市 辉南县', sendrequest.json()['result']['wfmain']['maindiqu'], msg='【response】流程实例ID数据复制')
        self.assertEqual(["C", "D"], sendrequest.json()['result']['wfmain']['mainduoxuan'], msg='【response】流程实例ID数据复制')
        self.assertEqual(110, sendrequest.json()['result']['wfmain']['mainshuzi'], msg='【response】流程实例ID数据复制')
        self.assertEqual('测试文本', sendrequest.json()['result']['wfmain']['mainwenben'], msg='【response】流程实例ID数据复制')
        self.assertEqual('复制流程', sendrequest.json()['result']['wfmain']['mainzifuchuan'], msg='【response】流程实例ID数据复制')
        self.assertIn('副总经理', sendrequest.json()['result']['wfmain']['mainzuzhijiagou'], msg='【response】流程实例ID数据复制')
