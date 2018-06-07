#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 下午 5:34
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_GetOrgByOrgAssign(self):
        '''按权限获取普通用户能看到的组织架构节点范围
           应用访问地址：/organization/contacts/
           平台应用场景：进入通讯录页面调用
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/user/contacts/GetOrgByOrgAssign')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)

    def test_GetUsers(self):
        '''获取通讯录用户
           应用访问地址：/organization/contacts/
           平台应用场景：进入通讯录页面调用
        '''
        params = {
            'start': 0,
            'perPage': 15,
            'role_id': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/user/contacts/GetUsers', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['result']['iTotalDisplayRecords'], msg='【response】获取通讯录用户')

    def test_contacts_case01(self):
        '''一人多岗在不同组织架构树节点下只会存在一条记录
           应用访问地址：/organization/contacts/
           平台应用场景：进入通讯录页面调用
           组织架构树:行政管理部
        '''
        params = {
            'start': 0,
            'perPage': 15,
            'role_id': 8
        }
        json = ['张宗超', 'Uzzc']
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/user/contacts/GetUsers', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(json, sendrequest.json()['result']['aaData'][0][0], msg='【response】一人多岗在不同组织架构树节点下只会存在一条记录')

    def test_contacts_case02(self):
        '''一人多岗在主职被设置查看权限,普通用户在通讯录搜索应该能够搜索到
           应用访问地址：/organization/contacts/
           平台应用场景：进入通讯录页面调用
           组织架构树:行政管理部
        '''
        params = {
            'start': 0,
            'perPage': 15,
            'role_id': 1,
            'search': '刘'
        }
        json = ['张宗超', 'Uzzc']
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/user/contacts/GetUsers', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual([], sendrequest.json()['result']['aaData'],
                            msg='【response】一人多岗在主职被设置查看权限,普通用户在通讯录搜索应该能够搜索到')
