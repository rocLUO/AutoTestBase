#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 4:54
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_DFDetailPrint(self):
        '''Android dataflow打印
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：Android dataflow打印(需要设备)
           main字符串：张宗超
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(
            Login().url + '/api2/data/mobileprinter/dFDetailPrint/DFMoRenPeiZhiHanCong/dfmaindefault/2')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】Android dataflow打印')
        self.assertNotEqual([], sendrequest.json()['data'], msg='【response】Android dataflow打印')

    def test_WFDetailPrint(self):
        '''Android workflow打印
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：Android workflow打印(需要设备)
           工作标题：测试组必备技能
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(
            Login().url + '/api2/data/mobileprinter/wFDetailPrint/GongZuoXieTong/12/WorkNode_-1')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】Android workflow打印')
        self.assertNotEqual([], sendrequest.json()['data'], msg='【response】Android workflow打印')
