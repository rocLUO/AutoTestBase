#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 6:49
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''dataflow主表历史记录
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow主表历史记录
           main_字符串：宋一伟
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/dataflow/history/DFMoRenPeiZhiHanCong/dfmaindefault/5')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow主表历史记录')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】dataflow主表历史记录')
