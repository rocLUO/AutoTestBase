#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/26 0026 上午 10:16
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_actionGET(self):
        '''获取当前用户仪表盘的所有主题分类
           应用访问地址：/dashboard
           平台应用场景：获取当前用户仪表盘的所有主题分类
        '''
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/chartcategory/category/')
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】获取当前用户仪表盘的所有主题分类')
        self.assertNotEqual([], sendrequest.json()['result'], msg='【response】获取当前用户仪表盘的所有主题分类')

    def test_actionPost(self):
        '''添加仪表盘分类
           应用访问地址：/dashboard
           平台应用场景：添加仪表盘分类
        '''
        values = {
            'categoryName': '添加一个分类'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.post(Login().url + '/api2/chartcategory/category/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】添加仪表盘分类')

    def test_actionPut(self):
        '''修改仪表盘分类
           应用访问地址：/dashboard
           平台应用场景：修改仪表盘分类
           分类名称：用于修改分类名称
        '''
        values = {
            'categoryId': 1,
            'name': '该分类已经被修改了'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.put(Login().url + '/api2/chartcategory/category/', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】修改仪表盘分类')

    def test_actionDelete(self):
        '''删除仪表盘分类
           应用访问地址：/dashboard
           平台应用场景：删除仪表盘分类
           分类名称：用于删除分类
        '''
        values = {
            'categoryId': 6
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.delete(Login().url + '/api2/chartcategory/category', data=values)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】删除仪表盘分类')
