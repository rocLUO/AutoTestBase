#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 9:29
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPUT(self):
        '''用户皮肤切换
           平台应用场景：用户可自由切换皮肤
        '''
        values = {
            'params[theme]': 'black',
            'params[userId]': 'UIDdulei'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/user/theme', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】用户皮肤切换')
