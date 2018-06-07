#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 上午 10:57
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''dataflow应用数据提醒
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow应用数据提醒,进入列表时触发
        '''
        nowlogin = Login().login('yuanfen')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/dataflow/remind_app/DFMoRenPeiZhiHanCong')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow应用数据提醒')
        self.assertEqual(True, sendrequest.json()['result'], msg='【response】dataflow应用数据提醒')
