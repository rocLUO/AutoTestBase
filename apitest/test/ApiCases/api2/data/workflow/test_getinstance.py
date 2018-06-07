#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 1:54
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''APP获取流程列表数据
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：APP获取流程列表数据
           标签：代办工作
        '''
        params = {
            'order[field]': 'workflow_update_at',
            'startPage': 0,
            'perPage': 15,
            'labelId': 7,
            'order[type]': 'DESC'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/workflow/getinstance', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP获取流程列表数据')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(0, sendrequest.json()['result']['count'],
                            msg='【response】APP获取流程列表数据')  # 断言(检查返回值status是否为200)
