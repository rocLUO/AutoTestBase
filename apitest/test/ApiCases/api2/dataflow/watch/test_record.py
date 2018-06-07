#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/25 0025 下午 6:38
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_watchDelete(self):
        '''dataflow取消关注单条记录
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow取消关注单条记录
           main_字符串：张译文
        '''
        values={
            'appId': 'DFMoRenPeiZhiHanCong'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api2/dataflow/watch/record/dfmaindefault/7',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow取消关注单条记录')


    def test_watchPoat(self):
        '''dataflow关注单条记录
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow关注单条记录
           main_字符串：张译文
        '''
        values={
            'appId': 'DFMoRenPeiZhiHanCong'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/dataflow/watch/record/dfmaindefault/7',data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】dataflow关注单条记录')
