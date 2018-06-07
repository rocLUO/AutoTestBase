#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/23 0023 上午 9:02
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet_case01(self):
        '''角色权限获取(角色授权-角色权限)
        '''
        params = {
            'model': 'workbench',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/lead/config', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】角色权限获取(角色授权-角色权限)')  # 断言(检查返回值status是否为200)


    def test_actionGet_case02(self):
        '''获取功能引导配置
           应用访问地址：/user/workbench
           平台应用场景：点击应用进入引用列表时触发
           应用：工作台
        '''
        params = {
            'model': 'workbench',
            'function': 'header'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/lead/config', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取功能引导配置')  # 断言(检查返回值status是否为200)


    def test_actionPOST(self):
        '''设置用户引导状态
        '''
        values = {
            'model': 'workbench',
            'type': 'done'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/lead/status/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】设置用户引导状态')  # 断言(检查返回值status是否为200)
