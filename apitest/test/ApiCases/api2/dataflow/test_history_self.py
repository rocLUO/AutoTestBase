#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 6:53
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''dataflow从表历史记录
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow从表历史记录
           main_字符串：杜磊
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/dataflow/history_self/dfsubdefault/1')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow从表历史记录')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】dataflow从表历史记录')
