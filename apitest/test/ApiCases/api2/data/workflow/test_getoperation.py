#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 3:03
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''
           APP流程详情页操作按钮
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           平台应用场景：APP流程详情页操作按钮
           标签：经办工作
           标题：测试
        '''
        params = {
            'workflowId': 'QuanZiDuanLiuCheng',
            'instanceId': 8,
            'labelId': 120
        }

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/data/workflow/getoperation', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】APP流程详情页操作按钮')
        self.assertIn('历史记录', sendrequest.text, msg='【历史记录】')
        self.assertIn('取回', sendrequest.text, msg='【取回】')
        self.assertIn('抄送', sendrequest.text, msg='【抄送】')
        self.assertIn('催办', sendrequest.text, msg='【催办】')
        self.assertIn('中断', sendrequest.text, msg='【中断】')
        # self.assertIn('打印', sendrequest.text, msg='【打印】')
