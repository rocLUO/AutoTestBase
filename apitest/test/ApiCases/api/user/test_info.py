#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/20 0020 上午 10:17
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''个人设置-获取用户信息
           应用访问地址：/user/setting
           平台应用场景：个人设置-获取当前用户信息
        '''
        userId = 'ApiTest'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/info/' + userId)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】个人设置-获取用户信息')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】个人设置-获取用户信息')  # 断言(检查返回值response)

    def test_actionPUT(self):
        '''个人设置－修改我的信息
           应用访问地址：/user/setting
           登录账号：杜磊
           平台应用场景：个人设置－基本资料修改
        '''
        values = {
            'userMessage[real_name]': '杜磊',
            'userMessage[login_user_id]': 'LIDdulei',
            'userMessage[sex]': 0,
            'userMessage[birthday]': '1992-1-25',
            'userMessage[birth_type]': 0,
            'userMessage[jobdesc]': '测试',
            'userMessage[addr]': '这是联系地址',
            'userMessage[sign]': '这是个性签名',
            'userMessage[qq]': '472173257',
            'userMessage[phone]': '15190450427',
            'userMessage[email]': '472173257@qq.com',
            'userMessage[ext]': '8125',
            'userMessage[idcard]': '320281199201250774'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api/user/info', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】个人设置－修改我的信息')  # 断言(检查返回值status是否为200)
