#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/20 0020 上午 10:28
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''密码等级
           应用访问地址：/user/setting#!/security/
           登录账号：杜磊
           平台应用场景：个人设置——>账号安全
        '''
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/password/getpwdgrade')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1', sendrequest.json()['grade'], msg='【response】密码等级')  # 断言(检查返回值status是否为200)

    def test_actionPost(self):
        '''修改密码
           登录账号：utest132
           平台应用场景：个人设置——>账号安全——>修改密码
        '''
        values = {
            'usermessage[password]': '22222222',
            'usermessage[old_pwd]': '11111111'
        }
        nowlogin = Login().login('utest132')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/user/password/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('ok', sendrequest.json()['status'], msg='【status】修改密码')  # 断言(检查返回值status是否为200)
