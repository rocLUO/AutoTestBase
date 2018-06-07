#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 上午 11:19
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''dataflow数据移交
           应用访问地址：/app/!/information/DFMoRenPeiZhiHanCong
           平台应用场景：dataflow数据移交
           移交数据：移交'宋一伟'这条数据给袁凤
        '''
        values = {
            'appId': 'DFMoRenPeiZhiHanCong',
            'records[]': 5,
            'receiver': 'Uyuanfeng'
        }
        msg = 'dataflow数据移交'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/dataflow/transfer/dfmaindefault', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】' + msg)
        self.assertEqual(True, sendrequest.json()['result'], msg='【response】' + msg)
