#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 4:26
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取用户待办消息订阅情况
           应用访问地址：/user/setting#!/messageswitch/
           平台应用场景：个人设置——>代办推送订阅
        '''
        params = {
            'type': 'all'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/todoswitch', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取用户待办消息订阅情况')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取用户待办消息订阅情况')

    def test_actionPOST(self):
        '''用户待办消息订阅保存(除邮件)
           应用访问地址：/user/setting#!/messageswitch/
           平台应用场景：个人设置——>代办推送订阅
        '''
        values = {
            'app': 'all',
            'desktop': 'all',
            'email': '-1'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/message/todoswitch', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】用户待办消息订阅保存(除邮件)')
