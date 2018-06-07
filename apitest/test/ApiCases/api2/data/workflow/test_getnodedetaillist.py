#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 2:48
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''APP流程详情列表
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：APP流程点击查看详情
           标签：过往工作
           工作标题：测试组的日常工作
        '''
        params = {
            'workflowId': 'GongZuoXieTong',
            'instanceId': 7,
            'labelId': 9
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/workflow/getnodedetaillist', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】应用分析权限控制——流程详情列表')  # 断言(检查返回值status是否为200)
