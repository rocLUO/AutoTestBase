#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 2:54
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionPUT(self):
        '''通过邮箱检索修改密码【不传邮箱】
           应用访问地址：/home/retrievepassword/apitest
           平台应用场景：首页找回密码最后一步修改密码时触发
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/home/retrievepwd')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(500, sendrequest.json()['status'], msg='【status】通过邮箱检索修改密码【不传邮箱】')
