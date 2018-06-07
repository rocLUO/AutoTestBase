#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 2:20
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET_case01(self):
        '''点开流程获取详细信息(经办中，非添加流程时获取)
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：点开流程获取详细信息(经办中，非添加流程时获取)
           工作标题：测试主题00000016
        '''
        opration = [
            {'title': '抄送', 'type': 'CCWORKFLOW'},
            {'title': '取回', 'type': 'GETBACK'},
            {'title': '中断流程', 'type': 'BREAKWORKFOLW'},
            {'title': '催办', 'type': 'URGE'}
        ]
        Datatable = [
            {'gongzuoshenhe': []},
            {'gongzuoxietong': []}
        ]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/instance_node/GongZuoXieTong/95/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】点开流程获取详细信息')
        self.assertEqual(opration, sendrequest.json()['result']['opration'], msg='【opration】点开流程获取详细信息')
        self.assertNotEqual(Datatable, sendrequest.json()['result']['Datatable'], msg='【Datatable】点开流程获取详细信息')

    def test_actionGET_case02(self):
        '''添加流程时获取详细信息
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：添加流程时获取详细信息
        '''
        params = {
            'action': 'run',
            'workflowid': 'GongZuoXieTong'
        }
        nowlogin = Login().login('admin')  # 登录系统
        # 获取流程实例ID
        sendrequest1 = nowlogin.get(Login().url + '/api2/workflow/permission', params=params)
        instantid = sendrequest1.json()['result']['instantid']
        # 流程发起
        sendrequest = nowlogin.get(
            Login().url + '/api2/workflow/instance_node/GongZuoXieTong/' + str(instantid) + '/WorkNode_1')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】添加流程时获取详细信息')
