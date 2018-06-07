#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 9:50
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_phone(self):
        '''检查手机号在系统中是否唯一
        '''
        values = {
            'field': 'phone',
            'value': '15190450427'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/user/unique', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】检查手机号在系统中是否唯一')
        self.assertEqual(False, sendrequest.json()['result'], msg='【response】检查手机号在系统中是否唯一')

    def test_email(self):
        '''检查邮箱在系统中是否唯一
        '''
        values = {
            'field': 'email',
            'value': '472173257@qq.com'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/user/unique', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】检查邮箱在系统中是否唯一')
        self.assertEqual(False, sendrequest.json()['result'], msg='【response】检查邮箱在系统中是否唯一')
