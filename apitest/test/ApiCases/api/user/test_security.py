#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/20 0020 下午 1:50
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''个人设置－帐号安全－操作记录
           应用访问地址：/user/setting#!/security/
           平台应用场景：个人设置－帐号安全－操作记录
        '''
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/security/getopera')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)

    def test_actionPost(self):
        '''检测本次登录的地区是否与上次登录一致
           应用访问地址：工作台入口进入即可
           平台应用场景：检测本次登录的地区是否与上次登录一致
        '''
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/user/security/CheckArea')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】检测本次登录的地区是否与上次登录一致')  # 断言(检查返回值status是否为200)
        self.assertEqual('true', sendrequest.json()['result'], msg='【response】检测本次登录的地区是否与上次登录一致')  # 断言(检查返回值response)
