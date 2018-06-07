#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 3:24
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_readMessage(self):
        '''标记文本消息为已读---Web端(单条已读消息)
           应用访问地址：/notice/index
           平台应用场景：文本消息@后点击标记已读
           @我的内容：@杜磊 这条文本at杜磊for测试1
        '''
        values = {
            'type': 'id',
            'value': 361
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/message/notice/readMessage', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】标记文本消息为已读---Web端(单条已读消息)')
        self.assertEqual(1, sendrequest.json()['result'], msg='【response】标记文本消息为已读---Web端(单条已读消息)')

    def test_actionGET(self):
        '''消息中心列表数据获取---Web端
           应用访问地址：/notice/index
           平台应用场景：访问消息中心时触发
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('dulei')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】消息中心列表数据获取---Web端')

    def test_consign(self):
        '''消息中心---工作交办
           应用访问地址：/notice/index
           平台应用场景：消息中心---工作交办
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/consign', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】消息中心---工作交办')

    def test_comment(self):
        '''消息中心---提到我的
           应用访问地址：/notice/index
           平台应用场景：消息中心---提到我的
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/comment', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】消息中心---提到我的')

    def test_other(self):
        '''消息中心---工作动态
           应用访问地址：/notice/index
           平台应用场景：消息中心---工作动态
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/other', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】消息中心---工作动态')

    def test_jobchange(self):
        '''消息中心---组织架构变动
           应用访问地址：/notice/index
           平台应用场景：消息中心---组织架构变动
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/jobchange', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】消息中心---组织架构变动')

    def test_workbenchUnread(self):
        '''工作台代办未阅读的工作
           应用访问地址：/notice/index
           平台应用场景：工作台代办未阅读的工作
        '''
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('wcm')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/workbenchUnread', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalDisplayRecords'], msg='【response】工作台代办未阅读的工作')

    def test_beforework(self):
        '''消息中心默认展示最新一条消息
           应用访问地址：/notice/index
           平台应用场景：消息中心默认展示最新一条消息
        '''
        params = {
            'requestByNew': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/beforework', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual('', sendrequest.json()['consign']['aaData'][0]['action_title'],
                            msg='【response】消息中心默认展示最新一条消息')
