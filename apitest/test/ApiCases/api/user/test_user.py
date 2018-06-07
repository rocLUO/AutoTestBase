#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/28 0028 下午 5:43
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetContactMembers(self):
        '''组织架构弹框,获取用户常用联系人(适用于所有用户)
           平台应用场景：工作协同交办下一步执行人弹框
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/user/getContactMembers')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json(), msg='【status】组织架构弹框,获取用户常用联系人(适用于所有用户)')

    def test_GetGroupLists(self):
        '''组织架构弹框，获取角色组列表(适用于所有用户)
           平台应用场景：工作协同交办下一步执行人弹框
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/user/GetGroupLists')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json(), msg='【status】组织架构弹框，获取角色组列表(适用于所有用户)')

    def test_GetUserIdsByGroupId(self):
        '''组织架构弹框，勾选角色组(适用于所有用户)
           平台应用场景：工作协同交办下一步执行人弹框
        '''
        params = {
            'groupId': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/user/user/getUserIdsByGroupId', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】组织架构弹框，勾选角色组(适用于所有用户)')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】组织架构弹框，勾选角色组(适用于所有用户)')
