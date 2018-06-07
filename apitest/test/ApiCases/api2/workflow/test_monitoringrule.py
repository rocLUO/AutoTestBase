#! /usr/bin/env/python3
# coding=utf-8
# @Time    : 2018/4/27 0027 下午 4:01
# @Author  : Dulei
import unittest,os,sys
from apitest.test.loginmod.login import Login
from apitest.test.method.checkmethod import isJson, outputrequest


class CalTest(unittest.TestCase):
    def test_module(self):
        '''获取流程监控规则列表
           应用访问地址：/workflow/monitoring
        '''
        params = {
            'tableparams[searchField]': '',
            'tableparams[bSearchable_10]': 'true',
            'tableparams[bRegex_10]': 'false',
            'tableparams[sSearch_10]': '',
            'tableparams[bSearchable_9]': 'true',
            'tableparams[bRegex_9]': 'false',
            'tableparams[sSearch_9]': '',
            'tableparams[bSearchable_8]': 'true',
            'tableparams[bRegex_8]': 'false',
            'tableparams[sSearch_8]': '',
            'tableparams[bSearchable_7]': 'true',
            'tableparams[bRegex_7]': 'false',
            'tableparams[sSearch_7]': '',
            'tableparams[bSearchable_6]': 'true',
            'tableparams[bRegex_6]': 'false',
            'tableparams[sSearch_6]': '',
            'tableparams[bSearchable_5]': 'true',
            'tableparams[bRegex_5]': 'false',
            'tableparams[sSearch_5]': '',
            'tableparams[bSearchable_4]': 'true',
            'tableparams[bRegex_4]': 'false',
            'tableparams[sSearch_4]': '',
            'tableparams[bSearchable_3]': 'true',
            'tableparams[bRegex_3]': 'false',
            'tableparams[sSearch_3]': '',
            'tableparams[bSearchable_2]': 'true',
            'tableparams[bRegex_2]': 'false',
            'tableparams[sSearch_2]': '',
            'tableparams[bSearchable_1]': 'true',
            'tableparams[bRegex_1]': 'false',
            'tableparams[sSearch_1]': '',
            'tableparams[bSearchable_0]': 'true',
            'tableparams[bRegex_0]': 'false',
            'tableparams[sSearch_0]': '',
            'tableparams[bRegex]': 'false',
            'tableparams[sSearch]': '',
            'tableparams[mDataProp_10]': 10,
            'tableparams[mDataProp_9]': 9,
            'tableparams[mDataProp_8]': 8,
            'tableparams[mDataProp_7]': 7,
            'tableparams[mDataProp_6]': 6,
            'tableparams[mDataProp_5]': 5,
            'tableparams[mDataProp_4]': 4,
            'tableparams[mDataProp_3]': 3,
            'tableparams[mDataProp_2]': 2,
            'tableparams[mDataProp_1]': 1,
            'tableparams[mDataProp_0]': 0,
            'tableparams[iDisplayLength]': 15,
            'tableparams[iDisplayStart]': 0,
            'tableparams[sColumns]': '',
            'tableparams[iColumns]': 11,
            'tableparams[sEcho]': 1
        }
        nowlogin = Login().login('admin')  # 登录系统
        sendrequest = nowlogin.get(Login().url + '/api2/workflow/monitoringrule', params=params)
        outputrequest(sendrequest,os.path.abspath(__file__),sys._getframe().f_code.co_name)  # 输出请求方式和请求API到report中
        self.assertEqual(True, isJson(jsonstr=sendrequest), msg='判断返回值是否为json格式')  # 断言(判断返回值是否为json格式)
        self.assertNotEqual(0, sendrequest.json()['iTotalRecords'], msg='【response】获取流程监控规则列表')
