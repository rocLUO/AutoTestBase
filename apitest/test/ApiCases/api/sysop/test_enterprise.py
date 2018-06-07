#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/5/17 0017 下午 5:37
# @Author  : Dulei
import unittest, os, sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_enterprise(self):
        '''root编辑企业信息
           应用访问地址：/sysop/enterprise
           平台应用场景：root编辑企业信息
        '''
        values = {
            'name': 'API测试企业',
            'parent': 0,
            'enterprise_tag': 'public_cloud',
            'admin_user': 'ApiTest',
            'safe_user': 'Uzongjingli',
            'audit_user': '',
            'business_model': '生产型',
            'scale': '1-50人',
            'provinceCity[0]': 12,
            'provinceCity[1]': 1201,
            'industry': '',
            'address': '',
            'zip': '',
            'fix_telephone': 0,
            'fax': '',
            'contact': '',
            'position': '',
            'tel': '',
            'mobile': '',
            'email': '',
            'note': '',
            'about': '',
            'founder_id': 'ApiTest',
            'id': 2,
            'enterprise_id': 'APICeShiQiYe'
        }
        nowlogin = Login().login('root')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api/sysop/enterprise', data=values)
        outputrequest(sendrequest, os.path.abspath(__file__), sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】root编辑企业信息')
