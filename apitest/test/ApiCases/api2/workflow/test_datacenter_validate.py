#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 上午 10:24
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''流程从表必填验证(无字段值控制必填验证)
           应用访问地址：/app/!/workflow/QuanZiDuanLiuCheng
           平台应用场景：流程从表必填验证
           main_字符串：sub01从表必填
        '''
        params = {
            'table_id[]': 'wfsub01'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/datacenter_validate/QuanZiDuanLiuCheng/18/WorkNode_1/',
                                   params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(False, sendrequest.json()['result'], msg='【status】流程从表必填验证')
