#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/17 0017 下午 2:44
# @Author  : Dulei
import unittest, os, sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''用户信息字段选择后提交——仅显示姓名
           应用访问地址：/app/!/information/YongHuXinXi
           平台应用场景：用户信息字段选择后提交
        '''
        values={'userId[]':'UIDdulei'}
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/datacenter/org_name/',data=values)
        outputrequest(sendrequest, os.path.abspath(__file__), sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】用户信息字段选择后提交——仅显示姓名')
        self.assertEqual('杜磊', sendrequest.json()['result'][0], msg='【response】用户信息字段选择后提交——仅显示姓名')
