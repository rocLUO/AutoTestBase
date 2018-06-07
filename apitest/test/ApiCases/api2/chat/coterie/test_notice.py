#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/24 0024 上午 10:47
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_SendComment(self):
        '''工作圈消息提醒列表
           平台应用场景：工作圈——>消息提醒列表
        '''
        params={
            'userId':'ApiTest',
            'perpage':20,
            'start':0,
            'status':0
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/coterie/notice',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】应用分析权限控制——列表获取')  # 断言(检查返回值status是否为200)
