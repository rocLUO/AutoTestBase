#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 5:19
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet_case01(self):
        '''邮箱格式验证
           应用访问地址：/user/setting#!/security/
           平台应用场景：个人设置——>账号安全——>绑定邮箱
        '''
        params = {
            'email': 'du6349393@qq.com'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/verifycode/email/countdown/emailbind', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】邮箱格式验证')

    def test_actionGet_case02(self):
        '''邮箱绑定——发送邮件
           应用访问地址：/user/setting#!/security/
           平台应用场景：个人设置——>账号安全——>绑定邮箱
        '''
        params = {
            'email': 'du6349393@qq.com'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/verifycode/email/send/emailbind', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】邮箱绑定——发送邮件')
