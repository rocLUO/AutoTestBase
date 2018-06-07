#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : zhnagyiwen
import unittest, os, sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''应用中心添加分类（双击添加分类）
           应用地址：/appcenter/appsystem/13
           使用状态：使用中
        '''
        values = {
            'params[name]': 'test',
            'params[description]': '',
            'params[category]': 13,
            'params[level]': 2,
            'params[order]': 2
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/app/admin', data=values)
        outputrequest(sendrequest, os.path.abspath(__file__), sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】应用中心添加分类')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】应用中心添加分类')
