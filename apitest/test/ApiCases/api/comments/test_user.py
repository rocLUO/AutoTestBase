#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/12 0012 上午 9:16
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet_case01(self):
        '''评论(获取@用户列表,点击@时获取)
           平台应用场景：评论，点击@，获取@用户列表
        '''
        values={
            'appId':'workflow_GongZuoXieTong_instance_12',
            'search':'',
            'start':0
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/comments/user/',params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】评论(获取@用户列表,点击@时获取)')  # 断言(检查返回值status是否为200)


    def test_actionGet_case02(self):
        '''评论(获取@用户列表,手动输入@人名时获取)
           平台应用场景：评论，输入@，获取@用户列表
        '''
        values={
            'appId':'workflow_GongZuoXieTong_instance_12',
            'search':'du',
        }
        json='杜磊'
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/comments/user/',params=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】评论(获取@用户列表,手动输入@人名时获取)')  # 断言(检查返回值status是否为200)
        self.assertEqual(json,sendrequest.json()['result']['UIDdulei']['name'])
