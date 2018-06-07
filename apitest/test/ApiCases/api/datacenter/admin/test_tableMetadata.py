#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/18 0018 上午 11:30
# @Author  : Dulei
import unittest, os, sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''数据中心编辑扩展属性
           应用访问地址：数据中心
           平台应用场景：数据中心（数据模型），点击编辑扩展属性出发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/admin/tableMetadata/dfsubdefault01')
        outputrequest(sendrequest, os.path.abspath(__file__), sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')
        self.assertEqual([], sendrequest.json(), msg='【web】数据中心编辑扩展属性')
