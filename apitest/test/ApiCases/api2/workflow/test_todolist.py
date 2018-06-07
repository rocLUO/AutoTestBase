#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 1:41
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_todolist(self):
        '''获取流程代办数据
           应用访问地址：/user/index
           平台应用场景：老首页获取流程代办数据
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/todolist')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程代办数据')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取流程代办数据')
