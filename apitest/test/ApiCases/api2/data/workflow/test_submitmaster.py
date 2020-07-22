#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/28 0028 下午 3:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_submitmain(self):
        '''APP流程——从表添加权限验证(主表无添加权限)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           工作标题：流程从表添加权限用例
           平台应用场景：工作协同
        '''
        values = {'instanceId': 10085,
                  'subordinateTableId': 'gongzuoshouli',
                  'nodeId': 'WorkNode_4',
                  'workflowId': 'GongZuoXieTong',
                  'data': '[]'
                  }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/data/workflow/submitmain', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect = 1200  # 期望返回值
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        actual = sendrequest.json()['status']  # 实际返回值
        self.assertEqual(expect, actual, msg='【APP】流程从表添加权限验证(主表无添加权限)')  # 断言
