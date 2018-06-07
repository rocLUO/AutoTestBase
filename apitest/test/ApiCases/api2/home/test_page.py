#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 2:43
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''获取当前企业banner和首页link
        '''
        json = '/user/workbench'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/home/page')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取当前企业banner和首页link')
        #self.assertEqual(json, sendrequest.json()['result']['link'], msg='【response】获取当前企业banner和首页link')
