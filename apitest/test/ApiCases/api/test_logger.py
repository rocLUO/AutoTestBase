#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/23 0023 上午 9:42
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetLoginLogger(self):
        '''安全审计(获取用户登录日志)
           应用访问地址：/securityaudit/index
           平台应用场景：安全管理可以查看用户登录日志
        '''
        params={
            'mongoId':'',
            'limit':15,
            'page':1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/logger/GetLoginLogger',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】安全审计(获取用户登录日志)')  # 断言(检查返回值status是否为200)


    def test_GetOperationModules_case01(self):
        '''普通用户操作日志
           应用访问地址：/securityaudit/index
           平台应用场景：审计管理员可以查看用户登录日志
        '''
        params={
            'userType':0,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/logger/GetOperationModules',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('无数据', sendrequest.json()['msg'], msg='【response】安全审计(获取用户操作日志类型)')  # 断言(检查返回值status是否为200)


    def test_GetOperationModules_case02(self):
        '''管理员操作日志
           应用访问地址：/securityaudit/index
           平台应用场景：安全管理员可以查看管理员操作日志
        '''
        params={
            'userType':1,
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/logger/GetOperationModules',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('操作成功', sendrequest.json()['msg'], msg='【response】安全审计(获取管理员操作日志类型)')  # 断言(检查返回值status是否为200)


    def test_GetLoginLogger_case01(self):
        '''安全审计(获取普通用户操作日志列表数据)
           应用访问地址：/securityaudit/index
           平台应用场景：审计管理员可以查看用户登录日志
        '''
        params={
            'mongoId':'',
            'limit':15,
            'page':0,
            'search[userType]':0
        }
        nowlogin = Login().login('wsm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/logger/GetLoger',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        #self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】安全审计(获取普通用户操作日志列表数据)')  # 断言(检查返回值status是否为200)


    def test_GetLoginLogger_case02(self):
        '''安全审计(获取管理员操作日志列表数据)
           应用访问地址：/securityaudit/index
           平台应用场景：安全管理可以查看用户登录日志
        '''
        params={
            'mongoId':'',
            'limit':15,
            'page':0,
            'search[userType]':1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/logger/GetLoger',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['count'], msg='【response】安全审计(获取管理员操作日志列表数据)')  # 断言(检查返回值status是否为200)
