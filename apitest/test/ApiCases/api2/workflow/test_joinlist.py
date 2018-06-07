#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 1:48
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''Web工作台最近处理的流程
           应用访问地址：/user/workbench
        '''
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/joinlist')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Web工作台最近处理的流程')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】Web工作台最近处理的流程')

    def test_actionGET_case01(self):
        '''App工作台最近处理的流程
        '''
        params = {
            'client': 'mobile'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/joinlist', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】App工作台最近处理的流程')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】App工作台最近处理的流程')
