#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:20
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''流程获取
           应用访问地址：/workflow/monitoring
           平台应用场景：流程监控，添加，选择流程时调用
        '''
        params = {
            'hideUnpublished': 'true'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/category', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】流程获取')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】流程获取')
