#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 4:42
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''Web我发起的工作---已完成的+进行中
           应用访问地址：/user/workbench
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/worklist')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Web我发起的工作---已完成的+进行中')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】Web我发起的工作---已完成的+进行中')

    def test_actionGET_case01(self):
        '''App工作台我发起的
        '''
        params = {
            'client': 'mobile'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/worklist', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】App工作台我发起的')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】App工作台我发起的')

    def test_actionGET_case02(self):
        '''App工作台我发起的——进行中
           App我发起的tab标签【进行中】点击全部时触发
        '''
        params = {
            'groupType': 'running'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/worklist', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】App工作台我发起的——进行中')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】App工作台我发起的——进行中')

    def test_actionGET_case03(self):
        '''App工作台我发起的——已完成
           App我发起的tab标签【已完成】点击全部时触发
        '''
        params = {
            'groupType': 'finished'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/worklist', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】App工作台我发起的——已完成')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】App工作台我发起的——已完成')
