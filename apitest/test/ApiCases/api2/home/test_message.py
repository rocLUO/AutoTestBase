#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 2:18
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest
import time


class CalTest(unittest.TestCase):
    def test_actionPost(self):
        '''运营通告下线通知下发与企业用户是否收到通知消息检查
           应用访问地址：/sysop/config
           平台应用场景：运营通告下线通知下发，下发成功后企业用户登录进入消息中心，系统消息查看
        '''
        values = {
            'id': '',
            'params[title]': '测试系统消息下发',
            'params[start]': '2018-01-01 16:27:03',
            'params[finish]': '2021-06-30 16:29:17',
            'params[introduce]': '平台即将下线咯',
            'params[logo]': '',
            'params[type]': '1',
            'params[noticeCompany]': '',
            'params[is_published]': '1',
            'params[extend][openCountdown]': 0
        }
        nowlogin = Login().login('root')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/home/message', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】运营通告下线通知下发')
        self.assertEqual(True, sendrequest.json()['result'], msg='【response】运营通告下线通知下发')

        time.sleep(5)  # 运营通告下发有延迟，设置等待时长
        params = {
            'paging[perPage]': 15,
            'paging[start]': 0,
            'requestByNew': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/message/notice/data/system', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json()['aaData'], msg='【response】企业用户是否收到通知消息检查')
