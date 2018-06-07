#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/24 0024 下午 1:41
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_CreateConversation(self):
        '''新建讨论组(目前6.6.0的APP已经关闭创建讨论组功能，后续会废弃该接口)
           平台应用场景：新建讨论组
        '''
        params={
            'conversationId':'595aaddb-a798-40f3-b3b2-ef6a4051769e',
            'conversationName':'群会话(test)',
            'conversationType':'discussion'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/conversation/createConversation',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(1200, sendrequest.json()['status'], msg='【status】新建讨论组')  # 断言(检查返回值status是否为200)
        self.assertEqual('595aaddb-a798-40f3-b3b2-ef6a4051769e', sendrequest.json()['result']['conversationId'], msg='【status】新建讨论组')  # 断言(检查返回值status是否为200)


    def test_GetConversationList(self):
        '''获取讨论组(目前6.6.0的APP已经关闭创建讨论组功能，后续会废弃该接口)
           平台应用场景：获取讨论组
        '''
        params={
            'conversationId':'595aaddb-a798-40f3-b3b2-ef6a4051769e',
            'conversationName':'群会话(test)',
            'conversationType':'discussion'
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chat/conversation/getConversationList',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1200', sendrequest.json()['status'], msg='【status】获取讨论组列表')  # 断言(检查返回值status是否为200)


    def test_DeleteConversationMember(self):
        '''退出讨论组(目前6.6.0的APP已经关闭创建讨论组功能，后续会废弃该接口)
           平台应用场景：退出讨论组
        '''
        params={
            'data':'{"conversationId":"595aaddb-a798-40f3-b3b2-ef6a4054769c","userIds":["UIDdulei"]}',
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/conversation/deleteConversationMember',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual('1200', sendrequest.json()['status'], msg='【status】退出讨论组')  # 断言(检查返回值status是否为200)


