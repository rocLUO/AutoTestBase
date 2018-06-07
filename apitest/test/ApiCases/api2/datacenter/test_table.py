#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/25 0025 下午 5:22
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_table(self):
        '''获取数据中心下所有数据表信息
           平台应用场景：通常不会被用到，该API通常用于配置相关逻辑，被用来查询现有数据表
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/datacenter/table')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取数据中心下所有数据表信息')

