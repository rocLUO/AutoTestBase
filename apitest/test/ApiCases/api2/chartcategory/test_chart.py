#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 上午 10:33
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取当前分类id数据权限
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chartcategory/chart/1')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取当前分类id数据权限')

    def test_actionPUT(self):
        '''移动图表到指定分类下(单应用)
           应用访问地址：/dashboard
           'API使用说明'图表移动到'使用说明分类中'
           平台应用场景：移动图表到指定分类下(单应用)
        '''
        values = {
            'categoryId': 34,
            'toCategoryId': 5,
            'isDefault': 1,
            'type': 'single'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/chartcategory/chart', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】移动图表到指定分类下(单应用)')

    def test_moveChart(self):
        '''移动图表位置
           应用访问地址：/dashboard
           平台应用场景：移动图表位置
        '''
        values = {
            'chartId[]': '-1',
            'chartId[]': '-3',
            'chartId[]': '-4',
            'chartId[]': '-22',
            'chartId[]': '-23',
            'chartId[]': '-24',
            'chartId[]': '-26',
            'chartId[]': '-27',
            'chartId[]': '-29',
            'chartId[]': '-30',
            'chartId[]': '-31',
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chartcategory/chart/moveChart', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】移动图表位置')

