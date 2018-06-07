#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 9:44
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''显示哪些用户托管给当前用户
           应用访问地址：/user/setting#!/trust/
           平台应用场景：个人设置进去触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/user/trusters')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】显示哪些用户托管给当前用户')
        self.assertNotEqual([], sendrequest.json()['result']['userList'], msg='【response】显示哪些用户托管给当前用户')
