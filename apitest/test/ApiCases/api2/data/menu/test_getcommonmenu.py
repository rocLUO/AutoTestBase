#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/25 0025 上午 10:52
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''移动端常用菜单获取
           平台应用场景：移动端常用菜单获取
        '''
        nowlogin = Login().login('utest131')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/menu/getcommonmenu/Client')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】移动端常用菜单获取')  # 断言(检查返回值status是否为200)
