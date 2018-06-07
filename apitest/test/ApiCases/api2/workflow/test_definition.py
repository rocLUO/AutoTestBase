#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:33
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取所有流程信息
           应用访问地址：/workflow/admin#!statistics/QuanZiDuanLiuCheng
           平台应用场景：获取所有流程信息
        '''
        params = {
            'action': 'data'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/definition', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取所有流程信息')
        self.assertNotEqual([], sendrequest.json()['result']['workflows'], msg='【response】获取所有流程信息')

    def test_actionGET_case01(self):
        '''获取当前流程运行状态信息
           应用访问地址：/workflow/admin#!statistics/QuanZiDuanLiuCheng
           平台应用场景：获取当前流程运行状态信息
        '''
        params = {
            'workflowid': 'QuanZiDuanLiuCheng',
            'action': 'statistics'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/definition', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取当前流程运行状态信息')

    def test_actionGET_case02(self):
        '''获取流程信息(myworkflow)
           应用访问地址：/workflow/admin#!statistics/QuanZiDuanLiuCheng
           平台应用场景：获取流程信息(myworkflow)
        '''
        params = {
            'workflowid': 'QuanZiDuanLiuCheng',
            'action': 'myworkflow'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/definition', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程信息(myworkflow)')
