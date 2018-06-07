#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 2:08
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''数据检索搜索
           应用访问地址：/app/extract/workflow/GongZuoXieTong?text=组
           平台应用场景：数据检索
        '''
        params = {
            'searchText': '组',
            'paging[perPage]': 15,
            'paging[start]': 0
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/extract/data/workflow/GongZuoXieTong', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】数据检索搜索')
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】数据检索搜索')
