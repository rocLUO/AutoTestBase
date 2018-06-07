#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/20 0020 下午 1:59
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetConfig(self):
        '''获取当前用户托管状态
           应用访问地址：/organization/manage
           平台应用场景：管理员组织架构列表页面，点击托管时触发
        '''
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/trust/able')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('enabled', sendrequest.json(), msg='【response】获取当前用户托管状态')  # 断言(response)

    def test_Open(self):
        '''移动端定制：开启托管功能
           平台应用场景：账号安全——>账号托管——>开启托管
        '''
        nowlogin = Login().login('utest131')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/trust/open')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('开启成功!', sendrequest.json()['msg'], msg='【response】移动端定制：开启托管功能')  # 断言(response)

    def test_Status(self):
        '''移动端定制：查询托管状态
           平台应用场景：账号安全——>账号托管
        '''
        json = '"userId":"ApiTest","userName":"企业管理员"'
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/trust/status')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertIn(json, sendrequest.text, msg='【response】移动端定制：查询托管状态')  # 断言(response)

    def test_Close(self):
        '''移动端定制：关闭托管功能
           平台应用场景：账号安全——>账号托管——>关闭托管
        '''
        nowlogin = Login().login('yrr')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/trust/close')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('关闭成功!', sendrequest.json()['msg'], msg='【response】移动端定制：关闭托管功能')  # 断言(response)

    def test_trust(self):
        '''Web管理员解除组织架构托管
           平台应用场景：组织架构管理员管理界面解除托管关系
           解除托管用户：袁凤
        '''
        values = {
            'user_id': 'Uyuanfeng',
            'truster': 'ApiTest',
            'trustPath': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api/user/trust', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(True, sendrequest.json()['success'], msg='【response】Web管理员解除组织架构托管')  # 断言(response)
