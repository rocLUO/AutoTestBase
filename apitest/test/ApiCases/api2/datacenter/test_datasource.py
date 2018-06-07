#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/25 0025 下午 5:05
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''检查日期类型数据源选择（显示方式：年、获取方式：搜索）
           应用访问地址：/app/!/information/ShiYongRiQiShuJuYuan
           平台应用场景：搜索数据源并选择
        '''
        tableId = 'shiyongriqishujuyuan'
        fieldId = 'shiyongriqishujuyuan'
        params = {
            'paging[perPage]': 20,
            'paging[start]': 0,
            'search': '2015'
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/datacenter/datasource/' + tableId + '/' + fieldId,
                                   params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertEqual(200, sendrequest.json()['status'], msg='【status】检查日期类型数据源选择（显示方式：年、获取方式：搜索）')
        self.assertIn('2015', sendrequest.text, msg='【response】检查日期类型数据源选择（显示方式：年、获取方式：搜索）')
