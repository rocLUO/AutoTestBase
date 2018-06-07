#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:27
# @Author  : zhangyiwen
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''应用中心获取子权限列表
           应用访问地址：/appcenter/appsystem/79
           使用状态：未知
        '''
        groupId='13'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/appcenter/permission_children/'+groupId)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】应用中心获取子权限列表')  # 断言(检查返回值status是否为200)
