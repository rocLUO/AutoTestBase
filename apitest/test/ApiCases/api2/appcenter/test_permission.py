#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : zhangyiwen
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''获取应用系统权限组
            状态：使用中
           应用地址：/appcenter/appsystem/79
        '''

        id = '79'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/appcenter/permission/group/' + id)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取应用系统权限组')  # 断言(检查返回值status是否为200)
        self.assertEqual('所有人都可看', sendrequest.json()['result']['10']['group_name'],
                         msg='【response】获取应用系统权限组')  # 断言(检查返回值status是否为200)

    def test_actionpost(self):
        '''新增/编辑 应用系统权限角色组
           状态：使用中
           应用地址：/appcenter/appsystem/79
        '''

        values = {
            'id''': 10,
            'appId': 79,
            'groupName': '所有人都可看',
            'blacklist[0][id]': 1,
            'blacklist[0][parent_id]': 0,
            'blacklist[0][type]': 'department',
            'blacklist[0][name]': 'API测试企业',
            'blacklist[0][checked]': 'true',
            'blacklist[0][checkedOrder]': 1,
            'blacklist[0][Parent]': 0,
            'blacklist[0][parent]': 0,
            'blacklist[0][Type]': 'department'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/appcenter/permission/group', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】新增/编辑 应用系统权限角色组')  # 断言(检查返回值status是否为200)
