#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/2 0002 上午 9:57
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_checktitle(self):
        '''APP-UI引擎workflow配置获取(应用名称获取)
           平台应用场景：APP进入流程应用列表时触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/uiengine/config/workflow/GongZuoXieTong/mobile')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】APP-UI引擎workflow配置获取(应用名称获取)')
