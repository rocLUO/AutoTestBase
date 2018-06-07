#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 上午 10:21
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_datacentercash(self):
        '''数据中心缓存清理
           应用访问地址：/config
           平台应用场景：管理员config工具页面（可通过运维开关开启，默认关闭）
        '''
        values = {
            'action': 'datacenter'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/cache', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】数据中心缓存清理')  # 断言(检查返回值status是否为200)

    def test_orgcash(self):
        '''组织架构缓存清理
           应用访问地址：/config
           平台应用场景：管理员config工具页面（可通过运维开关开启，默认关闭）
        '''
        values = {
            'action': 'org'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/cache', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】组织架构缓存清理')  # 断言(检查返回值status是否为200)

    def test_applistcash(self):
        '''应用列表缓存清理
           应用访问地址：/config
           平台应用场景：管理员config工具页面（可通过运维开关开启，默认关闭）
        '''
        values = {
            'action': 'applist'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/cache', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】应用列表缓存清理')  # 断言(检查返回值status是否为200)
