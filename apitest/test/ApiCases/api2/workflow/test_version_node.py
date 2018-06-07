#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/3/29 0029 上午 11:44
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_version_node_get(self):
        '''web流程——流程委托后当前办理人
           应用访问地址：/app/!/workflow/WeiTuoYongLiYi
           工作标题：提交给杜磊，由杜磊委托给王聪明
           平台应用场景：流程委托后流程图示查看当前办理人
        '''
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/version_node/10086/WorkNode_2')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        expect1 = '王聪明'  # 期望返回值
        expect2 = 200
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言
        actual1 = sendrequest.json()['result']['handler']  # 实际返回值
        actual2 = sendrequest.json()['status']
        self.assertEqual(expect1, actual1, msg='【web】流程委托后当前办理人')  # 断言
        self.assertEqual(expect2, actual2)
