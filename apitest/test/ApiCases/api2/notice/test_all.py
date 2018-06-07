#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 4:48
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''工作台提醒
           应用访问地址：
           平台应用场景：
        '''
        params = {
            'url': '/user/workbench'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/notice/all', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】工作台提醒')
        self.assertNotEqual(0, sendrequest.json()['result']['notice']['count'], msg='【response】工作台提醒')
