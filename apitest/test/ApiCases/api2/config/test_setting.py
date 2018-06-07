#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 上午 10:27
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''基础数据配置获取
           应用访问地址：/config
           平台应用场景：管理员config页面——>基础数据配置
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/config/setting')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】基础数据配置获取')  # 断言(检查返回值status是否为200)

    def test_actionPost(self):
        '''基础数据配置修改——修改企业首页链接配置
           应用访问地址：/config
           平台应用场景：管理员config页面——>基础数据配置
        '''
        values = {
            'type': 'home_page_link',
            'value[link]': '/user/index'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/config/setting', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】基础数据配置修改——修改企业首页链接配置')  # 断言(检查返回值status是否为200)
