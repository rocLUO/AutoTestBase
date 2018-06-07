#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 4:35
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取流程共同工作(all)
           应用访问地址：通讯录点击某个人查看时触发（被前端处理了）
        '''
        params={
            'userId':'UIDdulei',
            'paging[start]':0,
            'paging[perPage]':2
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/together/all/',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取流程共同工作(all)')
