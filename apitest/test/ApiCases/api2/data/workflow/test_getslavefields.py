#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 3:29
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''APP获取流程从表结构
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           平台应用场景：APP获取流程从表结构(从表新建或修改时调用)
           标签：代办工作
           标题：从表已填
        '''
        params = {
            'workflowId': 'QuanZiDuanLiuCheng',
            'instanceId': 16,
            'nodeId': 'WorkNode_1',
            'subordinateId': 'wfsub01'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/workflow/getsubordinatefields', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP获取流程从表结构')
