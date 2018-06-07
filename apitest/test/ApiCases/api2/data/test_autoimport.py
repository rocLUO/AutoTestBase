#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 4:20
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET_case01(self):
        '''【Web】workflow从表数据批量添加列表数据获取
           应用访问地址：/app/!/workflow/LiuChengCongBiaoPiLi
           平台应用场景：流程从表批量（点击从表小箭头触发）
        '''
        params = {
            'configs[tableId]': 'wfsub01congbiaopilia'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/autoimport', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Web workflow从表数据批量添加列表数据获取')
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】Web workflow从表数据批量添加列表数据获取')


    def test_actionGET_case02(self):
        '''【Web】dataflow从表数据批量添加列表数据获取
           应用访问地址：/app/!/information/dataflowCongBiaoPiLi
           平台应用场景：dataflow从表批量（点击从表小箭头触发）
        '''
        params = {
            'configs[tableId]':'dfsub01congbiaopilia'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/autoimport', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】Web dataflow从表数据批量添加列表数据获取')
        self.assertNotEqual(0, sendrequest.json()['result']['count'], msg='【response】Web dataflow从表数据批量添加列表数据获取')
