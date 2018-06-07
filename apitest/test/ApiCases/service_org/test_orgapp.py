#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/28 0028 下午 4:20
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest,statusmsg,responsemsg


class CalTest(unittest.TestCase):
    def test_allinfo(self):
        '''App通讯录搜索
           平台应用场景：App通讯录进去直接搜索
        '''
        msg='App通讯录搜索'
        values = {
            'text': '毛'
        }
        json = [{'role_name': '平台一组-组长', 'role_type': '1', 'user_id': 'Umj', 'role_id': '25', 'real_name': '毛佳'}]
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/service_org/orgapp/search/allinfo', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg=statusmsg(msg))
        self.assertEqual(json, sendrequest.json()['result']['user'], msg=responsemsg(msg))

