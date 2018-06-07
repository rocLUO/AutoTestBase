#! /usr/bin/env/python3
#coding=utf-8
# @Time    : 2018/4/16 0016 下午 4:25
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGet(self):
        '''数据中心分类与数据表树
           应用访问地址：/datacenter/#!showCategory/
           平台应用场景：进入数据中心,获取分类与数据表树（选择表单时用到【点击关联从表】）
        '''
        params={
            'entId':'APICeShiQiYe',
            'type':'all'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/tree',params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)


    def test_getCategories(self):
        '''获取数据中心分类树
           应用访问地址：/datacenter/#!showCategory/
           平台应用场景：进入数据中心左侧分类树，用来返回分类名称
        '''
        params = {
            'entId': 'APICeShiQiYe',
            'type': 'category'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/tree', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)


    def test_gettree(self):
        '''获取数据中心分类和表
           平台应用场景：规则引擎选择表时用到
        '''

        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api/datacenter/tree')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)