#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/13 0013 下午 3:01
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''规则引擎配置页面表字段查询
           规则引擎配置地址：/rulesengine/create/startrules/?edit=6
           规则引擎规则名称:dataflow添加触发消息提醒
           步骤：指定触发条件
           平台应用场景：规则引擎配置页面获取表字段
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/field/shujubiaoa')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('数据表A', sendrequest.json()['title'], msg='【response】规则引擎配置页面表字段查询')  # 断言(检查返回值response)