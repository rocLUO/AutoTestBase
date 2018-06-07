#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/18 0018 下午 3:47
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''人员概况(包含：当天活跃人数、活跃用户分布、最近加入人员)
           应用访问地址：/companyinfo/index
           平台应用场景：人员概况
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/enteroperation/user')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】人员概况(包含：当天活跃人数、活跃用户分布、最近加入人员)')  # 断言(检查返回值status是否为200)
        self.assertNotEqual(0, sendrequest.json()['result']['activeUser'], msg='【response】人员概况(包含：当天活跃人数、活跃用户分布、最近加入人员)')  # 断言(检查返回值status是否为200)