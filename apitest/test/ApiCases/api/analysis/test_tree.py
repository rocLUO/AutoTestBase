#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''web应用分析权限控制——列表获取
           应用访问地址：/analysis/permission#module
           平台应用场景：PaaS后台管理界面进入，用于控制哪些人具备哪些应用的分析权限
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/analysis/tree')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】应用分析权限控制——列表获取')  # 断言(检查返回值status是否为200)