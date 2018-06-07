#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 4:43
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_comm(self):
        '''互动沟通列表数据显示
        '''
        params={
            'userId':'Uwcm',
            'paging[start]':0,
            'paging[perPage]':10
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/together/comm',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】互动沟通列表数据显示')
