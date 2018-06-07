#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : zhangyiwen
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''流程条件分支—>分支条件—>节点—>用户角色组获取
           配置地址：/workflow/setting/#!/GongZuoXieTong/1
           使用状态：使用中
        '''
        type = 'group'
        id = 'GongZuoXieTong'
        nowlogin = Login().login('admin')  # 登录系
        sendrequest = nowlogin.get(Login().url + '/api2/appcenter/app/' + type + '/' + id)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'],
                         msg='【status】流程条件分支—>分支条件—>节点—>用户角色组获取')  # 断言(检查返回值status是否为200)
        self.assertEqual('默认', sendrequest.json()['result']['WorkFlow'][0]['group_name'],
                         msg='【response】流程条件分支—>分支条件—>节点—>用户角色组获取')

    def test_actionGET_case01(self):
        '''当前用户所有角色组获取
        '''
        nowlogin = Login().login('admin')  # 登录系
        sendrequest = nowlogin.get(Login().url + '/api2/appcenter/app/group')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】当前用户所有角色组获取')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】当前用户所有角色组获取')
