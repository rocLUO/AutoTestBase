#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : zhangyiwen
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''获取系统权限组列表(疑似原用户社交接口拆分)
           状态：未知
        '''
        params = {
            'groupId': 13
        }

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/appcenter/permission_group/', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取系统权限组列表')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取系统权限组列表')
