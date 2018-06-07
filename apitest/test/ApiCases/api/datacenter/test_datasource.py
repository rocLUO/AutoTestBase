#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/13 0013 下午 2:56
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET_datacenter(self):
        '''普通用户，父子应用获取数据源
           应用访问地址：/app/!/information/FuYingYong
           父应用字符串:测试字符串2
           平台应用场景：父子应用通过数据源来连接，使用父子应用会使用
        '''
        params={
            'command':'compute',
            'tableId':'fuyingyong',
            'recordId':2
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/data/',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】普通用户,父子应用获取数据源')  # 断言(检查返回值status是否为200)
        self.assertEqual([], sendrequest.json()['result'], msg='【response】普通用户,父子应用获取数据源')  # 断言(检查返回值status是否为200)
