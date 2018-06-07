#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/24 0024 上午 11:16
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetToken(self):
        '''启聊获取token
           平台应用场景：启聊获取token
        '''
        params = {
            'userId': 'ApiTest'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/chat/getToken', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1200', sendrequest.json()['status'], msg='【status】启聊获取token')  # 断言(检查返回值status是否为200)
        self.assertNotEqual('', sendrequest.json()['token'], msg='【response】启聊获取token')  # 断言(检查返回值status是否为200)

    def test_GetImUserInfo(self):
        '''获取某个用户信息
           平台应用场景：启聊查看用户信息
        '''
        params = {
            'userId': 'UIDdulei'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/chat/getImUserinfo', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1200', sendrequest.json()['status'], msg='【status】获取某个用户信息')  # 断言(检查返回值status是否为200)
        self.assertEqual('杜磊', sendrequest.json()['realName'], msg='【response】获取某个用户信息')  # 断言(检查返回值status是否为200)

    def test_GetAllDptGroupinfo(self):
        '''获取用户所有部门群信息
           平台应用场景：启聊查看所有部门群组
        '''
        json = "云平台研发部"
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/chat/getAllDptGroupinfo')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1200', sendrequest.json()['status'], msg='【status】获取用户所有部门群信息')  # 断言(检查返回值status是否为200)
        self.assertIn(json, sendrequest.text, msg='【response】获取用户所有部门群信息')  # 断言(检查返回值status是否为200)
