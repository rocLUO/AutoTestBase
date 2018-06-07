#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/24 0024 下午 3:20
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_creategroup(self):
        '''启聊新建群组
           平台应用场景：启聊新建群组
        '''
        params={
            'data':'{"userIds":["Umj","Uryy","Ucxy","Uham"],"groupName":"毛佳、颜蓉蓉、陈幸远..."}'
        }
        nowlogin = Login().login('maojia')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chat/groupchat/creategroup',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】启聊新建群组')  # 断言(检查返回值status是否为200)
        self.assertNotEqual('', sendrequest.json()['result']['groupId'], msg='【response】启聊新建群组')


    def test_checkuseringroup(self):
        '''扫码加入群组
           平台应用场景：APP扫码加入群组
        '''
        values1={
            'data':'{"userIds":["Umj","Ucxy","Uham"],"groupName":"扫码加入讨论组测试"}'
        }
        #创建讨论组
        nowlogin1 = Login().login('maojia')  # 登录系统
        sendrequest1 = nowlogin1.post(Login().url + '/api2/chat/groupchat/creategroup',data=values1)
        groupId=sendrequest1.json()['result']['groupId']
        nowlogin2 = Login().login('admin')

        #扫码加入讨论组
        strgroupid='"'+groupId+'"'
        data='{"groupId":' + strgroupid + ',"entId":"APICeShiQiYe"}'
        values2={
             'data':data
        }
        sendrequest = nowlogin2.post(Login().url + '/api2/chat/groupchat/checkuseringroup', data=values2)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】扫码加入群组')  # 断言(检查返回值status是否为200)
        self.assertEqual('扫码加入讨论组测试', sendrequest.json()['result']['groupName'], msg='【response】扫码加入群组')


