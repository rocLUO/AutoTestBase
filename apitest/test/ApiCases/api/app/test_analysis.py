#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/10 0010 下午 5:31
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest

class CalTest(unittest.TestCase):
    def test_actionGeoCity(self):
        '''企业运营概况用户登录分布地图下钻
           应用访问地址：/companyinfo/index
           平台应用场景：企业运营概况——活跃用户分布
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/app/analysis/geoCity/jiangsu')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【web】企业运营概况用户登录分布地图下钻')  # 断言(检查返回值status是否为200)


    def test_actionGet(self):
        '''应用列表数据分析标签数据获取
           应用访问地址：/app/!/workflow/GongZuoXieTong
           平台应用场景：应用列表—>数据分析标签—>数据获取
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/app/analysis/rule_list/workflow/GongZuoXieTong')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】应用列表数据分析标签数据获取')  # 断言(检查返回值status是否为200)
        self.assertNotEqual([], sendrequest.json()['result'], msg='【result】应用列表数据分析标签数据获取')  # 断言(检查返回值不包含某值)