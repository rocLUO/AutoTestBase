#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/11 0011 下午 6:47
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_config(self):
        '''获取UI引擎所有配置信息
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：在访问Dataflow列表时会请求并获取UI引擎配置
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/app/uiengine/config/information/DFMoRenPeiZhiHanCong/0/?system=1')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】获取UI引擎所有配置信息')  # 断言(检查返回值status是否为200)


    def test_thatMakeSence(self):
        '''获取指定的标签配置信息
           应用访问地址：未知
           平台应用场景：未知
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/app/uiengine/label/3')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】获取指定的标签配置信息')  # 断言(检查返回值status是否为200)
