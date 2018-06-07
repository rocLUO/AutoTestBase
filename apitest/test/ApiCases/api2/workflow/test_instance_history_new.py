#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:52
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取流程历史记录
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：获取流程历史记录
           工作标题：测试组的日常工作
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance_history_new/GongZuoXieTong/7/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程历史记录')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取流程历史记录')
