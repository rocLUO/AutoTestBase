#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/12 0012 下午 6:52
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''获取仪表盘默认主题或分类下的图表
           仪表盘访问地址：/dashboard
           平台应用场景：仪表盘入口进入，默认主题下图表获取
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/dashboard/rule/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】获取仪表盘默认主题或分类下的图表')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([],sendrequest.json()['result'],msg='【response】获取仪表盘默认主题或分类下的图表')


    def test_actionGet_case01(self):
        '''获取仪表盘指定分类下的图表
           仪表盘访问地址：/dashboard
           平台应用场景：仪表盘入口进入
           分类名称：用于修改分类名称
        '''
        params={
            'showCategory':'0',
            'showCategoryId':'1'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/dashboard/rule/',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】获取仪表盘指定分类下的图表')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([],sendrequest.json()['result'],msg='【response】获取仪表盘指定分类下的图表')